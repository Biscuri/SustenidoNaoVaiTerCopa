package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import br.ecomp.naovaitercopa.modelo.Selecao;

public interface SelecaoDAO {
	
	public void adicionar(Selecao selecao);
	
	public void remover(Selecao selecao);
	
	public void atualizar(Selecao selecao);
	
        public Selecao buscarSelecao(String nome, int ano);
		
	public List<Selecao> listar();
        
        public List<Selecao> listar(int ano);
        
        public List<Selecao> buscarSelecoes(String nome);

	public void removerTodos();
}
