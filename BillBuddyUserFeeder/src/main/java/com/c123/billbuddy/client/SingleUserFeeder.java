package com.c123.billbuddy.client;

import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

import com.c123.billbuddy.model.AccountStatus;
import com.c123.billbuddy.model.User;
import com.j_spaces.core.IJSpace;

public class SingleUserFeeder {

	public static void main(String[] args) {

		// Get a proxy to the space using a configurer
		
		String lookupGroups = System.getenv("XAP_LOOKUP_GROUPS");
		SpaceProxyConfigurer spaceConfigurer = null;
		// TODO: initialize spaceConfigurer - create new SpaceProxyConfigurer with the proper the space name in our exercise is BillBuddy-space edit the row below.

		spaceConfigurer.lookupGroups(lookupGroups);
      	IJSpace space = spaceConfigurer.space();
    	GigaSpace gigaSpace = new GigaSpaceConfigurer(space).gigaSpace();
    	

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
