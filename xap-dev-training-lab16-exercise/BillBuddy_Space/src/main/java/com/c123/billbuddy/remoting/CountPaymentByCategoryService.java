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
	

	public int findPaymentCountByCategory(CategoryType categoryType) {
		log.info("Start findPaymentCountByCategory service");
	    int paymentCount=0;
	    
		  //TODO: query for the Payment count, how many payments were made under a specific category
		  //HINT: find relevant Merchants in a specific category and then find a count of all their individual payments. 
		  // Summarize them all into one single count.
	    
	    
	    log.info("findPaymentCountByCategory - End Execute.");
	    return paymentCount;
	}
}
