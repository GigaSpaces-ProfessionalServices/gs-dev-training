package com.c123.billbuddy.report;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Component;

import com.c123.billbuddy.model.CategoryType;
import com.gigaspaces.async.AsyncFutureListener;
import com.gigaspaces.async.AsyncResult;

/** 
* CountPaymentsByCategoryFinder class. 
* 
* Executing a task which counts the number of payments in a specific category 
*  
* @author 123Completed
*/

@Component
public class CountPaymentsByCategoryFinder {

	private final static Log log = LogFactory.getLog(CountPaymentsByCategoryFinder.class);
	@Resource 
    private GigaSpace gigaSpace;
    
    private String categoryName;
    @PostConstruct
    public void construct() throws Exception {
       
    	CategoryType[] categoryTypes = CategoryType.values();
    	
    	CategoryType categoryType = categoryTypes[(int) ((categoryTypes.length - 1) * Math.random())];
    	
    	log.info("Search for merchants with following category: " + categoryType.name());
    	categoryName = categoryType.name();
        
    	
        gigaSpace.execute(new CountPaymentsByCategoryTask(categoryType)).setListener(new AsyncFutureListener<Long>() {
        	public void onResult(AsyncResult<Long> result) {
        		log.info("Found number of Payments : " + result.getResult() + " for category " + categoryName);
        	}
        });
       
    }
}
