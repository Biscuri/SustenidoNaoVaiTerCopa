package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.ecomp.naovaitercopa.modelo.Tecnico;
import br.ecomp.naovaitercopa.modelo.dao.TecnicoDAOHibernate;

public class TecnicoTest {
	TecnicoDAOHibernate x = new TecnicoDAOHibernate();
	private Tecnico x1 = new Tecnico();
	private Tecnico x2 = new Tecnico();

	@Test
	public void testAdicionar() {
		x1 = new Tecnico();
		x2 = new Tecnico();
		x1.setId((long) 1);
		x1.setNome("Albertocheater");
		Date d1 = new Date(1994-01-01);
		x1.setDataNascimento(d1);
		x2.setId((long) 2);
		x2.setNome("Lucasnoob");
		x2.setDataNascimento(d1);
		
		assertThat(x.listar().size(),is(0));
		x.adicionar(x1);
		assertThat(x.listar().size(),is(1));
		x.adicionar(x2);
		assertThat(x.listar().size(),is(2));
	}

	@Test
	public void testAtualizar() {
		Tecnico x1 = x.buscarTecnico(1);
		x1.setId((long) 3);
		x1.setNome("Lenoilluminati");
		Date d1 = new Date(1995-10-07);
		x1.setDataNascimento(d1);
		x.atualizar(x1);
		assertThat(x.buscarTecnico(3).getId(),is((long) 3));
		assertThat(x.buscarTecnico(3).getNome(),is("Lenoilluminati"));
	}

	@Test
	public void testRemover() {
		x1 = x.buscarTecnico(3);
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
		List<Tecnico> aux = x.listar();
		assertThat(1, is(aux.size()));
	}

	@Test
	public void testBuscar() {
		x1 = x.buscarTecnico(2);
		assertThat(x1.getId(),is((long) 2));
	}

}
