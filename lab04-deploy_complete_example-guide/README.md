# gs-dev-training - lab04-deploy_complete_example-guide

## Lab Goals

1. Experience an application deployment process. <br />
2. Get familiar with the BillBuddy application <br />

## Lab Description
In this lab we will show 'the big picture'. It will introduce the BillBuddy application. Subsequent labs will focus on specific features and their use inside a Gigaspaces application. However, in this lab we will simply focus on the deployment of an application and not be concerned with code. The same deployment process will be used throughout the labs from here on. 

## 1	Start the service grid and gs-ui 

1.1 Navigate to `$GS_HOME\bin` <br />
        
1.2 Start the service grid with local Manager server and 6 GSCs:

    ./gs.sh host run-agent --auto --gsc=6
    
1.3 Start gs-ui.

    ./gs-ui.sh
    
## 2	Deploy BillBuddy_Space
    
2.1 Open $GS_TRAINING_HOME/lab04-deploy_complete_solution-guide project with Intellij (open pom.xml) <br />
2.2 Run mvn package <br />

    ~/gs-dev-training/lab04-deploy_complete_solution-guide$ mvn package
    
    
    [INFO] ------------------------------------------------------------------------
    [INFO] Reactor Summary:
    [INFO] 
    [INFO] lab04-guide 1.0-SNAPSHOT ......................... SUCCESS [  0.935 s]
    [INFO] BillBuddyModel ..................................... SUCCESS [  6.586 s]
    [INFO] BillBuddy_Space .................................... SUCCESS [  1.192 s]
    [INFO] BillBuddyAccountFeeder ............................. SUCCESS [  0.737 s]
    [INFO] BillBuddyCurrentProfitDistributedExecutor .......... SUCCESS [  1.393 s]
    [INFO] BillBuddyWebApplication 14.0.1 ..................... SUCCESS [  3.370 s]
    [INFO] BillBuddyPaymentFeeder 1.0-SNAPSHOT ................ SUCCESS [  0.466 s]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

2.3 IntelliJ path Variables

###### Add GS_LOOKUP_GROUPS & GS_LOOKUP_LOCATORS

2.4 Copy the runConfigurations directory to the Intellij .idea directory to enable the Java Application configurations. Restart Intellij.

###### This will add the predefined Run Configuration Application to your Intellij IDE.

2.5 Open a new Terminal and navigate to `$GS_HOME/bin` <br />

    cd $GS_HOME\bin
           
2.6 Use Gigaspaces CLI to deploy BillBuddy_Space
 
    ./gs.sh pu deploy BillBuddy-Space ~/gs-dev-training/lab04-deploy_complete_example-guide/BillBuddy_Space/target/BillBuddy_Space.jar 

## 3	Run BillBuddyAccountFeeder from Intellij

3.1 From the Intellij run configuration select BillBuddyAccountFeeder and run it.<br>
3.2 Another option is to run it from the maven command line:<br>
    `cd ~/gs-dev-training/lab04-deploy_complete_example-guide/BillBuddyAccountFeeder`<br>
U    `mvn exec:java  -D"exec.mainClass"="com.gs.billbuddy.client.AccountFeeder" -Dexec.classpathScope=compile -Dcom.gs.jini_lus.locators=localhost -Dcom.gs.jini_lus.groups=xap-16.3.0`<br>

###### This application writes Users and Merchants to the Space
 
3.2 Validate Users and Merchants were written to the space using gs-ui. <br />
 Go to: Space Browser Tab -> Clusters -> Operations -> Data Types. <br />
 Examine the list of classes from which objects were written to the space.
 
![Screenshot](./Pictures/Picture1.png)

3.3 Query the list of Users by executing the following SQL: <br />
Choose the query option and copy the following SQL command to the SQL area: <br />

    SELECT * FROM com.gs.billbuddy.model.User
    
###### Note: Fully qualified class name is required. (You can use copy paste in the gs-ui)

![Screenshot](./Pictures/Picture2.png)

## 4	Run BillBuddyPaymentFeeder project
The BillBuddyPaymentFeeder application creates payments by randomly choosing a user, 
a merchant and an amount and performs the initial process of a payment. 
This includes deposit and withdrawal updates of each party’s balance appropriately. 
After the payment is initially processed it is written to the space for further processing. 
You will be further introduced with this application in a later lesson in greater detail. 
A new Payment is created every second.
 
4.1 Run the BillBuddyPaymentFeeder using Intellij: 
1.   Use the same instructions as used for the BillBuddyAccountFeeder.
2.   Another option is to run/deploy it from the GS command line:<br>
    `cd $GS_HOME/bin`<br>
    `./gs.sh pu deploy BillBuddyPaymentFeeder ~/gs-dev-training/lab04-deploy_complete_example-guide/BillBuddyPaymentFeeder/target/BillBuddyPaymentFeeder.jar`<br>

4.2 Validate Payments were written to the space using gs-ui. 
You may choose to view Payment Objects using the Query operation of gs-ui.
 
4.3 Go to the statistics operation and see that a payment is actually added every second.
You might be required to modify the sample rate and start the automatic refresh.

![Screenshot](./Pictures/Picture3.png)

4.4 Go to the Data Types view under Operations. Which object counts are increasing?

## 5 Deploy BillBuddyWebApplication project

5.1 Open a new Terminal and navigate to `$GS_HOME/bin`

5.2 Use the Gigaspaces CLI to deploy BillBuddyWebApplication
 
    ./gs.sh pu deploy --property=web.port=8082 BillBuddyWebApplication ~/gs-dev-training/lab04-deploy_complete_example-guide/BillBuddyWebApplication/target/BillBuddyWebApplication.war

5.3 Validate the application is deployed. 
Go to Deployed Processing Units tab and expand the BillBuddyWebApplication PU.

![Screenshot](./Pictures/Picture4.png)

5.4 The URL is for the application home page URL. 
Click on it and get to the application. 

![Screenshot](./Pictures/Picture5.png)

5.5 Congratulations, you have deployed the BillBuddy web application. 
Navigate through the application pages and investigate it.
