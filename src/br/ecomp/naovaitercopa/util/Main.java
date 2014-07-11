package br.ecomp.naovaitercopa.util;

import br.ecomp.naovaitercopa.modelo.Controller;
import br.ecomp.naovaitercopa.modelo.Copa;
import br.ecomp.naovaitercopa.modelo.Escalacao;
import br.ecomp.naovaitercopa.modelo.Jogador;
import br.ecomp.naovaitercopa.modelo.Jogo;
import br.ecomp.naovaitercopa.modelo.Pais;
import br.ecomp.naovaitercopa.modelo.Selecao;
import br.ecomp.naovaitercopa.modelo.Tecnico;
import br.ecomp.naovaitercopa.modelo.dao.JogoDAOHibernate;
import br.ecomp.naovaitercopa.modelo.dao.PaisDAOHibernate;
import java.util.Calendar;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class Main {

	public static void main(String[] args) {
            	
        Controller controller = new Controller();
        controller.CadastrarJogador(null, null, 11, Jogador.posicao.GOLEIRO, null);
	}

}
