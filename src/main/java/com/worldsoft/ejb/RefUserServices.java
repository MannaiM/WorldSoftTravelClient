package com.worldsoft.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.RefUsers;
import com.worldsoft.domain.RefUtilisateur;
@LocalBean
@Stateless
public class RefUserServices {

	@PersistenceContext
	EntityManager em;
	public RefUsers authentification(String login , String pwd){
		Query query = em
				.createQuery("select u from RefUser u where u.userLogin = :login and u.userPwd = :pwd").
				setParameter("login", login ).
				setParameter("pwd", pwd);
		return (RefUsers) query.getSingleResult();
		
}}
