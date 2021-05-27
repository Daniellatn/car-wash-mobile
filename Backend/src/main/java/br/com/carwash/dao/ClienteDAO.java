package br.com.carwash.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.carwash.entity.Cliente;
import br.com.carwash.utils.HibernateUtil;

public class ClienteDAO extends SuperDAO<Cliente> {

	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes(long idCliente, String nomeCliente, String cpfClienteS) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			String hql = " SELECT C FROM Cliente C WHERE 1=1 ";
			if(Objects.nonNull(idCliente))
				hql = hql + " AND C.id = :idCliente " ; 
			if(Objects.nonNull(nomeCliente))
				hql = hql + " AND C.nome LIKE %:nomeCliente% " ;
			if(Objects.nonNull(cpfClienteS))
				hql = hql + " AND C.cpf LIKE %:cpfClienteS% " ;
			
			Query query = em.createQuery(hql,Cliente.class);
			
			if(Objects.nonNull(idCliente))
				query.setParameter("idCliente", idCliente);
			if(Objects.nonNull(cpfClienteS))
				query.setParameter("cpfClienteS", cpfClienteS);
			if(Objects.nonNull(nomeCliente))
				query.setParameter("nomeCliente", nomeCliente);
				
			return query.getResultList();
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception(e);
		}finally {
			em.close();
		}
	}

}
