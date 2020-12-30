package com.gs.billbuddy.report;


import java.util.HashSet;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Component;

import com.gs.billbuddy.model.Merchant;
import com.gigaspaces.async.AsyncFuture;

/** 
* MerchantPaymentsFinder class. 
* 
* Reads MerchantsID Randomly and execute a Task from specific cluster member  
* which returned all user id's which have payments
* 
*  
* @author gsUniversity
*/

@Component
public class MerchantGetUserIdFinder {

	private final static Log log = LogFactory.getLog(MerchantGetUserIdFinder.class);
	@Resource 
    private GigaSpace gigaSpace;
    
    @PostConstruct
    public void construct() throws Exception {
       
    	 int merchantCount = gigaSpace.count(new Merchant());
         if (merchantCount == 0) {
             log.info("Could not find users, did you write any?");
         }
         else {
         	Random random = new Random();
         	int merchantId = (int)(merchantCount * random.nextDouble());
         	
         	Merchant merchant = gigaSpace.readById(Merchant.class, new Integer(merchantId));
         	if (merchant == null) {
         		
         	}
         	else {
	         	AsyncFuture<HashSet<Integer>> future = gigaSpace.execute(new MerchantGetUserIdTask(merchant.getMerchantAccountId()));
	         	HashSet<Integer> userIds = future.get();
	         	if(userIds.size() == 0){
	         		log.info("No user IDs were found for Merchant ID: '"+merchantId+"', Please re-run the MerchantGetUserId project.");
	         	}else if(userIds.size() > 0){
	         		log.info("Users for Merchant ID " + merchant.getMerchantAccountId() + " name " + merchant.getName());
		            for (Integer userId : userIds) {
		                log.info("User Id is: " + userId);
		            }
	         	}
         	}
         }
      }
}
