package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Escalacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Jogo jogo;

	@OneToMany(mappedBy = "escalacao")
	@Column(name = "jogadores_e")
	private List<Jogador> jogadores = new LinkedList<Jogador>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public boolean addJogadores(Jogador a) {
		if (jogadores.size() <= 11) {
			jogadores.add(a);
			return true;
		}
		return false;
	}

}
