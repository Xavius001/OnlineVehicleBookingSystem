package com.techwave.client.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.techwave.client.model.Customerdb;

public class ClientCustomer extends ClientLogin implements IClientCustomer {
	
	@Autowired
	RestTemplate restTemplate;
	public String url="http://localhost:8081/"; //server
	@Override
	public List<Customerdb> getAllCust() {
		Customerdb list[] = restTemplate.getForObject(url+"getAllCust", Customerdb[].class);
		return Arrays.asList(list);
	}
	@Override
	public Customerdb getByCustId(String custId) {
		return restTemplate.getForObject(url+"getByCustId/"+custId, Customerdb.class);
	}
	@Override
	public String AddCust(Customerdb C) {
		return restTemplate.postForObject(url+"AddCust", C, String.class);
	}
	@Override
	public String DeleteCust(Customerdb C) {
		restTemplate.delete(url+"DeleteCust/"+C.getcustId().getUserId(), String.class);
		return "Customer deleted";
	}
	
	@Override
	public String validateCustInfo(Customerdb info) {
		String msg = "";
		
		final String specialChars[] = {"#","@","$","%","&"};
		for(String s: specialChars) {
			if(info.getName().contains(s)) msg += "Name should not contain special characters."; break;
		}
		
		Period P = Period.between(info.getDob(), LocalDate.now());
		if(P.getYears()<=20) msg+= "Age should be greater than 20";
		
		String email[] = info.getEmail().split("@");
		if(!(email.length==2  && email[1].contains("."))) msg += "\nEmail Format: xxx@xxxx.com";
		
		String pno[] = info.getPno().split("-");
		if(!(pno.length==2 && pno[0].length()==3 && pno[1].length()==7
			&& NumberUtils.isParsable(pno[0]) && NumberUtils.isParsable(pno[1]) ) ) msg += "\nPhone Number Format: XXX-XXXXXXX";
		
		if(msg.equals("")) msg = "Valid Credentials";
		
		return msg;
		
	}
	
}
