package model;

import java.util.LinkedList;

public class Selecao {

	private String grupo;
	private int ano;
	private int posicao;
	private LinkedList<Jogador> jogadores;
	private Tecnico tecnico;
	private Pais pais;
	private LinkedList<Gol> gols;
	
	public Selecao(String grupo, int ano, int posicao, LinkedList<Jogador> jogadores, Tecnico tecnico, Pais pais,
			LinkedList<Gol> gols){
		this.grupo = grupo;
		this.ano = ano;
		this.jogadores = jogadores;
		this.tecnico = tecnico;
		this.pais = pais;
		this.gols = gols;
	}
	
	public String getGrupo() {
		return grupo;
	}
	public int getAno() {
		return ano;
	}
	public int getPosicao() {
		return posicao;
	}
	public LinkedList<Jogador> getJogadores() {
		return jogadores;
	}
	public Tecnico getTecnico() {
		return tecnico;
	}
	public Pais getPais() {
		return pais;
	}
	public LinkedList<Gol> getGols() {
		return gols;
	}
	
}
