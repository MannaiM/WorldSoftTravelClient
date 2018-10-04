package com.worldsoft.ejb;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.worldsoft.domain.MvmentPrix;
import com.worldsoft.model.MvmentPrixHotelModel;
import com.worldsoft.model.MvmentPrixHotelResultat;

@LocalBean
@Stateless
public class MvmentPrixHotelService {

	@PersistenceContext
	EntityManager em;

	public List<MvmentPrixHotelResultat> selectPrixHotel(MvmentPrixHotelModel mvmentPrixHotelModel) {
		System.out.println(mvmentPrixHotelModel);
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		// Requite Dynamic//
		CriteriaQuery<MvmentPrixHotelResultat> q = criteriaBuilder.createQuery(MvmentPrixHotelResultat.class);
		// From Table (MvmentPrix) //
		Root<MvmentPrix> r = q.from(MvmentPrix.class);
		// Select //
		q.select(criteriaBuilder.construct(MvmentPrixHotelResultat.class,
				criteriaBuilder.sum(r.<BigDecimal> get("prixVente")),
				criteriaBuilder.count(r.<BigDecimal> get("prixVente")), r.get("hotel").get("nomHotel"),
				r.get("hotel").get("categorie"), r.get("hotel").get("villeHotel"), r.get("hotel").get("pays"),
				r.get("typeChambre").get("LTypeChm"), r.get("hotel").get("idHotel"),
				r.get("arrangement").get("LArrangement")

		));

		// list where //
		List<Predicate> predicates = new ArrayList<Predicate>();

		// Where idAgence= Value
		if (mvmentPrixHotelModel.getVilleHotelM() != null) {
			predicates.add(criteriaBuilder.like(r.get("hotel").<String> get("villeHotel"), mvmentPrixHotelModel.getVilleHotelM()));
		}
		if (mvmentPrixHotelModel.getNomHotelM() != null) {
			predicates.add(criteriaBuilder.equal(r.get("hotel").get("nomHotel"), mvmentPrixHotelModel.getNomHotelM()));
		}
		if (mvmentPrixHotelModel.getArrangement() != null) {
			predicates.add(criteriaBuilder.equal(r.get("arrangement").get("abrvArrangement"),
					mvmentPrixHotelModel.getArrangement()));
		}
		if (mvmentPrixHotelModel.getLTypeChambreM() != null) {
			predicates.add(
					criteriaBuilder.equal(r.get("typeChambre").get("type"), mvmentPrixHotelModel.getLTypeChambreM()));
		}
		if (mvmentPrixHotelModel.getCategorieM() != null) {
			predicates
					.add(criteriaBuilder.equal(r.get("hotel").get("categorie"), mvmentPrixHotelModel.getCategorieM()));
		}
		// predicates.add(criteriaBuilder.equal(r.get("actifPrix"), 'o'));
		// predicates.add(criteriaBuilder.equal(r.get("flag"), 'h'));
		// predicates.add(criteriaBuilder.notEqual(r.get("nbreChm"),
		// mvmentPrixHotelModel.getNbrchm()));
		// date between
		if (mvmentPrixHotelModel.getDateCheckInM() != null && mvmentPrixHotelModel.getDateCheckOutM() != null) {
			try {
				mvmentPrixHotelModel.setDateCheckInM(mvmentPrixHotelModel.getDateCheckInM().substring(0, 10));
				mvmentPrixHotelModel.setDateCheckOutM(mvmentPrixHotelModel.getDateCheckOutM().substring(0, 10));
				SimpleDateFormat FormattedDATE = new SimpleDateFormat("yyyy-MM-dd");
				predicates.add(criteriaBuilder.between(r.<Date> get("dateRes"),
						FormattedDATE.parse(mvmentPrixHotelModel.getDateCheckInM()),
						FormattedDATE.parse(mvmentPrixHotelModel.getDateCheckOutM())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (predicates.size() == 1) {
			q.where(predicates.get(0));
		} else if (predicates.size() > 1) {
			q.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

		}
		q.groupBy(r.get("hotel").get("nomHotel"), r.get("hotel").get("categorie"), r.get("hotel").get("villeHotel"),
				r.get("hotel").get("pays"), r.get("typeChambre").get("LTypeChm"), r.get("hotel").get("idHotel"),
				r.get("arrangement").get("LArrangement"));
		List<MvmentPrixHotelResultat> results = em.createQuery(q).getResultList();
		System.out.println("results " + results);
		int taille = results.size();
		List<MvmentPrixHotelResultat> resultats = new ArrayList<MvmentPrixHotelResultat>();

		for (int i = 0; i < taille; i++) {
			if (results.get(i).getCompteur() == nbreJours(mvmentPrixHotelModel) + 1) {
				System.out.println(getIdList(mvmentPrixHotelModel).size());
				// results.get(i).setListId(getIdList(mvmentPrixHotelModel).get(i));
				resultats.add(results.get(i));
			}

		}
		System.out.println("resultats " + resultats);

		return resultats;
	}

	private Long nbreJours(MvmentPrixHotelModel mvmentPrixHotelModel) {

		Calendar calStr1 = Calendar.getInstance();
		Calendar calStr2 = Calendar.getInstance();
		Calendar calStr0 = Calendar.getInstance();

		System.out.println("date is " + mvmentPrixHotelModel.getDateCheckInM());

		mvmentPrixHotelModel.setDateCheckInM(mvmentPrixHotelModel.getDateCheckInM().substring(0, 10));
		mvmentPrixHotelModel.setDateCheckOutM(mvmentPrixHotelModel.getDateCheckOutM().substring(0, 10));

		Date date1 = null;
		Date date2 = null;

		int nbMois = 0;
		int nbAnnees = 0;
		long nbJours = 0;

		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(mvmentPrixHotelModel.getDateCheckInM());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(mvmentPrixHotelModel.getDateCheckOutM());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (date1.equals(date2)) {
			return (long) 0;
		}

		calStr1.setTime(date1);
		calStr2.setTime(date2);

		nbMois = 0;
		while (calStr1.before(calStr2)) {
			calStr1.add(GregorianCalendar.MONTH, 1);
			if (calStr1.before(calStr2) || calStr1.equals(calStr2)) {
				nbMois++;
			}
		}
		nbAnnees = (nbMois / 12);
		nbMois = (nbMois - (nbAnnees * 12));

		calStr0 = Calendar.getInstance();
		calStr0.setTime(date1);
		calStr0.add(GregorianCalendar.YEAR, nbAnnees);
		calStr0.add(GregorianCalendar.MONTH, nbMois);
		nbJours = (calStr2.getTimeInMillis() - calStr0.getTimeInMillis()) / 86400000;

		return nbJours;
	}

	public List<List<BigDecimal>> getIdList(MvmentPrixHotelModel mvmentPrixHotelModel) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		// Requite Dynamic//
		CriteriaQuery<MvmentPrixHotelResultat> q = criteriaBuilder.createQuery(MvmentPrixHotelResultat.class);
		// From Table (MvmentPrix) //
		Root<MvmentPrix> r = q.from(MvmentPrix.class);
		// Select //
		q.select(
				criteriaBuilder.construct(MvmentPrixHotelResultat.class, r.get("idPrix"), r.get("hotel").get("idHotel"),
						r.get("prixVente"), r.get("hotel").get("nomHotel"), r.get("hotel").get("villeHotel"),
						r.get("typeChambre").get("LTypeChm"), r.get("hotel").get("categorie")));

		// list where //
		List<Predicate> predicates = new ArrayList<Predicate>();

		// Where idAgence= Value
		if (mvmentPrixHotelModel.getPaysM() != null) {
			predicates.add(criteriaBuilder.like(r.get("hotel").<String> get("villeHotel"), mvmentPrixHotelModel.getVilleHotelM()));
		}
		if (mvmentPrixHotelModel.getNomHotelM() != null) {
			predicates.add(criteriaBuilder.equal(r.get("hotel").get("nomHotel"), mvmentPrixHotelModel.getNomHotelM()));
		}
		if (mvmentPrixHotelModel.getLTypeChambreM() != null) {
			predicates.add(
					criteriaBuilder.equal(r.get("typeChambre").get("type"), mvmentPrixHotelModel.getLTypeChambreM()));
		}
		if (mvmentPrixHotelModel.getCategorieM() != null) {
			predicates
					.add(criteriaBuilder.equal(r.get("hotel").get("categorie"), mvmentPrixHotelModel.getCategorieM()));
		}
		// predicates.add(criteriaBuilder.equal(r.get("actifPrix"), 'o'));
		// predicates.add(criteriaBuilder.equal(r.get("flag"), 'h'));
		// predicates.add(criteriaBuilder.notEqual(r.get("nbreChm"),
		// mvmentPrixHotelModel.getNbrchm()));
		// date between
		if (mvmentPrixHotelModel.getDateCheckInM() != null && mvmentPrixHotelModel.getDateCheckOutM() != null) {
			try {
				mvmentPrixHotelModel.setDateCheckInM(mvmentPrixHotelModel.getDateCheckInM().substring(0, 10));
				mvmentPrixHotelModel.setDateCheckOutM(mvmentPrixHotelModel.getDateCheckOutM().substring(0, 10));
				SimpleDateFormat FormattedDATE = new SimpleDateFormat("yyyy-MM-dd");
				predicates.add(criteriaBuilder.between(r.<Date> get("dateRes"),
						FormattedDATE.parse(mvmentPrixHotelModel.getDateCheckInM()),
						FormattedDATE.parse(mvmentPrixHotelModel.getDateCheckOutM())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (predicates.size() == 1) {
			q.where(predicates.get(0));
		} else if (predicates.size() > 1) {
			q.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

		}
		List<MvmentPrixHotelResultat> results = em.createQuery(q).getResultList();

		int taille = results.size();
		System.out.println(taille);
		boolean trouv = false;
		List<MvmentPrixHotelResultat> MvmentPrixHotelResultatNew = new ArrayList<MvmentPrixHotelResultat>();
		for (MvmentPrixHotelResultat MvmentPrixHotelResultat : results) {
			if (MvmentPrixHotelResultatNew.size() != 0) {
				for (int i = 0; i < MvmentPrixHotelResultatNew.size(); i++) {

					if (MvmentPrixHotelResultatNew.get(i).getIdHotelR().equals(MvmentPrixHotelResultat.getIdHotelR())
							&& MvmentPrixHotelResultatNew.get(i).getLTypeChambreR()
									.equals(MvmentPrixHotelResultat.getLTypeChambreR())) {
						MvmentPrixHotelResultatNew.get(i)
								.setCompteur(MvmentPrixHotelResultatNew.get(i).getCompteur() + 1);
						try {
							MvmentPrixHotelResultatNew.get(i).getListId().add(MvmentPrixHotelResultat.getIdPrix());
						} catch (Exception e) {
							MvmentPrixHotelResultatNew.get(i).setListId(new ArrayList<BigDecimal>());
							MvmentPrixHotelResultatNew.get(i).getListId().add(MvmentPrixHotelResultat.getIdPrix());
						}
						MvmentPrixHotelResultatNew.get(i).getListId();
						trouv = true;
					}
				}

			}
			if (!trouv) {
				MvmentPrixHotelResultatNew.add(MvmentPrixHotelResultat);
				MvmentPrixHotelResultatNew.get(MvmentPrixHotelResultatNew.size() - 1)
						.setListId(new ArrayList<BigDecimal>());
				MvmentPrixHotelResultatNew.get(MvmentPrixHotelResultatNew.size() - 1).getListId()
						.add(MvmentPrixHotelResultat.getIdPrix());

			}
			trouv = false;
		}
		int sizeListId = MvmentPrixHotelResultatNew.size();
		List<MvmentPrixHotelResultat> IdListe = new ArrayList<MvmentPrixHotelResultat>();
		List<List<BigDecimal>> listIdDec = new ArrayList<List<BigDecimal>>();
		for (int k = 0; k < sizeListId; k++) {
			if (MvmentPrixHotelResultatNew.get(k).getCompteur() == nbreJours(mvmentPrixHotelModel)) {
				IdListe.add(MvmentPrixHotelResultatNew.get(k));
				listIdDec.add(MvmentPrixHotelResultatNew.get(k).getListId());
			}
		}

		System.out.println("la liste des id : " + listIdDec);

		return listIdDec;

	}

}
