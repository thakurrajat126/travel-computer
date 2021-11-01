package com.mersedes.common;

public class DistanceInfoRequest {

	private String source;
	private String destination;
	
	public DistanceInfoRequest(String source2, String destination2) {
		setSource(source2);
		setDestination(destination2);
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
	
	
	

}
