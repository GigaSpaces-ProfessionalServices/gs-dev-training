package com.gs.billbuddy.report;


import java.util.HashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.executor.Task;
import org.openspaces.core.executor.TaskGigaSpace;

import com.gs.billbuddy.model.Payment;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.j_spaces.core.client.SQLQuery;

/** 
* MerchantPaymentsTask class. 
* 
* The task returns Array List of UserIds which have a Payments with specific Merchant ID
* 
*  
* @author 123Completed
*/


@SuppressWarnings("serial")
public class MerchantGetUserIdTask implements Task<HashSet<Integer>> {
   private final static Log log = LogFactory.getLog(MerchantGetUserIdTask.class);
   
      
   private Integer receivingMerchantId;
   
    
    public MerchantGetUserIdTask(Integer receivingMerchantId) {
		this.receivingMerchantId = receivingMerchantId;
	}

    
    @TaskGigaSpace
    private transient GigaSpace gigaSpace;

    public HashSet<Integer> execute() throws Exception {
    	
	    log.info("Search Payments for Merchant ID: " + receivingMerchantId);
	    
	    SQLQuery<Payment> query = new SQLQuery<Payment>(Payment.class, "receivingMerchantId = ? ");
	    query.setParameter(1, receivingMerchantId);
	
	    Payment[] payments = gigaSpace.readMultiple(query, Integer.MAX_VALUE);
	    
	    HashSet<Integer> userIds = new HashSet<Integer>();
	    
	   
	    // Eliminate duplicate UserId
	    if (payments != null){
		    for (int i = 0; i < payments.length; i++) {
		    	userIds.add(payments[i].getPayingAccountId());
			}
	    }
	  
	    return userIds;
    }

    //TODO: Add a routing Method and annotate accordingly

 
}
