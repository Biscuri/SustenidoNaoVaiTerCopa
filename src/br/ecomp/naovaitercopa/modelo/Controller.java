package br.ecomp.naovaitercopa.modelo;

import java.util.Calendar;
import java.util.List;

import br.ecomp.naovaitercopa.modelo.Jogador.posicao;
import br.ecomp.naovaitercopa.modelo.Jogo.fase;
import br.ecomp.naovaitercopa.modelo.dao.CopaDAOHibernate;
import br.ecomp.naovaitercopa.modelo.dao.GolDAOHibernate;
import br.ecomp.naovaitercopa.modelo.dao.JogadorDAOHibernate;
import br.ecomp.naovaitercopa.modelo.dao.JogoDAOHibernate;
import br.ecomp.naovaitercopa.modelo.dao.PaisDAOHibernate;
import br.ecomp.naovaitercopa.modelo.dao.SelecaoDAOHibernate;
import br.ecomp.naovaitercopa.modelo.dao.TecnicoDAOHibernate;



/**
 *
 * @author Keader
 */
public class Controller {
    
    PaisDAOHibernate paisDB;
    JogadorDAOHibernate jogadorDB;
    TecnicoDAOHibernate tecnicoDB;
    SelecaoDAOHibernate selecaoDB;
    CopaDAOHibernate copaDB;
    JogoDAOHibernate jogoDB;
    GolDAOHibernate golDB;
    
