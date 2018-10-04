package com.worldsoft.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Arrangement;
import com.worldsoft.domain.MvmentPrix;


@LocalBean
@Stateless
public class MvmentPrixServices {
	
	
		@PersistenceContext
		EntityManager em;
		
		
		public void addMvmentPrix() {
			MvmentPrix mvmentPrix= new MvmentPrix();
			BigDecimal idArrangement = new BigDecimal(1);
			long idChm = new Long (1);
			long idPeriode = new Long (3);
			BigDecimal prixAchat = new BigDecimal (70);
			BigDecimal prixVente= new BigDecimal (100);
			mvmentPrix.setArrangement(new Arrangement());
			
			em.persist(mvmentPrix);
		}
		
		
		
		public void editMvmentPrix(MvmentPrix mvmentPrix) {
			em.merge(mvmentPrix);
		}
		
		public MvmentPrix  findMvmentPrix(long idPrix) {
			return em.find(MvmentPrix.class, idPrix);
		}
		
		
		public void deletMvmentPrix(MvmentPrix mvmentPrix){
			em.remove(em.merge(mvmentPrix));
		}
		
		public List<String> findAllMvmentPrix(){
			Query query = em.createQuery("select u from MvmentPrix u");
			return query.getResultList();
		}
}
