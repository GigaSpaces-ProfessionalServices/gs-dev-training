# xap-dev-training - lab16-exercise

## 16	Space Based Remoting

###### Lab Goals
1.  Experience developing a remote service.
2.  Understand the location of each class of the remote service (Interface, Service and client).
###### Lab Description
This lab includes 3 exercises:
1. 	Investigate a space based remoting service.
2.	Develop a distributed executor based remoting service.
3.	Develop an executor based remoting with @routing.
###### Lab setup
Make sure you restart gs-agent and gs-ui (or at least undeploy all Processing Units using gs-ui)

16.1.1 Create dir: %XAP_TRAINING_HOME%/labs/lab16-exercise

    mkdir /Users/yuval/XAPDevTraining/labs/lab16-exercise

16.1.2 Navigate to lab16-exercise dir

    cd /Users/yuval/XAPDevTraining/labs/lab16-exercise

16.1.3 Clone the git project

    git clone https://github.com/GigaSpaces-ProfessionalServices/xap-dev-training.git

16.1.4 Checkout lab16-exercise

    cd xap-dev-training
    git checkout lab16-exercise
    
16.1.5 Verify that the branch has been checked out.

    yuval-pc:xap-dev-training yuval$ git branch
    * lab16-exercise
      master
               
16.1.6 Open xap-dev-training project with intellij <br />
16.1.7 Run mvn install

    yuval-pc:xap-dev-training yuval$ mvn install
    
       [INFO] ------------------------------------------------------------------------
       [INFO] Reactor Summary:
       [INFO] 
       [INFO] Lab16-exercise 1.0-SNAPSHOT ........................ SUCCESS [  0.535 s]
       [INFO] BillBuddyModel ..................................... SUCCESS [  4.100 s]
       [INFO] BillBuddy_Space .................................... SUCCESS [  1.269 s]
       [INFO] BillBuddyAccountFeeder ............................. SUCCESS [  1.413 s]
       [INFO] BillBuddyPaymentFeeder ............................. SUCCESS [  1.270 s]
       [INFO] BillBuddyCountPaymentsByCategoryDistributedExecutor  SUCCESS [  1.236 s]
       [INFO] BillBuddyCountPaymentByCategoryRemoteService ....... SUCCESS [  1.148 s]
       [INFO] BillBuddyCategoryTop5PaymentRemoteService 1.0-SNAPSHOT SUCCESS [  1.123 s]
       [INFO] ------------------------------------------------------------------------
       [INFO] BUILD SUCCESS


15.1.8 Run mvn xap:intellij
###### This will add the predefined Run Configuration Application to your Intellij IDE.

    yuval-pc:xap-dev-training yuval$ mvn xap:intellij
    
     [INFO] Reactor Summary:
     [INFO] 
     [INFO] Lab16-exercise 1.0-SNAPSHOT ........................ SUCCESS [  1.630 s]
     [INFO] BillBuddyModel ..................................... SKIPPED
     [INFO] BillBuddy_Space .................................... SKIPPED
     [INFO] BillBuddyAccountFeeder ............................. SKIPPED
     [INFO] BillBuddyPaymentFeeder ............................. SKIPPED
     [INFO] BillBuddyCountPaymentsByCategoryDistributedExecutor  SKIPPED
     [INFO] BillBuddyCountPaymentByCategoryRemoteService ....... SKIPPED
     [INFO] BillBuddyCategoryTop5PaymentRemoteService 1.0-SNAPSHOT SKIPPED
     [INFO] ------------------------------------------------------------------------
     [INFO] BUILD SUCCESS

## 16.2	Investigate a space based remoting service
In this exercise we will examine an existing remote service code. 
You will not have to do much coding in this exercise. <br /> 
16.2.1	Expand the BillBuddyCategoryTop5PaymentRemoteService project. <br /> 
16.2.2	Add Remoting annotation support to your space (Hint pu.xml at BillBuddy-space). <br />
16.2.3	BillBuddy requires a Top 5 Payments per category query. 
The service was implemented. Please answer the following questions about the remote service: <br />

a.	Where is the service interface located? In which project? Why? Locate it please. <br /> 
b.	Where is the actual Remote Service code located? Why? Locate it please. <br />
c.	Where is client code located? Locate it please. <br />
d.	Why is the CategoryTop5PaymentReducernot located with the service? <br />
e.	Can you assign a different type of Reducer to the same Remote Service?
f.	Is the service implemented as Executor Based Remoting? Or is it implemented as Event Based Remoting?

## 16.2	Develop a Distributed Executor Based Remoting
16.2.1	BillBuddy is required to generate a “Payment Count Per Category” report. 
A Payment Count report includes a count of all the payments made in a specific category.
You have already implemented that functionality as a distributed task in the previous lab 
and now you will refactor it to be a Space Based Remoting deployment in the space. 
The BillBuddyCountPaymentByCategoryDistributedExecutor project is provided as part of the Lab. 
You can use it in order to complete any coding gaps you might have. <br />
16.2.2	 Expand the BillBuddyModelproject. <br /> 
16.2.3	 Add the required method in the Interface com.c123.billbuddy.remoting.ICountPaymentsByCategoryService <br />

a.	Declare a method named findPaymentCountByCategory that will retrieve a count of all payments made in a specific category. <br /> 
16.2.4	 Implement the Service as follows: <br />
a.	Locate the com.c123.billbuddy.remoting.CountPaymentByCategoryService (Hint: BillBuddy_space). <br />
b.	Follow the //TO DO comments in the file. <br />
16.2.5	 Implement the Reducer class as follows: <br />
a.	Expand the BillBuddyCountPaymentByCategoryRemoteService project. <br />
b.	Locate the com.c123.billbuddy.report.CountPaymentByCategoryReducer. <br />
c.	Follow the //TO DO comments in the file. 
You only have to add all results to a single list. 
The reducer class is almost fully implemented. <br />
16.2.6	 Implement the Client as follows: <br />
a.	Expand the BillBuddyCountPaymentByCategoryRemoteService project. <br />
b.	Locate the com.c123.billbuddy.report.CountPaymentByCategoryReport. <br />
c.	Follow the //TO DO comments in the file. <br />
d.	Deploy the BillBuddy_Space PU to the Grid Service followed: <br /> 
e.	Run AccountFeeder and PaymentFeeder. <br />
f.	Run the BillBuddyCountPaymentByCategoryRemoteService and examine your results. 

## 16.3	Develop Executor Based Remoting using @routing
16.3.1	BillBuddy requires a profit report for a random merchant. 
A merchant's profit is calculated via the following formula: (receipts – feeAmount). 
You can use the Top10Payment distributed Executor Based Remoting as a reference. <br />
16.3.2	We will use the IMerchantProfitService interface. 
Complete the missing code in the Interface (Hint: located in the …model…). <br />
16.3.3	Implement the Service in MerchantProfitService. (Hint: located in the space…). <br />
a.	The service will return a specific merchant's calculated profit. <br />
b.	Remember that the merchantAccountId is also the merchant's routing attribute. 
Add the relevant annotation to enable the service to use routing. <br />
16.3.4	Implement the Client MerchantProfitReport as follows: <br />
a.	Expand the BillBuddyMerchantProfitRemoteService. <br />
b.	Select a random merchant from the space (Hint: count the merchants and randomize a number within the count result). <br />
Use the IMerchantProfitService interface to return the profit for the random MerchantAccountId and assign it to the merchant object. <br />
16.3.5	Deploy the BillBuddy_Space PU to the Grid Service followed by 
AccountFeeder and PaymentFeeder. <br />
16.3.6	Run and test the BillBuddyMerchantProfitRemoteService service.

