package br.com.carwash.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.carwash.entity.Produto;
import br.com.carwash.utils.HibernateUtil;

public class ProdutoDAO extends SuperDAO<Produto> {

	public ProdutoDAO() {
		super(Produto.class);
	}

	public List<Produto> econtraProdutoELojaPorIdLoja(Long idLoja, Long idProduto, String nomeProduto) {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			String hql = " SELECT p FROM Produto p " + " JOIN FETCH p.loja lj " + " WHERE 1=1 ";
			if (Objects.nonNull(idLoja))
				hql = hql + " AND lj.id = :idLoja ";
			if (Objects.nonNull(idProduto))
				hql = hql + "  p.id = :idProduto ";
			if (Objects.nonNull(nomeProduto))
				hql = hql + "  p.nome = :nomeProduto ";
			Query query = em.createQuery(hql, Produto.class);

			if (Objects.nonNull(idLoja))
				query.setParameter("idLoja", idLoja);
			if (Objects.nonNull(idProduto))
				query.setParameter("idLoja", idProduto);
			if (Objects.nonNull(nomeProduto)) {
				nomeProduto = "%" + nomeProduto.replace(" ", "%") + "%";
				query.setParameter("nomeProduto", nomeProduto);
			}

			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}
}
