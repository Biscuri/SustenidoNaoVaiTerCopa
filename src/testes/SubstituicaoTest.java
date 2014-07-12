package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.ecomp.naovaitercopa.modelo.Substituicao;
import br.ecomp.naovaitercopa.modelo.dao.SubstituicaoDAOHibernate;

public class SubstituicaoTest {
	SubstituicaoDAOHibernate x = new SubstituicaoDAOHibernate();
	private Substituicao x1 = new Substituicao();
	private Substituicao x2 = new Substituicao();

	@Test
	public void testAdicionar() {
		x1 = new Substituicao();
		x2 = new Substituicao();
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
		Substituicao x1 = x.buscarSubstituicao(1);
		x1.setId((long) 3);
		x.atualizar(x1);
		assertThat(x.buscarSubstituicao(3).getId(),is((long) 3));
	}

	@Test
	public void testRemover() {
		x1 = x.buscarSubstituicao(3);
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
		List<Substituicao> aux = x.listar();
		assertThat(1, is(aux.size()));
	}

	@Test
	public void testBuscar() {
		x1 = x.buscarSubstituicao(2);
		assertThat(x1.getId(),is((long) 2));
	}

}
