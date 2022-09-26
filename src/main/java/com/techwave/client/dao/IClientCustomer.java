package com.techwave.client.dao;

import java.util.List;

import com.techwave.client.model.Customerdb;

public interface IClientCustomer {

	List<Customerdb> getAllCust(); //get
	
	Customerdb getByCustId(String custId); //get
	
	String AddCust(Customerdb C); //post
//	
//	String UpdateCust(Customerdb C); //put
	
	String DeleteCust(Customerdb C); //delete
	
	String validateCustInfo(Customerdb info);
}
