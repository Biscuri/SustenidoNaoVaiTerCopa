package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import br.ecomp.naovaitercopa.modelo.Gol;

public interface GolDAO {
	
	public void adicionar(Gol gol);
	
	public void remover(Gol gol);
	
	public void atualizar(Gol gol);
	
	public Gol buscarGol(long id);
	
	public List<Gol> listar();

	void removerTodos();
}
