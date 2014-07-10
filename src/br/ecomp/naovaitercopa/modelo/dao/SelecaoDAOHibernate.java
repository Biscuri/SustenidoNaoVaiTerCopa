package br.ecomp.naovaitercopa.modelo.dao;


import java.util.List;

import org.hibernate.Query;
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

			Query consulta =  sessao.createQuery("delete from Selecao");

			transacao = sessao.beginTransaction();
			 consulta.executeUpdate();
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

			Query consulta = sessao.createQuery("from Selecao");

			transacao = sessao.beginTransaction();
			resultado = (List<Selecao>)  consulta.list();
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
	@SuppressWarnings("unchecked")
	@Override
	public Selecao buscarSelecao(String nome, int ano) {
		Selecao compare = new Selecao();
		compare.setNome(nome);
		compare.setAno(ano);
		List<Selecao> resultados = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Selecao where nome = :parametro");
			 consulta.setString("parametro", nome);

			transacao = sessao.beginTransaction();
			resultados = (List<Selecao>) consulta.list();
			transacao.commit();
			for (int i = 0 ; i < resultados.size() ; i++){
				if (resultados.get(i).equals(compare)){
					return resultados.get(i);
				}
			}
			return null;
			
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o selecao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());				
			}
		}
		return null;
	}
     /* (non-Javadoc)
     * @see br.ecomp.naivaitercopa.modelo.SelecaoDAO#listar(int ano)
     */
    @Override
    @SuppressWarnings({ "unchecked"})
    public List<Selecao> listar(int ano) {
        List<Selecao> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Selecao where ano = :parametro");
                        consulta.setInteger("parametro", ano);

			transacao = sessao.beginTransaction();
			resultado = (List<Selecao>)  consulta.list();
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
	 * @see br.ecomp.naivaitercopa.modelo.JogoDAO#buscarJogos(java.lang.String)
	 */
	@Override
	public List<Selecao> buscarSelecoes(String nome) {
		 List selecoes = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta =  sessao.createQuery("from Jogo where nome = :parametro");
			consulta.setString("parametro", nome);

			transacao = sessao.beginTransaction();
			selecoes = consulta.list();
			transacao.commit();
			return selecoes;
			
		} catch (HibernateException e) {
			System.err.println("Nao foi possivel buscar o jogo. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.err.println("Erro ao fechar operacao de busca. Mensagem: " + e.getMessage());				
			}
		}
		return selecoes;
	}


}
