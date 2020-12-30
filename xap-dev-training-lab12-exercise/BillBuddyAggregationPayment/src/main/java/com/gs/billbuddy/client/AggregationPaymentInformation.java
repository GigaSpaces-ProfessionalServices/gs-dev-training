package com.gs.billbuddy.client;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Component;

import com.gs.billbuddy.model.Payment;
import com.j_spaces.core.client.SQLQuery;
import static org.openspaces.extensions.QueryExtension.*;

@Component
public class AggregationPaymentInformation {
	private final Log log = LogFactory.getLog(AggregationPaymentInformation.class);
	@Resource
	private GigaSpace gigaSpace;

	@PostConstruct
	public void init() {
		
		//TODO: 1. Create SQL query to retrieve all payments
		

		//TODO: 2. Use aggregation to retrieve the maximum payment
		// retrieve the maximum value stored in the field "paymentAmount"
		Number maxPayment=0; 
		
		//TODO: 3. Use aggregation to retrieve the minimum payment
		/// retrieve the minimum value stored in the field "paymentAmount"
		Number minPayment=0;
		
		//TODO: 4. Use aggregation to retrieve the sum of all payment
		// Sum the "paymentAmount" field on all Payment objects.
		Number sumPayment=0;
		
		//TODO: 5. Use aggregation to retrieve the average of all payment
		// Sum's the "paymentAmount" field on all Payment objects then divides by the number of Payment objects.
		Double averagePayment=0d;
		
		//TODO: 6. Use aggregation to retrieve the Payment object with maximum paymentAmount value.
		// Retrieve the Payment object with the highest value for the field "paymentAmount".
		Payment paymentWithMaxAmount=null;
		
		//TODO: 7. Use aggregation to retrieve the Payment object with minimum paymentAmount value.
		// Retrieve the Payment object with the lowest value for the field "paymentAmount".
		Payment paymentWithMinAmount=null;
		
		log.info("Max payment is: "+ maxPayment.doubleValue() + " Payment was made at:" + paymentWithMaxAmount.getCreatedDate());
		log.info("Min payment is: "+ minPayment.doubleValue() + " Payment was made at:" + paymentWithMinAmount.getCreatedDate());
		log.info("Sum of all payments is: "+ sumPayment.doubleValue());
		log.info("Avarage of all payments is: "+ averagePayment.doubleValue());

	}
}
