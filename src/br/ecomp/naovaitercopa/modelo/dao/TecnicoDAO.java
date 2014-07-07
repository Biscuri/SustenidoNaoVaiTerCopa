package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import br.ecomp.naovaitercopa.modelo.Tecnico;

public interface TecnicoDAO {
	
	public void adicionar(Tecnico tecnico);
	
	public void remover(Tecnico tecnico);
	
	public void atualizar(Tecnico tecnico);
	
	public Tecnico buscarTecnico(String nome);
	
	public List<Tecnico> listar();

	void removerTodos();
}
