package com.gs.billbuddy.client;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.springframework.stereotype.Component;

import com.gs.billbuddy.model.Merchant;
import com.gs.billbuddy.model.Payment;

@Component
@SuppressWarnings({"unused" ,"null"})
public class MerchantsOfTop5Payments {
	private final Log log = LogFactory.getLog(MerchantsOfTop5Payments.class);
	
	@Resource
	private GigaSpace gigaSpace;

	
	@PostConstruct
	public void init() {
		Payment[] payments = null;
		Merchant merchant = null;
		
		//TODO: use query to retrieve top 5 Payments from the space
		//TODO: HINT - 'order by ATTRIBUTE desc'

		int order = 0;
		for (Payment p : payments) {
			
			//TODO: retrieve the payment associated Merchant to display its details.
			//TODO: HINT - space.readById(clazz,id)
			
			if (merchant != null) {
				log.info((order++)+": Merchant "+merchant.getName()+", payment: "+ p.getPaymentAmount());
			}
		}
	}
}
