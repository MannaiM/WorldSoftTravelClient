package com.worldsoft.model;

import java.math.BigDecimal;

public class MvmentPrixHotelModel {
	private BigDecimal idPrix;
	private BigDecimal typeChambre;
	private String DateCheckInM;
	private String DateCheckOutM;
	private String VilleHotelM;
	private String PaysM;
	private String NomHotelM;
	private String LTypeChambreM;
	private String CategorieM;
	private BigDecimal idHotelM;
	private BigDecimal prixVenteM;
	private BigDecimal nbrchm;
	private BigDecimal nbreJours;
	private String arrangement;

	public MvmentPrixHotelModel() {
		super();
	}

	@Override
	public String toString() {
		return "MvmentPrixHotelModel [typeChambre=" + typeChambre + ", DateCheckInM=" + DateCheckInM
				+ ", DateCheckOutM=" + DateCheckOutM + ", VilleHotelM=" + VilleHotelM + ", PaysM=" + PaysM
				+ ", NomHotelM=" + NomHotelM + ", LTypeChambreM=" + LTypeChambreM + ", CategorieM=" + CategorieM
				+ ", idHotelM=" + idHotelM + ", prixVenteM=" + prixVenteM + ", nbrchm=" + nbrchm + ", nbreJours="
				+ nbreJours + "]";
	}

	public MvmentPrixHotelModel(BigDecimal typeChambre, String DateCheckInM, String DateCheckOutM, String VilleHotelM,
			String PaysM, String NomHotelM, String LTypeChambreM, String CategorieM, BigDecimal idHotelM,
			BigDecimal prixVenteM, BigDecimal nbrchm, BigDecimal nbreJours) {
		super();
		this.typeChambre = typeChambre;
		this.DateCheckInM = DateCheckInM;
		this.DateCheckOutM = DateCheckOutM;
		this.VilleHotelM = VilleHotelM;
		this.PaysM = PaysM;
		this.NomHotelM = NomHotelM;
		this.LTypeChambreM = LTypeChambreM;
		this.CategorieM = CategorieM;
		this.idHotelM = idHotelM;
		this.prixVenteM = prixVenteM;
		this.nbrchm = nbrchm;
		this.nbreJours = nbreJours;

	}

	public BigDecimal getNbrchm() {
		return nbrchm;
	}

	public void setNbrchm(BigDecimal nbrchm) {
		this.nbrchm = nbrchm;
	}

	public BigDecimal getTypeChambre() {
		return typeChambre;
	}

	public void setTypeChambre(BigDecimal typeChambre) {
		this.typeChambre = typeChambre;
	}

	public String getDateCheckInM() {
		return DateCheckInM;
	}

	public void setDateCheckInM(String dateCheckInM) {
		DateCheckInM = dateCheckInM;
	}

	public String getDateCheckOutM() {
		return DateCheckOutM;
	}

	public void setDateCheckOutM(String dateCheckOutM) {
		DateCheckOutM = dateCheckOutM;
	}

	public String getVilleHotelM() {
		return VilleHotelM;
	}

	public void setVilleHotelM(String villeHotelM) {
		VilleHotelM = villeHotelM;
	}

	public String getPaysM() {
		return PaysM;
	}

	public void setPaysM(String paysM) {
		PaysM = paysM;
	}

	public String getNomHotelM() {
		return NomHotelM;
	}

	public void setNomHotelM(String nomHotelM) {
		NomHotelM = nomHotelM;
	}

	public String getLTypeChambreM() {
		return LTypeChambreM;
	}

	public void setLTypeChambreM(String lTypeChambreM) {
		LTypeChambreM = lTypeChambreM;
	}

	public String getCategorieM() {
		return CategorieM;
	}

	public void setCategorieM(String categorieM) {
		CategorieM = categorieM;
	}

	public BigDecimal getIdHotelM() {
		return idHotelM;
	}

	public void setIdHotelM(BigDecimal idHotelM) {
		this.idHotelM = idHotelM;
	}

	public BigDecimal getPrixVenteM() {
		return prixVenteM;
	}

	public void setPrixVenteM(BigDecimal prixVenteM) {
		this.prixVenteM = prixVenteM;
	}

	public BigDecimal getNbreJours() {
		return nbreJours;
	}

	public void setNbreJours(BigDecimal nbreJours) {
		this.nbreJours = nbreJours;
	}

	public BigDecimal getIdPrix() {
		return idPrix;
	}

	public void setIdPrix(BigDecimal idPrix) {
		this.idPrix = idPrix;
	}

	public String getArrangement() {
		return arrangement;
	}

	public void setArrangement(String arrangement) {
		this.arrangement = arrangement;
	}

}
