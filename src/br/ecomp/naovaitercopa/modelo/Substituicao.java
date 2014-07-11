package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	private Date tempo;

	@OneToOne
	private Jogador sai;
	@OneToOne
	private Jogador entra;

	@ManyToOne
	@JoinColumn(name = "substituicoesA_jg")
	private Selecao selecaoA;

	@ManyToOne
	@JoinColumn(name = "substituicoesB_jg")
	private Selecao selecaoB;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
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

	public Selecao getSelecaoA() {
		return selecaoA;
	}

	public void setSelecaoA(Selecao selecaoA) {
		this.selecaoA = selecaoA;
	}

	public Selecao getSelecaoB() {
		return selecaoB;
	}

	public void setSelecaoB(Selecao selecaoB) {
		this.selecaoB = selecaoB;
	}

}
