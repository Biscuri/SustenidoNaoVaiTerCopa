package model;

import java.util.Calendar;
import java.util.LinkedList;

public class Jogador {

	private String nome;
	private Calendar dataNascimento;
	private int numero;
	private posicao posicao;
	private LinkedList<Gol> gols;
	
	public Jogador(String nome, Calendar dataNascimento, int numero, posicao posicao){
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.numero = numero;
		this.posicao = posicao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public int getNumero() {
		return numero;
	}

	public posicao getPosicao() {
		return posicao;
	}

	public LinkedList<Gol> getGols() {
		return gols;
	}

	public void setGols(LinkedList<Gol> gols) {
		this.gols = gols;
	}
	
	public void addGol (Calendar tempo, boolean foiContra, Jogador jogador){
		gols.add(new Gol(tempo, foiContra, jogador));
	}

	public enum posicao{
		ZAGUEIRO, LATERALDIREITO, LATERALESQUERDO, LIBERO, VOLANTE, ALAESQUERDO, ALADIREITO,
		MEIAARMADOR, MEDIOCENTRO, MEIOCAMPISTALATERALESQUERDO, MEIOCAMPISTALATERALDIREITO,
		MEIAATACANTE, PONTA, SEGUNDOATACANTE, CENTROAVANTE
	}
}