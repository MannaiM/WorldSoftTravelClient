package com.worldsoft.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MvmentPrixVolResultat {
	private BigDecimal prixVenteR;
	private String LClassR;
	private String airDepR;
	private String airArrR;
	private String villeDestR;
	private String dateResR;
	private String dateRetR;
	private List<PassengerModel> passengers;

	public MvmentPrixVolResultat(BigDecimal prixVenteR, String lClassR, String airDepR, String airArrR, Date dateRes) {
		super();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.prixVenteR = prixVenteR;
		LClassR = lClassR;
		this.airDepR = airDepR;
		this.airArrR = airArrR;
		this.dateResR = format.format(dateRes);
		this.passengers = new ArrayList<PassengerModel>();
	}

	public MvmentPrixVolResultat(BigDecimal prixVenteR, String LClassR, String airDepR, String airArrR,
			String villeDestR, String dateResR) {
		super();
		this.prixVenteR = prixVenteR;
		this.LClassR = LClassR;
		this.airDepR = airDepR;
		this.airArrR = airArrR;
		this.villeDestR = villeDestR;
		this.dateResR = dateResR;
		this.passengers = new ArrayList<PassengerModel>();
	}

	public MvmentPrixVolResultat() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getPrixVenteR() {
		return prixVenteR;
	}

	public void setPrixVenteR(BigDecimal prixVenteR) {
		this.prixVenteR = prixVenteR;
	}

	public String getLClassR() {
		return LClassR;
	}

	public void setLClassR(String lClassR) {
		LClassR = lClassR;
	}

	public String getAirDepR() {
		return airDepR;
	}

	public void setAirDepR(String airDepR) {
		this.airDepR = airDepR;
	}

	public String getAirArrR() {
		return airArrR;
	}

	public void setAirArrR(String airArrR) {
		this.airArrR = airArrR;
	}

	public String getVilleDestR() {
		return villeDestR;
	}

	public void setVilleDestR(String villeDestR) {
		this.villeDestR = villeDestR;
	}

	public String getDateResR() {
		return dateResR;
	}

	public void setDateResR(String dateResR) {
		this.dateResR = dateResR;
	}

	public String getDateRetR() {
		return dateRetR;
	}

	public void setDateRetR(String dateRetR) {
		this.dateRetR = dateRetR;
	}

	@Override
	public String toString() {
		return "MvmentPrixVolResultat [prixVenteR=" + prixVenteR + ", LClassR=" + LClassR + ", airDepR=" + airDepR
				+ ", airArrR=" + airArrR + ", villeDestR=" + villeDestR + ", dateResR=" + dateResR + ", dateRetR="
				+ dateRetR + "]";
	}

	public List<PassengerModel> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<PassengerModel> passengers) {
		this.passengers = passengers;
	}

}