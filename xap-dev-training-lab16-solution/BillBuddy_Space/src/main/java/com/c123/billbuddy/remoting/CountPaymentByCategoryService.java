package com.c123.billbuddy.remoting;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.openspaces.remoting.RemotingService;

import com.c123.billbuddy.model.CategoryType;
import com.c123.billbuddy.model.Merchant;
import com.c123.billbuddy.model.Payment;

/** 
* CountPaymentByCategoryService class implements ICountPaymentByCategoryService interface for remoting capabilities 
* to the space for counting payments.
* 
* @author 123Completed
*/

@RemotingService
public class CountPaymentByCategoryService implements ICountPaymentsByCategoryService {
	private final Log log = LogFactory.getLog(CountPaymentByCategoryService.class);
	@Resource
	private GigaSpace gigaSpace;
	

	@Override
	public int findPaymentCountByCategory(CategoryType categoryType) {
		log.info("Start findPaymentCountByCategory service");
	    int paymentCount=0;
	    
	    // Search the space for all Merchant per selected category - prepare the query template 
	    
	    Merchant merchantTemplate = new Merchant();
	    merchantTemplate.setCategory(categoryType);
	
	    // Execute Merchant query to the space
	    
	    Merchant[] merchantList = gigaSpace.readMultiple(merchantTemplate, Integer.MAX_VALUE);
	    
	    // In case Merchant query result set has more then one Merchant
	    
	    if (merchantList.length > 0){
	    	
	    	Payment paymentTemplate;
	    	log.info("Number of merchants found: " + merchantList.length + " for category: " + categoryType);
	    	
	    	// Loop thru the list of Merchants
	    	
	    	for (Merchant merchant : merchantList) {
			
	    		// Prepare Payment query template to count number of Payments per each merchant
		    	
			    paymentTemplate = new Payment();
			    paymentTemplate.setReceivingMerchantId(merchant.getMerchantAccountId());
			    
			    // Execute query to count number of Payments per Merchant
			    
			    paymentCount += gigaSpace.count(paymentTemplate);
	    	}

	    	log.info("Number of payments found: " + paymentCount + " for category: " + categoryType);
	    } else {
	    	log.info("No Merchants found for category: " + categoryType + " !!");
	    }
	    
	    log.info("findPaymentCountByCategory - End Execute.");
	    return paymentCount;
	}
}
