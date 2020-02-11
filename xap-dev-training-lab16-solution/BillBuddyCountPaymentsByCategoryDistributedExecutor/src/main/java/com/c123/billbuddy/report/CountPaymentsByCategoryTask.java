package com.c123.billbuddy.report;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.executor.DistributedTask;
import org.openspaces.core.executor.TaskGigaSpace;

import com.c123.billbuddy.model.CategoryType;
import com.c123.billbuddy.model.Merchant;
import com.c123.billbuddy.model.Payment;
import com.gigaspaces.async.AsyncResult;

/** 
* CountPaymentsByCategoryTask class. 
* 
* The task return the count of all payments in a specific Category (the task parameter)
* Task iterates through all merchants in a specific category and counts how many payments for each merchant  
*  
* @author 123Completed
*/

@SuppressWarnings("serial")
public class CountPaymentsByCategoryTask implements DistributedTask<Integer,Long> {
   private final static Log log = LogFactory.getLog(CountPaymentsByCategoryTask.class);
    
    private CategoryType categoryType;
   
    public CountPaymentsByCategoryTask(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

    @TaskGigaSpace
    private transient GigaSpace gigaSpace;

    public Integer execute() throws Exception {
    	log.info("CountPaymentsByCategoryTask - Start Execute.");
	    log.info("Search Payments Count with category: " + categoryType);
	    
	    int paymentCount=0;
	    
	    // Search the space for all Merchant per selected category - prepare the query

	    Merchant merchantTemplate = new Merchant();
	    merchantTemplate.setCategory(categoryType);
	
	    // Execute Merchant query to the space
	    
	    Merchant[] merchantList = gigaSpace.readMultiple(merchantTemplate, Integer.MAX_VALUE);
	    
	    // In case Merchant query result set has more then one Merchant
	    
	    if (merchantList.length > 0){
	    	
	    	
	    	log.info("Number of merchantList found: " + merchantList.length + " for category: " + categoryType);
	    	
	    	// Loop thru the list of Merchants
	    	
	    	for (Merchant merchant : merchantList) {
			
	    		// Prepare Payment query to count number of Payments per each merchant
		    	
			    Payment paymentTemplate = new Payment();
			    paymentTemplate.setReceivingMerchantId(merchant.getMerchantAccountId());
			    
			    // Execute query to count number of Payments per Merchant
			    
			    paymentCount += gigaSpace.count(paymentTemplate);
	    	}

	    	log.info("Number of Payments found: " + paymentCount + " for category: " + categoryType);
	    } else {
	    	log.info("No Merchants found for category: " + categoryType + " !!");
	    }
	    
	    log.info("CountPaymentsByCategoryTask- End Execute.");
	    return paymentCount;
    }
    
    public Long reduce(List<AsyncResult<Integer>> results) throws Exception {
    	log.info("CountPaymentsByCategoryTask- Start Reduce.");
    	long paymentCountPerCategoryInSpace = 0;

    	// Loop thru all the list of results returning from the different partitions
    	
        for (AsyncResult<Integer> result : results) {
            if (result.getException() != null) {
                throw result.getException();
            }

            // Sum all transaction retrieved per partition to a single count
            
            paymentCountPerCategoryInSpace+= result.getResult();
        }
        if(paymentCountPerCategoryInSpace == 0){
        	log.info("No Payments were found for category "+categoryType+" PLease re-run CountPaymentsByCategoryTask project to select random category.");
        }
        log.info("CountPaymentsByCategoryTask- End Reduce.");
        return paymentCountPerCategoryInSpace;
      }

}
