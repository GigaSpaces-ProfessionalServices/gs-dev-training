# xap-dev-training - lab6-exercise

## 6 My First XAP Application

###### Lab Goals
1.	Experience XAP client code and see how easy it is to develop a XAP simple application
2.	Deploy a space using XAP CLI

###### Lab Description

This Description will let you examine simple code applications that access the space and write/read users. 
Two applications will be used, both using standard Java (no Spring).
You will first deploy a space using the XAP CLI to serve as your space, 
afterwards you will run the 2 applications and examine the results.
The first application will connect and write a single users. 
The second application “AccountFeeder” will create and write multiple user POJOs
and read all of them in a single readMultiple command.
###### Lab setup
Make sure you restart gs-agent and gs-ui (or at least undeploy all Processing Units using gs-ui)

6.1.1 Create dir: %XAP_TRAINING_HOME%/labs/lab6-exercise

    mkdir /Users/yuval/XAPDevTraining/labs/lab6-exercise

6.1.2 Navigate to lab6-exercise dir

    cd /Users/yuval/XAPDevTraining/labs/lab6-exercise

6.1.3 Clone the git project

    git clone https://github.com/GigaSpaces-ProfessionalServices/xap-dev-training.git

6.1.4 Checkout lab6-exercise

    cd xap-dev-training
    git checkout lab6-exercise
    
6.1.5 Verify that the branch has been checked out.

    yuval-pc:xap-dev-training yuval$ git branch
    * lab6-exercise
      master
               
6.1.6 Open xap-dev-training project with intellij <br />
6.1.7 Run mvn install

    yuval-pc:xap-dev-training yuval$ mvn install
    
    [INFO] ------------------------------------------------------------------------
    [INFO] Reactor Summary:
    [INFO] 
    [INFO] Lab6-exercise 1.0-SNAPSHOT ......................... SUCCESS [  1.033 s]
    [INFO] BillBuddyUserFeeder 1.0-SNAPSHOT ................... SUCCESS [  7.597 s]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

6.1.8 Run mvn xap:intellij
###### This will add the predefined Run Configuration Application to your Intellij IDE.

    yuval-pc:xap-dev-training yuval$ mvn xap:intellij
    
     ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 3.216 s
    [INFO] Finished at: 2019-03-19T18:42:47+02:00
    ------------------------------------------------------------------------

## 6.2  Deploy BillBuddy_Space

6.2.1 Open a new Terminal and navigate to %XAP_TRAINING_HOME%/gigaspaces-xap/bin/ <br />

    cd /Users/yuval/XAPDevTraining/gigaspaces-xap/bin
    
6.2.2 Use XAP CLI to deploy BillBuddy_space

    ./xap space deploy --partitions=2 --ha=true BillBuddy-space

## 6.3	Run User Feeder Using Configurer
6.2.1 Examine and run the com.c123.billbuddy.client.SingleUserFeeder file. <br /> 
a.	Locate the code fragment in which you get a proxy to the space. <br /> 
b.	Edit the SingleUserFeedercreatenewSpaceProxyConfigurer to connect to remote space – BillBuddy-space. <br /> 
###### HINT: look for the TODO& follow the instructions <br />
c.	Examine the code that writes a User to the space <br />
d.	Examine the code that reads a User from the space <br />
e.	Execute the project in Intellij to run user into the space

###### Note: the pictures are Eclipse snapshots but refers to Intellij as well.

![Screenshot](./Pictures/Picture1.png)
![Screenshot](./Pictures/Picture2.png)

## 6.4	Run User Feeder
###### Examine and run the com.c123.billbuddy.client.AccountFeeder. <br />
6.4.1 Check the UserFeeder.loadData() method. <br />
6.4.2 Open run configuration options in Intellij. <br />
6.4.3	Execute the AccountFeeder