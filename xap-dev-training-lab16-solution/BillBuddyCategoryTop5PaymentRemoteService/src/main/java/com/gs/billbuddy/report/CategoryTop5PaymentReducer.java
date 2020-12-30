package com.gs.billbuddy.report;

import com.gs.billbuddy.model.Payment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.remoting.RemoteResultReducer;
import org.openspaces.remoting.SpaceRemotingInvocation;
import org.openspaces.remoting.SpaceRemotingResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * CategoryTop5PaymentReducer class.
 * 
 * Reduce the results from findTop10Payments method which executed on top of the
 * space
 * 
 * Returns top 10 Payments
 * 
 * @author gsUniversity
 */

public class CategoryTop5PaymentReducer implements
		RemoteResultReducer<Payment[], Payment[]> {

	private final Log log = LogFactory.getLog(CategoryTop5PaymentReducer.class);

	public Payment[] reduce(SpaceRemotingResult<Payment[]>[] results,
			SpaceRemotingInvocation remotingInvocation) throws Exception {

		log.info("Starting CategoryTop5PaymentFinder");

		List<Payment> payments = new ArrayList<Payment>();

		// Each result is an array of events. Each result is from a single
		// partition.
		for (SpaceRemotingResult<Payment[]> result : results) {
			if (result.getException() != null) {
				// just log the fact that there was an exception
				log.error("Executor Remoting Exception ["
						+ result.getException() + "]");

				continue;
			}
			Collections.addAll(payments, result.getResult());
		}

		Collections.sort(payments, new Comparator<Payment>() {
			public int compare(Payment p1, Payment p2) {
				return p2.getPaymentAmount().compareTo(p1.getPaymentAmount());
			}
		});

		// If the number of results needed is less than the number of events
		// that were reduced, then
		// return a sublist. Otherwise, return the entire list of events.
		
		Payment[] top5Payments;

		if (payments.size() < 5) {
			top5Payments = new Payment[payments.size()];
			top5Payments = payments.toArray(top5Payments);
		} else {
			top5Payments = new Payment[5];
			top5Payments = payments.subList(0,5).toArray(new Payment[5]);
		}
		return top5Payments;

	}
}
