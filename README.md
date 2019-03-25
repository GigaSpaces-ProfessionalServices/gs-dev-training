# xap-dev-training - lab12-solution

## 12   Aggregations

###### Lab Goals
Experience usage of aggregation functions

###### Lab Description
This lab includes1 solutions:
1.	Access data in the space using aggregation functions.

###### Lab setup
Make sure you restart gs-agent and gs-ui (or at least undeploy all Processing Units using gs-ui)

12.1.1 Create dir: %XAP_TRAINING_HOME%/labs/lab12-solution

    mkdir /Users/yuval/XAPDevTraining/labs/lab12-solution

12.1.2 Navigate to lab12-solution dir

    cd /Users/yuval/XAPDevTraining/labs/lab12-solution

12.1.3 Clone the git project

    git clone https://github.com/GigaSpaces-ProfessionalServices/xap-dev-training.git

12.1.4 Checkout lab12-solution

    cd xap-dev-training
    git checkout lab12-solution
    
12.1.5 Verify that the branch has been checked out.

    yuval-pc:xap-dev-training yuval$ git branch
    * lab12-solution
      master
               
12.1.6 Open xap-dev-training project with intellij <br />
12.1.7 Run mvn install

    yuval-pc:xap-dev-training yuval$ mvn install
    
    [INFO] ------------------------------------------------------------------------
    [INFO] Reactor Summary:
    [INFO] 
    [INFO] Lab12-solution 1.0-SNAPSHOT ........................ SUCCESS [  0.661 s]
    [INFO] BillBuddyModel ..................................... SUCCESS [  5.916 s]
    [INFO] BillBuddy_Space .................................... SUCCESS [  0.593 s]
    [INFO] BillBuddyAccountFeeder ............................. SUCCESS [  1.188 s]
    [INFO] BillBuddyPaymentFeeder ............................. SUCCESS [  1.426 s]
    [INFO] BillBuddyAggregationPayment 1.0-SNAPSHOT ........... SUCCESS [  1.103 s]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS



12.1.8 Run mvn xap:intellij
###### This will add the predefined Run Configuration Application to your Intellij IDE.

    yuval-pc:xap-dev-training yuval$ mvn xap:intellij
    
     [INFO] Reactor Summary:
     [INFO] 
     [INFO] Lab12-solution 1.0-SNAPSHOT ........................ SUCCESS [  1.186 s]
     [INFO] BillBuddyModel ..................................... SKIPPED
     [INFO] BillBuddy_Space .................................... SKIPPED
     [INFO] BillBuddyAccountFeeder ............................. SKIPPED
     [INFO] BillBuddyPaymentFeeder ............................. SKIPPED
     [INFO] BillBuddyAggregationPayment 1.0-SNAPSHOT ........... SKIPPED
     [INFO] ------------------------------------------------------------------------
     [INFO] BUILD SUCCESS

## 12.2	Aggregation Functions (Only if time permits)
12.2.1	Open project BillBuddyAggregationPayment and modify 
        AggregationPaymentInformation class to retrieve aggregated information 
        like: Maximum, Minimum, Sum, Avarage 
        (search for the TODO: remarks & follow the instructions). <br />
12.2.2	Run BillBuddy-space (use theIntegrated PU Container containers). <br />
12.2.3	Run BillBuddyAccountFeeder. <br />
12.2.4	Run BillBuddyPaymentFeeder (let it run for about 20 second). <br />
12.2.5	Run your new AggregationPaymentInformation client. <br />
12.2.6	Examine your results. <br />
