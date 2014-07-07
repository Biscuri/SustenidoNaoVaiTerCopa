package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import br.ecomp.naovaitercopa.modelo.Pais;

public interface PaisDAO {
	
	public void adicionar(Pais pais);
	
	public void remover(Pais pais);
	
	public void atualizar(Pais pais);
	
	public Pais buscarPais(String nome);
	
	public List<Pais> listar();

	void removerTodos();
}
