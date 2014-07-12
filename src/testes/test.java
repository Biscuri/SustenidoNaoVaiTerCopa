package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import br.ecomp.naovaitercopa.modelo.*;

@Deprecated
public class test {

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
		
		//Insere e busca paï¿½ses.
		assertThat(controller.cadastrarPais("Brasil", "America do Sul"), is(true));
		assertThat(controller.cadastrarPais("Alemanha", "Europa"),is(true));
		assertThat(controller.cadastrarPais("Argentina", "America do Sul"),is(true));
		assertThat(controller.cadastrarPais("EUA", "Murica"),is(true));
		assertThat(controller.cadastrarPais("Inglaterra", "Europa"),is(true));
		assertThat(controller.cadastrarPais("Japao", "Asia"),is(true));
		assertThat(controller.cadastrarPais("Holanda", "Europa"),is(true));
		assertThat(controller.cadastrarPais("Costa Rica", "America Central"),is(true));
		
		p1 = controller.buscarPais("Brasil");
		p2 = controller.buscarPais("Alemanha");
		p3 = controller.buscarPais("Argentina");
		p4 = controller.buscarPais("EUA");
		p5 = controller.buscarPais("Inglaterra");
		p6 = controller.buscarPais("Japao");
		p7 = controller.buscarPais("Holanda");
		p8 = controller.buscarPais("Costa Rica");
		
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
		assertNotNull(p4);
		assertNotNull(p5);
		assertNotNull(p6);
		
		//Insere e busca Copas
		assertThat(controller.cadastrarCopa(2014, p1), is(true));
		assertThat(controller.cadastrarCopa(2018, p4), is(true));
		
		c1 = controller.BuscarCopa(2014);
		c2 = controller.BuscarCopa(2018);
		
		assertNotNull(c1);
		assertNotNull(c2);
		
		//Insere e busca seleï¿½ï¿½es
		
		assertThat(controller.cadastrarSelecao("Brasil", 2014, "A", 4, p1),is(true));
		assertThat(controller.cadastrarSelecao("Alemanha", 2014, "A", 1, p2),is(true));
		assertThat(controller.cadastrarSelecao("Argentina", 2014, "A", 2, p3),is(true));
		assertThat(controller.cadastrarSelecao("EUA", 2014, "A", 8, p4),is(true));
		assertThat(controller.cadastrarSelecao("Inglaterra", 2014, "B", 6, p5),is(true));
		assertThat(controller.cadastrarSelecao("Japao", 2014, "B", 7, p6),is(true));
		assertThat(controller.cadastrarSelecao("Holanda", 2014, "B", 3, p7),is(true));
		assertThat(controller.cadastrarSelecao("Costa Rica", 2014, "B", 5, p8),is(true));
		
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
		
		Date c = new Date(2000-10-01);
		
