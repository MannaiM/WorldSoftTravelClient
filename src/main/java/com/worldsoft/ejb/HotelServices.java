package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Hotel;

@LocalBean
@Stateless
public class HotelServices {
	@PersistenceContext
	EntityManager em;
	
	public void addHotel(Hotel hotel) {
		em.persist(hotel);
	}
	
	
	
	public void editRefTier(Hotel hotel) {
		em.merge(hotel);
	}
	
	public Hotel findHotel(long id) {
		return em.find(Hotel.class, id);
	}
	
	
	public void deletHotel(Hotel hotel){
		em.remove(em.merge(hotel));
	}
	
	public List<String> findAllHotel(){
		Query query = em.createQuery("select u.abrvHotel from Hotel u");
	    return query.getResultList();
}
}