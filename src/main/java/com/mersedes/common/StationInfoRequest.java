package com.mersedes.common;

public class StationInfoRequest {

	private String source;
	private String destination;
	
	public StationInfoRequest(String source2, String destination2) {
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
