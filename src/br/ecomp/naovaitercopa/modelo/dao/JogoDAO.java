package br.ecomp.naovaitercopa.modelo.dao;

import java.util.Calendar;
import java.util.List;

import br.ecomp.naovaitercopa.modelo.Jogo;
import br.ecomp.naovaitercopa.modelo.Selecao;
import br.ecomp.naovaitercopa.modelo.Jogo.fase;


public interface JogoDAO {
	
	public void adicionar(Jogo pais);
	
	public void remover(Jogo pais);
	
	public void atualizar(Jogo pais);
	
	public Jogo buscarJogo(String local, Calendar data, Selecao selecaoA, Selecao selecaoB, fase fase);
	
	public List<Jogo> listar();

	void removerTodos();
}
