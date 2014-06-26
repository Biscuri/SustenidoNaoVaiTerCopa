package model;

import java.util.LinkedList;

public class Pais {

	private String nome;
	private String continente;
	private LinkedList<Selecao> selecoes;
	
	public Pais (String nome, String continente, LinkedList<Selecao> selecoes){
		this.nome = nome;
		this.continente = continente;
		this.selecoes = selecoes;
	}

	public String getNome() {
		return nome;
	}
	
	public String getContinente() {
		return continente;
	}

	public LinkedList<Selecao> getSelecoes() {
		return selecoes;
	}
}
