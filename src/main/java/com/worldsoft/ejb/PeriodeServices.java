package com.worldsoft.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.worldsoft.domain.Periode;
import com.worldsoft.domain.PeriodeId;

@LocalBean
@Stateless
public class PeriodeServices {
	@PersistenceContext
	EntityManager em;
	public void addPeriode(Periode periode) {
		em.persist(periode);
	}
	
	
	
	public void editPeriode(Periode periode) {
		em.merge(periode);
	}
	
	public Periode findPeriode(PeriodeId id) {
		return em.find(Periode.class, id);
	}
	
	
	public void deletPeriode(Periode periode){
		em.remove(em.merge(periode));
	}
	
//	public List<PeriodeModel> findAllPeriode(){
//		Query query = em.createQuery("select new com.worldsoft.model.PeriodeModel( u.id.idPeriode ,u.abrvPeriode)from Periode u");
//		return query.getResultList();
//	}
	
}
