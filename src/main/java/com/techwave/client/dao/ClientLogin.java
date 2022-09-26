package com.techwave.client.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.techwave.client.model.Logindb;

@Service
public class ClientLogin extends ClientVehicle implements IClientLogin {
	
	@Autowired
	RestTemplate restTemplate;
	public String url="http://localhost:8081/"; //server

	@Override
	public List<Logindb> getAllLogins() {
		Logindb list[] = restTemplate.getForObject(url+"getAllLogins", Logindb[].class);
		return Arrays.asList(list);
	}
	
	@Override
	public Logindb getByLoginId(String loginId) {
		return restTemplate.getForObject(url+"getByLoginId/"+loginId, Logindb.class);
	}

	@Override
	public String AddLogin(Logindb L) {
		return restTemplate.postForObject(url+"AddLogin", L, String.class);
	}
	
	@Override
	public String UpdateLogin(Logindb L, String loginId) {
		restTemplate.put(url+"UpdateLogin/"+loginId, L);
		return "Login updated";
	}
	
	@Override
	public String ApproveLogin(Logindb L, String loginId) {
		restTemplate.put(url+"ApproveLogin/"+loginId, L);
		return "Login approved.";
	}
	
	@Override
	public String RejectLogin(Logindb L, String loginId) {
		restTemplate.put(url+"RejectLogin/"+loginId, L);
		return "Login rejected.";
	}

	@Override
	public String DeleteLogin(Logindb L) {
		restTemplate.delete(url+"DeleteLogin/"+L.getUserId(), L.getUserId());
		return "Login deleted";
	}

	@Override
	public String validateLogin(Logindb L) {
		Logindb login=null;
		login=getByLoginId(L.getUserId());
		if(login==null)
		{
			return "Invalid";
		}
		else
		{
			if(login.getPassword().equals(L.getPassword()))
			{
				return login.getRole();
			}
			else
			{
				return  "Invalid";
			}
		}	
	}
	
	public String getLoginStatus(Logindb L) {
		Logindb login=null;
		login=getByLoginId(L.getUserId());
		if(login==null)
		{
			return "Invalid";
		}
		else
		{
			if(login.getStatus().equals("approved"))
			{
				return login.getStatus();
			}
			else
			{
				return  "Invalid";
			}
		}	
	}
	
	@Override
	public String validateUserRequest(Logindb newUser) {
		final String specialChars[] = {"#","@","$","%","&"};
		final String numbers[] = {"0","1","2","3","4","5","6","7","8","9"};
		int specialCharCount = 0;
		int numberCount = 0;
		//user id
		if(newUser.getUserId().length()<6) {
			return "Error in creating your account. Contact System Administrator";
		}
		for(int i=0; i<specialChars.length; i++) {
			if(newUser.getUserId().contains(specialChars[i])) {
				return "Error in creating your account. Contact System Administrator";
			}
		}
		//password
		if(newUser.getPassword().length()<8 || newUser.getPassword().length()>20) {
			return"Error in creating your account. Contact System Administrator";
		}
		
		for(int i=0; i<specialChars.length; i++) {
			if(newUser.getPassword().contains(specialChars[i])) {
				specialCharCount++;
			}
		}
		if(specialCharCount<1) return "Error in creating your account. Contact System Administrator";
		
		for(int i=0; i<numbers.length; i++) {
			if(newUser.getPassword().contains(numbers[i])) {
				numberCount++;
			}
		}
		if(numberCount<1) return "Error in creating your account. Contact System Administrator";
		newUser.setStatus("pending");
		return AddLogin(newUser);	
	}

	@Override
	public String validateUserStatus(String loginId) {
		Logindb L = getByLoginId(loginId);
		L.setStatus("approved");
		return "User is approved";
	}
}
