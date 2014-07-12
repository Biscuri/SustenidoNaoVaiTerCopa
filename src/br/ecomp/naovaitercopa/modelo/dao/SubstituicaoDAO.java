package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import br.ecomp.naovaitercopa.modelo.Substituicao;

public interface SubstituicaoDAO {
	
	public void adicionar(Substituicao substituicao);
	
	public void remover(Substituicao substituicao);
	
	public void atualizar(Substituicao substituicao);
	
	public Substituicao buscarSubstituicao(long id);
	
	public List<Substituicao> listar();

	void removerTodos();
}
