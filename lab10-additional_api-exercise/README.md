# gs-dev-training - lab10-additional_api-exercise

## 	Advance Space Access API

###### Lab Goals
1. Experience using change API
2. Experience bulk operations
3. Understand and test the Lease concept. 
4. Practice WIKI search 

###### Lab Description
This lab includes2 exercises:
1. 	Space Data Access API: Change the PaymentFeeder PU to use change API.
2. 	Only if time permits: Bulk operations: you will modify the writing mechanism to write 5 Payments at a time. 

## 1 Lab setup
Make sure you restart the service grid and gs-ui (or at least undeploy all Processing Units using gs-ui)
               
1.1 Open gs-dev-training/lab10-additional_api-exercise project with intellij (open pom.xml) <br />
1.2 Run mvn package

    ~/gs-dev-training/lab10-additional_api-exercise$ mvn package
    
       [INFO] ------------------------------------------------------------------------
       [INFO] Reactor Summary:
       [INFO] 
       [INFO] lab10-exercise 1.0-SNAPSHOT ........................ SUCCESS [  0.990 s]
       [INFO] BillBuddyModel ..................................... SUCCESS [  6.876 s]
       [INFO] BillBuddy_Space .................................... SUCCESS [  0.835 s]
       [INFO] BillBuddyAccountFeeder ............................. SUCCESS [  0.985 s]
       [INFO] BillBuddyPaymentFeeder ............................. SUCCESS [  0.879 s]
       [INFO] Bill 1.0-SNAPSHOT .................................. SUCCESS [  0.730 s]
       [INFO] ------------------------------------------------------------------------
       [INFO] BUILD SUCCESS


1.3 Copy the runConfigurations directory to the Intellij .idea directory to enable the Java Application configurations. Restart Intellij.
###### This will add the predefined Run Configuration Application to your Intellij IDE.

## 2	Advance Space Access API	
 2.1	In this exercise you will change the implementation of the 
        Payment Feeder class to use change API. <br />
 2.2	Open the BillBuddyPaymentFeeder project.
        Payment Feeder creates a random payment every 1 second.
        The exercise focuses on space data access advance api.
        the other Java code is already prepared for you. <br /> 
 The overall requirement is to implement methods using Change API:
 
 1.	Update the User balance in the space (withdraw the amount from the balance) 
    using the change API in method updateUserBalance.
 2.	Update the Merchant balance in the space (deposit the amount to the receipts property), 
    using the change API in method updateMerchantReceipts.
 3.	Validate the results <br />
 a.	Run BillBuddy_Space run the space as Integrated Processing Unit Container using Intellij run configuration. <br />
 b.	Run BillBuddyAccountFeeder and BillBuddyPaymentFeeder using Intellij run configuration.
 
2.3	Validate that Payment Object are written to the space using gs-ui.

![Screenshot](./Pictures/Picture1.png)

## 3	Bulk operations (Only if time permits)
3.1	Open project BillBuddyMultiplePaymentFeeder and modify LeasePaymentFeeder 
        class to write all 5 Payments in a single writeMultiple command (search for the TODO: ). <br />
3.2	In order to demonstrate objects automatic eviction from the space, 
        make sure payments will stay only 20 seconds in the space (Hint: Lease time) <br />
3.3	Run your new MultiplePaymentFeeder for 30 seconds. <br /> 
3.4	Using gs-ui examine Payments getting evicted from the space 
        (Hint: Use Data Types operation at gs-ui).


