package com.c123.billbuddy.remoting;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.openspaces.remoting.RemotingService;

import com.c123.billbuddy.model.Merchant;

/**
 * ServiceFinder class.
 * 
 * Implements IServiceFinder interface remoting capabilities on top of the space
 * 
 * @author 123Completed
 */

@RemotingService
public class MerchantProfitService implements IMerchantProfitService {
	private final Log log = LogFactory.getLog(MerchantProfitService.class);
	@Resource
	private GigaSpace gigaSpace;

	@Override
	public Double getMerchantProfit(Integer merchantAccountId) {
		log.info("Start Merchant Profit service ");

		Double merchantProfit = 0d;
		Merchant merchant = gigaSpace.readById(Merchant.class, new Integer(
				merchantAccountId));
		if (merchant != null) {
			merchantProfit = merchant.getReceipts() - merchant.getFeeAmount();
			log.info("Profit for " + merchant.getName() + " is: "
					+ merchantProfit + "");
		}
		log.info("Finish Merchant Profit service for " + merchant.getName()
				+ "...");

		return merchantProfit;
	}

}
