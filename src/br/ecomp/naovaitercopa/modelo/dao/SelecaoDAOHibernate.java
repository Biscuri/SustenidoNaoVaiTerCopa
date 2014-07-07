package br.ecomp.naovaitercopa.modelo.dao;


import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ecomp.naovaitercopa.modelo.Selecao;
import br.ecomp.naovaitercopa.util.HibernateUtil;

public class SelecaoDAOHibernate implements SelecaoDAO {
	
	Session sessao = null;
	Transaction transacao = null;
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.SelecaoDAO#adicionar(br.ecomp.naivaitercopa.modelo.Selecao)
	 */
	@Override
	public void adicionar(Selecao selecao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = (Transaction) sessao.beginTransaction();
			sessao.save(selecao);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel inserir o selecao. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.SelecaoDAO#atualizar(br.ecomp.naivaitercopa.modelo.Selecao)
	 */
	@Override
	public void atualizar(Selecao selecao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.update(selecao);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel atualizar o selecao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de atualizacao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.SelecaoDAO#remover(br.ecomp.naivaitercopa.modelo.Selecao)
	 */
	@Override
	public void remover(Selecao selecao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.delete(selecao);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir o selecao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.SelecaoDAO#removerTodos()
	 */
	@Override
	public void removerTodos() {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = (Query) sessao.createQuery("delete from Selecao");

			transacao = sessao.beginTransaction();
			((org.hibernate.Query) consulta).executeUpdate();
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir os selecaos. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}

	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.SelecaoDAO#listar()
	 */
	@Override
	@SuppressWarnings({ "unchecked"})
	public List<Selecao> listar() {
		List<Selecao> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = (Query) sessao.createQuery("from Selecao");

			transacao = sessao.beginTransaction();
			resultado = (List<Selecao>) ((org.hibernate.Query) consulta).list();
			transacao.commit();
			return resultado;
		} 
		catch (HibernateException e) {
			System.err.println("Nao foi possivel listar os selecaos. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.SelecaoDAO#buscarSelecao(java.lang.String)
	 */
	@Override
	public Selecao buscarSelecao(String nome) {
		Selecao selecao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = (Query) sessao.createQuery("from Selecao where nome = :parametro");
			((org.hibernate.Query) consulta).setString("parametro", nome);

			transacao = sessao.beginTransaction();
			selecao = (Selecao) ((org.hibernate.Query) consulta).uniqueResult();
			transacao.commit();
			return selecao;
			
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o selecao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());				
			}
		}
		return selecao;
	}

}
