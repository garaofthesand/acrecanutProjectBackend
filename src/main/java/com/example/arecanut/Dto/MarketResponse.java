package com.example.arecanut.Dto;

public class MarketResponse {

	private String name;
	private int red;
	private int white;
	private int bette;
	
	
	public MarketResponse(String string, int i, int j, int k, String string2) {
		// TODO Auto-generated constructor stub
	}
	public MarketResponse() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getWhite() {
		return white;
	}
	public void setWhite(int white) {
		this.white = white;
	}
	public int getBette() {
		return bette;
	}
	public void setBette(int bette) {
		this.bette = bette;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	private String updated;

}
