package com.gs.billbuddy.report;


import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.openspaces.remoting.ExecutorProxy;
import org.springframework.stereotype.Component;

import com.gs.billbuddy.model.Merchant;
import com.gs.billbuddy.remoting.IMerchantProfitService;

/**
 * Top5MerchantFeeAmountFinder class.
 *
 * Execute findTop5MerchantFeeAmount method remoting on top of the space
 *
 *
 * @author gsUniversity
 */

@Component
public class MerchantProfitReport {
    private final Log log = LogFactory.getLog(MerchantProfitReport.class);

    @Resource
    private GigaSpace gigaSpace;

    @ExecutorProxy
    private IMerchantProfitService iMerchantProfitService;

    @PostConstruct
    public void construct() throws Exception {
        log.info("Starting Merchant Profit Report");

        Double merchantProfit = 0d;
        Random random = new Random();

        Integer merchantCount = gigaSpace.count(new Merchant());
        if (merchantCount == 0) {
            log.info("Could not find merchants, did you write any?");
            System.exit(-1);
        }
        int merchantId = (int)(merchantCount * random.nextDouble());
        Merchant merchant = gigaSpace.readById(Merchant.class, new Integer(merchantId));

        if (merchant != null) {
            merchantProfit = iMerchantProfitService.getMerchantProfit(merchant.getMerchantAccountId());
            log.info("Merchant Name: " + merchant.getName() + " Profit Amount is: " + merchantProfit);
        }

        log.info("Finished Merchant Profit Report");
    }
}
