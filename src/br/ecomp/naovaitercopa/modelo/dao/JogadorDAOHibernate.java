package br.ecomp.naovaitercopa.modelo.dao;


import java.util.List;

import org.hibernate.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ecomp.naovaitercopa.modelo.Jogador;
import br.ecomp.naovaitercopa.modelo.Selecao;
import br.ecomp.naovaitercopa.util.HibernateUtil;

public class JogadorDAOHibernate implements JogadorDAO {
	
	Session sessao = null;
	Transaction transacao = null;
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.JogadorDAO#adicionar(br.ecomp.naivaitercopa.modelo.Jogador)
	 */
	@Override
	public void adicionar(Jogador jogador) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = (Transaction) sessao.beginTransaction();
			sessao.save(jogador);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel inserir o jogador. Erro: " + e.getMessage());
		} 
		finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de insercao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.JogadorDAO#atualizar(br.ecomp.naivaitercopa.modelo.Jogador)
	 */
	@Override
	public void atualizar(Jogador jogador) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.update(jogador);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel atualizar o jogador. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de atualizacao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.JogadorDAO#remover(br.ecomp.naivaitercopa.modelo.Jogador)
	 */
	@Override
	public void remover(Jogador jogador) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.delete(jogador);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir o jogador. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.JogadorDAO#removerTodos()
	 */
	@Override
	public void removerTodos() {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta =  sessao.createQuery("delete from Jogador");

			transacao = sessao.beginTransaction();
			consulta.executeUpdate();
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir os jogadors. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}

	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.JogadorDAO#listar()
	 */
	@Override
	@SuppressWarnings({ "unchecked"})
	public List<Jogador> listar() {
		List<Jogador> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta =  sessao.createQuery("from Jogador");

			transacao = sessao.beginTransaction();
			resultado = (List<Jogador>)  consulta.list();
			transacao.commit();
			return resultado;
		} 
		catch (HibernateException e) {
			System.err.println("Nao foi possivel listar os jogadors. Erro: " + e.getMessage());
			throw new HibernateException(e);
		} 
		finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de listagem. Mensagem: " + e.getMessage());				
			}
		}
	}
        
        /* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.JogadorDAO#buscarJogador(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Jogador buscarJogador(String nome, Selecao selecao) {
		Jogador compare = new Jogador();
		compare.setNome(nome);
		compare.setSelecao(selecao);
		List<Jogador> resultados = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Jogador where nome = :parametro");
			consulta.setString("parametro", nome);

			transacao = sessao.beginTransaction();
			resultados = (List<Jogador>) consulta.list();
                       
			transacao.commit();
			for (int i = 0 ; i < resultados.size() ; i++){
				if (resultados.get(i).equals(compare)){
					return resultados.get(i);
				}
			}
			return null;
			
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o jogador. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());				
			}
		}
		return null;
	}
}
