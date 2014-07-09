package br.ecomp.naovaitercopa.modelo.dao;


import java.util.List;

import org.hibernate.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ecomp.naovaitercopa.modelo.Jogo;
import br.ecomp.naovaitercopa.util.HibernateUtil;

public class JogoDAOHibernate implements JogoDAO {
	
	Session sessao = null;
	Transaction transacao = null;
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.JogoDAO#adicionar(br.ecomp.naivaitercopa.modelo.Jogo)
	 */
	@Override
	public void adicionar(Jogo jogo) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = (Transaction) sessao.beginTransaction();
			sessao.save(jogo);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel inserir o jogo. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.JogoDAO#atualizar(br.ecomp.naivaitercopa.modelo.Jogo)
	 */
	@Override
	public void atualizar(Jogo jogo) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.update(jogo);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel atualizar o jogo. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de atualizacao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.JogoDAO#remover(br.ecomp.naivaitercopa.modelo.Jogo)
	 */
	@Override
	public void remover(Jogo jogo) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.delete(jogo);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir o jogo. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.JogoDAO#removerTodos()
	 */
	@Override
	public void removerTodos() {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta =  sessao.createQuery("delete from Jogo");

			transacao = sessao.beginTransaction();
			 consulta.executeUpdate();
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir os jogos. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}

	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.JogoDAO#listar()
	 */
	@Override
	@SuppressWarnings({ "unchecked"})
	public List<Jogo> listar() {
		List<Jogo> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta =  sessao.createQuery("from Jogo");

			transacao = sessao.beginTransaction();
			resultado = (List<Jogo>) consulta.list();
			transacao.commit();
			return resultado;
		} 
		catch (HibernateException e) {
			System.err.println("Nao foi possivel listar os jogos. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.JogoDAO#buscarJogo(java.lang.String)
	 */
	@Override
	public Jogo buscarJogo(String local) {
		Jogo jogo = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta =  sessao.createQuery("from Jogo where local = :parametro");
			consulta.setString("parametro", local);

			transacao = sessao.beginTransaction();
			jogo = (Jogo)consulta.uniqueResult();
			transacao.commit();
			return jogo;
			
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o jogo. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());				
			}
		}
		return jogo;
	}

}