package br.ecomp.naovaitercopa.modelo;

import br.ecomp.naovaitercopa.modelo.dao.PaisDAOHibernate;



/**
 *
 * @author Keader
 */
public class Controller {
    
    PaisDAOHibernate paisDB;
    
    public Controller(){
        paisDB = new PaisDAOHibernate();
    }
    
    /**
     * Metodo que cadastra um Pais na Database
     * @param nome nome do pais
     * @param continente continente do pais
     * @return true se foi possivel cadastrar , false se ja existia um pais cadastrado.
     */
    public boolean CadastrarPais(String nome, String continente){
        Pais novo = new Pais();
        novo.setNome(nome);
        novo.setContinente(continente);
        Pais verifica = paisDB.buscarPais(nome); // Busca pelo nome do pais, para evitar cadastro duplo.
        if(verifica == null){ // Se nao houver outro pais
            paisDB.adicionar(novo);  // cadastra o pais
            return true;
        }
        return false;
    }
    
    
}
