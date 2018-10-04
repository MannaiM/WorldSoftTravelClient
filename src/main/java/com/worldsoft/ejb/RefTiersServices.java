package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.RefTiers;
import com.worldsoft.domain.RefUsers;

@LocalBean
@Stateless
public class RefTiersServices {
	
	@PersistenceContext
	EntityManager em;
	
	public void addRefTiers(RefTiers refTiers) {
		em.persist(refTiers);
	}
	
	
	
	public void editRefTiers(RefTiers refTiers) {
		em.merge(refTiers);
	}
	
	public RefTiers findRefTiers(long id) {
		return em.find(RefTiers.class, id);
	}
	
	
	public void deletRefTiers(RefTiers refTiers){
		em.remove(em.merge(refTiers));
	}
	
	public List<String> findAllRefTiers(){
		Query query = em.createQuery("select u.adrTiers from RefTier u");
		return query.getResultList();
	}
	
	
	public RefUsers authentification(String login , String pwd){
		Query query =	em.createQuery("select u from RefUtilisateur u where u.userLogin = :login and u.userPwd = crypte(:pwd)").setParameter("login", login ).setParameter("pwd", pwd);
		return (RefUsers) query.getSingleResult();
		
		}

	
	
	
	
	
	

}
