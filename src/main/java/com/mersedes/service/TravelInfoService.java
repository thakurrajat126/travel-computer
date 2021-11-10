package com.mersedes.service;


import org.springframework.web.client.RestTemplate;
import com.mersedes.common.ChargeInfoRequest;
import com.mersedes.common.ChargeInfoResponse;
import com.mersedes.common.DistanceInfoRequest;
import com.mersedes.common.DistanceInfoResponse;
import com.mersedes.common.StationInfoRequest;
import com.mersedes.common.StationInfoResponse;

public class TravelInfoService {

	public static ChargeInfoResponse  getChargeLevel(String vin) throws Exception
	{
	    final String uri = "https://restmock.techgig.com/merc/charge_level";
	    RestTemplate restTemplate = new RestTemplate();
	    ChargeInfoResponse chargeInfo = restTemplate.postForObject(uri, new ChargeInfoRequest(vin), ChargeInfoResponse.class);
	    return chargeInfo;
	}
	
	public static DistanceInfoResponse getDistance(String source , String destination) throws Exception
	{
	    final String uri = "https://restmock.techgig.com/merc/distance";
	    RestTemplate restTemplate = new RestTemplate();
	    DistanceInfoResponse distanceInfo = restTemplate.postForObject(uri, new DistanceInfoRequest(source,destination), DistanceInfoResponse.class);
	    return distanceInfo;
	}
	
	public static StationInfoResponse getChargingStations(String source , String destination) throws Exception
	{
	    final String uri = "https://restmock.techgig.com/merc/charging_stations";
	    RestTemplate restTemplate = new RestTemplate();
	    StationInfoResponse stationInfo = restTemplate.postForObject(uri, new StationInfoRequest(source,destination), StationInfoResponse.class);
	    return stationInfo;
	}


}
