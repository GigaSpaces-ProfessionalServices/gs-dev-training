# xap-dev-training - lab7-exercise


Temp Instructions for testing:

1. open Intelij

2. create new project from existing Version Control. Git Repository URL:https://github.com/GigaSpaces-ProfessionalServices/xap-dev-training.git

3. Make it maven project by clicking the parent pom.xml

4. from the project directory run "mvn xap:intellij"

5. Set the Project SDK

6. Set the IDE Profile (Maven Projects -> Profiles)

7. Add XAP_LOOKUP_GROUPS & XAP_LOOKUP_LOCATORS in the InteliJ path variable.

8. Install BillBuddyCurrentProfit.jar in your local repository by running this command (change <your_user>):
mvn install:install-file -Dfile=/Users/<your_user>/_XAPDevTraining/labs/Lab_5-BillBuddy_Application/solution/BillBuddyWebApplication/webapp/WEB-INF/lib/BillBuddyCurrentProfit.jar -DgroupId=com.gigaspaces.dev.training -DartifactId=BillBuddyCurrentProfit -Dversion=1.0-SNAPSHOT -Dpackaging=compile
