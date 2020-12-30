package com.gs.billbuddy.remoting;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.openspaces.remoting.RemotingService;

import com.gs.billbuddy.model.CategoryType;
import com.gs.billbuddy.model.Merchant;
import com.gs.billbuddy.model.Payment;

/** 
* CountPaymentByCategoryService class implements ICountPaymentByCategoryService interface for remoting capabilities 
* to the space for counting payments.
* 
* @author gsUniversity
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
