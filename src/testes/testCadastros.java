package testes;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import br.ecomp.naovaitercopa.modelo.*;

import org.junit.Test;

public class testCadastros {

	private Controller controller = new Controller();
	private Copa c1,c2;
	private Jogo g1,g2,g3,g4,g5;
	private Selecao s1,s2,s3,s4;
	private Jogador[] j1,j2,j3,j4,j5,j6,j7,j8;
	private Escalacao e11,e12,e21,e22,e31,e32,e41,e42;
	private Tecnico t1,t2,t3,t4;
	private Pais p1, p2, p3, p4, p5, p6;
	
	@Test
	public void test(){
		
		//Insere e busca países.
		assertThat(controller.CadastrarPais("Brasil", "America do Sul"), is(true));
		assertThat(controller.CadastrarPais("Alemanha", "Europa"),is(true));
		assertThat(controller.CadastrarPais("Argentina", "America do Sul"),is(true));
		assertThat(controller.CadastrarPais("EUA", "Murica"),is(true));
		assertThat(controller.CadastrarPais("Inglaterra", "Europa"),is(true));
		assertThat(controller.CadastrarPais("Japao", "Asia"),is(true));
		
		p1 = controller.BuscarPais("Brasil");
		p2 = controller.BuscarPais("Alemanha");
		p3 = controller.BuscarPais("Argentina");
		p4 = controller.BuscarPais("EUA");
		p5 = controller.BuscarPais("Inglaterra");
		p6 = controller.BuscarPais("Japao");
		
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
		
		
		
	}

}
