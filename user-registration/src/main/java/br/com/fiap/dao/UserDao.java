package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Usuario;
import br.com.fiap.utils.JPAUtil;

public class UserDao {
	
	public void save(Usuario usuario) {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<Usuario> getAll() {
		EntityManager em = JPAUtil.getEntityManager();
		
		String jpql = "SELECT s FROM Usuario s";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		// em.close();
		
		return query.getResultList();
		
	}

}
