package model;

import java.util.Calendar;

public class Gol {

	private Calendar tempo;
	private boolean foiContra;
	private Jogador jogador;
	
	public Gol(Calendar tempo, boolean foiContra, Jogador jogador){
		this.tempo = tempo;
		this.foiContra = foiContra;
		this.jogador = jogador;
	}

	public Calendar getTempo() {
		return tempo;
	}

	public boolean isFoiContra() {
		return foiContra;
	}

	public Jogador getJogador() {
		return jogador;
	}
}
