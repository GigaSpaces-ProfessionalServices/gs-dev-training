# gs-dev-training

Before you start please verify that you have on your machine the following:

1. `JDK` - Oracle JDK or OpenJDK, preferably version 11.
1. `Maven`
1. `Intellij` - this is the preferred Java IDE, although other IDEs will work.
1. `Git` (optional)

If you don't have please install.

Go to the location where you want lab content to be stored and perform the following:

`git clone https://github.com/GigaSpaces-ProfessionalServices/gs-dev-training.git`

Or:

Download the zip frem this repository and extract it, preferably to your home directory.

In general the course is based on hands-on exercises/labs which you will need to perform one by one according to their order. Completing the exercises is of high importance in order to get the relevant knowledge and experience with Gigaspaces.
 
## Labs

 * Lab 00 Setup
 * Lab 01 Intro to UI
 * Lab 03 Intro to Deployment
 * Lab 04 Deploy Complete Example
 * Lab 05 First GS Application
 * Lab 06 Processing Unit Intro
 * Lab 07 Spaceclass Intro
 * Lab 08 Spring Intro
 * Lab 09 Gigaspaces Core Api
 * Lab 10 Additional Api
 * Lab 11 Aggregations
 * Lab 12 Event Processing
 * Lab 13 Transactions
 * Lab 14 Task Executor
 * Lab 15 Space Based Remoting
 * Lab 16 Persistency
 * Lab 17 Web App

##### Note 1 - Maven

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
(There is already a section mirror. Modify the url and comment out or remove blocked=true)

##### Note 2 - Downloading Gigaspaces jars

Some corporate networks do not allow connecting directly to external Maven repositories. In this case, run:

`$GS_HOME/bin/gs maven install`

This will copy the GigaSpaces jars (bundled with your installation) to your local .m2 Maven repository.

##### Note 3 - runConfigurations

Many labs will have an instruction to 'Copy the runConfigurations directory to the .idea folder to enable the Java Application configurations.'

The accompanying lab folder will have a runConfigurations directory containing xml files. These are example configurations to run a Java Program from within Intellij. Copy the entire runConfigurations folder into the Intellij .idea folder (the .idea folder gets created when you open the Maven project in Intellj). You will then need to restart Intellij.

You can also set the environment variables used by Intellij. Go to Settings | Appearance & Behavior | Path Variables.

![Intellij environment variables](./Pictures/Picture1.png)

##### Note 4 - Oshi
If Oshi related errors prevent Gigaspaces from starting, you can disable Oshi by setting in the `bin/setenv-overrides, export GS_OPTIONS_EXT="-Dcom.gs.oshi.enabled=false"`

##### Note 5 - The Gigaspaces processes don't appear under Hosts tab
In the `bin/setenv-overrides, export GS_OPTIONS_EXT="-Djava.net.preferIPv4Stack=true"`

##### Note 6 - java.lang.UnsatisfiedLinkError with JNA on Mac
java.lang.UnsatisfiedLinkError on Mac with JNA error. Download the latest jna jar. Replace the lib/optional/oshi/jna.jar with the new jar (remove version from jna.jar). JNA is used to provide host machine information displayed in GigaSpaces.
