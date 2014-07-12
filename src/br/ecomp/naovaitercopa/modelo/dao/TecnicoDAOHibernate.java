package br.ecomp.naovaitercopa.modelo.dao;


import java.util.List;

import org.hibernate.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ecomp.naovaitercopa.modelo.Tecnico;
import br.ecomp.naovaitercopa.util.HibernateUtil;

public class TecnicoDAOHibernate implements TecnicoDAO {
	
	Session sessao = null;
	Transaction transacao = null;
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.TecnicoDAO#adicionar(br.ecomp.naivaitercopa.modelo.Tecnico)
	 */
	@Override
	public void adicionar(Tecnico tecnico) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = (Transaction) sessao.beginTransaction();
			sessao.save(tecnico);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel inserir o tecnico. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.TecnicoDAO#atualizar(br.ecomp.naivaitercopa.modelo.Tecnico)
	 */
	@Override
	public void atualizar(Tecnico tecnico) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.update(tecnico);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel atualizar o tecnico. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de atualizacao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.TecnicoDAO#remover(br.ecomp.naivaitercopa.modelo.Tecnico)
	 */
	@Override
	public void remover(Tecnico tecnico) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
					
			transacao = sessao.beginTransaction();
			sessao.delete(tecnico);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir o tecnico. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.TecnicoDAO#removerTodos()
	 */
	@Override
	public void removerTodos() {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta =  sessao.createQuery("delete from Tecnico");

			transacao = sessao.beginTransaction();
			consulta.executeUpdate();
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir os tecnicos. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());				
			}
		}
	}

	/* (non-Javadoc)
	 * @see br.ecomp.naivaitercopa.modelo.TecnicoDAO#listar()
	 */
	@Override
	@SuppressWarnings({ "unchecked"})
	public List<Tecnico> listar() {
		List<Tecnico> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Tecnico");

			transacao = sessao.beginTransaction();
			resultado = (List<Tecnico>) consulta.list();
			transacao.commit();
			return resultado;
		} 
		catch (HibernateException e) {
			System.err.println("Nao foi possivel listar os tecnicos. Erro: " + e.getMessage());
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
	 * @see br.ecomp.naivaitercopa.modelo.TecnicoDAO#buscarTecnico(java.lang.String)
	 */
	@Override
	public Tecnico buscarTecnico(long id) {
		Tecnico tecnico = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Tecnico where id = :parametro");
			consulta.setLong("parametro", id);

			transacao = sessao.beginTransaction();
			tecnico = (Tecnico) consulta.uniqueResult();
			transacao.commit();
			return tecnico;
			
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o tecnico. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());				
			}
		}
		return tecnico;
	}

}
