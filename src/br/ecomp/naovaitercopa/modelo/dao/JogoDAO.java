package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import br.ecomp.naovaitercopa.modelo.Jogo;


public interface JogoDAO {
	
	public void adicionar(Jogo pais);
	
	public void remover(Jogo pais);
	
	public void atualizar(Jogo pais);
	
	public Jogo buscarJogo(String local);
	
	public List<Jogo> listar();

	void removerTodos();
}