		for (int i = 0 ; i < 23 ; i++){
			j1[i] = new Jogador();			
			j1[i].setNome("carinha"+i);
			j1[i].setDataNascimento(c);
			j1[i].setNumero(i);
			j1[i].setPosicao(posicao.GOLEIRO);
			
			assertThat(controller.cadastrarJogador("carinha"+i, c, i, posicao.GOLEIRO, s1),is(true));
			
			j2[i] = new Jogador();
			j2[i].setNome("manolo"+i);
			j2[i].setDataNascimento(c);
			j2[i].setNumero(i);
			j2[i].setPosicao(posicao.MEIAARMADOR);
			
			assertThat(controller.cadastrarJogador("manolo"+i, c, i, posicao.MEIAARMADOR, s2),is(true));
			
			j3[i] = new Jogador();
			j3[i].setNome("truta"+i);
			j3[i].setDataNascimento(c);
			j3[i].setNumero(i);
			j3[i].setPosicao(posicao.ZAGUEIRO);
			
			assertThat(controller.cadastrarJogador("truta"+i, c, i, posicao.ZAGUEIRO, s3),is(true));
			
			j4[i] = new Jogador();
			j4[i].setNome("brodinho"+i);
			j4[i].setDataNascimento(c);
			j4[i].setNumero(i);
			j4[i].setPosicao(posicao.VOLANTE);
			
			assertThat(controller.cadastrarJogador("brodinho"+i, c, i, posicao.VOLANTE, s4),is(true));
			
			j5[i] = new Jogador();
			j5[i].setNome("dot"+i);
			j5[i].setDataNascimento(c);
			j5[i].setNumero(i);
			j5[i].setPosicao(posicao.MEIOCAMPISTALATERALESQUERDO);
			
			assertThat(controller.cadastrarJogador("dot"+i, c, i, posicao.MEIOCAMPISTALATERALESQUERDO, s5),is(true));
			
			j6[i] = new Jogador();
			j6[i].setNome("line"+i);
			j6[i].setDataNascimento(c);
			j6[i].setNumero(i);
			j6[i].setPosicao(posicao.MEIOCAMPISTALATERALDIREITO);
			
			assertThat(controller.cadastrarJogador("line"+i, c, i, posicao.MEIOCAMPISTALATERALDIREITO, s6),is(true));
			
			j7[i] = new Jogador();
			j7[i].setNome("exclamation"+i);
			j7[i].setDataNascimento(c);
			j7[i].setNumero(i);
			j7[i].setPosicao(posicao.PONTA);
			
			assertThat(controller.cadastrarJogador("exclamation"+i, c, i, posicao.PONTA, s7),is(true));
			
			j8[i] = new Jogador();
			j8[i].setNome("interrogation"+i);
			j8[i].setDataNascimento(c);
			j8[i].setNumero(i);
			j8[i].setPosicao(posicao.LIBERO);
			
			assertThat(controller.cadastrarJogador("interrogation"+i, c, i, posicao.LIBERO, s8),is(true));
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
		
		assertThat(controller.cadastrarTecnico("Albertocheater", c, s1),is(true));
		assertThat(controller.cadastrarTecnico("Lenoilluminati", c, s2),is(true));
		assertThat(controller.cadastrarTecnico("Lucasnoob", c, s3),is(true));
		assertThat(controller.cadastrarTecnico("Carinhaquemoralogoali", c, s4),is(true));
		assertThat(controller.cadastrarTecnico("DotaehmelhorqueLoL", c, s5),is(true));
		assertThat(controller.cadastrarTecnico("WoWsugaalmas", c, s6),is(true));
		assertThat(controller.cadastrarTecnico("qwertyuiopissoasdfghjklehuma", c, s7),is(true));
		assertThat(controller.cadastrarTecnico("zxcvbnmmensagemqazwsxedcrfvsubliminartgbyhnujm", c, s8),is(true));
		
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
		controller.cadastrarSelecaoNaCopa(s1, 2014);
		controller.cadastrarSelecaoNaCopa(s2, 2014);
		controller.cadastrarSelecaoNaCopa(s3, 2014);
		controller.cadastrarSelecaoNaCopa(s4, 2014);
		controller.cadastrarSelecaoNaCopa(s5, 2014);
		controller.cadastrarSelecaoNaCopa(s6, 2014);
		controller.cadastrarSelecaoNaCopa(s7, 2014);
		controller.cadastrarSelecaoNaCopa(s8, 2014);
		controller.cadastrarSelecaoNaCopa(s1, 2018);
		controller.cadastrarSelecaoNaCopa(s2, 2018);
		controller.cadastrarSelecaoNaCopa(s3, 2018);
		controller.cadastrarSelecaoNaCopa(s4, 2018);
		controller.cadastrarSelecaoNaCopa(s5, 2018);
		controller.cadastrarSelecaoNaCopa(s6, 2018);
		controller.cadastrarSelecaoNaCopa(s7, 2018);
		controller.cadastrarSelecaoNaCopa(s8, 2018);
		
		assertNotNull(controller.BuscarCopa(2014).getSelecoes());
		assertNotNull(controller.BuscarCopa(2018).getSelecoes());
		
		//Insere e busca jogos
		
		Date d1 = new Date(2014-07-10);
		Date d2 = new Date(2014-07-10);
		Date d3 = new Date(2014-07-10);
		Date d4 = new Date(2014-07-10);
		Date d5 = new Date(2014-07-10);
		
		Jogador[] j11 = new Jogador[11];
		Jogador[] j22 = new Jogador[11];
		Jogador[] j33 = new Jogador[11];
		Jogador[] j44 = new Jogador[11];
		Jogador[] j55 = new Jogador[11];
		Jogador[] j66 = new Jogador[11];
		Jogador[] j77 = new Jogador[11];
		Jogador[] j88 = new Jogador[11];
		
		for (int i = 0 ; i < 11 ; i++){
			j11[i] = j1[i];
			j22[i] = j2[i];
			j33[i] = j3[i];
			j44[i] = j4[i];
			j55[i] = j5[i];
			j66[i] = j6[i];
			j77[i] = j7[i];
			j88[i] = j8[i];
		}
		
		e11 = controller.cadastrarEscalacao(s1, j11);
		e12 = controller.cadastrarEscalacao(s1, j22);
		e21 = controller.cadastrarEscalacao(s2, j33);
		e22 = controller.cadastrarEscalacao(s3, j44);
		e31 = controller.cadastrarEscalacao(s4, j55);
		e32 = controller.cadastrarEscalacao(s6, j66);
		e41 = controller.cadastrarEscalacao(s7, j77);
		e42 = controller.cadastrarEscalacao(s8, j88);
		
		assertNotNull(e11);
		assertNotNull(e12);
		assertNotNull(e21);
		assertNotNull(e22);
		assertNotNull(e31);
		assertNotNull(e32);
		assertNotNull(e41);
		assertNotNull(e42);
		
		assertThat(controller.cadastrarJogo(d1, "FSA", fase.GRUPOS, s1, s2, e11, e12),is(true));
		assertThat(controller.cadastrarJogo(d2, "SP", fase.GRUPOS, s3, s4, e21, e22),is(true));
		assertThat(controller.cadastrarJogo(d3, "RJ", fase.GRUPOS, s5, s6, e31, e32),is(true));
		assertThat(controller.cadastrarJogo(d4, "Acre", fase.GRUPOS, s7, s8, e41, e42),is(true));
		assertThat(controller.cadastrarJogo(d5, "Seará", fase.FINAL, s2, s3, e51, e52),is(true));
		
		g1 = controller.BuscarJogo("FSA", d1, s1, s2, fase.GRUPOS);
		g2 = controller.BuscarJogo("SP", d2, s3, s4, fase.GRUPOS);
		g3 = controller.BuscarJogo("RJ", d3, s5, s6, fase.GRUPOS);
		g4 = controller.BuscarJogo("Acre", d4, s7, s8, fase.GRUPOS);
		g5 = controller.BuscarJogo("Seará", d5, s2, s3, fase.FINAL);
		
		assertNotNull(g1);
		assertNotNull(g2);
		assertNotNull(g3);
		assertNotNull(g4);
		assertNotNull(g5);
		
	}
	
	@Test
	public void testUserStories(){
		
	}
	
}
