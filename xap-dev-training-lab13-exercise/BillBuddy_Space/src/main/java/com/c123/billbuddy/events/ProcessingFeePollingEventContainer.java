package com.c123.billbuddy.events;


import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.openspaces.events.*;
import org.openspaces.events.polling.Polling;
import org.springframework.beans.factory.annotation.Qualifier;

import com.c123.billbuddy.model.Contract;
import com.c123.billbuddy.model.Merchant;
import com.c123.billbuddy.model.Payment;
import com.c123.billbuddy.model.ProcessingFee;
import com.c123.billbuddy.model.TransactionStatus;

/** 
 * ProcessingFeePollingEventContainer class. 
 *  
 * ProcessingFeePolling starts when a Payment with Transaction status AUDIT written into space.
 * SpaceDataEvent reads Merchant by Id, Contract Document and executing Processing Fee 
 * transaction between Merchant and BillBuddy 
 * 
 * @author 123Completed
 */

//1. TODO: Do not forget to annotate your Event Container

public class ProcessingFeePollingEventContainer {
    private final Log log = LogFactory.getLog(ProcessingFeePollingEventContainer.class);
    
    @Resource
	private GigaSpace gigaSpace;
	
    	
// 2. TODO: Create the Event Template method and annotate support for event template. 
// the polling container should listen to all Payments with status AUDITED. 
// see TransactionStatus Enum in BillBuddyModel project
 
// 3. TODO: annotate support for space data event
    public Payment processPayments(Payment payment) {
        Merchant merchant = null;
        Contract contract = null;
    
    // 3.1 TODO: Read Merchant that got the payment
    // 3.2 TODO: Read the Merchant contract using projection API. Read only the transactionPercentFee property 

	// Calculate the ProcessingFeeAmoun see the contract variable make sure you initialize it with the Contract document (See 2.2)
		Double transactionFeeAmount = contract.getTransactionPrecentFee() * payment.getPaymentAmount();
	// Create a ProcesingFee Instance and set it up (See Fee Processing)
    	ProcessingFee processingFee = new ProcessingFee();
	  
	    processingFee.setDescription(payment.getDescription());
	    processingFee.setDependentPaymentId(payment.getPaymentId());
	    processingFee.setPayingAccountId(merchant.getMerchantAccountId());
	    
	    processingFee.setAmount(transactionFeeAmount);
	    
	    Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
	    processingFee.setCreatedDate(calendar.getTime());
	    
	    processingFee.setStatus(TransactionStatus.PROCESSED);

    // 3.3 TODO: Update the Merchant: add the "processing Fee" to the merchant's "feeAmount"
	// 3.4 TODO: Write Merchant 
	// 3.5 TODO: Write Processing Fee
	// 3.6 TODO: set the status of Payment to 'PROCESSED'
	 
	    return payment;
    }
}
