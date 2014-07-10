package br.ecomp.naovaitercopa.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private Calendar data;
	private String local;
	private fase faseEnum;
	private LinkedList<Gol> gols = new LinkedList<Gol>();
	private Selecao selecaoA;
	private Selecao selecaoB;
	private Escalacao escalacaoA;
	private Escalacao escalacaoB;
	private LinkedList<Substituicao> substituicoesA = new LinkedList<Substituicao>();
	private LinkedList<Substituicao> substituicoesB = new LinkedList<Substituicao>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
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

	public LinkedList<Gol> getGols() {
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

	public LinkedList<Substituicao> getSubstituicoesA() {
		return substituicoesA;
	}

	public void setSubstituicoesA(LinkedList<Substituicao> substituicoesA) {
		this.substituicoesA = substituicoesA;
	}

	public LinkedList<Substituicao> getSubstituicoesB() {
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
    
    public void addGol(Gol novo){
        gols.add(novo);      
    }
    
    public void removeGol(Gol novo){
        gols.remove(novo);
    }
    
    public boolean addSubstituicaoA(Substituicao nova){
        if(substituicoesA.size() < 3){
            substituicoesA.add(nova);
            return true;
        }
        return false;
    }
    
        public boolean addSubstituicaoB(Substituicao nova){
        if(substituicoesB.size() < 3){
            substituicoesB.add(nova);
            return true;
        }
        return false;
    }
    
    
        

	public enum fase {
		GRUPOS, OITAVAS, QUARTAS, SEMIS, FINAL, TERCEIROLUGAR
	}
}
