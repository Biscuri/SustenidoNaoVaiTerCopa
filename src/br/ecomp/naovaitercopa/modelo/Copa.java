package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Copa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long id;
	
	private int ano;
	
	@OneToOne
	private Pais pais;	
	private LinkedList<Jogo> jogos;
	private LinkedList<Selecao> selecoes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public LinkedList<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(LinkedList<Jogo> jogos) {
		this.jogos = jogos;
	}
	public LinkedList<Selecao> getSelecoes() {
		return selecoes;
	}
	public void setSelecoes(LinkedList<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

}
