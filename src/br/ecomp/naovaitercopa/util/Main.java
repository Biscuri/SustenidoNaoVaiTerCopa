package br.ecomp.naovaitercopa.util;

import br.ecomp.naovaitercopa.modelo.Pais;
import br.ecomp.naovaitercopa.modelo.dao.PaisDAOHibernate;

public class Main {

	public static void main(String[] args) {
		Pais pais = new Pais();
		PaisDAOHibernate paisTabela = new PaisDAOHibernate();
		
		pais.setNome("Braziuu ziuu");
		
		paisTabela.adicionar(pais);
	}

}
