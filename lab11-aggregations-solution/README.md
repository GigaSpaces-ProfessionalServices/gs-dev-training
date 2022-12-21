# gs-dev-training - lab12-aggregations-solution

##   Aggregations

###### Lab Goals
Experience usage of aggregation functions

###### Lab Description
This lab includes1 solutions:
1.	Access data in the space using aggregation functions.

## 1 Lab setup
Make sure you restart the service grid and gs-ui (or at least undeploy all Processing Units using gs-ui)

1.1 Open gs-dev-training/lab11-aggregations-solution project with intellij (open pom.xml) <br />
1.2 Run mvn package

    ~/gs-dev-training/lab11-aggregations-solution$ mvn package
    
    [INFO] ------------------------------------------------------------------------
    [INFO] Reactor Summary:
    [INFO] 
    [INFO] lab11-solution 1.0-SNAPSHOT ........................ SUCCESS [  0.661 s]
    [INFO] BillBuddyModel ..................................... SUCCESS [  5.916 s]
    [INFO] BillBuddy_Space .................................... SUCCESS [  0.593 s]
    [INFO] BillBuddyAccountFeeder ............................. SUCCESS [  1.188 s]
    [INFO] BillBuddyPaymentFeeder ............................. SUCCESS [  1.426 s]
    [INFO] BillBuddyAggregationPayment 1.0-SNAPSHOT ........... SUCCESS [  1.103 s]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS



1.3 Copy the runConfigurations directory to the Intellij .idea directory to enable the Java Application configurations. Restart Intellij.
###### This will add the predefined Run Configuration Application to your Intellij IDE.

## 2	Aggregation Functions (Only if time permits)
2.1	Open project BillBuddyAggregationPayment and modify 
        AggregationPaymentInformation class to retrieve aggregated information 
        like: Maximum, Minimum, Sum, Avarage 
        (search for the TODO: remarks & follow the instructions). <br />
2.2	Run BillBuddy-space (use the Integrated PU Container containers). <br />
2.3	Run BillBuddyAccountFeeder. <br />
2.4	Run BillBuddyPaymentFeeder (let it run for about 20 second). <br />
2.5	Run your new AggregationPaymentInformation client. <br />
2.6	Examine your results. <br />
