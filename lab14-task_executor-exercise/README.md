# gs-dev-training - lab14-task_executor-exercise

## 	Task Executors

###### Lab Goals
1.  Experience developing Distributed Task Executors.
2.  Understand routing for tasks (non-distributed).
###### Lab Description
This lab includes3 exercises:
1. 	Execute and investigate a Distributed Task Executor
2.	Develop a Distributed Task Executor
3. 	Implement Routing for a Task Executor
## 1 Lab setup
Make sure you restart the service grid and gs-ui (or at least undeploy all Processing Units using gs-ui)

**1.1** Open gs-dev-training/lab14-task_executor-exercise project with intellij (open pom.xml)<br>
**1.2** Run mvn package

    ~/gs-dev-training/lab14-task_executor-exercise$ mvn package
    
    [INFO] ------------------------------------------------------------------------
    [INFO] Reactor Summary:
    [INFO] 
    [INFO] BillBuddyModel ..................................... SUCCESS [  2.804 s]
    [INFO] BillBuddy_Space .................................... SUCCESS [  1.153 s]
    [INFO] BillBuddyAccountFeeder ............................. SUCCESS [  1.265 s]
    [INFO] BillBuddyPaymentFeeder ............................. SUCCESS [  1.054 s]
    [INFO] lab14-exercise 1.0-SNAPSHOT ........................ SUCCESS [  0.017 s]
    [INFO] BillBuddyCountPaymentsByCategoryDistributedExecutor  SUCCESS [  0.991 s]
    [INFO] BillBuddyCurrentProfitDistributedExecutor .......... SUCCESS [  0.839 s]
    [INFO] BillBuddyMerchantGetUserIdTaskExecutor 1.0-SNAPSHOT  SUCCESS [  1.080 s]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS



**1.3** Copy the runConfigurations directory to the Intellij .idea directory to enable the Java Application configurations. Restart Intellij.
###### This will add the predefined Run Configuration Application to your Intellij IDE.

## 2	Execute and investigate a Distributed Task Executor
In this exercise we will execute a Distributed Task Executor. 
For this purpose we will deploy our Space PU to the Grid Service, 
explore the POJOs of each Space Instance (Partition) and see the Task in action.
BillBuddy requires a service that will count all payments of a specific Category.
Merchants are distributed over the space partitions and Category is a Merchant class property. 
Our distributed task will:
*   Query all merchant of a specific category and then count 
    the number of payments for each merchant.
*   Return the total count for its partition (sum of all counts) to the reducer.
*   The Reducer should sum all results from all partitions getting the 
    total count of payments in a specific category.
    
**2.1**	Deploy your space to the grid service. 
        Start the service grid and use gs-ui to deploy your Space PU Jar. <br />
**2.2**	Run the AccountFeeder. <br />
**2.3**	Run the PaymentFeeder. <br />
**2.4**	Examine each partition of the space and see the Merchants POJO distribution. <br /> 
Hint: use the Space Browser tab of gs-ui. 
Notice how we examine a specific partition in the snapshot below.
Specifically notice how the Merchant Categories are distributed.

![Screenshot](./Pictures/Picture1.png)

**2.5**	Expand the BillBuddyCountPaymentsByCategoryDistributedExecutor project 
        and examine the files: <br />

    CountPaymentsByCategoryFinder
    CountPaymentsByCategoryTask

BillBuddy provides the user with a search utility aimed at assisting 
in finding the count of Payments that were executed in a specific category. 
The task searches for all merchants of a specific category, 
counts all their payments and returns payment count for a specific category 
as a return value.

**2.6**	Run the BillBuddyCountPaymentsByCategoryDistributedExecutor 
        using the Integrated Processing Unit Container (Hint: Intellij Run option). <br /> 
**2.7**	Check to see what results are retrieved from the space.

## 3	Develop a Distributed Task Executor

BillBuddy requires querying the space for its total revenue. 
BillBuddy total revenue is calculated as follows: <br />
Sum of all ProcessingFee amounts in the space. <br /> 

In this exercise you will implement this distributed task. <br /> 
You should create a task that returns the sum of all ee amounts in each partition
and reduce the result to a total sum which represents the current profit of BillBuddy.
You can use the previous distributed task example as a reference.  

**3.1**	Expand the BillBuddyCurrentProfitDistributedExecutor project and examine the files: 

        ProcessServiceAmountFinder
        ProcessServiceAmountTask
        
**3.2**	Develop the Distributed Task, (search for all //TODO: comments). <br />
Your execute method will sum the feeAmount property of the Merchant space class in each partition. <br /> 
The reducer will sum all results from all partitions. <br /> 
**3.3**	Add a log.info(); command to the task execute()command. 
Your command should print the return value (Total fee amount per partition) to the log). 
You will should see the print in the each of the GSCs. <br />
**3.4**	Test your Task <br />
a.	Deploy your space to the grid service. <br />
b.	Run the AccountFeeder. <br />
c.	Run the PaymentFeeder. <br />
d.	Run BillBuddyCurrentProfitDistributedExecutor. <br />
e.	Check the console log of the service grid or the gsc logs of the partitions (Hint: gs-ui hosts tab) 
    to see your message “Hello” is printed in both partitions and 
    ensure that the task is actually being distributed to multiple partitions.

## 4	Implement Routing for a Task Executor

BillBuddy requires querying all user IDs of a specific Merchant. 
For this purpose a developer developed a Task named “Merchant Get User Id”. <br />
Unfortunately the developer does not remember that the task
should be routed according to the Merchant Id. You will have to complete this task for him. <br />
**4.1**	Expand the BillBuddyMerchantGetUserIdTaskExecutor  project and examine the files. <br /> 
**4.2**	Locate the //TODO comment and implement the missing code (Hint: Routing Method). 
Do not forget to annotate accordingly. <br />
**4.3**	You may choose to use any other routing method in your solution. <br />
**4.4**	Run and test your code. <br />
