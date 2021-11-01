package com.mersedes.common;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseJson {

	private String transactionId;
	private String vin;
	private String source;
	private String destination;
	private Integer distance = null;
	private Integer currentChargeLevel = null;
	private Boolean isChargingRequired;
	private ResponseError[] errors;
	private ArrayList<ChargingStation> chargingStations; 
	
	
	public ArrayList<ChargingStation> getChargingStations() {
		return chargingStations;
	}
	public void setChargingStations(ArrayList<ChargingStation> chargingStations) {
		this.chargingStations = chargingStations;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
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
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Integer getCurrentChargeLevel() {
		return currentChargeLevel;
	}
	public void setCurrentChargeLevel(Integer currentChargeLevel) {
		this.currentChargeLevel = currentChargeLevel;
	}
	public Boolean getIsChargingRequired() {
		return isChargingRequired;
	}
	public void setIsChargingRequired(Boolean isChargingRequired) {
		this.isChargingRequired = isChargingRequired;
	}
	public ResponseError[] getErrors() {
		return errors;
	}
	public void setErrors(ResponseError[] errors) {
		this.errors = errors;
	}
	
}
