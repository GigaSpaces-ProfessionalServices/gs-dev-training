package com.c123.billbuddy.client;

import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

import com.j_spaces.core.IJSpace;


/** 
 * UserFeederActivator class create a standalone proxy connection to the space using configurer.
 * The class then activates the UserFeeder to write all user into the space.
 * @author 123Completed
 */

public class AccountFeeder {

	public static void main(String[] args) {
    	
		// Get a proxy to the space using a configurer
		
		String lookupGroups = System.getenv("XAP_LOOKUP_GROUPS");
		SpaceProxyConfigurer spaceConfigurer = new SpaceProxyConfigurer("BillBuddy-space");
		spaceConfigurer.lookupGroups(lookupGroups);
	  	IJSpace space = spaceConfigurer.space();
	  	
	  	// Create a space proxy
	  	
	  	GigaSpace gigaSpace = new GigaSpaceConfigurer(space).gigaSpace();
    	
    	try {
    		
    		// Write users into the space 
    		
    		UserFeeder.loadData(gigaSpace);
    	
    	} catch (Exception ex){
    		ex.printStackTrace();
    	}
    	
	}

}
