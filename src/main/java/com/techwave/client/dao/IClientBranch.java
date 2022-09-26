package com.techwave.client.dao;

import java.util.List;

import com.techwave.client.model.Branchdb;
import com.techwave.client.model.Logindb;

public interface IClientBranch {
	
	List<Branchdb> getAllBranches(); //get
	
	Branchdb getByBranchId(String branchId); //get
	
	String AddBranch(Branchdb B); //post
	
//	String UpdateBranch(Branchdb B); //put
	
	String DeleteBranch(Branchdb B); //delete
	
	//Branchdb newBranch();
	
	String validateBranchInfo(Branchdb info);
	
	List<String> getAllBranchIds();
}
