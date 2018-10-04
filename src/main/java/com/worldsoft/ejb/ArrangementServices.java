package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Arrangement;
import com.worldsoft.domain.ArrangementId;

@LocalBean
@Stateless
public class ArrangementServices {
	@PersistenceContext
	EntityManager em;
	public void addArrangement(Arrangement arrangement) {
		em.persist(arrangement);
	}
	
	
	
	public void editArrangement(Arrangement arrangement) {
		em.merge(arrangement);
	}
	
	public Arrangement findArrangement(ArrangementId id) {
		return em.find(Arrangement.class, id);
	}
	
	
	public void deletArrangement(Arrangement arrangement){
		em.remove(em.merge(arrangement));
	}
	
//	public List<ArrangementModel> findAllArrangement(){
//		Query query = em.createQuery("select new com.worldsoft.model.ArrangementModel( u.id.idArrangement ,u.lArrangement) from Arrangement u");
//		return query.getResultList();
//	}
}
