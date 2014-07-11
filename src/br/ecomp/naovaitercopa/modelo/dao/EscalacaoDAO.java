package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import br.ecomp.naovaitercopa.modelo.Escalacao;

public interface EscalacaoDAO {
	
	public void adicionar(Escalacao escalacao);
	
	public void remover(Escalacao escalacao);
	
	public void atualizar(Escalacao escalacao);
	
	public Escalacao buscarEscalacao(String nome);
	
	public List<Escalacao> listar();

	void removerTodos();
}
