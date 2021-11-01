package com.mersedes.util;

import java.util.Comparator;

import com.mersedes.common.ChargingStation;

public class StationComparator implements Comparator<ChargingStation> {


	@Override
	public int compare(ChargingStation o1, ChargingStation o2) {
		if(o1.getDistance()==o2.getDistance()) {
			return o1.toString().compareTo(o2.toString());
		}
		return o1.getDistance()-o2.getDistance();
	}


}
