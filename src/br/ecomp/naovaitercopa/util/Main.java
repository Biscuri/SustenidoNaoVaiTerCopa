package br.ecomp.naovaitercopa.util;

import br.ecomp.naovaitercopa.modelo.Controller;
import br.ecomp.naovaitercopa.modelo.Jogador;

public class Main {

	public static void main(String[] args) {
            	
        Controller controller = new Controller();
        controller.CadastrarJogador(null, null, 22, Jogador.posicao.GOLEIRO, null);
	}

}
