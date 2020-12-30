package com.gs.billbuddy.client;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.openspaces.core.GigaSpace;

import com.gs.billbuddy.model.CategoryType;
import com.gs.billbuddy.model.Contract;
import com.gs.billbuddy.model.Merchant;

/** 
 * Merchant Feeder class gets merchant name list which is stored in DataUtils class. 
 * The class performing loop on the list and create user class and write it into space
 * 
 * The Class also enables creating one static user & write into the space
 * 
 * @author gsUniversity
 */


public class MerchantFeeder {

	@SuppressWarnings("serial")
	private static final ArrayList<String> merchants=new ArrayList<String>(){{
	    add("Like Pace"); add("Konegsad"); add("SomeDisk"); add("Swakowsky"); 
	    add("Green Head band"); add("Shiruckou"); add("Eagle"); add("Lohitech"); 
	    add("The musicals"); add("SoccerMaster"); add("Fort"); add("2-Times"); 
	    add("Mazalaty"); add("jewelry 4 U"); add("Gems"); add("Hautika"); 

	}};
	
	public MerchantFeeder(){
	}
	
	// Method loads a list of merchants from the DataUtil class that serves as a user repository.
	// It then writes them into the space using a GigaSpace space proxy.
	// It reads users from the space & displays them into the console.
	public static void loadData(GigaSpace gigaSpace) throws Exception {
		System.out.println("Starting Merchant Feeder");
		System.out.println("Method: loadData - loads all merchants into the space");
		
        // merchantAccountId will serve as the Unique Identifier value
        
		Integer merchantAccountId = 1;
		Merchant foundMerchant=null;
        
        CategoryType[] categoryTypes = CategoryType.values();        

        // for each merchant in the merchantList do:
        
        for (String merchantName : MerchantFeeder.merchants) {
        	
        	// TODO: Check the merchant does not exist in the space already by trying to read it
            
        	
        	// TODO: If Merchant was not found then create the Merchant and write it to the space
        	
        	if (foundMerchant == null) {
            	
        		Merchant merchant = new Merchant();
            	
                // TODO: Select Random Category

                // TODO: Write the Merchant to the space
            	
        		System.out.println("Added Merchant object with name: " + merchant.getName());
        		
        		createMerchantContract(merchant.getMerchantAccountId(),gigaSpace);
            }
            
            merchantAccountId++;
        }
        	
        System.out.println("Stopping Merchant Feeder");
    }
	
    /** 
     * Creates SpaceDocument with the terms between Merchant and BillBuddy 
     */ 
    private static void createMerchantContract(Integer merchantId, GigaSpace gigaSpace) {
    	
    	Calendar calendar = Calendar.getInstance();
    	Contract contract = new Contract();
		
		// TODO 1. Fill Contract details
		double randomTransactionFee = Double.parseDouble(new DecimalFormat("#.##").format(Math.random()/10 + 0.01));  
		       
        // TODO 2. Write the document to the space using gigaSpace
        
		
        System.out.println(String.format("Added MerchantContract object with id '%s' with transaction fee of %.2f%n", contract.getId(), contract.getTransactionPrecentFee()));
		
	}

}
