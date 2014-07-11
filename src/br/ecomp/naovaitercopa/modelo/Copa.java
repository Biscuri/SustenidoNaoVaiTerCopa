package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Copa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "copas_p")
	private Pais pais;

	@OneToMany(mappedBy = "copa")
	@Column(name = "jogos_c")
	private List<Jogo> jogos = new LinkedList<Jogo>();

	@OneToMany(mappedBy = "copa")
	@Column(name = "selecoes_c")
	private List<Selecao> selecoes = new LinkedList<Selecao>();

	private int ano;

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

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(LinkedList<Jogo> jogos) {
		this.jogos = jogos;
	}

	public List<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(LinkedList<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

	public void addSelecao(Selecao selecao) {
		selecoes.add(selecao);
	}

	public void removeSelecoes(Selecao selecao) {
		selecoes.remove(selecao);
	}

	public void addJogo(Jogo novo) {
		jogos.add(novo);
	}

	public void removeJogo(Jogo remover) {
		jogos.remove(remover);
	}

}
