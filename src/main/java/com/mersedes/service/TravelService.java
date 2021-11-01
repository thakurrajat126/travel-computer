package com.mersedes.service;


import java.util.ArrayList;

import com.mersedes.common.ChargeInfoResponse;
import com.mersedes.common.ChargingStation;
import com.mersedes.common.DistanceInfoResponse;
import com.mersedes.common.StationInfoResponse;
import com.mersedes.util.StationComparator;
import com.mersedes.util.StationSequencer;

public class TravelService {
	
	public ArrayList<ChargingStation> stations = new  ArrayList<ChargingStation>();
	public int distance = 0;
	public int currentCharge = 0 ;
	ArrayList<ChargingStation> resCS = new ArrayList<ChargingStation>();


	public ArrayList<ChargingStation> getStations(ChargeInfoResponse chargeInfo, DistanceInfoResponse distanceInfo,
			StationInfoResponse stationInfo) throws Exception {
		
		ArrayList<String> res = new ArrayList<String>();
		currentCharge = chargeInfo.getCurrentChargeLevel();
		distance = distanceInfo.getDistance();
		stations = stationInfo.getChargingStations();
		stations.sort(new StationComparator());
		ArrayList<ChargingStation> ss = new StationSequencer(currentCharge,distance,stations).generateSequence();
		
		return ss;
	}



}
