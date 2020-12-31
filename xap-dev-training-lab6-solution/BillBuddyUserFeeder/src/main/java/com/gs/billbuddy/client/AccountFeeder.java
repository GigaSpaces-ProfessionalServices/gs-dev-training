package com.gs.billbuddy.client;

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
		String spaceName = "BillBuddy-space";
		GigaSpace gigaSpace = new GigaSpaceConfigurer(new SpaceProxyConfigurer(spaceName)).create();
    	
    	try {
    		
    		// Write users into the space 
    		
    		UserFeeder.loadData(gigaSpace);
    	
    	} catch (Exception ex){
    		ex.printStackTrace();
    	}
    	
	}

}
