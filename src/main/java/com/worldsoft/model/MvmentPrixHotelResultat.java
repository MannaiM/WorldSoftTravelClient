package com.worldsoft.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MvmentPrixHotelResultat {
	private BigDecimal idPrix;
	private String VilleHotelR;
	private String PaysR;
	private String NomHotelR;
	private String LTypeChambreR;
	private String CategorieR;
	private BigDecimal idHotelR;
	private BigDecimal prixVenteR;
	private String DateCheckInR;
	private String DateCheckOutR;
	private long Compteur;
	private String arrangement;
	private List<BigDecimal> listId;
	private List<PassengerModel> passengers;

	public MvmentPrixHotelResultat(BigDecimal prixVenteR, String nomHotelR, String categorieR, BigDecimal idHotelR,
			String villeHotelR, String paysR, String lTypeChambreR, long Compteur) {
		super();
		VilleHotelR = villeHotelR;
		PaysR = paysR;
		NomHotelR = nomHotelR;
		LTypeChambreR = lTypeChambreR;
		CategorieR = categorieR;
		this.prixVenteR = prixVenteR;
		this.idHotelR = idHotelR;
		this.Compteur = Compteur;
		this.passengers = new ArrayList<PassengerModel>();

	}

	public MvmentPrixHotelResultat(BigDecimal prixVenteR, long Compteur, String nomHotelR, String categorieR,
			String villeHotelR, String paysR, String lTypeChambreR, BigDecimal idHotelR, String arrangement) {
		super();
		VilleHotelR = villeHotelR;
		PaysR = paysR;
		NomHotelR = nomHotelR;
		LTypeChambreR = lTypeChambreR;
		CategorieR = categorieR;
		this.prixVenteR = prixVenteR;
		this.idHotelR = idHotelR;
		this.Compteur = Compteur;
		this.passengers = new ArrayList<PassengerModel>();
		this.arrangement = arrangement;


	}

	public MvmentPrixHotelResultat(String VilleHotelR, String PaysR, String NomHotelR, String LTypeChambreR,
			String CategorieR, BigDecimal idHotelR, BigDecimal prixVenteR, String DateCheckInR, String DateCheckOutR,
			long Compteur) {
		super();
		this.VilleHotelR = VilleHotelR;
		this.PaysR = PaysR;
		this.NomHotelR = NomHotelR;
		this.LTypeChambreR = LTypeChambreR;
		this.CategorieR = CategorieR;
		this.idHotelR = idHotelR;
		this.prixVenteR = prixVenteR;
		this.DateCheckInR = DateCheckInR;
		this.DateCheckOutR = DateCheckOutR;
		this.Compteur = Compteur;
		this.passengers = new ArrayList<PassengerModel>();

	}

	public String getVilleHotelR() {
		return VilleHotelR;
	}

	public void setVilleHotelR(String villeHotelR) {
		VilleHotelR = villeHotelR;
	}

	public String getPaysR() {
		return PaysR;
	}

	public void setPaysR(String paysR) {
		PaysR = paysR;
	}

	public String getNomHotelR() {
		return NomHotelR;
	}

	public void setNomHotelR(String nomHotelR) {
		NomHotelR = nomHotelR;
	}

	public String getLTypeChambreR() {
		return LTypeChambreR;
	}

	public void setLTypeChambreR(String lTypeChambreR) {
		LTypeChambreR = lTypeChambreR;
	}

	public String getCategorieR() {
		return CategorieR;
	}

	public void setCategorieR(String categorieR) {
		CategorieR = categorieR;
	}

	public BigDecimal getIdHotelR() {
		return idHotelR;
	}

	public void setIdHotelR(BigDecimal idHotelR) {
		this.idHotelR = idHotelR;
	}

	public BigDecimal getPrixVenteR() {
		return prixVenteR;
	}

	public void setPrixVenteR(BigDecimal prixVenteR) {
		this.prixVenteR = prixVenteR;
	}

	public String getDateCheckInR() {
		return DateCheckInR;
	}

	public void setDateCheckInR(String dateCheckInR) {
		DateCheckInR = dateCheckInR;
	}

	public String getDateCheckOutR() {
		return DateCheckOutR;
	}

	public void setDateCheckOutR(String dateCheckOutR) {
		DateCheckOutR = dateCheckOutR;
	}

	public long getCompteur() {
		return Compteur;
	}

	public void setCompteur(long compteur) {
		Compteur = compteur;
	}

	@Override
	public String toString() {
		return "MvmentPrixHotelResultat [VilleHotelR=" + VilleHotelR + ", PaysR=" + PaysR + ", NomHotelR=" + NomHotelR
				+ ", LTypeChambreR=" + LTypeChambreR + ", CategorieR=" + CategorieR + ", idHotelR=" + idHotelR
				+ ", prixVenteR=" + prixVenteR + ", DateCheckInR=" + DateCheckInR + ", DateCheckOutR=" + DateCheckOutR
				+ ", Compteur=" + Compteur + "]";
	}

	public List<BigDecimal> getListId() {
		return listId;
	}

	public void setListId(List<BigDecimal> listId) {
		this.listId = listId;
	}

	public BigDecimal getIdPrix() {
		return idPrix;
	}

	public void setIdPrix(BigDecimal idPrix) {
		this.idPrix = idPrix;
	}

	public MvmentPrixHotelResultat(BigDecimal idPrix, BigDecimal idHotelR, BigDecimal prixVenteR, String nomHotelR,
			String villeHotelR, String lTypeChambreR, String categorieR) {
		super();
		VilleHotelR = villeHotelR;
		NomHotelR = nomHotelR;
		LTypeChambreR = lTypeChambreR;
		this.CategorieR = categorieR;
		this.prixVenteR = prixVenteR;
		this.idHotelR = idHotelR;
		this.idPrix = idPrix;
		this.passengers = new ArrayList<PassengerModel>();

	}

	public MvmentPrixHotelResultat(BigDecimal idPrix, BigDecimal prixVenteR, long Compteur, String nomHotelR,
			String categorieR, String villeHotelR, String paysR, String lTypeChambreR, BigDecimal idHotelR) {
		super();
		VilleHotelR = villeHotelR;
		PaysR = paysR;
		NomHotelR = nomHotelR;
		LTypeChambreR = lTypeChambreR;
		CategorieR = categorieR;
		this.prixVenteR = prixVenteR;
		this.idHotelR = idHotelR;
		this.Compteur = Compteur;
		this.idPrix = idPrix;
		this.passengers = new ArrayList<PassengerModel>();

	}

	public MvmentPrixHotelResultat(BigDecimal idPrix, String VilleHotelR, String PaysR, String NomHotelR,
			String LTypeChambreR, String CategorieR, BigDecimal idHotelR, BigDecimal prixVenteR, String DateCheckInR,
			String DateCheckOutR, long Compteur) {
		super();
		this.VilleHotelR = VilleHotelR;
		this.PaysR = PaysR;
		this.NomHotelR = NomHotelR;
		this.LTypeChambreR = LTypeChambreR;
		this.CategorieR = CategorieR;
		this.idHotelR = idHotelR;
		this.prixVenteR = prixVenteR;
		this.DateCheckInR = DateCheckInR;
		this.DateCheckOutR = DateCheckOutR;
		this.Compteur = Compteur;
		this.idPrix = idPrix;
		this.passengers = new ArrayList<PassengerModel>();
	}

	public List<PassengerModel> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<PassengerModel> passengers) {
		this.passengers = passengers;
	}

	public String getArrangement() {
		return arrangement;
	}

	public void setArrangement(String arrangement) {
		this.arrangement = arrangement;
	}

}