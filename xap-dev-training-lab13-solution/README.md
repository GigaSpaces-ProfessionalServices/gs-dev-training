# xap-dev-training - lab13-solution

##    Messaging and Event Containers

###### Lab Goals
1.  Understand the concept of Event Driven Architecture
2.  Implement an event container
3.  Implement reading information from the space using projection
4.  Monitor Event Containers
###### Lab Description
During this lab you will explore the BillBuddy application 
Event Driven Architecture and will implement 
the “Processing Fee Polling Container”. 
In this lab you will have to implement the Processing Fee Event Container. 
You will monitor events using gs-ui, but first here is a full description of the BillBuddy Event Driven architecture. 
## 1 Lab setup
Make sure you restart gs-agent and gs-ui (or at least undeploy all Processing Units using gs-ui)

1.1 Open %XAP_TRAINING_HOME%/xap-dev-training-lab13-solution project with intellij (open pom.xml) <br />
1.2 Run mvn install

    ~/xap-dev-training/xap-dev-training-lab13-solution$ mvn install
    
       [INFO] ------------------------------------------------------------------------
       [INFO] Reactor Summary:
       [INFO] 
       [INFO] Lab13-solution 1.0-SNAPSHOT ........................ SUCCESS [  1.493 s]
       [INFO] BillBuddyModel ..................................... SUCCESS [  8.002 s]
       [INFO] BillBuddy_Space .................................... SUCCESS [  1.290 s]
       [INFO] BillBuddyAccountFeeder ............................. SUCCESS [  1.519 s]
       [INFO] BillBuddyPaymentFeeder 1.0-SNAPSHOT ................ SUCCESS [  1.294 s]
       [INFO] ------------------------------------------------------------------------
       [INFO] BUILD SUCCESS



1.3 Run mvn xap:intellij
###### This will add the predefined Run Configuration Application to your Intellij IDE.

    ~/xap-dev-training/xap-dev-training-lab13-solution$ mvn xap:intellij
    
    [INFO] Reactor Summary:
    [INFO] 
    [INFO] Lab13-solution 1.0-SNAPSHOT ........................ SUCCESS [  1.786 s]
    [INFO] BillBuddyModel ..................................... SKIPPED
    [INFO] BillBuddy_Space .................................... SKIPPED
    [INFO] BillBuddyAccountFeeder ............................. SKIPPED
    [INFO] BillBuddyPaymentFeeder 1.0-SNAPSHOT ................ SKIPPED
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

The BillBuddy application is managing the lifecycle of a Payment POJO. 
A Payment POJO has 3 statuses (in real payment processing applications there 
are many more statuses or, as they are usually called: Payment States). 
The 3 Payment Statuses are:
(see also com.c123.billbuddy.model.TransactionSatus and flow diagram in next page)

![Screenshot](./Pictures/Picture1.png)

The following flow diagram illustrates the Event Driven Architecture 
right after a New Payment was written to the space:

![Screenshot](./Pictures/Picture2.png)

The following is an explanation of the above diagram:
*   Payment Feeder (Simulator that creates and writes a payment every 1 second).
1.	Reads a random User.
2.	Reads a random Merchant.
3.	Update the user balance (withdraw from user).
4.	Update the Merchant receipts (deposit to merchant).
5.	Write payment object to the space.
•	Audit Polling Container.
6.	Asynchronously Takes every payments with status=“new”.
7.	Container prints the payment to an audit log and sets the 
    payment status to “audited”.
8.	writes the payment to back to the space with the new status

•	Fee Processing Polling Container
 
9.	Asynchronously Takes all payments with status=“audited”.
10.	Read merchant.
11.	Read merchant contract using space projection API 
    and calculates the merchant processing fee.
12.	Write merchant after adding the processing fee amount to merchant.feeAmount
13.	Write the processing fee object to the space and modifies the 
    payment status to “processed”.
14.	Write the payment back to the space.

## 2	Event Driven Architecture
2.1	Why is this architecture named Event Driven Architecture? <br /> 
1.2	Where do you think the code for these event containers will be located
        (which Project) and why? <br />
2.3	Can you think of a reason why an event container 
        will be located in a different location than the space it listens to? <br />

## 3	Implement a Processing Fee Polling Container
3.1	In this solution you will implement the Processing Fee Event Container. <br />

Expand BillBuddy_Space <br />
Open com.c123.billbuddy.events.ProcessingFeeEventContainer 

3.2	Open pu.xml <br />
a.	Add @Polling and @Notify annotations support in the pu.xml file <br />
3.3	Open com.c123.billbuddy.events.ProcessingFeeEventContainer <br />
a.	Add Event Container annotation. 
    Which one should be added Polling or Notify container? Why? <br />
b.	Implement the Event Template (See TODO comments for more information). <br />
c.	Implement the SpaceDataEvent (See TODO comments for more information). <br />
a.	Read the Contract data using the projection API to retrieve only 
    “transactionPercentFee” attribute. <br />
You can refer to the AuditPaymentEventContainerfor an example. <br />
3.4	Test your code. <br />
a.	Run BillBuddy_Space <br />
b.	Run BillBuddyAccountFeeder <br />
c.	Run BillBuddyPaymentFeeder <br />
d.	Query Payment and see the status set to PROCESSED.

![Screenshot](./Pictures/Picture3.png)

e.	Query ProcessingFee and validate they are written to the space. 

![Screenshot](./Pictures/Picture4.png)

## 4	Monitor Events

4.1	Deploy BillBuddy_Space to the service grid and run the Feeders. <br />

a.	First stop your current BillBuddy_space if you run it in your IDE or gs-ui. <br />
b.	Hint: Deploy Application at gs-ui (start gs-agent of course). <br /> 
c.	Run BillBuddyAccountFeeder (from Integrated PU Container in Intellij). <br />
d.	Run BillBuddyPaymentFeeder (from Integrated PU Container in Intellij). <br />
e.	Monitor Event Containers activity. Open:
    gs-ui -> Deployed Processing Units -> Processing Unit Instances -> 
    any primary partition instance ->BillBuddy_space -> Event Containers 

![Screenshot](./Pictures/Picture5.png)