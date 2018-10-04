package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Hotel;
import com.worldsoft.domain.Reduction;
import com.worldsoft.domain.ReductionId;

@LocalBean
@Stateless
public class ReductionServices {
	@PersistenceContext
	EntityManager em;
	
	public void addReduction(Reduction reduction) {
		em.persist(reduction);
	}
	
	
	
	public void editReduction(Reduction reduction) {
		em.merge(reduction);
	}
	
	public Reduction findReduction(ReductionId id) {
		return em.find(Reduction.class, id);
	}
	
	
	public void deletReduction(Reduction reduction){
		em.remove(em.merge(reduction));
	}
	
	public List<String> findAllReduction(){
		Query query = em.createQuery("select u.abrvReduction from Reduction u");
		return query.getResultList();
}
}
