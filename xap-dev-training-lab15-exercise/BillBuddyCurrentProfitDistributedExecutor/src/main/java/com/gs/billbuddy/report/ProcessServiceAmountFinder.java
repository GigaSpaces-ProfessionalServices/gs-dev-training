package com.gs.billbuddy.report;

/** 
* ProcessServiceAmountFinder class. 
* 
* Executing a task which gets all Processing Fee amounts
*  
* @author 123Completed
*/

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Component;

@Component
public class ProcessServiceAmountFinder {

	private final static Log log = LogFactory.getLog(ProcessServiceAmountFinder.class);
    @Resource
	private GigaSpace gigaSpace;
	
    @PostConstruct
    public void construct() throws Exception {
    	Double processingFeeAmount = null;
    	// TODO: execute the task
    	 if(processingFeeAmount > 0.0){
    	    	log.info("Processing Fee Amount is: " + processingFeeAmount);
    	        }else if(processingFeeAmount == 0.0){
    	        	log.info("BillBuddy profit is 0 (ZERO), Please run the PaymentFeeder project.");
    	        }  
    }
}
