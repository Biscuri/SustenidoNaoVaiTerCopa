package br.ecomp.naovaitercopa.modelo;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import br.ecomp.naovaitercopa.modelo.Jogador.Posicao;
import br.ecomp.naovaitercopa.modelo.Jogo.fase;
import br.ecomp.naovaitercopa.modelo.dao.CopaDAOHibernate;
import br.ecomp.naovaitercopa.modelo.dao.EscalacaoDAOHibernate;
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
	EscalacaoDAOHibernate escalacaoDB;

	/**
	 * Construtor da classe controller.
	 */
	public Controller() {
		paisDB = new PaisDAOHibernate();
		jogadorDB = new JogadorDAOHibernate();
		tecnicoDB = new TecnicoDAOHibernate();
		selecaoDB = new SelecaoDAOHibernate();
		copaDB = new CopaDAOHibernate();
		jogoDB = new JogoDAOHibernate();
		golDB = new GolDAOHibernate();
		escalacaoDB = new EscalacaoDAOHibernate();
	}

	/**
	 * Metodo que cadastra um Pais na Database
	 * 
	 * @param nome
	 *            nome do pais
	 * @param continente
	 *            continente do pais
	 * @return true se foi possivel cadastrar , false se ja existia um pais
	 *         cadastrado.
	 */
	public boolean cadastrarPais(String nome, String continente) {
		Pais novo = new Pais();
		novo.setNome(nome);
		novo.setContinente(continente);
		Pais verifica = paisDB.buscarPais(nome); // Busca pelo nome do pais,
													// para evitar cadastro
													// duplo.
		if (verifica == null) { // Se nao houver outro pais
			paisDB.adicionar(novo); // cadastra o pais
			return true;
		}
		return false;
	}

	/**
	 * Metodo para cadastro de um Jogador
	 * 
	 * @param nome
	 *            nome do jogador
	 * @param data
	 *            data de nascimento
	 * @param num
	 *            numero da sua camisa
	 * @param selecao
	 *            selecao a qual ele pertence
	 * @return true se foi possivel cadastrar, false se ja havia sido cadastrado
	 */
	public void cadastrarJogador(String nome, Date data, int num,
			Posicao posicao, Selecao selecao) {
		Jogador novo = new Jogador();
		novo.setNome(nome);
		novo.setNumero(num);
		novo.setDataNascimento(data);
		novo.setSelecao(selecao);
		novo.setPosicao(posicao);
		
		if (jogadorDB.buscarJogador(novo.getId()) == null){
			jogadorDB.adicionar(novo);
		}
	}

	/**
	 * Metodo para cadastro do Tecnico
	 * 
	 * @param nome
	 *            nome do tecnico
	 * @param data
	 *            data de nascimento
	 * @param time
	 *            time que ele treina
	 * @return true se foi possivel cadastrar, false se n√£o foi possivel.
	 */
	public void cadastrarTecnico(String nome, Date data, Selecao time) {
		Tecnico novo = new Tecnico();
		novo.setNome(nome);
		novo.setDataNascimento(data);
		tecnicoDB.adicionar(novo);
		time.setTecnico(novo);
	}

	/**
	 * Metodo para cadastro das selecoes
	 * 
	 * @param nome
	 *            nome da selecao
	 * @param ano
	 *            ano da selecao
	 * @param grupo
	 * @param posicao
	 * @param pais
	 *            a qual pertence
	 * @return true se foi possivel o cadastro, false se ja existia a selecao
	 */
	public boolean cadastrarSelecao(String nome, int ano, String grupo,
			int posicao, Pais pais) {
		Selecao nova = new Selecao();
		nova.setNome(nome);
		nova.setAno(ano);
		nova.setGrupo(grupo);
		nova.setPosicao(posicao);

		Selecao busca = selecaoDB.buscarSelecao(nome, ano);
		if (busca == null) {
			selecaoDB.adicionar(nova);
			pais.addSelecao(nova);
			return true;
		} else {
			if (busca.getAno() != ano) {
				selecaoDB.adicionar(nova);
				pais.addSelecao(nova);
				return true;
			}
			return false;
		}
	}

	/**
	 * Metodo para cadstro da copa
	 * 
	 * @param ano
	 *            ano que a copa esta/estava acontecendo
	 * @param sede
	 *            pais sede da copa
	 * @return true se cadastrou,false se ja existia
	 */
	public boolean cadastrarCopa(int ano, Pais sede) {
		Copa nova = new Copa();
		nova.setAno(ano);
		nova.setPais(sede);
		Copa busca = copaDB.buscarCopa(ano);
		if (busca == null) {
			copaDB.adicionar(nova);
			return true;
		}
		return false;
	}

	/**
	 * Metodo dependente de copa, para o cadastro das selecoes na copa
	 * 
	 * @param selecao
	 *            selecao a ser cadastrada
	 * @param ano
	 *            ano da copa para busca
	 */
	public void cadastrarSelecaoNaCopa(Selecao selecao, int ano) {
		Copa busca = copaDB.buscarCopa(ano);
		Selecao sd = selecaoDB.buscarSelecao(selecao.getPais().getNome(), ano);
		if (busca != null && sd != null) {
			busca.addSelecao(sd);
		}
	}

	/**
	 * Metodo dependente da copa, para cadastro dos jogos na copa
	 * 
	 * @param jogo
	 *            jogo a ser cadastrado
	 * @param ano
	 *            ano da copa a ser buscada
	 */
	public void cadastrarJogoNaCopa(Jogo jogo, int ano) {
		Copa busca = copaDB.buscarCopa(ano);
		Jogo jogoD = jogoDB.buscarJogo(jogo.getId());
		if (busca != null && jogoD != null) {
			busca.addJogo(jogoD);
		}
	}

	/**
	 * Metodo que cadastra um novo Jogo
	 * 
	 * @param data
	 *            data de realizacao da partida
	 * @param local
	 *            onde a partida esta sendo realizada
	 * @param fase
	 *            qual fase do campeonato ela esta sendo disputada
	 * @param selecaoA
	 *            Selecao A na disputa
	 * @param selecaoB
	 *            Selecao B na disputa
	 * @param play1
	 *            Escalacao de jogadores do time A
	 * @param play2
	 *            Escalacao de jogadores do time B
	 * @return true se foi possivel , false se nao
	 */
	public void cadastrarJogo(Date data, String local, fase fase,
			Selecao selecaoA, Selecao selecaoB, Escalacao play1, Escalacao play2) {
		Jogo novo = new Jogo();
		novo.setData(data);
		novo.setLocal(local);
		novo.setSelecaoA(selecaoA);
		novo.setSelecaoB(selecaoB);
		novo.setEscalacaoA(play1);
		novo.setEscalacaoB(play2);
		jogoDB.adicionar(novo);
	}

	/**
	 * Cadastra um Gol em um jogo
	 * 
	 * @param jogo
	 *            jogo que o gol foi feito
	 * @param jogador
	 *            jogador que fez o gol
	 * @param contra
	 *            se o gol foi contra
	 * @param tempo
	 *            em quanto tempo o jogo foi feito
	 */
	public void CadastrarGol(Jogo jogo, Jogador jogador, boolean contra,
			Date tempo) {
		Gol novo = new Gol();
		novo.setFoiContra(contra);
		novo.setJogador(jogador);
		novo.setTempo(tempo);
		golDB.adicionar(novo);
		jogo.addGol(novo);
	}

	public List<Pais> listarPaisesCadastrados() {
		return paisDB.listar();
	}

	public List<Jogador> listarJogadoresCadastrados() {
		return jogadorDB.listar();
	}

	public List<Tecnico> listarTecnicossCadastrados() {
		return tecnicoDB.listar();
	}

	public List<Selecao> listarSelecoes(int ano) {
		return selecaoDB.listar(ano);
	}

	public Escalacao cadastrarEscalacao(Selecao selecao, Jogador selecionados[]) {
		Escalacao nova = new Escalacao();
		if (selecao == null) {
			return null;
		}
		if (selecionados.length != 11) {
			return null;
		}
		for (int i = 0; i < selecionados.length; i++) {
			nova.addJogadores(selecionados[i]);
		}
		nova.setSelecao(selecao);
		return nova;
	}

	/**
	 * Metodo que retorna a lista de Jogadores de uma selecao
	 * 
	 * @param nome
	 *            nome da selecao
	 * @param ano
	 *            ano da selecao
	 * @return lista de jogadores que pertecem/perteceram a selecao
	 */
	public Jogador[] listarJogadoresDeUmaSelecao(String nome, int ano) {
		List<Selecao> busca = selecaoDB.buscarSelecoes(nome); // busco a lista
																// de
		// jogadores
		Selecao a, resultado;
		if (busca != null) {
			for (int i = 0; i < busca.size(); i++) {
				a = (Selecao) busca.get(i);
				if (a.getAno() == ano) { // Apesar do nome ser igual e
											// necessario comparar o ano
					resultado = a; // se for igual, retorna a lista de jogadores
									// daquela selecao
					return resultado.getJogadores();
				}
			}

		}
		return null;

	}

	/**
	 * Metodo que retorna o nome do tecnico de uma selecao
	 * 
	 * @param nomeSelecao
	 *            nome da selecao do tecnico
	 * @param ano
	 *            ano da selecao
	 * @return nome do tecnico
	 */
	public String consultarTecnicoDeUmaSelecao(String nomeSelecao, int ano) {
		Selecao busca = selecaoDB.buscarSelecao(nomeSelecao, ano);
		Tecnico tecnico = busca.getTecnico();
		if (tecnico != null) {
			return tecnico.getNome();
		}
		return "Selecao Sem Tecnico, Jogadores Vid4 Lok4";
	}

	/**
	 * Metodo que lista todas as copas do mundo com seu ano e pais
	 * 
	 * @return uma lista dos paises
	 */
	public List<Copa> ListarTodasAsCopas() {
		List<Copa> copa = copaDB.listar();
		Copa listando;
		for (int i = 0; i < copa.size(); i++) {
			// Ja que nao sabemos de que forma sera listado ainda e.e
			listando = (Copa) copa.get(i);
			System.out.println("Copa do mundo de: " + listando.getAno() + "-"
					+ listando.getPais().getNome());
		}
		return copa;
	}

	/**
	 * Metodo que lista todos os paises participantes da copa de determinado ano
	 * 
	 * @param ano
	 *            ano da copa
	 */
	public void listarPaisesParticipantesDaCopa(int ano) {
		Copa copa = copaDB.buscarCopa(ano);
		LinkedList<Selecao> lista = (LinkedList<Selecao>) copa.getSelecoes();
		System.out.println("Participantes da copa de :" + ano);
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("-" + lista.get(i).getNome());
		}
	}

	/**
	 * Metodo que exibe placar de um jogo
	 * 
	 * @param ano
	 *            ano em que o jogo foi realizado
	 * @param selecaoA
	 *            Selecao que jogou
	 * @param selecaoB
	 *            Selecao que jogou
	 * @return  do jogo em forma de string
	 */
	public String exibirPlacarDeUmJogo(int ano, String selecaoA, String selecaoB) {

		int contA = 0, contB = 0;
		Copa c = copaDB.buscarCopa(ano);
		List<Jogo> jogos = c.getJogos();
		for (int i = 0; i < jogos.size(); i++) {
			if (selecaoA.equals(jogos.get(i).getSelecaoA().getNome())){
				if (selecaoB.equals(jogos.get(i).getSelecaoB().getNome())){
					contA = jogos.get(i).getSelecaoA().getGols().size();
					contB = jogos.get(i).getSelecaoB().getGols().size();
				}
			}
		}

		return "Placar: " + selecaoA + ": " + contA + " X " + contB + " :" + selecaoB;
	}

	/**
	 * Metodo que lista o placar de todos os jogos da copa de 1 ano
	 * 
	 * @param ano
	 *            ano da copa
	 */
	public void listarTodosOsJogosDeUmaCopa(int ano) {
		Copa copa = copaDB.buscarCopa(ano);
		LinkedList<Jogo> jogos = (LinkedList<Jogo>) copa.getJogos();
		for (int a = 0; a < jogos.size(); a++) {
			int contA = 0, contB = 0;
			LinkedList<Gol> apuracao = (LinkedList<Gol>) jogos.get(a).getGols();
			for (int i = 0; i < apuracao.size(); i++) {
				if (apuracao.get(i).isFoiContra()) { // se foi contra
					if (apuracao.get(i).getJogador().getSelecao()
							.equals(jogos.get(a).getSelecaoA())) { // verifica
																	// se foi a
																	// selecao A
																	// que fez
						contB++; // se foi a selecao A , incrementa os gols da
									// selecao B
					} else {
						contA++; // Se foi a B , incrementa nos gols da A
					}
				} else { // Se nao foi contra
					if (apuracao.get(i).getJogador().getSelecao()
							.equals(jogos.get(a).getSelecaoA())) {
						contA++;
					} else {
						contB++;
					}

				}
			}
			System.out.println("Placar de: "
					+ jogos.get(a).getSelecaoA().getNome() + "e: " + contA
					+ " contra " + contB + " da "
					+ jogos.get(a).getSelecaoB().getNome());

		}
	}

	public void mostrarEscalacaoDeUmaSelecao(String nomeSelecao, int ano) {
		Selecao busca = selecaoDB.buscarSelecao(nomeSelecao, ano);
		Jogador[] players = busca.getJogadores();
		System.out.println("Selecao: " + nomeSelecao + "Jogadores:");
		for (int i = 0; i < players.length; i++) {
			System.out.println("Jogador:" + players[i].getNome()
					+ "Jogando na posicao" + players[i].getPosicao().name());
		}
	}

	public void mostrarSubstituicoes(int ano, String selecaoA, String selecaoB) {
		Copa c = copaDB.buscarCopa(ano);
		Jogo j = null;
		Substituicao subs;
		List<Jogo> jogos = c.getJogos();
		for (int i = 0; i < jogos.size(); i++) {
			if (selecaoA.equals(jogos.get(i).getSelecaoA().getNome())){
				if (selecaoB.equals(jogos.get(i).getSelecaoB().getNome())){
					j = jogos.get(i);
				}
			}
		}
		
		List<Substituicao> subsA = j.getSubstituicoesA();
		List<Substituicao> subsB = j.getSubstituicoesB();
		
		
		System.out.println("Substituicoes do Time "
				+ selecaoA);
		for (int i = 0; i < subsA.size(); i++) {
			subs = subsA.get(i);
			System.out.println("Sai " + subs.getSai().getNome() + "e entra "
					+ subs.getEntra().getNome());
		}
		System.out.println("Substituicoes do Time "
				+ selecaoB);
		for (int i = 0; i < subsB.size(); i++) {
			subs = subsB.get(i);
			System.out.println("Sai " + subs.getSai().getNome() + "e entra "
					+ subs.getEntra().getNome());
		}

	}
	
	//TODO ALBERTO
	public void listarGolsDeUmaPartida(Jogo jogod){
		
		Jogo jogo = jogoDB.buscarJogo(jogod.getId());

		if(jogo != null){
			jogo.getGols();
			Iterator<Gol> it = jogo.getGols().iterator();
			while(it.hasNext()){
				System.out.println(it.next().toString());
			}
		}
		else {
			System.out.println("Partida inexistente");
		}
	}
	
	public int quantidadeDeJogosDeUmPais(String nome){
		int i = 0;
		Pais pais = paisDB.buscarPais(nome);
		
		if(pais != null){
			Copa copa;
			//Pega todas as copas do pais
			Iterator<Copa> itC = pais.getCopas().iterator();
			
			while(itC.hasNext()){
				copa = itC.next();
				//pega todos os jogos da copa
				Iterator<Jogo> itCJ = copa.getJogos().iterator();
				while(itCJ.hasNext()){
					//pergunta se a SelecaoA ou a SelecaoB È o pais escolhido
					if(itCJ.next().getSelecaoA().getNome().equals(pais.getNome()) || itCJ.next().getSelecaoB().getNome().equals(pais.getNome())){
						i++;
					}
				}

			}
		}
		else {
			return 0;
		}
		
		return i;
	}

	public void listarJogosEmpatadosDaCopa(int ano){
		Copa copa = copaDB.buscarCopa(ano);
		if(copa != null){
			Iterator<Jogo> it = copa.getJogos().iterator();
			while(it.hasNext()){
				Jogo jogo = it.next();
				if(jogo.getGols().size() % 2 == 0){
					System.out.println(jogo.toString());
				}
			}
		}
	}

}
