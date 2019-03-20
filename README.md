# xap-dev-training - lab10-exercise

## 10 Space Access API

###### Lab Goals
Implement Processing Unit client feeder that requires a wider space data access operations.
###### Lab Description
This lab includes3 exercises:
1.	WIKI Search for the “GigaSpace Interface”. 
    You will practice using the Wiki for getting useful information that might be needed for this lab. 
2.	Space Data Access API: Develop the PaymentFeeder processing unit
3.	Only if time permits: SQL Query operation: You will practice writing a SQL query
###### Lab setup
Make sure you restart gs-agent and gs-ui (or at least undeploy all Processing Units using gs-ui)

10.1.1 Create dir: %XAP_TRAINING_HOME%/labs/lab10-exercise

    mkdir /Users/yuval/XAPDevTraining/labs/lab10-exercise

10.1.2 Navigate to lab9-exercise dir

    cd /Users/yuval/XAPDevTraining/labs/lab10-exercise

10.1.3 Clone the git project

    git clone https://github.com/GigaSpaces-ProfessionalServices/xap-dev-training.git

10.1.4 Checkout lab10-exercise

    cd xap-dev-training
    git checkout lab10-exercise
    
10.1.5 Verify that the branch has been checked out.

    yuval-pc:xap-dev-training yuval$ git branch
    * lab10-exercise
      master
               
10.1.6 Open xap-dev-training project with intellij <br />
10.1.7 Run mvn install

    yuval-pc:xap-dev-training yuval$ mvn install
    
      [INFO] Reactor Summary:
      [INFO] 
      [INFO] Lab10-exercise 1.0-SNAPSHOT ........................ SUCCESS [  1.276 s]
      [INFO] BillBuddyModel ..................................... SUCCESS [  4.326 s]
      [INFO] BillBuddy_Space .................................... SUCCESS [  0.603 s]
      [INFO] BillBuddyAccountFeeder ............................. SUCCESS [  1.489 s]
      [INFO] BillBuddyPaymentFeeder ............................. SUCCESS [  1.244 s]
      [INFO] BillBuddy_Space 1.0-SNAPSHOT ....................... SUCCESS [  1.072 s]
      [INFO] ------------------------------------------------------------------------
      [INFO] BUILD SUCCESS

10.1.8 Run mvn xap:intellij.
###### This will add the predefined Run Configuration Application to your Intellij IDE.

    yuval-pc:xap-dev-training yuval$ mvn xap:intellij
    
     [INFO] --- xap-maven-plugin:14.0.1:intellij (default-cli) @ Lab10-exercise ---
     [INFO] ------------------------------------------------------------------------
     [INFO] Reactor Summary:
     [INFO] 
     [INFO] Lab10-exercise 1.0-SNAPSHOT ........................ SUCCESS [  0.694 s]
     [INFO] BillBuddyModel ..................................... SKIPPED
     [INFO] BillBuddy_Space .................................... SKIPPED
     [INFO] BillBuddyAccountFeeder ............................. SKIPPED
     [INFO] BillBuddyPaymentFeeder ............................. SKIPPED
     [INFO] BillBuddy_Space 1.0-SNAPSHOT ....................... SKIPPED
     [INFO] ------------------------------------------------------------------------
     [INFO] BUILD SUCCESS


## 10.2	Docs Search for GigaSpace Interface	
Open a browser and go to: http://docs.gigaspaces.com/ <br />
Search the docs for “API Documentation”. <br />
Search the Javadoc GigaSpace API for the GigaSpace Interface. <br /> 
Investigate the different methods and their signatures. 

## 10.3	Space Data Access API	
10.3.1	In this exercise you will implement the Payment Feeder class. <br />
10.3.2	Open the BillBuddyPaymentFeeder project. <br />
        Payment Feeder creates a random payment every 1 second. <br />
        The exercise focuses on space data access API; <br /> 
        the other Java code is already prepared for you. <br /> 
        The overall process of creating a payment is:
1.	Read an existing User randomly for auditing purposes. <br /> 
2.	Read an existing Merchant randomly for auditing purposes. <br />
3.	Determine payment amount randomly. <br />
4.	Check if User has enough money in its balance. <br />
5.	If User does not have enough balance, 
    deposit a random amount of money to the user account so the simulation feeder may continue. <br />
6.	If the User does have enough balance you will create a payment. <br /> 
a.	Create a Payment instance and set its properties accordingly. <br /> 
b.	Update the User balance in the space (withdraw the amount from the balance). <br />
c.	Update the Merchant balance in the space (deposit the amount to the receipts property). <br />
d.	Write the Payment object to the space. <br />

Follow the //TODO: comments top down and implement the missing code. <br />
Hints:
1.	You might want to use gigaSpace.count(Template) in order to find out how many users and merchants you have prior to choosing them randomly. 
2.	Remember that the UserFeeder and MerchantFeeder are generating UIDs starting 1 for both Merchants and Users. 
3.	RunBillBuddy_Space to deploy the space to the Integrated Processing Unit Container using Intellij run configuration.
4.	RunBillBuddyAccountFeeder and BillBuddyPaymentFeeder using Intellij run configuration.

10.3.3	Validate that Payment Object are written to the space using gs-ui.
![Screenshot](./Pictures/Picture1.png) 

10.3.4	Deploy PaymentFeeder and BillBuddySpace to the service grid.

*	Deploy PaymentFeeder to the service grid using gs-ui by following the steps below. <br /> 
    (This means you have to jar your PaymentFeeder project together with the BillBuddyModel project 
    like you did for the BillBuddySpace). <br />
    Follow these steps: <br />
        *   Stop all Integrated PU Container in your IDE.
        *   Restart gs-agent.
        *   Restart gs-ui.
        *   Deploy BillBuddy-space to the service grid (if not already deployed).
        *   Run AccountFeeder from your IDE.
        *   Jar PaymentFeeder to a PU.
        *   Deploy PaymentFeeder to the service grid.
        *   Check payments are created.
        *   Press on the Deployed Processing Units tab.
 
![Screenshot](./Pictures/Picture2.png) 

*   After successful deployment and validation you might want to scale up your feeding load on the system:
![Screenshot](./Pictures/Picture3.png) 

*   Press on the BillBuddyPaymentFeederProcessingUnitInstances and then press on the add instances. <br /> 
    When doing that a new PU instance will be deployed and started. 
*   Check how many payments are created per second. 
    It should be about 2 per second (Or about the number of PaymentFeeder PU instance per second). <br />
*   Check where your PaymentFeeder PU instance was deployed.

![Screenshot](./Pictures/Picture4.png)

## 10.4	SQL Query(Only if time permits)
10.4.1	Open project merchantsOfTop5Payments. <br />
10.4.2	Write query (SQLQuery object) to retrieve top five payments exists in the space. <br />
10.4.3	For each payment, print the details of the merchant receiving the payment. <br />
10.4.4	Run BillBuddy-space (use theIntegrated PU Container containers). <br />
10.4.5	Run BillBuddyAccountFeeder. <br />
10.4.6	Run BillBuddyPaymentFeeder for 30 seconds. <br />
10.4.7	Run your new MerchantOfTop5Payments client. <br />
10.4.8	examine your results. <br />