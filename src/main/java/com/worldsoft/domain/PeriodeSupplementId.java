package com.worldsoft.domain;
// Generated 31 mars 2016 10:57:06 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PeriodeSupplementId generated by hbm2java
 */
@Embeddable
public class PeriodeSupplementId implements java.io.Serializable {

	private BigDecimal idHotel;
	private BigDecimal idSupp;
	private BigDecimal idPeriode;
	private BigDecimal idJour;

	public PeriodeSupplementId() {
	}

	public PeriodeSupplementId(BigDecimal idHotel, BigDecimal idSupp, BigDecimal idPeriode, BigDecimal idJour) {
		this.idHotel = idHotel;
		this.idSupp = idSupp;
		this.idPeriode = idPeriode;
		this.idJour = idJour;
	}

	@Column(name = "ID_HOTEL", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(BigDecimal idHotel) {
		this.idHotel = idHotel;
	}

	@Column(name = "ID_SUPP", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdSupp() {
		return this.idSupp;
	}

	public void setIdSupp(BigDecimal idSupp) {
		this.idSupp = idSupp;
	}

	@Column(name = "ID_PERIODE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdPeriode() {
		return this.idPeriode;
	}

	public void setIdPeriode(BigDecimal idPeriode) {
		this.idPeriode = idPeriode;
	}

	@Column(name = "ID_JOUR", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdJour() {
		return this.idJour;
	}

	public void setIdJour(BigDecimal idJour) {
		this.idJour = idJour;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PeriodeSupplementId))
			return false;
		PeriodeSupplementId castOther = (PeriodeSupplementId) other;

		return ((this.getIdHotel() == castOther.getIdHotel()) || (this.getIdHotel() != null
				&& castOther.getIdHotel() != null && this.getIdHotel().equals(castOther.getIdHotel())))
				&& ((this.getIdSupp() == castOther.getIdSupp()) || (this.getIdSupp() != null
						&& castOther.getIdSupp() != null && this.getIdSupp().equals(castOther.getIdSupp())))
				&& ((this.getIdPeriode() == castOther.getIdPeriode()) || (this.getIdPeriode() != null
						&& castOther.getIdPeriode() != null && this.getIdPeriode().equals(castOther.getIdPeriode())))
				&& ((this.getIdJour() == castOther.getIdJour()) || (this.getIdJour() != null
						&& castOther.getIdJour() != null && this.getIdJour().equals(castOther.getIdJour())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdHotel() == null ? 0 : this.getIdHotel().hashCode());
		result = 37 * result + (getIdSupp() == null ? 0 : this.getIdSupp().hashCode());
		result = 37 * result + (getIdPeriode() == null ? 0 : this.getIdPeriode().hashCode());
		result = 37 * result + (getIdJour() == null ? 0 : this.getIdJour().hashCode());
		return result;
	}

}
