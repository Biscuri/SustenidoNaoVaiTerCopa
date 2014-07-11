package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Gol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date tempo;
	private boolean foiContra;

	@ManyToOne
	@JoinColumn(name = "gols_j")
	private Jogador jogador;

	@ManyToOne
	@JoinColumn(name = "gols_s")
	private Selecao selecao;

	@ManyToOne
	@JoinColumn(name = "gols_jg")
	private Jogo jogo;

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

	public boolean isFoiContra() {
		return foiContra;
	}

	public void setFoiContra(boolean foiContra) {
		this.foiContra = foiContra;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

}
