package br.ecomp.naovaitercopa.modelo.dao;


import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ecomp.naovaitercopa.modelo.Pais;
import br.ecomp.naovaitercopa.util.HibernateUtil;

public class PaisDAOHibernate implements PaisDAO {
	
	Session sessao = null;
	Transaction transacao = null;
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.PaisDAO#adicionar(br.ecomp.naivaitercopa.modelo.Pais)
	 */
	@Override
	public void adicionar(Pais pais) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = (Transaction) sessao.beginTransaction();
			sessao.save(pais);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel inserir o pais. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.PaisDAO#atualizar(br.ecomp.naivaitercopa.modelo.Pais)
	 */
	@Override
	public void atualizar(Pais pais) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.update(pais);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel atualizar o pais. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de atualizacao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.PaisDAO#remover(br.ecomp.naivaitercopa.modelo.Pais)
	 */
	@Override
	public void remover(Pais pais) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.delete(pais);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir o pais. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.PaisDAO#removerTodos()
	 */
	@Override
	public void removerTodos() {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = (Query) sessao.createQuery("delete from Pais");

			transacao = sessao.beginTransaction();
			((org.hibernate.Query) consulta).executeUpdate();
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir os paiss. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}

	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.PaisDAO#listar()
	 */
	@Override
	@SuppressWarnings({ "unchecked"})
	public List<Pais> listar() {
		List<Pais> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = (Query) sessao.createQuery("from Pais");

			transacao = sessao.beginTransaction();
			resultado = (List<Pais>) ((org.hibernate.Query) consulta).list();
			transacao.commit();
			return resultado;
		} 
		catch (HibernateException e) {
			System.err.println("Nao foi possivel listar os paiss. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.PaisDAO#buscarPais(java.lang.String)
	 */
	@Override
	public Pais buscarPais(String nome) {
		Pais pais = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = (Query) sessao.createQuery("from Pais where nome = :parametro");
			((org.hibernate.Query) consulta).setString("parametro", nome);

			transacao = sessao.beginTransaction();
			pais = (Pais) ((org.hibernate.Query) consulta).uniqueResult();
			transacao.commit();
			return pais;
			
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o pais. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());				
			}
		}
		return pais;
	}

}
