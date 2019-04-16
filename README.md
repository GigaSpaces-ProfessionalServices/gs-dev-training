# xap-dev-training - lab1-guide

## 1	Introduction

#### 1.1 setup

##### 1.1.1 Download 14.2.0 XAP Commercial Edition and extract it on you machine.
##### 1.1.2 Add relevant license to `xap-license.txt` file located at the root of xap insllation directory.
##### 1.1.3 Download IntelliJ IDEA Community:
   https://www.jetbrains.com/idea/download
##### 1.1.4 Go to `$XAP_HOME/bin` open `setenv-overrides.sh` and set: <br>
   `JAVA_HOME` -> point to you java installation directory <br>
   `XAP_LOOKUP_GROUPS` -> set any unique identifier
   
##### 1.1.5 Test your XAP Installation. <br>
   You will start a XAP process (gs-agent) and you will wait to see a message that the gs-agent started successfully with groups [<your user group>]
   
   cd ${XAP_TRAINING_HOME}/gigaspaces-xap/bin 
   ./gs-agent.sh
   
   The following screen will appear:
   (Search for the message marked below):
   
![Screenshot](./Pictures/Picture1.png)
   
   If you see the above, you have successfully installed the courseware for our class.
   
##### 1.1.5	Stop processes
    a.	Stop the gs-agent process

#### 1.2	Wiki and API Doc Exercise  

##### 1.2.1 Validate internet connectivity by opening a browser and going to GigaSpace site: 
        www.gigaspaces.com
##### 1.2.2 Click on support-> Documents

![Screenshot](./Pictures/Picture2.png)


![Screenshot](./Pictures/Picture3.png)        

   
   
