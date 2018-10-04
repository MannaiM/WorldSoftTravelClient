package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the PASSENGER database table.
 * 
 */
@Entity
@NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p")
public class Passenger implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PassengerPK id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_NAIS")
	private Date dtNais;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIR_DATE_PASS")
	private Date expirDatePass;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "NUM_PASS")
	private String numPass;

	public Passenger() {
	}

	public PassengerPK getId() {
		return this.id;
	}

	public void setId(PassengerPK id) {
		this.id = id;
	}

	public Date getDtNais() {
		return this.dtNais;
	}

	public void setDtNais(Date dtNais) {
		this.dtNais = dtNais;
	}

	public Date getExpirDatePass() {
		return this.expirDatePass;
	}

	public void setExpirDatePass(Date expirDatePass) {
		this.expirDatePass = expirDatePass;
	}

	public String getNumPass() {
		return this.numPass;
	}

	public void setNumPass(String numPass) {
		this.numPass = numPass;
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

}