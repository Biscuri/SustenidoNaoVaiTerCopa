package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.ecomp.naovaitercopa.modelo.Escalacao;
import br.ecomp.naovaitercopa.modelo.dao.EscalacaoDAOHibernate;

public class EscalacaoTest {
	EscalacaoDAOHibernate e = new EscalacaoDAOHibernate();
	private Escalacao e1 = new Escalacao();
	private Escalacao e2 = new Escalacao();

	@Test
	public void testAdicionar() {
		e1 = new Escalacao();
		e2 = new Escalacao();
		e1.setId((long) 1);
		e2.setId((long) 2);
		assertThat(e.listar().size(),is(0));
		e.adicionar(e1);
		assertThat(e.listar().size(),is(1));
		e.adicionar(e2);
		assertThat(e.listar().size(),is(2));
	}

	@Test
	public void testAtualizar() {
		Escalacao e1 = e.buscarEscalacao(1);
		e1.setId((long) 3);
		e.atualizar(e1);
		assertThat(e.buscarEscalacao(3).getId(),is((long) 3));
	}

	@Test
	public void testRemover() {
		e1 = e.buscarEscalacao(3);
		e.remover(e1);
		assertThat(e.listar().size(),is(1));
	}

	@Test
	public void testRemoverTodos() {
		e.removerTodos();
		assertThat(e.listar().size(),is(0));
	}

	@Test
	public void testListar() {
		List<Escalacao> aux = e.listar();
		assertThat(1, is(aux.size()));
	}

	@Test
	public void testBuscar() {
		e1 = e.buscarEscalacao(2);
		assertThat(e1.getId(),is((long) 2));
	}

}
