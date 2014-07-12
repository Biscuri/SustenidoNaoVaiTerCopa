package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.ecomp.naovaitercopa.modelo.Pais;
import br.ecomp.naovaitercopa.modelo.dao.PaisDAOHibernate;

public class PaisTest {
	PaisDAOHibernate x = new PaisDAOHibernate();
	private Pais x1 = new Pais();
	private Pais x2 = new Pais();

	@Test
	public void testAdicionar() {
		x1 = new Pais();
		x2 = new Pais();
		x1.setId((long) 1);
		x1.setNome("Alemanha");
		x1.setContinente("Europa");
		x2.setId((long) 2);
		x2.setNome("Holanda");
		x2.setContinente("Europa");
		assertThat(x.listar().size(),is(0));
		x.adicionar(x1);
		assertThat(x.listar().size(),is(1));
		x.adicionar(x2);
		assertThat(x.listar().size(),is(2));
	}

	@Test
	public void testAtualizar() {
		Pais x1 = x.buscarPais("Alemanha");
		x1.setNome("Inglaterra");
		x.atualizar(x1);
		assertThat(x.buscarPais("Inglaterra").getNome(),is("Inglaterra"));
	}

	@Test
	public void testRemover() {
		x1 = x.buscarPais("Inglaterra");
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
		List<Pais> aux = x.listar();
		assertThat(1, is(aux.size()));
	}

	@Test
	public void testBuscar() {
		x1 = x.buscarPais("Holanda");
		assertThat(x1.getNome(),is("Holanda"));
	}

}