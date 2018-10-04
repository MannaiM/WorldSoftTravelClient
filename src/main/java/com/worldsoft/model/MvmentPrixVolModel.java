package com.worldsoft.model;

import java.math.BigDecimal;
import java.util.Date;

import com.worldsoft.domain.ClassVol;

public class MvmentPrixVolModel {
	private String LClassM;
	private String airDepM;
	private String airArrM;
	private String villeDestM;
	private String dateResM;
	private String dateRetM;

	public MvmentPrixVolModel() {
		super();
	}

	public MvmentPrixVolModel(String LClassM, String airDepM, String airArrM, String villeDestM, String dateResM,String dateRetM) {
		this.LClassM = LClassM;
		this.airDepM = airDepM;
		this.airArrM = airArrM;
		this.villeDestM = villeDestM;
		this.dateResM = dateResM;
		this.dateRetM = dateRetM;
	}

	public String getLClassM() {
		return LClassM;
	}

	public void setLClassM(String lClassM) {
		LClassM = lClassM;
	}

	public String getAirDepM() {
		return airDepM;
	}

	public void setAirDepM(String airDepM) {
		this.airDepM = airDepM;
	}

	public String getAirArrM() {
		return airArrM;
	}

	public void setAirArrM(String airArrM) {
		this.airArrM = airArrM;
	}

	public String getVilleDestM() {
		return villeDestM;
	}

	public void setVilleDestM(String villeDestM) {
		this.villeDestM = villeDestM;
	}

	public String getDateResM() {
		return dateResM;
	}

	public void setDateResM(String dateResM) {
		this.dateResM = dateResM;
	}

	public String getDateRetM() {
		return dateRetM;
	}

	public void setDateRetM(String dateRetM) {
		this.dateRetM = dateRetM;
	}
	

}