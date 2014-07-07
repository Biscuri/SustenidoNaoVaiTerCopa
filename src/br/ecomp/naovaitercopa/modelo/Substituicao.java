package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Substituicao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private Calendar tempo;
	
	@OneToOne
	private Jogador sai;
	@OneToOne
	private Jogador entra;
	
	@ManyToOne
	private Selecao selecao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getTempo() {
		return tempo;
	}

	public void setTempo(Calendar tempo) {
		this.tempo = tempo;
	}

	public Jogador getSai() {
		return sai;
	}

	public void setSai(Jogador sai) {
		this.sai = sai;
	}

	public Jogador getEntra() {
		return entra;
	}

	public void setEntra(Jogador entra) {
		this.entra = entra;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

}
