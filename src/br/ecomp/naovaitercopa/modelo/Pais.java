package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

	@OneToMany(mappedBy = "pais")
	@Column(name = "selecoes_p")
	private List<Selecao> selecoes = new LinkedList<Selecao>();

	@OneToMany(mappedBy = "pais")
	@Column(name = "copas_p")
	private List<Copa> copas = new LinkedList<Copa>();

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

	public List<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(LinkedList<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

	public List<Copa> getCopas() {
		return copas;
	}

	public void setCopas(List<Copa> copas) {
		this.copas = copas;
	}

	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

	public void addSelecao(Selecao nova) {
		selecoes.add(nova);
	}

	public void removeSelecao(Selecao remove) {
		selecoes.remove(remove);
	}

}
