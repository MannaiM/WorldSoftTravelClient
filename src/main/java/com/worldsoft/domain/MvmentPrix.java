package com.worldsoft.domain;
// Generated 1 avr. 2016 15:12:05 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MvmentPrix generated by hbm2java
 */
@Entity
@Table(name = "MVMENT_PRIX")
public class MvmentPrix implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idPrix;
	private Arrangement arrangement;
	private Hotel hotel;
	private RefTiers refTiers;
	private Jour jour;
	private Periode periode;
	private TypeChambre typeChambre;
	private Avion avion;
	private TypeVol typeVol;
	private ClassVol classVol;
	private BigDecimal prixAchat;
	private BigDecimal marge;
	private BigDecimal txMarge;
	private BigDecimal prixVente;
	private Character actifPrix;
	private Date dateRes;
	private String dep;
	private String arr;
	private BigDecimal nbreChm;
	private String paysDest;
	private Character flag;
	private String idVolSegment;
	private BigDecimal numVol;
	

	public MvmentPrix() {
	}

	public MvmentPrix(BigDecimal idPrix, Jour jour, Periode periode) {
		this.idPrix = idPrix;
		this.jour = jour;
		this.periode = periode;
	}

	public MvmentPrix(BigDecimal idPrix, Arrangement arrangement, Hotel hotel, RefTiers refTiers, Jour jour,
			Periode periode, TypeChambre typeChambre, Avion avion, TypeVol typeVol, ClassVol classVol,
			BigDecimal prixAchat, BigDecimal marge, BigDecimal txMarge, BigDecimal prixVente, Character actifPrix,
			Date dateRes, String dep, String arr, BigDecimal nbreChm , String villeDest , Character flag) {
		this.idPrix = idPrix;
		this.arrangement = arrangement;
		this.hotel = hotel;
		this.refTiers = refTiers;
		this.jour = jour;
		this.periode = periode;
		this.typeChambre = typeChambre;
		this.avion = avion;
		this.typeVol = typeVol;
		this.classVol = classVol;
		this.prixAchat = prixAchat;
		this.marge = marge;
		this.txMarge = txMarge;
		this.prixVente = prixVente;
		this.actifPrix = actifPrix;
		this.dateRes = dateRes;
		this.dep = dep;
		this.arr = arr;
	}
	
	@Id

	@Column(name = "ID_PRIX", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdPrix() {
		return this.idPrix;
	}

	public void setIdPrix(BigDecimal idPrix) {
		this.idPrix = idPrix;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
			@JoinColumn(name = "ID_ARRANGEMENT", referencedColumnName = "ID_ARRANGEMENT") })
	public Arrangement getArrangement() {
		return this.arrangement;
	}

	public void setArrangement(Arrangement arrangement) {
		this.arrangement = arrangement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_HOTEL", insertable = false, updatable = false)
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_REF_TIERS")
	public RefTiers getRefTiers() {
		return this.refTiers;
	}

	public void setRefTiers(RefTiers refTiers) {
		this.refTiers = refTiers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JOUR", nullable = false)
	public Jour getJour() {
		return this.jour;
	}

	public void setJour(Jour jour) {
		this.jour = jour;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
			@JoinColumn(name = "ID_PERIODE", referencedColumnName = "ID_PERIODE",  insertable = false, updatable = false) })
	public Periode getPeriode() {
		return this.periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
			@JoinColumn(name = "ID_CHM", referencedColumnName = "ID_CHM", insertable = false, updatable = false) })
	public TypeChambre getTypeChambre() {
		return this.typeChambre;
	}

	public void setTypeChambre(TypeChambre typeChambre) {
		this.typeChambre = typeChambre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AVION")
	public Avion getAvion() {
		return this.avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TYPE_VOL")
	public TypeVol getTypeVol() {
		return this.typeVol;
	}

	public void setTypeVol(TypeVol typeVol) {
		this.typeVol = typeVol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "ID_AVION", referencedColumnName = "ID_AVION", insertable = false, updatable = false),
			@JoinColumn(name = "ID_CLASS_VOL", referencedColumnName = "ID_CLASS_VOL", insertable = false, updatable = false) })
	public ClassVol getClassVol() {
		return this.classVol;
	}

	public void setClassVol(ClassVol classVol) {
		this.classVol = classVol;
	}

	@Column(name = "PRIX_ACHAT", precision = 22, scale = 0)
	public BigDecimal getPrixAchat() {
		return this.prixAchat;
	}

	public void setPrixAchat(BigDecimal prixAchat) {
		this.prixAchat = prixAchat;
	}

	@Column(name = "MARGE", precision = 22, scale = 0)
	public BigDecimal getMarge() {
		return this.marge;
	}

	public void setMarge(BigDecimal marge) {
		this.marge = marge;
	}

	@Column(name = "TX_MARGE", precision = 22, scale = 0)
	public BigDecimal getTxMarge() {
		return this.txMarge;
	}

	public void setTxMarge(BigDecimal txMarge) {
		this.txMarge = txMarge;
	}

	@Column(name = "PRIX_VENTE", precision = 22, scale = 0)
	public BigDecimal getPrixVente() {
		return this.prixVente;
	}

	public void setPrixVente(BigDecimal prixVente) {
		this.prixVente = prixVente;
	}

	@Column(name = "ACTIF_PRIX", length = 1)
	public Character getActifPrix() {
		return this.actifPrix;
	}

	public void setActifPrix(Character actifPrix) {
		this.actifPrix = actifPrix;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_RES", length = 7)
	public Date getDateRes() {
		return this.dateRes;
	}

	public void setDateRes(Date dateRes) {
		this.dateRes = dateRes;
	}
	
	@Column(name = "DEP", length = 3)
	public String getDep() {
		return this.dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	@Column(name = "ARR", length = 3)
	public String getArr() {
		return this.arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}
	
	@Column(name = "NBRE_CHM", precision = 22, scale = 0)
	public BigDecimal getNbreChm() {
		return this.nbreChm;
	}

	public void setNbreChm(BigDecimal nbreChm) {
		this.nbreChm = nbreChm;
	}
	
	@Column(name = "PAYS_DEST", length = 30)
	public String getPaysDest() {
		return this.paysDest;
	}

	public void setPaysDest(String paysDest) {
		this. paysDest = paysDest;
	}
	
	@Column(name = "FLAG", length = 1)
	public Character getFlag (){
		return this.flag;
	}

	public void setFlag(Character flag) {
		this.flag = flag;
	}
	
	@Column(name = "ID_VOL_SEGMENT", length = 30)
	public String getIdVolSegment() {
		return this.idVolSegment;
	}

	public void setIdVolSegment(String idVolSegment) {
		this.idVolSegment = idVolSegment;
	}
	
	@Column(name = "NUM_VOL", precision = 22, scale = 0)
	public BigDecimal getNumVol() {
		return this.numVol;
	}

	public void setNumVol(BigDecimal numVol) {
		this.numVol = numVol;
	}

}
