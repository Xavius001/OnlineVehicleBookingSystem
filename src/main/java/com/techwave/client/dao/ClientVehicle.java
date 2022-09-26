package com.techwave.client.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.techwave.client.model.Branchdb;
import com.techwave.client.model.Vehicledb;

public class ClientVehicle implements IClientVehicle {
	
	@Autowired
	RestTemplate restTemplate;
	public String url="http://localhost:8081/"; //server
	
	@Autowired
	List<Vehicledb> requests;
	
	@Override
	public List<Vehicledb> getAllVehicles() {
		Vehicledb list[] = restTemplate.getForObject(url+"getAllVehicles", Vehicledb[].class);
		return Arrays.asList(list);
	}
	@Override
	public Vehicledb getByVehicleId(String vehicleId) {
		return restTemplate.getForObject(url+"getByVehicleId/"+vehicleId, Vehicledb.class);
	}
	@Override
	public String AddVehicle(Vehicledb v) {
		return restTemplate.postForObject(url+"AddVehicle", v, String.class);
	}
	@Override
	public String UpdateVehicle(Vehicledb v) {
		restTemplate.put(url+"UpdateVehicle/"+v.getVehicleId(), v);
		return "vehicle updated";
	}
	@Override
	public String DeleteVehicle(Vehicledb v) {
		restTemplate.delete(url+"DeleteVehicle/"+v.getVehicleId(), String.class);
		return "Vehicle deleted";
	}
	@Override
	public String validateVehicleRequest(Vehicledb newVehicle, Branchdb branchId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Vehicledb> searchVehicles(Vehicledb search, Integer price1, Integer price2) {
		List<Vehicledb> vlist;
		try {
			vlist = getAllVehicles().stream().filter(i->
				i.getManufactureName().equalsIgnoreCase(search.getManufactureName()) &&
				
				(i.getPrice()>price1 && i.getPrice()<price2) && 
				
				i.getColor().equalsIgnoreCase(search.getColor()) &&
				
				i.getbranchId().getbranchId().getUserId().equalsIgnoreCase(search.getbranchId().getbranchId().getUserId()) &&
				
				i.getStock()>0 ).collect(Collectors.toList()); 
			
			if(vlist!=null) {
				return vlist;
			}
			else {
				throw new Exception();
			}
		}
		catch (Exception E) {
			return null;
		}
	}
	
	@Override
	public String requestVehicle(Vehicledb request) {
		requests.add(request);
		return "Request added.";
	}
	
	@Override
	public List<Vehicledb> displayRequests() {
		return requests;
	}
	
	@Override
	public String approveVehicle(Vehicledb request) {
		try {
			Vehicledb old = getByVehicleId(request.getVehicleId());
			if(old!=null && 
				old.getManufactureName().equals(request.getManufactureName()) &&
				old.getColor().equalsIgnoreCase(request.getColor()) && old.getPrice().compareTo(request.getPrice())==0
				&& old.getbranchId().getbranchId().getUserId().equals(request.getbranchId().getbranchId().getUserId())
				&& old.getStock()<request.getStock()) 
			{
				rejectVehicle(request); //removes request
				return UpdateVehicle(request);
			}
			else {
				throw new Exception();
			}
		}
		catch (Exception E) {
			return E.getMessage();
		}
	}
	
	@Override
	public String rejectVehicle(Vehicledb request) {
		requests.remove(request);
		return "Vehicle Request Denied";
	}
}
