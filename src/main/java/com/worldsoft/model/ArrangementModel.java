package com.worldsoft.model;

public class ArrangementModel {

	private String abvArrangement;
	private String lArrangement;

	public ArrangementModel() {
		super();
	}

	public ArrangementModel(String abvArrangement, String lArrangement) {
		super();
		this.abvArrangement = abvArrangement;
		this.lArrangement = lArrangement;
	}

	public String getAbvArrangement() {
		return abvArrangement;
	}

	public void setAbvArrangement(String abvArrangement) {
		this.abvArrangement = abvArrangement;
	}

	public String getlArrangement() {
		return lArrangement;
	}

	public void setlArrangement(String lArrangement) {
		this.lArrangement = lArrangement;
	}

}
