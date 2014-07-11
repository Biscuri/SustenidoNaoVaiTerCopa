package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ecomp.naovaitercopa.modelo.Copa;
import br.ecomp.naovaitercopa.util.HibernateUtil;

public class CopaDAOHibernate implements CopaDAO {

	Session sessao = null;
	Transaction transacao = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ecomp.naovaitercopa.modelo.CopaDAO#adicionar(br.ecomp.naovaitercopa
	 * .modelo.Copa)
	 */
	@Override
	public void adicionar(Copa copa) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = (Transaction) sessao.beginTransaction();
			sessao.save(copa);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel inserir o copa. Erro: "
					+ e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err
						.println("Erro ao fechar operacao de insercao. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ecomp.naovaitercopa.modelo.CopaDAO#atualizar(br.ecomp.naovaitercopa
	 * .modelo.Copa)
	 */
	@Override
	public void atualizar(Copa copa) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();
			sessao.update(copa);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel atualizar o copa. Erro: "
					+ e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err
						.println("Erro ao fechar operacao de atualizacao. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ecomp.naovaitercopa.modelo.CopaDAO#remover(br.ecomp.naovaitercopa.
	 * modelo.Copa)
	 */
	@Override
	public void remover(Copa copa) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();
			sessao.delete(copa);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir o copa. Erro: "
					+ e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err
						.println("Erro ao fechar operacao de exclusao. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ecomp.naovaitercopa.modelo.CopaDAO#removerTodos()
	 */
	@Override
	public void removerTodos() {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = (Query) sessao.createQuery("delete from Copa");

			transacao = sessao.beginTransaction();
			((org.hibernate.Query) consulta).executeUpdate();
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir os copas. Erro: "
					+ e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err
						.println("Erro ao fechar operacao de exclusao. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ecomp.naovaitercopa.modelo.CopaDAO#listar()
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public List<Copa> listar() {
		List<Copa> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Copa");

			transacao = sessao.beginTransaction();
			resultado = (List<Copa>) ((org.hibernate.Query) consulta).list();
			transacao.commit();
			return resultado;
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel listar os copas. Erro: "
					+ e.getMessage());
			throw new HibernateException(e);
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err
						.println("Erro ao fechar operacao de listagem. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ecomp.naovaitercopa.modelo.CopaDAO#buscarCopa(java.lang.Integer)
	 */
	@Override
	public Copa buscarCopa(int ano) {
		Copa copa = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao
					.createQuery("from Copa where ano = :parametro");
			consulta.setInteger("parametro", ano);

			transacao = sessao.beginTransaction();
			copa = (Copa) ((org.hibernate.Query) consulta).uniqueResult();
			transacao.commit();
			return copa;

		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o copa. Erro: "
					+ e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err
						.println("Erro ao fechar operacao de busca. Mensagem: "
								+ e.getMessage());
			}
		}
		return copa;
	}

}
