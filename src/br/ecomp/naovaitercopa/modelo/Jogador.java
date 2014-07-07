package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Jogador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private Calendar dataNascimento;
	private int numero;
	private posicao posicao;
	private LinkedList<Gol> gols;

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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LinkedList<Gol> getGols() {
		return gols;
	}

	public void setGols(LinkedList<Gol> gols) {
		this.gols = gols;
	}
	
	public posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(posicao posicao) {
		this.posicao = posicao;
	}

	public enum posicao{
		ZAGUEIRO, LATERALDIREITO, LATERALESQUERDO, LIBERO, VOLANTE, ALAESQUERDO, ALADIREITO,
		MEIAARMADOR, MEDIOCENTRO, MEIOCAMPISTALATERALESQUERDO, MEIOCAMPISTALATERALDIREITO,
		MEIAATACANTE, PONTA, SEGUNDOATACANTE, CENTROAVANTE
	}

}
