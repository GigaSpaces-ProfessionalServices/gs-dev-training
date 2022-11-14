# xap-dev-training

Before you start please verify that you have on your machine the following:<br>
1. `Git`
2. `Maven`
3. `Intellij`

If you don't have please install.

Go to the location where you want xap dev content to be stored and perform the following:<br>
`git clone https://github.com/GigaSpaces-ProfessionalServices/xap-dev-training.git`

From here forward please follow the trainer instructions.<br>
In general the course is based on hands-on (exercise labs) which you need to perform one by one according to their order. <br>
Completing the exercises is with high importance in order to get the relevant knowledge and experience to be able to use XAP.
 
## Following are the list of labs:

* Lab1 - Introduction
* Lab2 - XAP Overview
* Lab3 - Grid Service Components
* Lab4 - Application Level Components
* Lab5 - The Bill Buddy Application
* Lab6 - My First XAP Application
* Lab7 - Processing Unit
* Lab8 - Space Classes and Data Model
* Lab9 - Spring Introduction
* Lab10 - Space Access API
* Lab11 - Advance Space Access API (Change API)
* Lab12 - Aggregations
* Lab13 - Messaging and Event Containers
* Lab14 - Transactions
* Lab15 - Task Executors
* Lab16 - Space Based Remoting
* Lab17 - Persistency – Mirror Service
* Lab18 - Web Applications
* Lab19 - zipkin

##### Note 1 - Maven:

Maven versions &gt; 3.8 won't connect to non-https repos by default. Below is a workaround.

In ~/.m2/settings.xml, (if it doesn't exist, copy it from &lt;maven install directory&gt;/conf/settings.xml)

Add:
```xml
<mirror>
  <id>maven-default-http-blocker</id>
  <mirrorOf>external:http:*</mirrorOf>
  <name>Pseudo repository to mirror external repositories intially using HTTP.</name>
  <url>http://maven-repository.openspaces.org</url>
</mirror>
```
(There is already a section mirror. Modify the url and and comment out or remove blocked=true)

##### Note 2 - Downloading Gigaspaces jars:

Some corporate networks do not allow connecting directly to external Maven repositories. In this case, run:

`$GS_HOME/bin/gs maven install`

This will copy the GigaSpaces jars (bundled with your installation) to your local .m2 Maven repository.
