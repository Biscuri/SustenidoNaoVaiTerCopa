package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Escalacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private Selecao selecao;
	private LinkedList<Jogador> jogadores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	public LinkedList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(LinkedList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
}