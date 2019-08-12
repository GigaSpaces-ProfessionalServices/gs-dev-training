# xap-persist-training - lab2-solution

## Lab Goals

1. Experience an application deployment process. <br />
2. Get familiar with the BillBuddy web application <br />

## Lab Description
In this lab we will focus on deployment and the application and not be concerned with code, therefore simply focus on the deployment process, you will use this process throughout the labs here on.

## 2.1	Start gs-agent and gs-ui 

2.1.1 Find your host name by running "hostname" command.

    yuval-pc:~ yuval$ hostname
    yuval-pc


2.1.2 Navigate to %XAP_HOME%/bin/ <br />

    cd $XAP_HOME/bin
    
2.1.3 Edit setenv-overrides.sh and put your host name as a value for XAP_MANAGER_SERVERS parameter.

    vi setenv-overrides.sh
    export XAP_MANAGER_SERVERS=yuval-pc
        
2.1.4 Start gs-agent with XAP Manager and 2 GSCs.

    ./gs.sh host run-agent --manager --gsc=2
    
2.1.5 Start the gs-ui:

    cd $XAP_HOME/bin
    ./gs-ui.sh
    
## 2.2	Clone the project lab and deploy BillBuddy_Space

2.2.1 Create your XAP_TRAINING_HOME directory: 

    mkdir ~/XAPPersistTraining

2.2.2 Define XAP_TRAINING_HOME

###### Linux
    
    vi ~/.bash_profile
    export XAP_TRAINING_HOME=~/XAPPersistTraining
    source ~/.bash_profile
    
###### Windows
 
    add XAP_TRAINING_HOME to your system variables

2.2.3 Create lab directory:
    mkdir ~/XAPPersistTraining/labs
    mkdir ~/XAPPersistTraining/labs/lab5-solution
      
2.2.4 Clone the project from git
    
    cd ~/XAPPersistTraining/labs/lab5-solution
    git clone https://github.com/GigaSpaces-ProfessionalServices/xap-persist-training.git 
    
2.2.5 Checkout lab2-solution
    
    cd xap-persist-training
    git checkout lab2-solution
    
2.2.6 Verify that the branch has been checked out.
    
    git branch
    * lab2-solution
      master 
    
2.2.7 Open xap-persist-training project with intellij <br />
2.2.8 Run mvn install <br />

    yuval-pc:xap-persist-training yuval$ mvn install
    
    
       [INFO] ------------------------------------------------------------------------
       [INFO] Reactor Summary:
       [INFO] 
       [INFO] Lab2-solution 1.0-SNAPSHOT ......................... SUCCESS [  1.411 s]
       [INFO] BillBuddyModel ..................................... SUCCESS [  4.550 s]
       [INFO] BillBuddy_Space .................................... SUCCESS [  0.943 s]
       [INFO] BillBuddyAccountFeeder ............................. SUCCESS [  0.743 s]
       [INFO] BillBuddyPaymentFeeder ............................. SUCCESS [  0.474 s]
       [INFO] BillBuddyWebApplication 14.0.1 ..................... SUCCESS [  2.778 s]
       [INFO] ------------------------------------------------------------------------
       [INFO] BUILD SUCCESS
       [INFO] ------------------------------------------------------------------------


2.2.9 Run mvn xap:intellij.
######This will add the predefined Run Configuration Application to your Intellij IDE.

    yuval-pc:xap-persist-training yuval$ mvn xap:intellij
    
        [INFO] ------------------------------------------------------------------------
        [INFO] Reactor Summary:
        [INFO] 
        [INFO] Lab2-solution 1.0-SNAPSHOT ......................... SUCCESS [  0.698 s]
        [INFO] BillBuddyModel ..................................... SKIPPED
        [INFO] BillBuddy_Space .................................... SKIPPED
        [INFO] BillBuddyAccountFeeder ............................. SKIPPED
        [INFO] BillBuddyPaymentFeeder ............................. SKIPPED
        [INFO] BillBuddyWebApplication 14.0.1 ..................... SKIPPED
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------




2.2.10 Open a new Terminal and navigate to %XAP_HOME%/bin/ <br />
2.2.11 Use XAP CLI to deploy BillBuddy_Space
 
    ./gs.sh pu deploy BillBuddy-Space ~/Downloads/XAPPersistTraining/labs/lab2-solution/xap-persist-training/BillBuddy_Space/target/BillBuddy_Space.jar
    
    
## 2.3	Run BillBuddyAccountFeeder from Intellij

2.3.1 From the Intellij run configuration select BillBuddyAccountFeeder and run it.

###### This application writes Users and Merchants to the Space
 
2.3.2 Validate Users and Merchants were written to the space using gs-ui. <br />
 Go to: Space Browser Tab -> Clusters -> Operations -> Data Types. <br />
 Examine the list of classes from which objects were written to the space.
 
![Screenshot](./Pictures/Picture1.png)

2.3.3 Query the list of Users by executing the following SQL: <br />
Choose the query option and copy the following SQL command to the SQL area: <br />

    SELECT * FROM com.c123.billbuddy.model.User
###### Note: Fully qualified class name is required. (You can use copy paste in the gs-ui)

![Screenshot](./Pictures/Picture2.png)

## 2.4	Run BillBuddyPaymentFeeder project
The BillBuddyPaymentFeeder application creates payments by randomly choosing a user, 
a merchant and an amount and performs the initial process of a payment. 
This includes deposit and withdrawal updates of each party’s balance appropriately. 
After the payment is initially processed it is written to the space for further processing. 
You will be further introduced with this application in a later lesson in greater detail. 
A new Payment is created every second.
 
2.4.1 Run the BillBuddyPaymentFeeder using Intellij: 
Use the same instructions as used for the BillBuddyAcountFeeder.

2.4.2 Validate Payments were written to the space using gs-ui. 
You may choose to view Payment Objects using the Query operation of gs-ui.
 
2.4.3 Go to the statistics operation and see that a payment is actually added every second.
You might be required to modify the sample rate and start the automatic refresh.

![Screenshot](./Pictures/Picture3.png)

2.4.4 Go to the Data Types view under Operations. Which object counts are increasing?

## 2.5 Deploy BillBuddyWebApplication project

2.5.1 Open a new Terminal and navigate to %XAP_HOME%/bin/

2.5.2 Use XAP CLI to deploy BillBuddyWebApplication
 
    ./gs.sh pu deploy BillBuddyWebApplication ~/Downloads/XAPPersistTraining/labs/lab2-solution/xap-persist-training/BillBuddyWebApplication/target/BillBuddyWebApplication.war

2.5.3 Validate the application is deployed. 
Go to Deployed Processing Units tab and expand the BillBuddyWebApplication PU.

![Screenshot](./Pictures/Picture4.png)

2.5.4 The URL is for the application home page URL. 
Click on it and get to the application. 

![Screenshot](./Pictures/Picture5.png)

2.5.5 Congratulations, you have deployed the BillBuddy web application. 
Navigate through the application pages and investigate it.
