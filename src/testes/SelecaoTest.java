package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.ecomp.naovaitercopa.modelo.Pais;
import br.ecomp.naovaitercopa.modelo.Selecao;
import br.ecomp.naovaitercopa.modelo.dao.SelecaoDAOHibernate;

public class SelecaoTest {
	SelecaoDAOHibernate x = new SelecaoDAOHibernate();
	private Selecao x1 = new Selecao();
	private Selecao x2 = new Selecao();

	@Test
	public void testAdicionar() {
		x1 = new Selecao();
		x2 = new Selecao();
		Pais p1 = new Pais();
		p1.setNome("Alemanha");
		p1.setContinente("Europa");
		x1.setId((long) 1);
		x1.setPais(p1);
		x2.setId((long) 2);
		Pais p2 = new Pais();
		p2.setNome("Holanda");
		p2.setContinente("Europa");
		x2.setPais(p2);
		assertThat(x.listar().size(),is(0));
		x.adicionar(x1);
		assertThat(x.listar().size(),is(1));
		x.adicionar(x2);
		assertThat(x.listar().size(),is(2));
	}

	@Test
	public void testAtualizar() {
		x1 = x.buscarSelecoes("Alemanha").get(0);
		x1.getPais().setNome("Inglaterra");
		x.atualizar(x1);
		assertThat(x.buscarSelecoes("Inglaterra").get(0).getPais().getNome(),is("Inglaterra"));
	}

	@Test
	public void testRemover() {
		x1 = x.buscarSelecoes("Inglaterra").get(0);
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
		List<Selecao> aux = x.listar();
		assertThat(1, is(aux.size()));
	}

	@Test
	public void testBuscar() {
		x1 = x.buscarSelecoes("Holanda").get(0);
		assertThat(x1.getNome(),is("Holanda"));
	}

}
