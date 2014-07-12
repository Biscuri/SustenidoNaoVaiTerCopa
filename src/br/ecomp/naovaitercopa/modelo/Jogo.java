package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Jogo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private fase fase;
	private fase faseEnum;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "data_jg")
	private Date data;

	@ManyToOne
	@JoinColumn(name = "jogos_c")
	private Copa copa;

	@Lob
	private String local;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "jogo")
	private Selecao selecaoA;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "jogo")
	private Selecao selecaoB;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "jogo")
	private Escalacao escalacaoA;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "jogo")
	private Escalacao escalacaoB;

	@OneToMany(mappedBy = "selecaoA")
	@Column(name = "substituicoesA_jg")
	private List<Substituicao> substituicoesA = new LinkedList<Substituicao>();

	@OneToMany(mappedBy = "selecaoB")
	@Column(name = "substituicoesB_jg")
	private List<Substituicao> substituicoesB = new LinkedList<Substituicao>();

	@OneToMany(mappedBy = "jogo")
	@Column(name = "gols_jg")
	private List<Gol> gols = new LinkedList<Gol>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public fase getFaseEnum() {
		return faseEnum;
	}

	public void setFaseEnum(fase faseEnum) {
		this.faseEnum = faseEnum;
	}

	public List<Gol> getGols() {
		return gols;
	}

	public void setGols(LinkedList<Gol> gols) {
		this.gols = gols;
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

	public Escalacao getEscalacaoA() {
		return escalacaoA;
	}

	public void setEscalacaoA(Escalacao escalacaoA) {
		this.escalacaoA = escalacaoA;
	}

	public Escalacao getEscalacaoB() {
		return escalacaoB;
	}

	public void setEscalacaoB(Escalacao escalacaoB) {
		this.escalacaoB = escalacaoB;
	}

	public List<Substituicao> getSubstituicoesA() {
		return substituicoesA;
	}

	public void setSubstituicoesA(LinkedList<Substituicao> substituicoesA) {
		this.substituicoesA = substituicoesA;
	}

	public List<Substituicao> getSubstituicoesB() {
		return substituicoesB;
	}

	public void setSubstituicoesB(LinkedList<Substituicao> substituicoesB) {
		this.substituicoesB = substituicoesB;
	}

	public fase getFase() {
		return fase;
	}

	public void setFase(fase fase) {
		this.fase = fase;
	}

	public Copa getCopa() {
		return copa;
	}

	public void setCopa(Copa copa) {
		this.copa = copa;
	}

	public void setSubstituicoesA(List<Substituicao> substituicoesA) {
		this.substituicoesA = substituicoesA;
	}

	public void setSubstituicoesB(List<Substituicao> substituicoesB) {
		this.substituicoesB = substituicoesB;
	}

	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Jogo) {
			Jogo outro = (Jogo) o;
			if (this.data == outro.getData()) {
				if (this.selecaoA == outro.getSelecaoA()) {
					if (this.selecaoB == outro.getSelecaoB()) {
						if (this.fase.equals(outro.getFase())) {
							return true;
						}
					}
				}
			}

		}
		return false;
	}

	public void addGol(Gol novo) {
		gols.add(novo);
	}

	public void removeGol(Gol novo) {
		gols.remove(novo);
	}

	public boolean addSubstituicaoA(Substituicao nova) {
		if (substituicoesA.size() < 3) {
			substituicoesA.add(nova);
			return true;
		}
		return false;
	}

	public boolean addSubstituicaoB(Substituicao nova) {
		if (substituicoesB.size() < 3) {
			substituicoesB.add(nova);
			return true;
		}
		return false;
	}

	public enum fase {
		GRUPOS, OITAVAS, QUARTAS, SEMIS, FINAL, TERCEIROLUGAR
	}
}
