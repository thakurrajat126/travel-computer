package com.mersedes.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mersedes.common.ChargeInfoResponse;
import com.mersedes.common.ChargingStation;
import com.mersedes.common.DistanceInfoResponse;
import com.mersedes.common.RequestJson;
import com.mersedes.common.ResponseError;
import com.mersedes.common.ResponseJson;
import com.mersedes.common.StationInfoResponse;
import com.mersedes.service.TravelInfoService;
import com.mersedes.service.TravelService;

@RestController  
public class UserController   
{  
@PostMapping(value = "/compute")  
public ResponseJson getProduct(@RequestBody RequestJson req)   
{  
	ResponseJson rj = 	new ResponseJson();
	try {
	ChargeInfoResponse chargeInfo = TravelInfoService.getChargeLevel(req.getVin());
	DistanceInfoResponse distanceInfo = TravelInfoService.getDistance(req.getSource(), req.getDestination());
	StationInfoResponse stationInfo = TravelInfoService.getChargingStations(req.getSource(), req.getDestination());
	
	
	
	rj.setTransactionId(Calendar.getInstance().getTimeInMillis()+""+new Random().nextInt(99999));
	if(null!=chargeInfo.getError() || 
			null!=distanceInfo.getError() ||
			null!=stationInfo.getError()) {
			throw new Exception();
		}
	rj.setDestination(req.getDestination());
	rj.setSource(req.getSource());
	rj.setVin(req.getVin());
	rj.setCurrentChargeLevel(chargeInfo.getCurrentChargeLevel());
	rj.setIsChargingRequired(false);
	
	rj.setDistance(distanceInfo.getDistance());
	
	ArrayList<ChargingStation> stations = new TravelService().getStations(chargeInfo,distanceInfo,stationInfo);
	if(null==stations) {
		ResponseError error = new ResponseError();
		error.setId(8888);
		error.setDescription("Unable to reach the destination with the current fuel level");
		ResponseError[] errors = new ResponseError[1];
		errors[0] = error;
		rj.setErrors(errors);
		rj.setIsChargingRequired(true);
	}
	else {
		if(stations.size()>0) {
			rj.setIsChargingRequired(true);
			rj.setChargingStations(stations);
		}
		else {
			rj.setChargingStations(null);
		}
	}
	

	}
	catch(Exception e) {
		ResponseError error = new ResponseError();
		error.setId(9999);
		error.setDescription("Technical Exception");
		ResponseError[] errors = new ResponseError[1];
		errors[0] = error;
		rj.setErrors(errors);
	}
	
	return rj;  
}  
}  