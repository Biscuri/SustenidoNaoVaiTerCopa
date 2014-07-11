package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.ecomp.naovaitercopa.modelo.Gol;
import br.ecomp.naovaitercopa.modelo.dao.GolDAOHibernate;

public class GolTest {
	GolDAOHibernate x = new GolDAOHibernate();
	private Gol x1 = new Gol();
	private Gol x2 = new Gol();

	@Test
	public void testAdicionar() {
		x1 = new Gol();
		x2 = new Gol();
		x1.setId((long) 1);
		x2.setId((long) 2);
		assertThat(x.listar().size(),is(0));
		x.adicionar(x1);
		assertThat(x.listar().size(),is(1));
		x.adicionar(x2);
		assertThat(x.listar().size(),is(2));
	}

	@Test
	public void testAtualizar() {
		Gol x1 = x.buscarGol(1);
		x1.setId((long) 3);
		x.atualizar(x1);
		assertThat(x.buscarGol(3).getId(),is((long) 3));
	}

	@Test
	public void testRemover() {
		x1 = x.buscarGol(3);
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
		List<Gol> aux = x.listar();
		assertThat(1, is(aux.size()));
	}

	@Test
	public void testBuscar() {
		x1 = x.buscarGol(2);
		assertThat(x1.getId(),is((long) 2));
	}

}
