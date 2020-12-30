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

		SQLQuery<Payment> query = new SQLQuery<Payment>(Payment.class,"");

		// retrieve the maximum value stored in the field "paymentAmount"
		Number maxPayment = max(gigaSpace, query, "paymentAmount");
		/// retrieve the minimum value stored in the field "paymentAmount"
		Number minPayment = min(gigaSpace, query, "paymentAmount");
		// Sum the "paymentAmount" field on all Payment objects.
		Number sumPayment = sum(gigaSpace, query, "paymentAmount");
		// Sum's the "paymentAmount" field on all Payment objects then divides by the number of Payment objects.
		Double averagePayment = average(gigaSpace, query, "paymentAmount");
		// Retrieve the Payment object with the highest value for the field "paymentAmount".
		Payment paymentWithMaxAmount = maxEntry(gigaSpace, query, "paymentAmount");
		/// Retrieve the Payment object with the lowest value for the field "paymentAmount".
		Payment paymentWithMinAmount = minEntry(gigaSpace, query, "paymentAmount");

		log.info("Max payment is: "+ maxPayment.doubleValue() + " Payment was made at:" + paymentWithMaxAmount.getCreatedDate());
		log.info("Min payment is: "+ minPayment.doubleValue() + " Payment was made at:" + paymentWithMinAmount.getCreatedDate());
		log.info("Sum of all payments is: "+ sumPayment.doubleValue());
		log.info("Average of all payments is: "+ averagePayment.doubleValue());

	}
}
