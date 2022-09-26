package com.techwave.client.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techwave.client.model.Branchdb;
import com.techwave.client.model.Logindb;

@Service
public class ClientBranch extends ClientCustomer implements IClientBranch {

	@Autowired
	RestTemplate restTemplate;
	public String url="http://localhost:8081/"; //server
	
	@Override
	public List<Branchdb> getAllBranches() {
		Branchdb list[] = restTemplate.getForObject(url+"getAllBranches", Branchdb[].class);
		return Arrays.asList(list);
	}

	@Override
	public Branchdb getByBranchId(String branchId) {
		return restTemplate.getForObject(url+"getByBranchId/"+branchId, Branchdb.class);
	}
	
	@Override
	public String validateBranchInfo(Branchdb info) {
		String msg = "";
		final String specialChars[] = {"#","@","$","%","&"};
		for(String s: specialChars) {
			if(info.getbLoc().contains(s)) msg += "Branch location should not contain special characters."; break;
		}
		String email[] = info.getEmail().split("@");
		if(!(email.length==2  && email[1].contains("."))) msg += "\nEmail Format: xxx@xxxx.com";
		String pno[] = info.getPno().split("-");
		if(!(pno.length==2 && pno[0].length()==3 && pno[1].length()==7  
			&& NumberUtils.isParsable(pno[0]) && NumberUtils.isParsable(pno[1])	)) msg += "\nPhone Number Format: XXX-XXXXXXX";
		if(msg.equals("")) msg = "Valid Credentials";
		return msg;
	}

	@Override
	public String AddBranch(Branchdb B) {
		return restTemplate.postForObject(url+"AddBranch", B, String.class);
	}

	@Override
	public String DeleteBranch(Branchdb B) {
		restTemplate.delete(url+"DeleteBranch", B);
		return "Branch deleted.";
	}

	@Override
	public List<String> getAllBranchIds() {
		List<String> idList = new ArrayList<String>();
		List<Branchdb> blist;
		try {
			blist = getAllBranches();
			if(blist!=null) {
				for(Branchdb B : blist) {
					idList.add(B.getbranchId().getUserId());
				}
				return idList;
			}
			else {
				throw new Exception();
			}
		}
		catch(Exception E) {
			return null;
		}
	}
	
}
