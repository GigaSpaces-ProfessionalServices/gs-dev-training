package com.c123.billbuddy.client;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;

import org.springframework.stereotype.Component;

import com.c123.billbuddy.model.AccountStatus;
import com.c123.billbuddy.model.Merchant;
import com.c123.billbuddy.model.Payment;
import com.c123.billbuddy.model.TransactionStatus;
import com.c123.billbuddy.model.User;
@Component
@SuppressWarnings("unused")
public class PaymentFeeder  {
	@Resource
    private GigaSpace gigaSpace;

    private final Log log = LogFactory.getLog(PaymentFeederGenerator.class);
    private int userCount = 0;
    private int merchantCount = 0;
    private User user;
    private Merchant merchant;

    @PostConstruct
    public void construct() throws Exception {
        log.info("Starting PaymentWriter");

        //TODO: get the number of users from the space and keep that value
        //      You will require this value for Randomly choosing a User later (use userCount property)

        

        //TODO: get the number of merchants from the space and keep that value
        //      You will require this value for Randomly choosing a User later (use merchantCount property)

       
    }
    

    public void createPayment() {
	
    	Random random = new Random();
    	
    	int userId = (int)(userCount * random.nextDouble());
        //TODO: read a random user

    	
    	int merchantId = (int)(merchantCount * random.nextDouble());
    	//TODO: read a random merchant

    	
    	if (user != null && merchant != null) {
            Calendar calendar = Calendar.getInstance();
        	calendar.setTimeInMillis(System.currentTimeMillis());
        	Date date = calendar.getTime();
        	
        	
        	Double paymentAmount = Double.valueOf(Math.random()*100);
        	paymentAmount = Math.round(paymentAmount*100.0)/100.0;
        	
        	// Check If user valid and have credit limit (if not add money to users balance and update the user
        	if (user.getStatus() != AccountStatus.ACTIVE){
        		log.info("User: " + user.getName() + " status is " + user.getStatus());
        	}
        	else if (user.getBalance() - paymentAmount < user.getCreditLimit()){
        		log.info("User: " + user.getName() + " doesn't have credit.");
        		// TODO: Add Random amount of money to user's balance so user will be able to continue paying for stuff
        		// TODO: write the user to the space
            	
        	}
        	else { 
        		
        		 // Withdraw payment amount from user account
                updateUserBalance(user, paymentAmount);

                // Deposit payment amount to merchant account                     
                updateMerchantReceipts(merchant, paymentAmount);
                
                // Create a Payment POJO and set it up.  
        		Payment payment = new Payment();
                
                payment.setPayingAccountId(user.getUserAccountId());
                payment.setReceivingMerchantId(merchant.getMerchantAccountId());
                payment.setDescription(merchant.getCategory().name());
                payment.setCreatedDate(date);
                payment.setPaymentAmount(Math.round(paymentAmount*100.0)/100.0);
                payment.setStatus(TransactionStatus.NEW);
                
                // TODO: Write the payment object
                                
                log.info("TransactionWriterTask wrote new transaction between user: " + user.getName() + 
                		" and merchant: " + merchant.getName());
        	}
        	}		
	}

	private void updateUserBalance(User user, Double paymentAmount) {
    	log.info("TransactionWriterTask withdraw " + paymentAmount + 
    			" from user: " + user.getName());
    	
    	//TODO: Subtract paymentAmount from user balance and save using write API
    	
	
    }
    
    private void updateMerchantReceipts(Merchant merchant, Double paymentAmount) {
    	log.info("TransactionWriterTask deposit " + paymentAmount + 
    			" to merchant: " + merchant.getName());
    	
    	//TODO: Add paymentAmount to Merchant receipts and save using write API
    	    	
	
    }
}

