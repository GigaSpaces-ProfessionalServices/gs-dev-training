# gs-dev-training - lab08-spring_intro-solution

## 9 Spring Introduction

###### Lab Goals
Experience Spring Framework in order to understand Open Spaces framework and API.
###### Lab Description
This solution will demonstrate the same application developed 3 times each using a different method:
1.	A traditional Java application
2.	A Spring XML based application
3.	A Spring Annotations based application
You will explore the first 2 applications and code the 3rd application.
## 1 Lab setup
Make sure you restart the service grid and gs-ui (or at least undeploy all Processing Units using gs-ui)
               
1.1 Open gs-dev-training/lab08-spring_intro-solution project with intellij (open pom.xml) <br />
1.2 Run mvn package

    ~/gs-dev-training/lab08-spring_intro-solution$ mvn package
    
       [INFO] ------------------------------------------------------------------------
       [INFO] Reactor Summary:
       [INFO] 
       [INFO] lab08-solution 1.0-SNAPSHOT ......................... SUCCESS [  1.624 s]
       [INFO] BillBuddy_Space .................................... SUCCESS [  8.323 s]
       [INFO] BillBuddy_Space .................................... SUCCESS [  0.680 s]
       [INFO] Traditional_Java 1.0-SNAPSHOT ...................... SUCCESS [  2.176 s]
       [INFO] ------------------------------------------------------------------------
       [INFO] BUILD SUCCESS

1.3 Copy the runConfigurations directory to the Intellij .idea directory to enable the Java Application configurations. Restart Intellij.
###### This will add the predefined Run Configuration Application to your Intellij IDE.

Make sure you have a C:\temp directory on your computer. <br />
In case you do not have it will create the file inside Temp folder in your Traditional_Java folder. <br />
Notice the 3 projects; each is named according to the method type. <br />
Use the slides in order to recap the application design.  

## 2	Standard Java application
a.	Examine the classes and code of the application. <br />
    Especially examine the relationship between the classes. <br />
b.	Run the class com.gs.nospring.example.TraditionalMain in the Traditional_Java folder. <br />
c.	Check the output file (location is printed in the Intellij console) <br /> 
## 3	Spring XML based application
a.	Examine the classes and code of the application in the Spring_Xml folder. <br />
Validate you understand the wiring code and bean lifecycle processing by Spring. <br />
    Especially examine: <br />
a.	springContext.xml <br /> 
b.	com.gs.spring.example.SpringMain <br />
b.	Run the class com.gs.spring.example.SpringMain <br />
c.	Check the output file (location is printed in the Intellij console) <br /> 
d.	If you still feel confused. Use Intellij Debugger to get a better 
    understanding of the application flow. <br />
## 4	Spring Annotations based application
In this lab you are required to fix several files in the application
in order to utilize Spring Annotations. <br />
The following are the list of tasks required for you to do: <br />
a.	Edit the springContextAnnotations.xml file in the Spring Annotations folder and add 
<context:component-scan…> for required missing packages. <br />
b.	Edit com.gs.springAnnotations.example.DAL.FileObjectWriter 
    and fix all missing annotations (Hint: Search for “//TODO:”) <br />
c.	Edit com.gs.springAnnotations.example.UserGenerator 
    and fix all missing annotations (Hint: Search for “//TODO:” <br />
d.	Run com.gs.springAnnotations.example.SpringAnnotationsMain <br />
e.	Check the output file (location is printed in the Intellij console) <br />
f.	You might be required to add import statements for supporting the added annotation.
