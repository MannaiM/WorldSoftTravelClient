package com.worldsoft.ejb;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Promotion;

@LocalBean
@Stateless
public class PromotionServices {
	@PersistenceContext
	EntityManager em;
	
	public void addPromotion(Promotion promotion) {
		em.persist(promotion);
	}
	
	
	
	public void editPromotion(Promotion promotion) {
		em.merge(promotion);
	}
	
	public Promotion findPromotion(long idPromo) {
		return em.find(Promotion.class, idPromo);
	}
	
	
	public void deletPromotion(Promotion promotion){
		em.remove(em.merge(promotion));
	}
	
	public List<String> findAllPromotion(){
		Query query = em.createQuery("select u.abrvPromotion from Promotion u");
		return query.getResultList();
}
}
