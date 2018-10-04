package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.RefTiers;
import com.worldsoft.domain.RefUtilisateur;

@LocalBean
@Stateless
public class RefUtilisateurServices {

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

	public void deletRefTiers(RefTiers refTiers) {
		em.remove(em.merge(refTiers));
	}

	public List<String> findAllRefTiers() {
		Query query = em.createQuery("select u.adrTiers from RefTier u");
		return query.getResultList();
	}

	public RefUtilisateur authentification(String login, String pwd) {
		System.out.println(login + " " + pwd);

		Query query = em
				.createQuery(
						"select u from RefUtilisateur u where u.logUtilisateur = :login and u.passwUtilisateur = :pwd")
				.setParameter("login", login).setParameter("pwd", pwd);
		try {
			return (RefUtilisateur) query.getSingleResult();

		} catch (Exception e) {
			return null;

		}

	}

}
