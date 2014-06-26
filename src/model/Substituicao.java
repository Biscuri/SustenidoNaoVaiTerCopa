package model;

import java.util.Calendar;

public class Substituicao {

	private Calendar tempo;
	private Jogador sai, entra;
	private Selecao selecao;
	
	public Substituicao(Calendar tempo, Jogador sai, Jogador entra, Selecao selecao){
		this.tempo = tempo;
		this.sai = sai;
		this.entra = entra;
		this.selecao = selecao;
	}

	public Calendar getTempo() {
		return tempo;
	}
	
	public Jogador getSai() {
		return sai;
	}
	
	public Jogador getEntra(){
		return entra;
	}

	public Selecao getSelecao() {
		return selecao;
	}
}
