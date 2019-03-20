# xap-dev-training - lab7-exercise

## 7 Processing Unit

###### Lab Goals
1. Configure your processing unit for space deployment.
2. Deploy a space in several different methods. 

###### Lab Description
This lab includes two exercises:
1. 	Configure your processing unit space definitions & deployment rules
2. 	Space Deployment Methods. You will deploy a space Processing Unit via 2 different methods.

###### Lab setup
Make sure you restart gs-agent and gs-ui (or at least undeploy all Processing Units using gs-ui)

7.1.1 Create dir: %XAP_TRAINING_HOME%/labs/lab7-exercise

    mkdir /Users/yuval/XAPDevTraining/labs/lab7-exercise

7.1.2 Navigate to lab7-exercise dir

    cd /Users/yuval/XAPDevTraining/labs/lab7-exercise

7.1.3 Clone the git project

    git clone https://github.com/GigaSpaces-ProfessionalServices/xap-dev-training.git

7.1.4 Checkout lab7-exercise

    cd xap-dev-training
    git checkout lab7-exercise
    
7.1.5 Verify that the branch has been checked out.

    yuval-pc:xap-dev-training yuval$ git branch
    * lab7-exercise
      master
               
7.1.6 Open xap-dev-training project with intellij <br />
7.1.7 Run mvn install

    yuval-pc:xap-dev-training yuval$ mvn install
    
    [INFO] ------------------------------------------------------------------------
    [INFO] Reactor Summary:
    [INFO] 
    [INFO] Lab7-exercise 1.0-SNAPSHOT ......................... SUCCESS [  1.547 s]
    [INFO] BillBuddyModel ..................................... SUCCESS [  7.115 s]
    [INFO] BillBuddy_Space .................................... SUCCESS [  0.893 s]
    [INFO] BillBuddyAccountFeeder 1.0-SNAPSHOT ................ SUCCESS [  1.604 s]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS


7.1.8 Run mvn xap:intellij.
###### This will add the predefined Run Configuration Application to your Intellij IDE.

    yuval-pc:xap-dev-training yuval$ mvn xap:intellij
    
    [INFO] ------------------------------------------------------------------------
    [INFO] Reactor Summary:
    [INFO] 
    [INFO] Lab7-exercise 1.0-SNAPSHOT ......................... SUCCESS [  2.099 s]
    [INFO] BillBuddyModel ..................................... SKIPPED
    [INFO] BillBuddy_Space .................................... SKIPPED
    [INFO] BillBuddyAccountFeeder 1.0-SNAPSHOT ................ SKIPPED
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS


## 7.2	Space Topologies
7.2.1 Configure space in the pu.xml files in BillBuddy_Space project <br />
a. Define embedded space. <br />
b. Define GigaSapce. <br />

7.2.2	Configure Partitioned Space (2 partitions) in the sla.xml file as 1 backup per each partition in the BillBuddy_Space project. 

## 7.3  Deploy a PU with Embedded Space – Integrated Processing Unit Container
7.3.1   The Integrated Processing Unit Container is the preferred way to 
deploy Processing Unit during development. <br />
a. Stop gs-agent (you are not deploying to the grid in this lab) if one is running. <br /> 
This is not a must but it will emphasize the fact 
that you are running your PU without the need of the GRID. <br />
b.	Re-open gs-ui (close if it is running and start again). 
Make sure no Space is deployed (you might need to Un-deploy your previously deployed space from prior labs) <br />
c.	Go to Intellij “run configurations” and choose the BillBuddy_Space. As you can see the main class used is the org.openspaces.pu.container.integrated.IntegratedProcessingUnitContainer class.

###### Note: the pictures are Eclipse snapshots but refers to Intellij as well.
![Screenshot](./Pictures/Picture1.png)

d.	Press run. <br />
e.	Where do you see the space in gs-ui? <br /> 
    Can you guess why you can see it only there? <br /> 
f.	Check if your space is deployed in the “space browser” tab. <br /> 
    You can only see the space in the space browser since you did not deploy your PU to the Grid <vr />
    but used integrated processing unit container, so, no GSCs are deployed with your PU. <br /> 
    The integrated processing unit container does not use the sla.xml configuration. <br />
    It just deploys a simple single space instance.
    
![Screenshot](./Pictures/Picture2.png)

g.	Check the “Deployed Processing Unit” tab to see that the Grid does not know about your space.

![Screenshot](./Pictures/Picture3.png)

7.3.2   Run the BillBuddyAccountFeeder (main class UserFeederActivator) application 
        and check Users are written to the space. 
        
## 7.4	Deploy a PU with Embedded Space to the Grid
7.4.1	Deploy the space to the grid service. <br />
a.  Start gs-agent and gs-ui (if they are not already running). <br />
7.4.2	Make sure no Space is deployed (you might need to Un-deploy your pre-deployed space from prior labs).

7.4.3	Deploy the space using gs-ui. <br />
a.	Choose “Deploy Application” option:

![Screenshot](./Pictures/Picture4.png)

b.	Choose “Deploy Application” option. <br />
c.  Browse to %XAP_TRAINING_HOME%/labs/lab7-exercise/xap-dev-training/BillBuddy_Space/target/BillBuddy_Space.jar <br />
    and press deploy

![Screenshot](./Pictures/Picture5.png)

d.	Wait until deployment completes. <br />
e.	Run the BillBuddyAccountFeeder application and check Users are written to the space.