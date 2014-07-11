package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.ecomp.naovaitercopa.modelo.Copa;
import br.ecomp.naovaitercopa.modelo.dao.CopaDAOHibernate;

public class CopaTest {
	
	private CopaDAOHibernate c = new CopaDAOHibernate();
	private Copa c1 = new Copa();
	private Copa c2 = new Copa();

	@Test
	public void testAdicionar() {
		c1 = new Copa();
		c2 = new Copa();
		c1.setAno(2014);
		c2.setAno(2018);
		assertThat(c.listar().size(),is(0));
		c.adicionar(c1);
		assertThat(c.listar().size(),is(1));
		c.adicionar(c2);
		assertThat(c.listar().size(),is(2));
	}

	@Test
	public void testAtualizar() {
		Copa c1 = c.buscarCopa(2014);
		c1.setAno(2002);
		c.atualizar(c1);
		assertThat(c.buscarCopa(2002).getAno(),is(2002));
	}

	@Test
	public void testRemover() {
		c1 = c.buscarCopa(2002);
		c.remover(c1);
		assertThat(c.listar().size(),is(1));
	}

	@Test
	public void testRemoverTodos() {
		c.removerTodos();
		assertThat(c.listar().size(),is(0));
	}

	@Test
	public void testListar() {
		List<Copa> aux = c.listar();
		assertThat(1, is(aux.size()));
	}

	@Test
	public void testBuscar() {
		c1 = c.buscarCopa(2018);
		assertThat(c1.getAno(),is(2018));
	}

}
