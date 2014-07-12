package br.ecomp.naovaitercopa.modelo.dao;


import java.util.List;

import org.hibernate.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ecomp.naovaitercopa.modelo.Substituicao;
import br.ecomp.naovaitercopa.util.HibernateUtil;

public class SubstituicaoDAOHibernate implements SubstituicaoDAO {
	
	Session sessao = null;
	Transaction transacao = null;
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.SubstituicaoDAO#adicionar(br.ecomp.naivaitercopa.modelo.Substituicao)
	 */
	@Override
	public void adicionar(Substituicao substituicao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = (Transaction) sessao.beginTransaction();
			sessao.save(substituicao);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel inserir o substituicao. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.SubstituicaoDAO#atualizar(br.ecomp.naivaitercopa.modelo.Substituicao)
	 */
	@Override
	public void atualizar(Substituicao substituicao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.update(substituicao);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel atualizar o substituicao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de atualizacao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.SubstituicaoDAO#remover(br.ecomp.naivaitercopa.modelo.Substituicao)
	 */
	@Override
	public void remover(Substituicao substituicao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.delete(substituicao);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir o substituicao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.SubstituicaoDAO#removerTodos()
	 */
	@Override
	public void removerTodos() {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("delete from Substituicao");

			transacao = sessao.beginTransaction();
			consulta.executeUpdate();
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir os substituicaos. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}

	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.SubstituicaoDAO#listar()
	 */
	@Override
	@SuppressWarnings({ "unchecked"})
	public List<Substituicao> listar() {
		List<Substituicao> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = (Query) sessao.createQuery("from Substituicao");

			transacao = sessao.beginTransaction();
			resultado = (List<Substituicao>)consulta.list();
			transacao.commit();
			return resultado;
		} 
		catch (HibernateException e) {
			System.err.println("Nao foi possivel listar os substituicaos. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.SubstituicaoDAO#buscarSubstituicao(java.lang.String)
	 */
	@Override
	public Substituicao buscarSubstituicao(long id) {
		Substituicao substituicao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Substituicao where id = :parametro");
			consulta.setLong("parametro", id);

			transacao = sessao.beginTransaction();
			substituicao = (Substituicao) consulta.uniqueResult();
			transacao.commit();
			return substituicao;
			
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o substituicao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());				
			}
		}
		return substituicao;
	}

}
