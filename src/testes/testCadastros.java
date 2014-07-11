package testes;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Calendar;

import br.ecomp.naovaitercopa.modelo.*;
import br.ecomp.naovaitercopa.modelo.Jogador.posicao;
import br.ecomp.naovaitercopa.modelo.Jogo.fase;

import org.junit.Test;

public class testCadastros {

	private Controller controller = new Controller();
	private Copa c1,c2;
	private Jogo g1,g2,g3,g4,g5;
	private Selecao s1,s2,s3,s4,s5,s6,s7,s8;
	private Jogador[] j1,j2,j3,j4,j5,j6,j7,j8;
	private Escalacao e11,e12,e21,e22,e31,e32,e41,e42,e51,e52;
	private Tecnico t1,t2,t3,t4,t5,t6,t7,t8;
	private Pais p1, p2, p3, p4, p5, p6, p7, p8;
	
	@Test
	public void test(){
		
		//Insere e busca pa�ses.
		assertThat(controller.CadastrarPais("Brasil", "America do Sul"), is(true));
		assertThat(controller.CadastrarPais("Alemanha", "Europa"),is(true));
		assertThat(controller.CadastrarPais("Argentina", "America do Sul"),is(true));
		assertThat(controller.CadastrarPais("EUA", "Murica"),is(true));
		assertThat(controller.CadastrarPais("Inglaterra", "Europa"),is(true));
		assertThat(controller.CadastrarPais("Japao", "Asia"),is(true));
		assertThat(controller.CadastrarPais("Holanda", "Europa"),is(true));
		assertThat(controller.CadastrarPais("Costa Rica", "America Central"),is(true));
		
		p1 = controller.BuscarPais("Brasil");
		p2 = controller.BuscarPais("Alemanha");
		p3 = controller.BuscarPais("Argentina");
		p4 = controller.BuscarPais("EUA");
		p5 = controller.BuscarPais("Inglaterra");
		p6 = controller.BuscarPais("Japao");
		p7 = controller.BuscarPais("Holanda");
		p8 = controller.BuscarPais("Costa Rica");
		
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
		assertNotNull(p4);
		assertNotNull(p5);
		assertNotNull(p6);
		
		//Insere e busca Copas
		assertThat(controller.CadastrarCopa(2014, p1), is(true));
		assertThat(controller.CadastrarCopa(2018, p4), is(true));
		
		c1 = controller.BuscarCopa(2014);
		c2 = controller.BuscarCopa(2018);
		
		assertNotNull(c1);
		assertNotNull(c2);
		
		//Insere e busca sele��es
		
		assertThat(controller.CadastrarSelecao("Brasil", 2014, "A", 4, p1),is(true));
		assertThat(controller.CadastrarSelecao("Alemanha", 2014, "A", 1, p2),is(true));
		assertThat(controller.CadastrarSelecao("Argentina", 2014, "A", 2, p3),is(true));
		assertThat(controller.CadastrarSelecao("EUA", 2014, "A", 8, p4),is(true));
		assertThat(controller.CadastrarSelecao("Inglaterra", 2014, "B", 6, p5),is(true));
		assertThat(controller.CadastrarSelecao("Japao", 2014, "B", 7, p6),is(true));
		assertThat(controller.CadastrarSelecao("Holanda", 2014, "B", 3, p7),is(true));
		assertThat(controller.CadastrarSelecao("Costa Rica", 2014, "B", 5, p8),is(true));
		
		s1 = controller.BuscarSelecao("Brasil", 2014);
		s2 = controller.BuscarSelecao("Alemanha", 2014);
		s3 = controller.BuscarSelecao("Argentina", 2014);
		s4 = controller.BuscarSelecao("EUA", 2014);
		s5 = controller.BuscarSelecao("Inglaterra", 2014);
		s6 = controller.BuscarSelecao("Japao", 2014);
		s7 = controller.BuscarSelecao("Holanda", 2014);
		s8 = controller.BuscarSelecao("Costa Rica", 2014);
		
		//Insere e busca jogadores
		
		j1 = new Jogador[23];
		j2 = new Jogador[23];
		j3 = new Jogador[23];
		j4 = new Jogador[23];
		j5 = new Jogador[23];
		j6 = new Jogador[23];
		j7 = new Jogador[23];
		j8 = new Jogador[23];
		
		Calendar c = Calendar.getInstance();
		c.set(2014, Calendar.JANUARY, 10);
		
		for (int i = 0 ; i < 23 ; i++){
			j1[i] = new Jogador();			
			j1[i].setNome("carinha"+i);
			j1[i].setDataNascimento(c);
			j1[i].setNumero(i);
			j1[i].setPosicao(posicao.GOLEIRO);
			
			assertThat(controller.CadastrarJogador("carinha"+i, c, i, posicao.GOLEIRO, s1),is(true));
			
			j2[i] = new Jogador();
			j2[i].setNome("manolo"+i);
			j2[i].setDataNascimento(c);
			j2[i].setNumero(i);
			j2[i].setPosicao(posicao.MEIAARMADOR);
			
			assertThat(controller.CadastrarJogador("manolo"+i, c, i, posicao.MEIAARMADOR, s2),is(true));
			
			j3[i] = new Jogador();
			j3[i].setNome("truta"+i);
			j3[i].setDataNascimento(c);
			j3[i].setNumero(i);
			j3[i].setPosicao(posicao.ZAGUEIRO);
			
			assertThat(controller.CadastrarJogador("truta"+i, c, i, posicao.ZAGUEIRO, s3),is(true));
			
			j4[i] = new Jogador();
			j4[i].setNome("brodinho"+i);
			j4[i].setDataNascimento(c);
			j4[i].setNumero(i);
			j4[i].setPosicao(posicao.VOLANTE);
			
			assertThat(controller.CadastrarJogador("brodinho"+i, c, i, posicao.VOLANTE, s4),is(true));
			
			j5[i] = new Jogador();
			j5[i].setNome("dot"+i);
			j5[i].setDataNascimento(c);
			j5[i].setNumero(i);
			j5[i].setPosicao(posicao.MEIOCAMPISTALATERALESQUERDO);
			
			assertThat(controller.CadastrarJogador("dot"+i, c, i, posicao.MEIOCAMPISTALATERALESQUERDO, s5),is(true));
			
			j6[i] = new Jogador();
			j6[i].setNome("line"+i);
			j6[i].setDataNascimento(c);
			j6[i].setNumero(i);
			j6[i].setPosicao(posicao.MEIOCAMPISTALATERALDIREITO);
			
			assertThat(controller.CadastrarJogador("line"+i, c, i, posicao.MEIOCAMPISTALATERALDIREITO, s6),is(true));
			
			j7[i] = new Jogador();
			j7[i].setNome("exclamation"+i);
			j7[i].setDataNascimento(c);
			j7[i].setNumero(i);
			j7[i].setPosicao(posicao.PONTA);
			
			assertThat(controller.CadastrarJogador("line"+i, c, i, posicao.PONTA, s7),is(true));
			
			j8[i] = new Jogador();
			j8[i].setNome("interrogation"+i);
			j8[i].setDataNascimento(c);
			j8[i].setNumero(i);
			j8[i].setPosicao(posicao.LIBERO);
			
			assertThat(controller.CadastrarJogador("line"+i, c, i, posicao.LIBERO, s8),is(true));
		}
		
		assertNotNull(controller.BuscarJogador("carinha0",s1));
		assertNotNull(controller.BuscarJogador("manolo2",s2));
		assertNotNull(controller.BuscarJogador("truta3",s3));
		assertNotNull(controller.BuscarJogador("brodinho5",s4));
		assertNotNull(controller.BuscarJogador("dot8",s5));
		assertNotNull(controller.BuscarJogador("line7",s6));
		assertNotNull(controller.BuscarJogador("exclamation1",s7));
		assertNotNull(controller.BuscarJogador("interrogation22",s8));
		
		//Insere e busca tecnicos
		
		assertThat(controller.CadastrarTecnico("Albertocheater", c, s1),is(true));
		assertThat(controller.CadastrarTecnico("Lenoilluminati", c, s2),is(true));
		assertThat(controller.CadastrarTecnico("Lucasnoob", c, s3),is(true));
		assertThat(controller.CadastrarTecnico("Carinhaquemoralogoali", c, s4),is(true));
		assertThat(controller.CadastrarTecnico("DotaehmelhorqueLoL", c, s5),is(true));
		assertThat(controller.CadastrarTecnico("WoWsugaalmas", c, s6),is(true));
		assertThat(controller.CadastrarTecnico("qwertyuiopissoasdfghjklehuma", c, s7),is(true));
		assertThat(controller.CadastrarTecnico("zxcvbnmmensagemqazwsxedcrfvsubliminartgbyhnujm", c, s8),is(true));
		
		t1 = controller.BuscarTecnico("Albertocheater");
		t2 = controller.BuscarTecnico("Lenoilluminati");
		t3 = controller.BuscarTecnico("Lucasnoob");
		t4 = controller.BuscarTecnico("Carinhaquemoralogoali");
		t5 = controller.BuscarTecnico("DotaehmelhorqueLoL");
		t6 = controller.BuscarTecnico("WoWsugaalmas");
		t7 = controller.BuscarTecnico("qwertyuiopissoasdfghjklehuma");
		t8 = controller.BuscarTecnico("zxcvbnmmensagemqazwsxedcrfvsubliminartgbyhnujm");
		
		assertThat(s1.getTecnico(),is(t1));
		assertThat(s2.getTecnico(),is(t2));
		assertThat(s3.getTecnico(),is(t3));
		assertThat(s4.getTecnico(),is(t4));
		assertThat(s5.getTecnico(),is(t5));
		assertThat(s6.getTecnico(),is(t6));
		assertThat(s7.getTecnico(),is(t7));
		assertThat(s8.getTecnico(),is(t8));
	
		//Insere selecoes na copa
		controller.CadastrarSelecaoNaCopa(s1, 2014);
		controller.CadastrarSelecaoNaCopa(s2, 2014);
		controller.CadastrarSelecaoNaCopa(s3, 2014);
		controller.CadastrarSelecaoNaCopa(s4, 2014);
		controller.CadastrarSelecaoNaCopa(s5, 2014);
		controller.CadastrarSelecaoNaCopa(s6, 2014);
		controller.CadastrarSelecaoNaCopa(s7, 2014);
		controller.CadastrarSelecaoNaCopa(s8, 2014);
		controller.CadastrarSelecaoNaCopa(s1, 2018);
		controller.CadastrarSelecaoNaCopa(s2, 2018);
		controller.CadastrarSelecaoNaCopa(s3, 2018);
		controller.CadastrarSelecaoNaCopa(s4, 2018);
		controller.CadastrarSelecaoNaCopa(s5, 2018);
		controller.CadastrarSelecaoNaCopa(s6, 2018);
		controller.CadastrarSelecaoNaCopa(s7, 2018);
		controller.CadastrarSelecaoNaCopa(s8, 2018);
		
		assertNotNull(controller.BuscarCopa(2014).getSelecoes());
		assertNotNull(controller.BuscarCopa(2018).getSelecoes());
		
		//Insere e busca jogos
		
		Calendar c1 = Calendar.getInstance();
		c1.set(2014, Calendar.JULY, 10);
		Calendar c2 = Calendar.getInstance();
		c2.set(2014, Calendar.JULY, 10);
		Calendar c3 = Calendar.getInstance();
		c3.set(2014, Calendar.JULY, 13);
		Calendar c4 = Calendar.getInstance();
		c4.set(2014, Calendar.JULY, 13);
		Calendar c5 = Calendar.getInstance();
		c5.set(2014, Calendar.JULY, 31);
		
	}
	
}
