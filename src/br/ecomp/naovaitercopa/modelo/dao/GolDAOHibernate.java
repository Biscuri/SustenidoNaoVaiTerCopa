package br.ecomp.naovaitercopa.modelo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ecomp.naovaitercopa.modelo.Gol;
import br.ecomp.naovaitercopa.util.HibernateUtil;

public class GolDAOHibernate implements GolDAO {

	Session sessao = null;
	Transaction transacao = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ecomp.naovaitercopa.modelo.GolDAO#adicionar(br.ecomp.naovaitercopa
	 * .modelo.Gol)
	 */
	@Override
	public void adicionar(Gol gol) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = (Transaction) sessao.beginTransaction();
			sessao.save(gol);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel inserir o gol. Erro: "
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
	 * br.ecomp.naovaitercopa.modelo.GolDAO#atualizar(br.ecomp.naovaitercopa
	 * .modelo.Gol)
	 */
	@Override
	public void atualizar(Gol gol) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();
			sessao.update(gol);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel atualizar o gol. Erro: "
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
	 * br.ecomp.naovaitercopa.modelo.GolDAO#remover(br.ecomp.naovaitercopa.modelo
	 * .Gol)
	 */
	@Override
	public void remover(Gol gol) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();
			sessao.delete(gol);
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir o gol. Erro: "
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
	 * @see br.ecomp.naovaitercopa.modelo.GolDAO#removerTodos()
	 */
	@Override
	public void removerTodos() {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("delete from Gol");

			transacao = sessao.beginTransaction();
			consulta.executeUpdate();
			transacao.commit();
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel excluir os gols. Erro: "
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
	 * @see br.ecomp.naovaitercopa.modelo.GolDAO#listar()
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public List<Gol> listar() {
		List<Gol> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Gol");

			transacao = sessao.beginTransaction();
			resultado = (List<Gol>) consulta.list();
			transacao.commit();
			return resultado;
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel listar os gols. Erro: "
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
	 * @see br.ecomp.naovaitercopa.modelo.GolDAO#buscarGol(java.lang.String)
	 */
	@Override
	public Gol buscarGol(long id) {
		Gol gol = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

<<<<<<< HEAD
			Query consulta = sessao
					.createQuery("from Gol where nome = :parametro");
			consulta.setString("parametro", nome);
=======
			Query consulta =  sessao.createQuery("from Gol where id = :parametro");
			consulta.setLong("parametro", id);
>>>>>>> origin/master

			transacao = sessao.beginTransaction();
			gol = (Gol) consulta.uniqueResult();
			transacao.commit();
			return gol;

		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o gol. Erro: "
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
		return gol;
	}

}
