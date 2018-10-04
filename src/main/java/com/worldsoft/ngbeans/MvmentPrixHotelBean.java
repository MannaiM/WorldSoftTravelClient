package com.worldsoft.ngbeans;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.MvmentPrixHotelService;
import com.worldsoft.ejb.MvmentPrixVolRetourService;
import com.worldsoft.ejb.MvmentPrixVolService;
import com.worldsoft.ejb.TypeArrangementServices;
import com.worldsoft.ejb.TypeChambreServices;
import com.worldsoft.model.MvmentPrixHotelModel;
import com.worldsoft.model.MvmentPrixHotelResultat;
import com.worldsoft.model.MvmentPrixVolModel;
import com.worldsoft.model.MvmentPrixVolResultat;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class MvmentPrixHotelBean {

	@Inject
	ModelQuery modelQuery;

	@Inject
	MvmentPrixHotelService mvmentPrixHotelService;

	@Inject
	TypeChambreServices typeChambreServices;
	@Inject
	TypeArrangementServices ArrangementServices;
	@Inject
	MvmentPrixVolService mvmentPrixVolService;
	@Inject
	MvmentPrixVolRetourService mvmentPrixVolRetourService;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("mvmentPrixVol", new MvmentPrixVolModel())
				.setProperty("mvmentPrixHotel", new MvmentPrixHotelModel())
				.setProperty("typeCmps", typeChambreServices.findAllTypeChambre())
				.setProperty("typeArran", ArrangementServices.findAllArrangement());

	}

	@Get
	@NGReturn(model = "PrixVolsRet")
	public List<MvmentPrixVolResultat> searchVol(MvmentPrixVolModel mvmentPrixVolModel) {
		return mvmentPrixVolService.selectPrixVolRetour(mvmentPrixVolModel);

	}

	@Get
	@NGReturn(model = "PrixVolsRet")
	public List<MvmentPrixVolResultat> searchVolRet(MvmentPrixVolModel mvmentPrixVolModel) {
		List<MvmentPrixVolResultat> volAllee = mvmentPrixVolService.selectPrixVolRetour(mvmentPrixVolModel);
		List<MvmentPrixVolResultat> volRetour = mvmentPrixVolRetourService.selectPrixVolRetour(mvmentPrixVolModel);

		List<MvmentPrixVolResultat> volAlleeRetours = new ArrayList<MvmentPrixVolResultat>();

		for (MvmentPrixVolResultat volR : volRetour) {
			for (MvmentPrixVolResultat volA : volAllee) {
				MvmentPrixVolResultat volAlleRetour = new MvmentPrixVolResultat();
				volAlleRetour.setAirArrR(volA.getAirArrR());
				volAlleRetour.setAirDepR(volA.getAirDepR());
				volAlleRetour.setLClassR(volA.getLClassR());
				volAlleRetour.setPrixVenteR(volA.getPrixVenteR().add(volR.getPrixVenteR()));
				volAlleRetour.setDateRetR(volR.getDateResR());
				volAlleRetour.setDateResR(volA.getDateResR());
				volAlleeRetours.add(volAlleRetour);
			}
		}

		return volAlleeRetours;
	}

	@Get
	@NGReturn(model = "PrixHotels")
	public List<MvmentPrixHotelResultat> searchHotel(MvmentPrixHotelModel mvmentPrixHotelModel) {
		return mvmentPrixHotelService.selectPrixHotel(mvmentPrixHotelModel);

	}

}