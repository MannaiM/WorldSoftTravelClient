package com.worldsoft.model;

public class TypeChambreModel {

	private String lTypeChambre;
	private String type;

	public TypeChambreModel(String lTypeChambre, String type) {
		super();
		this.lTypeChambre = lTypeChambre;
		this.type = type;
	}

	public String getlTypeChambre() {
		return lTypeChambre;
	}

	public void setlTypeChambre(String lTypeChambre) {
		this.lTypeChambre = lTypeChambre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TypeChambreModel() {
		super();
	}

}
