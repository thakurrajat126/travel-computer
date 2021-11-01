package com.mersedes.common;

import java.util.ArrayList;

public class StationInfoResponse {
	
	private String source;
	private String destination;
	private ArrayList<ChargingStation> chargingStations;
	private String error= null;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public ArrayList<ChargingStation> getChargingStations() {
		return chargingStations;
	}
	public void setChargingStations(ArrayList<ChargingStation> chargingStations) {
		this.chargingStations = chargingStations;
	}
	public String getError() {
		return error;
	}
	public void setErrors(String error) {
		this.error = error;
	}

	
	
	

}
