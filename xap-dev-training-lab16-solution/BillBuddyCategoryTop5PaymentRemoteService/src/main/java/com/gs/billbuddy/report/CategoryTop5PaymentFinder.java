package com.gs.billbuddy.report;


import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.remoting.ExecutorProxy;
import org.springframework.stereotype.Component;

import com.gs.billbuddy.model.CategoryType;
import com.gs.billbuddy.model.Payment;
import com.gs.billbuddy.remoting.IPaymentService;

/** 
* CategoryTop5PaymentFinder class. 
*  
* Execute findTop10Payments method remoting on top of the space
*  
* 
* @author gsUniversity
*/

@Component
public class CategoryTop5PaymentFinder {
    private final Log log = LogFactory.getLog(CategoryTop5PaymentFinder.class);

    @ExecutorProxy(gigaSpace="gigaSpace",
    	    broadcast=true,
    	    remoteResultReducerType=CategoryTop5PaymentReducer.class)
    private IPaymentService iPaymentService;

    @PostConstruct
    public void construct() throws Exception {
    	log.info("Starting CategoryTop5PaymentFinder");
    	
    	// Choose a Random Category 
    	
    	CategoryType[] categoryTypes = CategoryType.values();
    	
    	CategoryType categoryType = categoryTypes[(int) ((categoryTypes.length - 1) * Math.random())];
    	log.info("Find Top 5 Payments per category:" + categoryType);
    	
    	// Execute space base remoting API for retrieving Top 5 Payments per category 
    	
    	Payment[] payments = iPaymentService.findTop5PaymentsPerCategory(categoryType);
    	
    	if (payments!=null){
	    	for (Payment payment: payments){
	    		log.info("Payment Id: " + payment.getPaymentId() + " Payment Amount: " + payment.getPaymentAmount());
	    	}
    	}
    	log.info("Finished CategoryTop5PaymentFinder");
    }
}
