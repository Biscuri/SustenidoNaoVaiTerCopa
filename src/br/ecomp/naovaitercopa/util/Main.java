package br.ecomp.naovaitercopa.util;

import br.ecomp.naovaitercopa.modelo.Controller;
import br.ecomp.naovaitercopa.modelo.Jogo;
import br.ecomp.naovaitercopa.modelo.Pais;
import br.ecomp.naovaitercopa.modelo.dao.JogoDAOHibernate;
import br.ecomp.naovaitercopa.modelo.dao.PaisDAOHibernate;

public class Main {

	public static void main(String[] args) {
            Jogo novo = new Jogo();
            novo.setLocal("Teste123");
            Jogo novo2 = new Jogo();
            novo2.setLocal("Teste");
            JogoDAOHibernate teste = new JogoDAOHibernate();
            teste.adicionar(novo);
            teste.adicionar(novo2);
            Jogo hue = teste.buscarJogo("Teste123");
            System.out.println("O jogo da hueragem é:"+ hue.getLocal());
            
        
           
	}

}
