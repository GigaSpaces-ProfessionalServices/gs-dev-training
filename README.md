# xap-dev-training - lab5-solution


## 5.1	Deploy BillBuddy-Space using cli.


a. Find your host name by running hostname command.
b. Go to %XAP_TRAINING_HOME%/gigaspaces-xap/bin/
c. Edit setenv-overrides.sh and put your host name as a value to XAP_MANAGER_SERVERS parameter. e.g: <br />
    export XAP_MANAGER_SERVERS=<your host name>

d. Start gs-agent with one GSM, one LUS and 2 GSCs. e.g: <br />
./xap host run-agent --manager --gsc=2 <br />
e.	Start gs-ui. e.g: ./gs-ui.sh <br />
f. Deploy BillBuddy_Space. e.g: <br />
    1. Clone lab5-solution repository by creating dir: %XAP_TRAINING_HOME%/labs/lab5-solution and typing: git clone <br /> https://github.com/GigaSpaces-ProfessionalServices/xap-dev-training.git
        xap-dev-training project will be created. <br />
    2. Open xap-dev-training project with intellij <br />
    3. Run mvn install <br />
    4. Run mvn xap:intellij. This will add the predefined Run Configuration Application to your Intellij IDE. <br />
    5. Open a new Terminal and go to %XAP_TRAINING_HOME%/gigaspaces-xap/bin/ <br />
    5. Deploy BillBuddy_Space by running ./xap pu deploy BillBuddy-Space %XAP_TRAINING_HOME%/labs/lab5-solution/xap-dev-training/BillBuddy_Space/target/BillBuddy_Space.jar <br />
    6. Run BillBuddyAccountFeeder from your Intellij.

    ![Screenshot](Picture1.png)
    ![Optional Text](http://Picture1.png)
    ![stack Overflow](http://lmsotfy.com/so.png)
    <img src="Picture1.png" alt="My cool logo"/>
