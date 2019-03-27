package com.c123.billbuddy.remoting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.openspaces.remoting.RemotingService;

import com.c123.billbuddy.model.CategoryType;
import com.c123.billbuddy.model.Merchant;
import com.c123.billbuddy.model.Payment;
import com.c123.billbuddy.model.User;
import com.j_spaces.core.client.SQLQuery;

/**
 * PaymentService class that implements IPaymentService interface provides 
 * remoting capabilities to the space
 * 
 * @author 123Completed
 */

@RemotingService
public class PaymentService implements IPaymentService {
	
	private final Log log = LogFactory.getLog(PaymentService.class);
	@Resource
	private GigaSpace gigaSpace;
	
	public Payment[] findTop5PaymentsPerCategory(CategoryType categoryType) {
		log.info("Find Top 5 Payments Per Category");
		List<Payment> allPayments = new ArrayList<Payment>();
		
	    // Search the space for all Merchant per selected category - prepare the query template
	    
	    Merchant merchantTemplate = new Merchant();
	    merchantTemplate.setCategory(categoryType);
	    
	    // Execute Merchant query to the space
	    
	    Merchant[] merchantList = gigaSpace.readMultiple(merchantTemplate, Integer.MAX_VALUE);

	    // In case Merchant query result set has more then one Merchant
	    
	    if (merchantList.length > 0){
	    	
	    	SQLQuery<Payment> paymentQuery;
	    	log.info("Number of merchants found: " + merchantList.length + " for category: " + categoryType);
	    	
	    	// Loop thru the list of Merchants
	    	
	    	for (Merchant merchant : merchantList) {
			
	    		// Prepare Payment query to get top 5 payments per merchant
	
				paymentQuery = new SQLQuery<Payment>(Payment.class,
						"receivingMerchantId=? order by paymentAmount desc");
				paymentQuery.setParameter(1, merchant.getMerchantAccountId());
				Payment[] payments = gigaSpace.readMultiple(paymentQuery, 5);
				
				// Add top 5 payments to the summary collection of all top payments

				Collections.addAll(allPayments, payments);
	    	}
	    }

	 // Sort the entire payments results by payment amount from largest to smallest
	    
	    if (allPayments.size() > 0 ) {
			Collections.sort(allPayments, new Comparator<Payment>() {
				public int compare(Payment p1, Payment p2) {
					return p2.getPaymentAmount().compareTo(p1.getPaymentAmount());
				}
			});
	    }
	    
		// return only top 5 payments for the requested category
		
		Payment[] top5Payments;

		if (allPayments.size() < 5) {
			top5Payments = new Payment[allPayments.size()];
			top5Payments = allPayments.toArray(top5Payments);
		} else {
			top5Payments = new Payment[5];
			top5Payments = allPayments.subList(0,5).toArray(new Payment[5]);
		}
		
		
		log.info("Found: " + top5Payments.length + " payments for category: " + categoryType);
		User[] userList = gigaSpace.readMultiple(new User(), Integer.MAX_VALUE);
		log.info("Found: " + userList.length + " users ");

		return top5Payments;
	}

}