    /**
     * Construtor da classe controller.
     */
    public Controller(){
        paisDB = new PaisDAOHibernate();
        jogadorDB = new JogadorDAOHibernate();
        tecnicoDB = new TecnicoDAOHibernate();
        selecaoDB = new SelecaoDAOHibernate();
        copaDB = new CopaDAOHibernate();
        jogoDB = new JogoDAOHibernate();
        golDB = new GolDAOHibernate();
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
    /**
     * Metodo para cadastro de um Jogador
     * @param nome nome do jogador
     * @param data data de nascimento
     * @param num numero da sua camisa
     * @param selecao selecao a qual ele pertence
     * @return  true se foi possivel cadastrar, false se ja havia sido cadastrado
     */
    public boolean CadastrarJogador(String nome, Calendar data, int num, posicao posicao, Selecao selecao){
        Jogador novo = new Jogador();
        novo.setNome(nome);
        novo.setNumero(num);
        novo.setDataNascimento(data);
        novo.setSelecao(selecao);
        novo.setPosicao(posicao);
        Jogador verifica = jogadorDB.buscarJogador(nome,selecao);
        if(verifica == null){
            jogadorDB.adicionar(novo);
            return selecao.addJogador(novo);
        }
        
        return false;
    }
    /**
     * Metodo para cadastro do Tecnico
     * @param nome nome do tecnico
     * @param data data de nascimento
     * @param time time que ele treina
     * @return true se foi possivel cadastrar, false se não foi possivel.
     */
    public boolean CadastrarTecnico(String nome, Calendar data, Selecao time){
        Tecnico novo = new Tecnico();
        novo.setNome(nome);
        novo.setDataNascimento(data);
        Tecnico busca = tecnicoDB.buscarTecnico(nome);
        if(busca == null){
            tecnicoDB.adicionar(novo);
            time.setTecnico(novo);
            return true;
        }
        time.setTecnico(busca);
        return false;
    }
    
    /**
     * Metodo para cadastro das selecoes
     * @param nome nome da selecao
     * @param ano ano da selecao
     * @param grupo 
     * @param posicao
     * @param pais a qual pertence
     * @return  true se foi possivel o cadastro, false se ja existia a selecao
     */
    public boolean CadastrarSelecao(String nome, int ano,String grupo,int posicao, Pais pais){
        Selecao nova = new Selecao();
        nova.setNome(nome);
        nova.setAno(ano);
        nova.setGrupo(grupo);
        nova.setPosicao(posicao);
        
        Selecao busca = selecaoDB.buscarSelecao(nome,ano);
        if(busca == null){
            selecaoDB.adicionar(nova);
            pais.addSelecao(nova);
            return true;
        }
        else{
            if(busca.getAno() != ano){
                selecaoDB.adicionar(nova);
                pais.addSelecao(nova);
                return true;
            }
            return false;
        }
    }
    
    /**
     * Metodo para cadstro da copa
     * @param ano ano que a copa esta/estava acontecendo
     * @param sede pais sede da copa
     * @return true se cadastrou,false se ja existia
     */
    public boolean CadastrarCopa(int ano, Pais sede){
        Copa nova = new Copa();
        nova.setAno(ano);
        nova.setPais(sede);
        Copa busca = copaDB.buscarCopa(ano);
        if(busca == null){
            copaDB.adicionar(nova);
        }
        return false;
    }
    /**
     * Metodo dependente de copa, para o cadastro das selecoes na copa
     * @param selecao selecao a ser cadastrada
     * @param ano  ano da copa para busca
     */
    public void CadastrarSelecaoNaCopa(Selecao selecao, int ano){
        Copa busca = copaDB.buscarCopa(ano);
        if(busca!=null){
            busca.addSelecao(selecao);
        }
    }
    /**
     * Metodo dependente da copa, para cadastro dos jogos na copa
     * @param jogo jogo a ser cadastrado
     * @param ano  ano da copa a ser buscada
     */
      public void CadastrarJogoNaCopa(Jogo jogo, int ano){
        Copa busca = copaDB.buscarCopa(ano);
        if(busca!=null){
            busca.addJogo(jogo);
        }
        
    }
      /**
       * Metodo que cadastra um novo Jogo
       * @param data data de realizacao da partida
       * @param local onde a partida esta sendo realizada
       * @param fase qual fase do campeonato ela esta sendo disputada
       * @param selecaoA Selecao A na disputa
       * @param selecaoB Selecao B na disputa
       * @param play1 Escalacao de jogadores do time A
       * @param play2 Escalacao de jogadores do time B
       * @return true se foi possivel , false se nao
       */
      public boolean CadastrarJogo(Calendar data, String local, fase fase,Selecao selecaoA, Selecao selecaoB, Escalacao play1, Escalacao play2){
          Jogo novo = new Jogo();
          novo.setData(data);
          novo.setLocal(local);
          novo.setSelecaoA(selecaoA);
          novo.setSelecaoB(selecaoB);
          novo.setEscalacaoA(play1);
          novo.setEscalacaoB(play2);
          Jogo busca = jogoDB.buscarJogo(local, data, selecaoA, selecaoB, fase);
          if(busca == null){
              jogoDB.adicionar(novo);
              return true;
          }
          else{
              if(!busca.equals(novo)){
                  jogoDB.adicionar(novo);
                  return true;
              }
              return false;
          }  
      }
      /**
       * Cadastra um Gol em um jogo
       * @param jogo jogo que o gol foi feito
       * @param jogador jogador que fez o gol
       * @param contra se o gol foi contra
       * @param tempo em quanto tempo o jogo foi feito
       */
      public void CadastrarGol(Jogo jogo, Jogador jogador, boolean contra, Calendar tempo){
          Gol novo = new Gol();
          novo.setFoiContra(contra);
          novo.setJogador(jogador);
          novo.setTempo(tempo);
         golDB.adicionar(novo);
         jogo.addGol(novo);
      }
      

      
      public List<Pais> listarPaisesCadastrados(){
          return paisDB.listar();
      }
      
      public List<Jogador> listarJogadoresCadastrados(){
          return jogadorDB.listar();
      }
      
      public List<Tecnico> listarTecnicossCadastrados(){
          return tecnicoDB.listar();
      }
      
      public List<Selecao> listarSelecoes(int ano){
          return selecaoDB.listar(ano);
      }
      
      public Pais BuscarPais(String pais){
    	  return paisDB.buscarPais(pais);
      }
      
      public Copa BuscarCopa(int ano){
    	  return copaDB.buscarCopa(ano);
      }
      
      public Jogo BuscarJogo(String local, Calendar data, Selecao selecaoA, Selecao selecaoB, fase fase){
    	  return jogoDB.buscarJogo(local, data, selecaoA, selecaoB, fase);
      }
      
      public Tecnico BuscarTecnico(String nome){
    	  return tecnicoDB.buscarTecnico(nome);
      }
      
      public Jogador BuscarJogador(String nome, Selecao selecao){
    	  return jogadorDB.buscarJogador(nome, selecao);
      }
      
      public Selecao BuscarSelecao(String nome, int ano){
    	  return selecaoDB.buscarSelecao(nome, ano);
      }
    
    
}
