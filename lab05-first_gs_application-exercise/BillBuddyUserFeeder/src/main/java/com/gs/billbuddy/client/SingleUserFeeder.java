package com.gs.billbuddy.client;

import com.gs.billbuddy.model.AccountStatus;
import com.gs.billbuddy.model.User;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

import com.j_spaces.core.IJSpace;

public class SingleUserFeeder {

	public static void main(String[] args) {

		// TODO: initialize SpaceProxyConfigurer
		// TODO: create new GigaSpaceConfigurer
		// TODO: edit the gigaSpace row below.

		// Get a proxy to the space using a configurer
		String spaceName = "BillBuddy-space";
		GigaSpace gigaSpace = null;


    	try {
    		
    		// Write one static user into the space using a GigaSpace space proxy.
    		// It reads users from the space & displays them into the console.
    		System.out.println("Starting User Feeder");
    		    		
    		int useraccountid = 151273;
    		
    		// Create and write a User to the Space    	
        	
    		User user = new User();
        	user.setUserAccountId(useraccountid);
        	user.setBalance(120000.87);
        	user.setCreditLimit(20000.00);
        	user.setName("GigaSpaces");
        	user.setStatus(AccountStatus.BLOCKED);
        	
        	gigaSpace.write(user);
        	
        	// Read a User from the Space       	
        	System.out.println("Reading User from the space per User ID: " + useraccountid);
        	User result = gigaSpace.readById(User.class, useraccountid);
        	
        	System.out.println("User ID: " + result.getUserAccountId());
        	System.out.println("User Name: " + result.getName());
        	System.out.println("User Balance: " + result.getBalance());
        	System.out.println("User Status: " + result.getStatus());
    		
    		  	
    	
    	} catch (Exception ex){
    		System.out.println(ex.getMessage());
    		System.out.println(ex.getStackTrace());
    	}
    	
	}
}
