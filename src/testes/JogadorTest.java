package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.ecomp.naovaitercopa.modelo.Jogador;
import br.ecomp.naovaitercopa.modelo.Jogador.Posicao;
import br.ecomp.naovaitercopa.modelo.dao.JogadorDAOHibernate;

public class JogadorTest {
	JogadorDAOHibernate x = new JogadorDAOHibernate();
	private Jogador x1 = new Jogador();
	private Jogador x2 = new Jogador();

	@Test
	public void testAdicionar() {
		x1 = new Jogador();
		x2 = new Jogador();
		x1.setId((long) 1);
		x1.setNome("Albertocheater");
		Date d1 = new Date(1994-01-01);
		x1.setDataNascimento(d1);
		x1.setNumero(24);
		x1.setPosicao(Posicao.GOLEIRO);
		x2.setId((long) 2);
		x2.setNome("Lucasnoob");
		x2.setDataNascimento(d1);
		x2.setNumero(11);
		x2.setPosicao(Posicao.LIBERO);
		
		assertThat(x.listar().size(),is(0));
		x.adicionar(x1);
		assertThat(x.listar().size(),is(1));
		x.adicionar(x2);
		assertThat(x.listar().size(),is(2));
	}

	@Test
	public void testAtualizar() {
		Jogador x1 = x.buscarJogador(1);
		x1.setId((long) 3);
		x1.setNome("Lenoilluminati");
		Date d1 = new Date(1995-10-07);
		x1.setDataNascimento(d1);
		x1.setNumero(13);
		x1.setPosicao(Posicao.ZAGUEIRO);
		x.atualizar(x1);
		assertThat(x.buscarJogador(3).getId(),is((long) 3));
		assertThat(x.buscarJogador(3).getNome(),is("Lenoilluminati"));
		assertThat(x.buscarJogador(3).getNumero(),is(13));
		assertThat(x.buscarJogador(3).getPosicao(),is(Posicao.ZAGUEIRO));
	}

	@Test
	public void testRemover() {
		x1 = x.buscarJogador(3);
		x.remover(x1);
		assertThat(x.listar().size(),is(1));
	}

	@Test
	public void testRemoverTodos() {
		x.removerTodos();
		assertThat(x.listar().size(),is(0));
	}

	@Test
	public void testListar() {
		List<Jogador> aux = x.listar();
		assertThat(1, is(aux.size()));
	}

	@Test
	public void testBuscar() {
		x1 = x.buscarJogador(2);
		assertThat(x1.getId(),is((long) 2));
	}

}
