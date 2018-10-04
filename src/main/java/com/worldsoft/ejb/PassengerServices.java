package com.worldsoft.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.worldsoft.domain.Passenger;

@LocalBean
@Stateless
public class PassengerServices {

	@PersistenceContext
	EntityManager em;

	public void addPassenger(Passenger passenger) {
		em.persist(passenger);
	}

	public void editPassenger(Passenger passenger) {
		em.merge(passenger);
	}

	public Passenger findPassenger(long idPassenger) {
		return em.find(Passenger.class, idPassenger);
	}

	public void deletAvion(Passenger passenger) {
		em.remove(em.merge(passenger));
	}

	// public List<PassengerModel> findAllPassenger(){
	// Query query = em.createQuery("select new
	// com.worldsoft.model.PassengerModel(
	// u.idPassenger ,u.nomPassenger) from Passenger u");
	// return query.getResultList();
	// }

}
