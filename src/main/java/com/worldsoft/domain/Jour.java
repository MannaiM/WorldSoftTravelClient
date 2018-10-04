package com.worldsoft.domain;
// Generated 31 mars 2016 10:57:06 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Jour generated by hbm2java
 */
@Entity
@Table(name = "JOUR")
public class Jour implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idJour;
	private BigDecimal numJour;
	private String nomJour;
	private Set<MvmentPrix> mvmentPrixes = new HashSet<MvmentPrix>(0);
	private Set<Promotion> promotions = new HashSet<Promotion>(0);
	private Set<PeriodeSupplement> periodeSupplements = new HashSet<PeriodeSupplement>(0);

	public Jour() {
	}

	public Jour(BigDecimal idJour) {
		this.idJour = idJour;
	}

	public Jour(BigDecimal idJour, BigDecimal numJour, String nomJour, Set<MvmentPrix> mvmentPrixes,
			Set<Promotion> promotions, Set<PeriodeSupplement> periodeSupplements) {
		this.idJour = idJour;
		this.numJour = numJour;
		this.nomJour = nomJour;
		this.mvmentPrixes = mvmentPrixes;
		this.promotions = promotions;
		this.periodeSupplements = periodeSupplements;
	}

	@Id

	@Column(name = "ID_JOUR", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdJour() {
		return this.idJour;
	}

	public void setIdJour(BigDecimal idJour) {
		this.idJour = idJour;
	}

	@Column(name = "NUM_JOUR", precision = 22, scale = 0)
	public BigDecimal getNumJour() {
		return this.numJour;
	}

	public void setNumJour(BigDecimal numJour) {
		this.numJour = numJour;
	}

	@Column(name = "NOM_JOUR_", length = 9)
	public String getNomJour() {
		return this.nomJour;
	}

	public void setNomJour(String nomJour) {
		this.nomJour = nomJour;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jour")
	public Set<MvmentPrix> getMvmentPrixes() {
		return this.mvmentPrixes;
	}

	public void setMvmentPrixes(Set<MvmentPrix> mvmentPrixes) {
		this.mvmentPrixes = mvmentPrixes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jour")
	public Set<Promotion> getPromotions() {
		return this.promotions;
	}

	public void setPromotions(Set<Promotion> promotions) {
		this.promotions = promotions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jour")
	public Set<PeriodeSupplement> getPeriodeSupplements() {
		return this.periodeSupplements;
	}

	public void setPeriodeSupplements(Set<PeriodeSupplement> periodeSupplements) {
		this.periodeSupplements = periodeSupplements;
	}

}