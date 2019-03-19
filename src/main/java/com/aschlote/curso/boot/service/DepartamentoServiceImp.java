package com.aschlote.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aschlote.curso.boot.domain.Departamento;
import com.aschlote.curso.boot.domain.dao.DepartamentoDao;

@Service
public class DepartamentoServiceImp implements DepartamentoService {
	
	@Autowired
	private DepartamentoDao dao;

	@Override @Transactional(readOnly = false)
	public void salvar(Departamento departamento) {
		dao.save(departamento);
	}

	@Override @Transactional(readOnly = false)
	public void editar(Departamento departamento) {
		dao.update(departamento);
	}

	@Override @Transactional(readOnly = false)
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Departamento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Departamento> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		return !buscarPorId(id).getCargos().isEmpty();
	}

}
