package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import br.ecomp.naovaitercopa.modelo.Copa;

public interface CopaDAO {
	
	public void adicionar(Copa copa);
	
	public void remover(Copa copa);
	
	public void atualizar(Copa copa);
	
	public Copa buscarCopa(String nomePais);
	
	public List<Copa> listar();

	void removerTodos();
}
