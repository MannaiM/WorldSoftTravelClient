package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Role;

@LocalBean
@Stateless

public class RoleServices {
	@PersistenceContext
	EntityManager em;
	public void addRole(Role role) {
		em.persist(role);
	}
	
	
	
	public void editRole(Role role) {
		em.merge(role);
	}
	
	public Role findRole(long idRole) {
		return em.find(Role.class, idRole);
	}
	
	
	public void deletRole(Role role){
		em.remove(em.merge(role));
	}
	
	public List<Role> findAllRole(){
		Query query = em.createQuery("select u from Role u");
		return query.getResultList();
	}

}
