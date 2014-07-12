package br.ecomp.naovaitercopa.modelo.dao;


import java.util.List;

import org.hibernate.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ecomp.naovaitercopa.modelo.Escalacao;
import br.ecomp.naovaitercopa.util.HibernateUtil;

public class EscalacaoDAOHibernate implements EscalacaoDAO {
	
	Session sessao = null;
	Transaction transacao = null;
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.EscalacaoDAO#adicionar(br.ecomp.naivaitercopa.modelo.Escalacao)
	 */
	@Override
	public void adicionar(Escalacao escalacao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = (Transaction) sessao.beginTransaction();
			sessao.save(escalacao);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel inserir o escalacao. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.EscalacaoDAO#atualizar(br.ecomp.naivaitercopa.modelo.Escalacao)
	 */
	@Override
	public void atualizar(Escalacao escalacao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.update(escalacao);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel atualizar o escalacao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de atualizacao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.EscalacaoDAO#remover(br.ecomp.naivaitercopa.modelo.Escalacao)
	 */
	@Override
	public void remover(Escalacao escalacao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.delete(escalacao);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir o escalacao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.EscalacaoDAO#removerTodos()
	 */
	@Override
	public void removerTodos() {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("delete from Escalacao");

			transacao = sessao.beginTransaction();
			consulta.executeUpdate();
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir os escalacaos. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}

	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.EscalacaoDAO#listar()
	 */
	@Override
	@SuppressWarnings({ "unchecked"})
	public List<Escalacao> listar() {
		List<Escalacao> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Escalacao");

			transacao = sessao.beginTransaction();
			resultado = (List<Escalacao>) consulta.list();
			transacao.commit();
			return resultado;
		} 
		catch (HibernateException e) {
			System.err.println("Nao foi possivel listar os escalacaos. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.EscalacaoDAO#buscarEscalacao(java.lang.String)
	 */
	@Override
	public Escalacao buscarEscalacao(long id) {
		Escalacao escalacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Escalacao where id = :parametro");
			consulta.setLong("parametro", id);

			transacao = sessao.beginTransaction();
			escalacao = (Escalacao) ((org.hibernate.Query) consulta).uniqueResult();
			transacao.commit();
			return escalacao;
			
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o escalacao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());				
			}
		}
		return escalacao;
	}

}
