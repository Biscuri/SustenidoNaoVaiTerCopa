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

	private Selecao a;
	private Selecao b;
	private LinkedList<Jogador> jogadoresA;
	private LinkedList<Jogador> jogadoresB;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Selecao getA() {
		return a;
	}

	public void setA(Selecao a) {
		this.a = a;
	}

	public Selecao getB() {
		return b;
	}

	public void setB(Selecao b) {
		this.b = b;
	}

	public LinkedList<Jogador> getJogadoresA() {
		return jogadoresA;
	}

	public void setJogadoresA(LinkedList<Jogador> jogadoresA) {
		this.jogadoresA = jogadoresA;
	}

	public LinkedList<Jogador> getJogadoresB() {
		return jogadoresB;
	}

	public void setJogadoresB(LinkedList<Jogador> jogadoresB) {
		this.jogadoresB = jogadoresB;
	}

}
