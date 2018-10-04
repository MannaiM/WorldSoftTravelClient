package com.worldsoft.ngbeans;

import javax.inject.Inject;

import com.worldsoft.domain.RefUtilisateur;
import com.worldsoft.ejb.RefUtilisateurServices;

import angularBeans.api.AngularBean;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;

@AngularBean
public class AuthentificationBean {

	@Inject
	RefUtilisateurServices refUtilisateurServices;

	@Get
	@NGReturn(model = "utilisateur")
	public String sauthentifier(String login, String pwd) {
		try {
			RefUtilisateur utilisateur = refUtilisateurServices.authentification(login, pwd);
			if (utilisateur != null) {
				System.out.println(utilisateur.getNomRefUtilisateur());
				return utilisateur.getNomRefUtilisateur();
			} else {
				return "null";
			}

		} catch (Exception e) {
			return "null";

		}

	}
}
