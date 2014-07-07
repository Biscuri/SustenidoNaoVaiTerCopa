package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import br.ecomp.naovaitercopa.modelo.Jogador;

public interface JogadorDAO {
	
	public void adicionar(Jogador jogador);
	
	public void remover(Jogador jogador);
	
	public void atualizar(Jogador jogador);
	
	public Jogador buscarJogador(String nome);
	
	public List<Jogador> listar();

	void removerTodos();
}
