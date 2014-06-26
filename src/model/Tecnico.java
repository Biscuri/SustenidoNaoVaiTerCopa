package model;

import java.util.Calendar;

public class Tecnico {

	private String nome;
	private Calendar dataNascimento;
	
	public Tecnico(String nome, Calendar dataNascimento){
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}
}
