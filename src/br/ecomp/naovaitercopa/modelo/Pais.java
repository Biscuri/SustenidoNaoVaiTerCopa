package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String continente;
	private LinkedList<Selecao> selecoes = new LinkedList<Selecao>();
        

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public LinkedList<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(LinkedList<Selecao> selecoes) {
		this.selecoes = selecoes;
	}
        
        public void addSelecao(Selecao nova){
            selecoes.add(nova);
        }
        
        public void removeSelecao(Selecao remove){
            selecoes.remove(remove);
        }
        
        

}
