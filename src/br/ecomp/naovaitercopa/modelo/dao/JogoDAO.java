package br.ecomp.naovaitercopa.modelo.dao;

import java.util.Date;
import java.util.List;

import br.ecomp.naovaitercopa.modelo.Jogo;
import br.ecomp.naovaitercopa.modelo.Jogo.fase;
import br.ecomp.naovaitercopa.modelo.Selecao;


public interface JogoDAO {
	
	public void adicionar(Jogo pais);
	
	public void remover(Jogo pais);
	
	public void atualizar(Jogo pais);
	
	public Jogo buscarJogo(long id);
        
	public List<Jogo> listar();

	void removerTodos();
}
