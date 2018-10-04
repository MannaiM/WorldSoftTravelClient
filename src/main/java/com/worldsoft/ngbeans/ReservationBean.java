package com.worldsoft.ngbeans;

import java.math.BigDecimal;

import javax.inject.Inject;

import com.worldsoft.domain.Passenger;
import com.worldsoft.ejb.ReservationServices;
import com.worldsoft.model.MvmentPrixHotelResultat;
import com.worldsoft.model.MvmentPrixVolResultat;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class ReservationBean {

	@Inject
	ModelQuery modelQuery;

	@Inject
	ReservationServices reservationServices;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("reservation", new Passenger());
	}

	@Get
	@NGReturn(model = "success")
	public String reserverVol(MvmentPrixVolResultat vol) {

		reservationServices.addReservation(vol, new BigDecimal(1));
		return "Success";

	}
	@Get
	@NGReturn(model = "success")
	public String reserverHotel(MvmentPrixHotelResultat hotel) {

		reservationServices.addReservation(hotel, new BigDecimal(1));
		return "Success";

	}

}
