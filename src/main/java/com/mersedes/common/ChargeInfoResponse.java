package com.mersedes.common;

public class ChargeInfoResponse {

	private String vin;
	private int currentChargeLevel;
	private String error = null;
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public int getCurrentChargeLevel() {
		return currentChargeLevel;
	}
	public void setCurrentChargeLevel(int currentChargeLevel) {
		if(currentChargeLevel>100) {
			this.currentChargeLevel = 100;
		}
		else
		this.currentChargeLevel = currentChargeLevel;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

	
	
	
	

}
