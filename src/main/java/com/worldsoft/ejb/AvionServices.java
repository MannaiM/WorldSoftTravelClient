package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Arrangement;
import com.worldsoft.domain.Avion;

@LocalBean
@Stateless
public class AvionServices {
	@PersistenceContext
	EntityManager em;
	public void addAvion(Avion avion) {
		em.persist(avion);
	}
	
	
	
	public void editAvion(Avion avion) {
		em.merge(avion);
	}
	
	public Avion findAvion(long idAvion) {
		return em.find(Avion.class, idAvion);
	}
	
	
	public void deletAvion(Avion avion){
		em.remove(em.merge(avion));
	}
	
	public List<String> findAllAvion(){
		Query query = em.createQuery("select u.abrvAvion from Avion u");
		return query.getResultList();
	}
	
}
