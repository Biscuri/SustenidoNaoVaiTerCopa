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
	private LinkedList<Jogador> jogadoresA;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao a) {
		this.selecao = a;
	}



	public LinkedList<Jogador> getJogadoresA() {
		return jogadoresA;
	}

	public void setJogadoresA(LinkedList<Jogador> jogadoresA) {
		this.jogadoresA = jogadoresA;
	}
        
        public boolean addJogadores(Jogador a){
            if(jogadoresA.size()<= 11){
                jogadoresA.add(a);
                return true;
            }
           return false; 
        }



}
