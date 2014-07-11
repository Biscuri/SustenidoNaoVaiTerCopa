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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Selecao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String grupo;
	private int ano;
	private int posicao;

	@OneToMany(mappedBy = "selecao")
	@Column(name = "jogadores_s")
	private List<Jogador> jogadores = new LinkedList<Jogador>();

	@OneToMany(mappedBy = "selecao")
	@Column(name = "gols_s")
	private List<Gol> gols;

	@ManyToOne
	@JoinColumn(name = "selecoes_c")
	private Copa copa;

	@ManyToOne
	@JoinColumn(name = "selecoes_p")
	private Pais pais;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "selecao")
	private Tecnico tecnico;

	@OneToOne
	private Jogo jogo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public Jogador[] getJogadores() {
		return (Jogador[]) jogadores.toArray();
	}

	public void setJogadores(LinkedList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Gol> getGols() {
		return gols;
	}

	public void setGols(LinkedList<Gol> gols) {
		this.gols = gols;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Copa getCopa() {
		return copa;
	}

	public void setCopa(Copa copa) {
		this.copa = copa;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}

	public boolean addJogador(Jogador jogador) {
		for (int i = 0; i < 23; i++) {
			if (jogadores.toArray()[i] == null) {
				jogadores.toArray()[i] = jogador;
				return true;
			}
		}
		return false;
	}

	public boolean removeJogador(Jogador jogador) {
		for (int i = 0; i < 23; i++) {
			if (jogadores.toArray()[i].equals(jogador)) {
				for (int j = i; j < 22; j++) {
					jogadores.toArray()[j] = jogadores.toArray()[j + 1];
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Selecao) {
			Selecao outra = (Selecao) o;
			if (this.nome.equals(outra.getNome())) {
				// if (this.ano == outra.getAno()){
				return true;
				// }
			}
		}
		return false;
	}

}
