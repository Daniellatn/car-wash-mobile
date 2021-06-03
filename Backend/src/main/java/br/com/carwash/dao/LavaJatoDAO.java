package br.com.carwash.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.carwash.entity.LavaJato;
import br.com.carwash.utils.HibernateUtil;

public class LavaJatoDAO extends SuperDAO<LavaJato>{

	public LavaJatoDAO() {
		super(LavaJato.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<LavaJato> getListLojas(Long id, String nomeLoja, String email, String cnpj) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			String hql = " SELECT lv FROM LavaJato WHERE 1 = 1 ";
			if(Objects.nonNull(id))
				if(id != 0)
					hql = hql + " AND lv.id = :id ";
			if(Objects.nonNull(nomeLoja))
				hql = hql + " AND lv.nome = :nomeLoja ";
			if(Objects.nonNull(email))
					hql = hql + " AND lv.email = :email ";
			if(Objects.nonNull(cnpj))
				hql = hql + " AND lv.cnpj = :cnpj " ;
			
			Query query = em.createQuery(hql,LavaJato.class);
			
			if(Objects.nonNull(id))
				if(id != 0)
					query.setParameter("id", id);
			if(Objects.nonNull(nomeLoja))
				query.setParameter("nomeLoja", nomeLoja);
			if(Objects.nonNull(email))
				query.setParameter("email", email);
			if(Objects.nonNull(cnpj))
				query.setParameter("cnpj", cnpj);
			
			return query.getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

}
