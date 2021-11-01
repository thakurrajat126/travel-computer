package com.mersedes.common;

public class ChargingStation {

	private String name;
	private int distance;
	private int limit;
	public ChargingStation() {
	}
	public ChargingStation(String name, int distance, int limit) {
		setName(name);
		setDistance(distance);
		setLimit(limit);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		if(limit>100)
		{
			this.limit = 100;
		}	
		else
		this.limit = limit;
	}
	
	
	

}
