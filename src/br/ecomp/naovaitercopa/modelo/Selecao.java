package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private Jogador[] jogadores = new Jogador[99];
	private Tecnico tecnico;
	private Pais pais;
	private LinkedList<Gol> gols;
        private int cont = 0;

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
		return jogadores;
	}

	public void setJogadores(Jogador[] jogadores) {
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

	public LinkedList<Gol> getGols() {
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
   
    @SuppressWarnings("unused")
	public boolean addJogador(Jogador jogador){
            if(cont < 23){
                if(jogadores[cont]==null){
                    jogadores[cont] = jogador;
                    cont++;
                    return true;          
                }
                
            }
            if(cont < 30){
                cont=0;}
            cont++;
                    return false;
        
            
        /*
        	for (int i = 0 ; i < 23 ; i++){
        		if (jogadores[i] == null)
        			jogadores[i] = jogador;
        			return true;
        	}
        }
        return false;*/
    }
    
    public boolean removeJogador(Jogador jogador){
    	for (int i = 0 ; i < 23 ; i++){
    		if (jogadores[i].equals(jogador)){
    			for (int j = i ; j < 22 ; j++){
    				jogadores[j] = jogadores[j+1];
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
                //}
            }
        }
        return false;
    }
   
        
}
