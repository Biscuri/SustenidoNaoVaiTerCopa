package model;

import java.util.LinkedList;

public class Copa {

	private int ano;
	private Pais pais;
	private LinkedList<Jogo> jogos;
	private LinkedList<Selecao> selecoes;
	
	public Copa(int ano, Pais pais, LinkedList<Jogo> jogos, LinkedList<Selecao> selecoes){
		this.ano = ano;
		this.pais = pais;
		this.jogos = jogos;
		this.selecoes = selecoes;
	}

	public int getAno() {
		return ano;
	}

	public Pais getPais() {
		return pais;
	}

	public LinkedList<Jogo> getJogos() {
		return jogos;
	}

	public LinkedList<Selecao> getSelecoes() {
		return selecoes;
	}
}
