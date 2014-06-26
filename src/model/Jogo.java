package model;

import java.util.Calendar;
import java.util.LinkedList;

public class Jogo {

	private Calendar data;
	private String local;
	private fase fase;
	private LinkedList<Gol> gols;
	private Selecao selecaoA, selecaoB;
	private Escalacao escalacaoA, escalacaoB;
	private LinkedList<Substituicao> substituicoesA, substituicoesB;
	
	public Jogo(Calendar data, String local, fase fase, LinkedList<Gol> gols, Selecao selecaoA,
			Selecao selecaoB, Escalacao escalacaoA, Escalacao escalacaoB, LinkedList<Substituicao> substituicoesA,
			LinkedList<Substituicao> substituicoesB){
		this.data = data;
		this.local = local;
		this.fase = fase;
		this.gols = gols;
		this.selecaoA = selecaoA;
		this.selecaoB = selecaoB;
		this.escalacaoA = escalacaoA;
		this.escalacaoB = escalacaoB;
		this.substituicoesA = substituicoesA;
		this.substituicoesB = substituicoesB;
	}
	
	public Calendar getData() {
		return data;
	}

	public String getLocal() {
		return local;
	}

	public fase getFase() {
		return fase;
	}

	public LinkedList<Gol> getGols() {
		return gols;
	}
	
	public Selecao getSelecaoA() {
		return selecaoA;
	}
	
	public Selecao getSelecaoB() {
		return selecaoB;
	}

	public Escalacao getEscalacaoA() {
		return escalacaoA;
	}

	public Escalacao getEscalacaoB() {
		return escalacaoB;
	}

	public LinkedList<Substituicao> getSubstituicoesA() {
		return substituicoesA;
	}

	public LinkedList<Substituicao> getSubstituicoesB() {
		return substituicoesB;
	}

	public enum fase{
		GRUPOS, OITAVAS, QUARTAS, SEMIS, FINAL, TERCEIROLUGAR
	}
}
