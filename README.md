# xap-dev-training - lab5-solution


## 5.1	Start gs-agent and gs-ui 

5.1.1 Find your host name by running hostname command. <br />
5.1.2 Go to %XAP_TRAINING_HOME%/gigaspaces-xap/bin/ <br />
5.1.3 Edit setenv-overrides.sh and put your host name as a value to XAP_MANAGER_SERVERS parameter. e.g: <br />
    export XAP_MANAGER_SERVERS=<your host name> <br />
5.1.4 Start gs-agent with one GSM, one LUS and 2 GSCs. e.g: <br />
./xap host run-agent --manager --gsc=2 <br />
5.1.5 Start gs-ui. e.g: ./gs-ui.sh <br />
    
## 5.2	Deploy BillBuddy_Space

5.2.1 Clone lab5-solution repository by creating dir: %XAP_TRAINING_HOME%/labs/lab5-solution and typing: git clone <br /> https://github.com/GigaSpaces-ProfessionalServices/xap-dev-training.git <br />
xap-dev-training project will be created. <br />
5.2.2 Open xap-dev-training project with intellij <br />
5.2.3 Run mvn install <br />
5.2.4 Run mvn xap:intellij. This will add the predefined Run Configuration Application to your Intellij IDE. <br />
5.2.5 Open a new Terminal and go to %XAP_TRAINING_HOME%/gigaspaces-xap/bin/ <br />
5.2.6 Execute ./xap pu deploy BillBuddy-Space %XAP_TRAINING_HOME%/labs/lab5-solution/xap-dev-training/BillBuddy_Space/target/BillBuddy_Space.jar <br />

## 5.3	Run BillBuddyAccountFeeder from Intellij

5.3.1 From the Intellij run configuration select BillBuddyAccountFeeder
 

    ![Screenshot](Picture1.png)
    ![Optional Text](http://Picture1.png)
    ![stack Overflow](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png)
    <img src="Picture1.png" alt="My cool logo"/>
