package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.worldsoft.domain.TypeChambre;
import com.worldsoft.model.TypeChambreModel;

@LocalBean
@Stateless

public class TypeChambreServices {
	@PersistenceContext
	EntityManager em;

	public void addTypeChambre(TypeChambre typeChambre) {
		em.persist(typeChambre);
	}

	public void editTypeChambre(TypeChambre typeChambre) {
		em.merge(typeChambre);
	}

	public TypeChambre findTypeChambre(long idChambre) {
		return (TypeChambre) em.createQuery("select u from TypeChambre u where u.id.idChm =:p1")
				.setParameter("p1", idChambre).getResultList();
	}
	
	public List<TypeChambreModel> findAllTypeChambre() {
		return em.createQuery("select distinct new com.worldsoft.model.TypeChambreModel(u.LTypeChm , u.type)  from TypeChambre u ")
			.getResultList();
	}
	

	public void deletTypeChambre(TypeChambre typeChambre) {
		em.remove(em.merge(typeChambre));
	}

//	public List<TypeChambreModel> findAllTypeChambre() {
//		Query query = em.createQuery("select new com.worldsoft.model.TypeChambreModel( u.id.idChm ,u.lTypeChm)from TypeChambre u");
//		return query.getResultList();
//	}

}
