package com.gs.billbuddy.client;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.SpaceInterruptedException;
import org.springframework.stereotype.Component;
import com.gs.billbuddy.model.AccountStatus;
import com.gs.billbuddy.model.Merchant;
import com.gs.billbuddy.model.Payment;
import com.gs.billbuddy.model.TransactionStatus;
import com.gs.billbuddy.model.User;

@Component
public class LeasePaymentFeeder {
	private final Log log = LogFactory.getLog(LeasePaymentFeeder.class);
	private long defaultDelay = 5000;

	private static final int NUMBER_OF_PAYMENTS = 5;

	@Resource
	private GigaSpace gigaSpace;

	private User[] users;

	private Merchant[] merchants;

	@PostConstruct
	public void construct() throws Exception {
		log.info("Starting PaymentWriter");

		// Read users
		users = gigaSpace.readMultiple(new User(), Integer.MAX_VALUE);
		if ((users == null) || (users.length == 0)) {
			log.info("Could not find users, did you write any?");
			System.exit(-1);
		}
		// Read Merchants
		merchants = gigaSpace.readMultiple(new Merchant(), Integer.MAX_VALUE);
		if ((merchants == null) || (merchants.length == 0)) {
			log.info("Could not find merchants, did you write any?");
			System.exit(-1);
		}

       Thread t = new Thread(new PaymentCreatorExecuter());
        t.start();
	}

	@PreDestroy
	public void destroy() throws Exception {
		log.info("Stopping PaymentWriter");

	}

	public void create5Payments() {
		try {
			Payment[] payments = new Payment[NUMBER_OF_PAYMENTS];
			
			// Create 5 payments
			for (int i = 0; i < NUMBER_OF_PAYMENTS; i++) {

				// Pick a random user
				User user = ((users != null) && (users.length > 0)) ? users[(int) ((users.length - 1) * Math
						.random())] : null;

				// Pick a random merchant
				Merchant merchant = ((merchants != null) && (merchants.length > 0)) ? merchants[(int) ((merchants.length - 1) * Math
						.random())] : null;

				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				Date date = calendar.getTime();

				Double paymentAmount = Double.valueOf(Math.random() * 100);
				paymentAmount = Math.round(paymentAmount * 100.0) / 100.0;

				// Check If user valid and have credit limit
				if (user.getStatus() != AccountStatus.ACTIVE) {
					log.info("User: " + user.getName() + " status is "
							+ user.getStatus());
				} else if (user.getBalance() - paymentAmount < user
						.getCreditLimit()) {
					log.info("User: " + user.getName()
							+ " doesn't have credit.");

					Double addUserBalance = Double
							.valueOf(Math.random() * 1000);
					addUserBalance = Math.round(addUserBalance * 100.0) / 100.0;

					log.info("Add " + addUserBalance + " to user balance");

					user.setBalance(user.getBalance() + addUserBalance);
					gigaSpace.write(user);

				} else {

					// Withdraw payment amount from user account
					updateUserBalance(user, paymentAmount);

					// Deposit payment amount to merchant account
					updateMerchantReceipts(merchant, paymentAmount);

					Payment payment = new Payment();

					payment.setPayingAccountId(user.getUserAccountId());
					payment.setReceivingMerchantId(merchant
							.getMerchantAccountId());
					payment.setDescription(merchant.getCategory().name());
					payment.setCreatedDate(date);
					payment.setPaymentAmount(Double.valueOf(Math.random() * 100));
					payment.setPaymentAmount(Math.round(paymentAmount * 100.0) / 100.0);
					payment.setStatus(TransactionStatus.NEW);

					payments[i] = payment;

					log.info("TransactionWriterTask wrote new transaction between user: "
							+ user.getName()
							+ " and merchant: "
							+ merchant.getName());

				}
			}

			//TODO: use writeMultiple to write the payments make sure Payments will stay only 20 seconds in the space (Hint: Lease time)

		} catch (SpaceInterruptedException e) {
			// ignore, we are being shutdown
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Updates User balance
	private void updateUserBalance(User user, Double paymentAmount) {
		log.info("TransactionWriterTask withdraw " + paymentAmount
				+ " from user: " + user.getName());

		user.setBalance(user.getBalance() - paymentAmount);
		gigaSpace.write(user);

		log.info("TransactionWriterTask updates user balance. User: "
				+ user.getName() + " new balance is " + user.getBalance());

	}

	// Updates Merchant receipts
	private void updateMerchantReceipts(Merchant merchant, Double paymentAmount) {
		log.info("TransactionWriterTask deposit " + paymentAmount
				+ " to merchant: " + merchant.getName());

		merchant.setReceipts(merchant.getReceipts() + paymentAmount);
		gigaSpace.write(merchant);

		log.info("TransactionWriterTask updates merchant receipt. Merchant: "
				+ merchant.getName() + " new receipt is "
				+ merchant.getReceipts());

	}
	
	private class PaymentCreatorExecuter implements Runnable {
		
	    public void run() {
	        try {
	        	log.info("PaymentFeeder.PaymentCreatorExecuter thread has start");
	        	while (true){
	        		create5Payments();
	        		Thread.sleep(defaultDelay);
	        	}
	        } catch (InterruptedException e) {
	        	log.error("PaymentFeeder.PaymentCreatorExecuter has failed");
	        }
	    }
    }
}