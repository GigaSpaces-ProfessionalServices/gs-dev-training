package com.c123.billbuddy.client;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Component;

import com.c123.billbuddy.model.Merchant;
import com.c123.billbuddy.model.Payment;
import com.j_spaces.core.client.SQLQuery;

@Component
public class MerchantsOfTop5Payments {
	private final Log log = LogFactory.getLog(MerchantsOfTop5Payments.class);
	@Resource
	private GigaSpace gigaSpace;

	@PostConstruct
	public void init() {
		SQLQuery<Payment> query = new SQLQuery<Payment>(Payment.class,
				"ORDER BY paymentAmount DESC");

		Payment[] payments = gigaSpace.readMultiple(query, 5);
		int order = 0;
		for (Payment p : payments) {
			Merchant merchant = gigaSpace.readById(Merchant.class,
					p.getReceivingMerchantId());
			if (merchant != null) {
				log.info((order++)+": Merchant "+merchant.getName()+", payment: "+ p.getPaymentAmount());
			}
		}
	}
}
