package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.worldsoft.model.ArrangementModel;

@LocalBean
@Stateless

public class TypeArrangementServices {
	@PersistenceContext
	EntityManager em;

	public List<ArrangementModel> findAllArrangement() {
		return em
				.createQuery(
						"select distinct new com.worldsoft.model.ArrangementModel(u.abrvArrangement , u.LArrangement)  from Arrangement u ")
				.getResultList();
	}
}
