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
 * RefTiers generated by hbm2java
 */
@Entity
@Table(name = "REF_TIERS")
public class RefTiers implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idRefTiers;
	private String resSocial;
	private String emailClient;
	private String adrTiers;
	private String siteTiers;
	private BigDecimal telTiers;
	private BigDecimal mobTiers;
	private Character tiersActif;
	private Set<RefUtilisateur> refUtilisateurs = new HashSet<RefUtilisateur>(0);
	private Set<MvmentPrix> mvmentPrixes = new HashSet<MvmentPrix>(0);
	private Set<Reservation> reservations = new HashSet<Reservation>(0);

	public RefTiers() {
	}

	public RefTiers(BigDecimal idRefTiers) {
		this.idRefTiers = idRefTiers;
	}

	public RefTiers(BigDecimal idRefTiers, String resSocial, String emailClient, String adrTiers, String siteTiers,
			BigDecimal telTiers, BigDecimal mobTiers, Character tiersActif, Set<RefUtilisateur> refUtilisateurs,
			Set<MvmentPrix> mvmentPrixes, Set<Reservation> reservations) {
		this.idRefTiers = idRefTiers;
		this.resSocial = resSocial;
		this.emailClient = emailClient;
		this.adrTiers = adrTiers;
		this.siteTiers = siteTiers;
		this.telTiers = telTiers;
		this.mobTiers = mobTiers;
		this.tiersActif = tiersActif;
		this.refUtilisateurs = refUtilisateurs;
		this.mvmentPrixes = mvmentPrixes;
		this.reservations = reservations;
	}

	@Id

	@Column(name = "ID_REF_TIERS", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdRefTiers() {
		return this.idRefTiers;
	}

	public void setIdRefTiers(BigDecimal idRefTiers) {
		this.idRefTiers = idRefTiers;
	}

	@Column(name = "RES_SOCIAL", length = 25)
	public String getResSocial() {
		return this.resSocial;
	}

	public void setResSocial(String resSocial) {
		this.resSocial = resSocial;
	}

	@Column(name = "EMAIL_CLIENT", length = 20)
	public String getEmailClient() {
		return this.emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	@Column(name = "ADR_TIERS", length = 20)
	public String getAdrTiers() {
		return this.adrTiers;
	}

	public void setAdrTiers(String adrTiers) {
		this.adrTiers = adrTiers;
	}

	@Column(name = "SITE_TIERS", length = 20)
	public String getSiteTiers() {
		return this.siteTiers;
	}

	public void setSiteTiers(String siteTiers) {
		this.siteTiers = siteTiers;
	}

	@Column(name = "TEL_TIERS", precision = 22, scale = 0)
	public BigDecimal getTelTiers() {
		return this.telTiers;
	}

	public void setTelTiers(BigDecimal telTiers) {
		this.telTiers = telTiers;
	}

	@Column(name = "MOB_TIERS", precision = 22, scale = 0)
	public BigDecimal getMobTiers() {
		return this.mobTiers;
	}

	public void setMobTiers(BigDecimal mobTiers) {
		this.mobTiers = mobTiers;
	}

	@Column(name = "TIERS_ACTIF", length = 1)
	public Character getTiersActif() {
		return this.tiersActif;
	}

	public void setTiersActif(Character tiersActif) {
		this.tiersActif = tiersActif;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refTiers")
	public Set<RefUtilisateur> getRefUtilisateurs() {
		return this.refUtilisateurs;
	}

	public void setRefUtilisateurs(Set<RefUtilisateur> refUtilisateurs) {
		this.refUtilisateurs = refUtilisateurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refTiers")
	public Set<MvmentPrix> getMvmentPrixes() {
		return this.mvmentPrixes;
	}

	public void setMvmentPrixes(Set<MvmentPrix> mvmentPrixes) {
		this.mvmentPrixes = mvmentPrixes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refTiers")
	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

}
