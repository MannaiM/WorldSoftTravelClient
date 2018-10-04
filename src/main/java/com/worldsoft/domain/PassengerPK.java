package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PASSENGER database table.
 * 
 */
@Embeddable
public class PassengerPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "ID_PASSENGER")
	private long idPassenger;

	@Column(name = "ID_REF_TIERS")
	private long idRefTiers;

	@Column(name = "ID_RESERV")
	private long idReserv;

	public PassengerPK() {
	}

	public PassengerPK(long idPassenger, long idRefTiers, long idReserv) {
		super();
		this.idPassenger = idPassenger;
		this.idRefTiers = idRefTiers;
		this.idReserv = idReserv;
	}

	public long getIdPassenger() {
		return this.idPassenger;
	}

	public void setIdPassenger(long idPassenger) {
		this.idPassenger = idPassenger;
	}

	public long getIdRefTiers() {
		return this.idRefTiers;
	}

	public void setIdRefTiers(long idRefTiers) {
		this.idRefTiers = idRefTiers;
	}

	public long getIdReserv() {
		return this.idReserv;
	}

	public void setIdReserv(long idReserv) {
		this.idReserv = idReserv;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PassengerPK)) {
			return false;
		}
		PassengerPK castOther = (PassengerPK) other;
		return (this.idPassenger == castOther.idPassenger) && (this.idRefTiers == castOther.idRefTiers)
				&& (this.idReserv == castOther.idReserv);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idPassenger ^ (this.idPassenger >>> 32)));
		hash = hash * prime + ((int) (this.idRefTiers ^ (this.idRefTiers >>> 32)));
		hash = hash * prime + ((int) (this.idReserv ^ (this.idReserv >>> 32)));

		return hash;
	}
}