package model;

import java.util.LinkedList;

public class Escalacao {

	private Selecao a, b;
	private LinkedList<Jogador> jogadoresA, jogadoresB;
	
	public Escalacao(Selecao a, Selecao b, LinkedList<Jogador> jogadoresA, LinkedList<Jogador> jogadoresB){
		this.a = a;
		this.b = b;
		this.jogadoresA = jogadoresA;
		this.jogadoresB = jogadoresB;
	}

	public Selecao getA() {
		return a;
	}

	public Selecao getB() {
		return b;
	}

	public LinkedList<Jogador> getJogadoresA() {
		return jogadoresA;
	}

	public LinkedList<Jogador> getJogadoresB() {
		return jogadoresB;
	}
}
