package com.worldsoft.ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.worldsoft.model.MvmentPrixVolModel;
import com.worldsoft.model.MvmentPrixVolResultat;

@LocalBean
@Stateless
public class MvmentPrixVolService {
	@PersistenceContext
	EntityManager em;

	public List<MvmentPrixVolResultat> selectPrixVolRetour(MvmentPrixVolModel mvmentPrixVolModel) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		// Requite Dynamic//
		CriteriaQuery<MvmentPrixVolResultat> q = criteriaBuilder.createQuery(MvmentPrixVolResultat.class);
		// From Table (MvmentPrix) //
		Root<MvmentPrix> r = q.from(MvmentPrix.class);
		// Select //
		q.select(criteriaBuilder.construct(MvmentPrixVolResultat.class, r.get("prixVente"),
				r.get("classVol").get("LClass"), r.get("dep"), r.get("arr"),r.get("dateRes")

		));

		// list where //
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (mvmentPrixVolModel.getAirDepM() != null && mvmentPrixVolModel.getAirArrM() != null) {

			predicates.add(criteriaBuilder.equal(r.get("dep"), mvmentPrixVolModel.getAirDepM()));

			predicates.add(criteriaBuilder.equal(r.get("arr"), mvmentPrixVolModel.getAirArrM()));

		}

		if (mvmentPrixVolModel.getLClassM() != null) {
			predicates.add(criteriaBuilder.equal(r.get("classVol").get("LClass"), mvmentPrixVolModel.getLClassM()));
		}

		predicates.add(criteriaBuilder.equal(r.get("actifPrix"), 'O'));
		predicates.add(criteriaBuilder.equal(r.get("flag"), 'V'));

		if (mvmentPrixVolModel.getDateResM() != null) {
			try {
				mvmentPrixVolModel.setDateResM(mvmentPrixVolModel.getDateResM().substring(0, 10));
				SimpleDateFormat FormattedDATE = new SimpleDateFormat("yyyy-MM-dd");

				predicates.add(criteriaBuilder.equal(r.<Date> get("dateRes"),
						FormattedDATE.parse(mvmentPrixVolModel.getDateResM())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (predicates.size() == 1) {
			q.where(predicates.get(0));
		} else if (predicates.size() > 1) {
			q.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
		}
		List<MvmentPrixVolResultat> results = em.createQuery(q).getResultList();
		return results;
	}

}
