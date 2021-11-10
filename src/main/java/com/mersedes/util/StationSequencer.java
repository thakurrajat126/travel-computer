package com.mersedes.util;

import java.util.ArrayList;

import com.mersedes.common.ChargingStation;

public class StationSequencer {
	
	private int currentCharge;
	private int distance;
	private ArrayList<ChargingStation> stations;
	private ArrayList<ChargingStation> route = null;
	
	public StationSequencer(int currentCharge, int distance, ArrayList<ChargingStation> stations) {
		super();
		this.currentCharge = currentCharge;
		this.distance = distance;
		this.stations = stations;
	}

	public  void subset(int k, int start, int currLen, boolean[] used) {
		if(null==route) {
			if (currLen == k) {
				ArrayList<ChargingStation> cs = new ArrayList<ChargingStation>();
				for (int i = 0; i < stations.size(); i++) {
					if (used[i] == true) {
						cs.add(stations.get(i));
						//System.out.print(stations.get(i).getName()+"-");
					}
				}
				//System.out.println();
				if(validateRoute(cs)) {
					route=cs;
				}
				return;
			}
			if (start == stations.size()) {
				return;
			}
			used[start] = true;
			subset(k, start + 1, currLen + 1, used);
			used[start] = false;
			subset(k, start + 1, currLen, used);
		}
		return;
	}

	public  ArrayList<ChargingStation> generateSequence() {
		boolean[] B = new boolean[stations.size()];
		if(currentCharge-distance>=0) {
			return new ArrayList<ChargingStation>(0);
		}
		for(int i = 1 ; i <= stations.size() ; i++) {
            if(null!=route)break;
			subset(i, 0, 0, B);
		}
		return route;
	}
	
	
	private Boolean validateRoute(ArrayList<ChargingStation> chargingStations) {
		int newCharge = currentCharge;
		int newDistance = distance;
		int i = 0;
		if(chargingStations.size()==0) {
			if(currentCharge-distance>=0)
			return true;
			else return false;
		}
		if(chargingStations.get(0).getDistance()>newCharge) {
			return false;
		}
		for(; i < chargingStations.size() ; i ++) {
			newCharge = newCharge - chargingStations.get(i).getDistance() + chargingStations.get(i).getLimit();
			newDistance = newDistance - chargingStations.get(i).getDistance();
			if(newCharge>100) {
				newCharge = 100;
			}
			if(newCharge <=0) {
				return false;
			}
		}
		if(newCharge-(newDistance-chargingStations.get(i-1).getDistance())<0) {
			return false;
		}
		return true;
		}

}
