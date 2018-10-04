package com.worldsoft.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The persistent class for the PASSENGER database table.
 * 
 */
public class PassengerModel {

	private long idPassenger;
	private long idRefTiers;
	private long idReserv;
	private String dtNais;
	private String expirDatePass;
	private String firstName;
	private String lastName;
	private String numPass;

	public PassengerModel() {
	}

	public PassengerModel(long idPassenger, long idRefTiers, long idReserv, Date dtNais, Date expirDatePass,
			String firstName, String lastName, String numPass) {
		super();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.idPassenger = idPassenger;
		this.idRefTiers = idRefTiers;
		this.idReserv = idReserv;
		this.setDtNais(dateFormat.format(dtNais));
		this.setExpirDatePass(dateFormat.format(expirDatePass));
		this.firstName = firstName;
		this.lastName = lastName;
		this.numPass = numPass;
	}

	public long getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(long idPassenger) {
		this.idPassenger = idPassenger;
	}

	public long getIdRefTiers() {
		return idRefTiers;
	}

	public void setIdRefTiers(long idRefTiers) {
		this.idRefTiers = idRefTiers;
	}

	public long getIdReserv() {
		return idReserv;
	}

	public void setIdReserv(long idReserv) {
		this.idReserv = idReserv;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumPass() {
		return numPass;
	}

	public void setNumPass(String numPass) {
		this.numPass = numPass;
	}

	public String getExpirDatePass() {
		return expirDatePass;
	}

	public void setExpirDatePass(String expirDatePass) {
		this.expirDatePass = expirDatePass;
	}

	public String getDtNais() {
		return dtNais;
	}

	public void setDtNais(String dtNais) {
		this.dtNais = dtNais;
	}

}