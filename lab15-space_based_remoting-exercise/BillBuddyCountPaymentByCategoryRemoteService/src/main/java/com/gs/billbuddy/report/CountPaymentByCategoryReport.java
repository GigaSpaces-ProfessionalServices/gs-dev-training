package com.gs.billbuddy.report;


import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.remoting.ExecutorProxy;
import org.springframework.stereotype.Component;

import com.gs.billbuddy.model.CategoryType;
import com.gs.billbuddy.remoting.ICountPaymentsByCategoryService;

/** 
* CountPaymentByCategoryReport class. 
*  
* Execute findPaymentCountByCategory method remoting to the space
*  
* 
* @author gsUniversity
*/

@Component
public class CountPaymentByCategoryReport {
    private final Log log = LogFactory.getLog(CountPaymentByCategoryReport.class);
    
    //TODO Annotate the remote proxy - @ExecutorProxy with all relevant attributes

    private ICountPaymentsByCategoryService iCategoryTransactionVolumeService;

    @PostConstruct
    public void construct() throws Exception {
    	log.info("Starting CountPaymentByCategoryReport");
    	int result=0;	
    	    	
    	CategoryType[] categoryTypes = CategoryType.values();
    	CategoryType categoryType = categoryTypes[(int) ((categoryTypes.length - 1) * Math.random())];
    	log.info("Search for Payment Count for the following category: " + categoryType.name());
    	
    	//TODO: use the remote service to retrieve Payment count in a specific Category

    	log.info("Payment Count for the following category: " + categoryType.name() + " is: " + result);
    	
    	log.info("Finished CountPaymentByCategoryReport");
    }
}
