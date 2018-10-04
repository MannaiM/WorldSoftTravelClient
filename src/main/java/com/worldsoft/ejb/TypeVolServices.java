package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Avion;
import com.worldsoft.domain.TypeVol;

@LocalBean
@Stateless

public class TypeVolServices {
	@PersistenceContext
	EntityManager em;
	public void addTypeVol(TypeVol typeVol) {
		em.persist(typeVol);
	}
	
	
	
	public void editTypeVol(TypeVol typeVol) {
		em.merge(typeVol);
	}
	
	public TypeVol findTypeVol(long idTypeVol) {
		return em.find(TypeVol.class, idTypeVol);
	}
	
	
	public void deletTypeVol(TypeVol typeVol){
		em.remove(em.merge(typeVol));
	}
	
	public List<TypeVol> findAllTypeVol(){
		Query query = em.createQuery("select u from TypeVol u");
		return query.getResultList();
	}

}
