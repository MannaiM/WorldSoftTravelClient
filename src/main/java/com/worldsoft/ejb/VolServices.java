package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.ClassVol;
import com.worldsoft.domain.ClassVolId;


@LocalBean
@Stateless
public class VolServices {
	@PersistenceContext
	EntityManager em;
	public void addVol(ClassVol classVol) {
		em.persist(classVol);
	}
	
	
	
	public void editVol( ClassVol classVol) {
		em.merge(classVol);
	}
	
	public ClassVol findVol( ClassVolId id) {
		return em.find(ClassVol.class, id);
	}
	
	
	public void deletRefTier(ClassVol classVol){
		em.remove(em.merge(classVol));
	}
	
	public List<String> findAllRefTier(){
		Query query = em.createQuery("select u.abrvClass from ClassVol u");
		return query.getResultList();
	}

}
