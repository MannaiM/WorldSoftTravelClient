package com.worldsoft.domain;
// Generated 31 mars 2016 10:57:06 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Supplement generated by hbm2java
 */
@Entity
@Table(name = "SUPPLEMENT")
public class Supplement implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SupplementId id;
	private Hotel hotel;
	private String abrvSupp;
	private String LSupp;
	private Character actifSupp;
	private Set<PeriodeSupplement> periodeSupplements = new HashSet<PeriodeSupplement>(0);

	public Supplement() {
	}

	public Supplement(SupplementId id, Hotel hotel) {
		this.id = id;
		this.hotel = hotel;
	}

	public Supplement(SupplementId id, Hotel hotel, String abrvSupp, String LSupp, Character actifSupp,
			Set<PeriodeSupplement> periodeSupplements) {
		this.id = id;
		this.hotel = hotel;
		this.abrvSupp = abrvSupp;
		this.LSupp = LSupp;
		this.actifSupp = actifSupp;
		this.periodeSupplements = periodeSupplements;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idHotel", column = @Column(name = "ID_HOTEL", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "idSupp", column = @Column(name = "ID_SUPP", nullable = false, precision = 22, scale = 0)) })
	public SupplementId getId() {
		return this.id;
	}

	public void setId(SupplementId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_HOTEL",  insertable = false, updatable = false)
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Column(name = "ABRV_SUPP", length = 20)
	public String getAbrvSupp() {
		return this.abrvSupp;
	}

	public void setAbrvSupp(String abrvSupp) {
		this.abrvSupp = abrvSupp;
	}

	@Column(name = "L_SUPP", length = 250)
	public String getLSupp() {
		return this.LSupp;
	}

	public void setLSupp(String LSupp) {
		this.LSupp = LSupp;
	}

	@Column(name = "ACTIF_SUPP", length = 1)
	public Character getActifSupp() {
		return this.actifSupp;
	}

	public void setActifSupp(Character actifSupp) {
		this.actifSupp = actifSupp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "supplement")
	public Set<PeriodeSupplement> getPeriodeSupplements() {
		return this.periodeSupplements;
	}

	public void setPeriodeSupplements(Set<PeriodeSupplement> periodeSupplements) {
		this.periodeSupplements = periodeSupplements;
	}

}
