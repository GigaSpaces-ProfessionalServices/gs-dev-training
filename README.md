# xap-dev-training - lab3-guide


## 3    Grid Service Components

###### Lab Goals
*   Be introduced and experienced Grid Service Components

###### Lab Description
In this lab you will start XAP infrastructure services. Inspect the runtime grid in the GS-UI.

3.1.1	Start XAP Infrastructure <br>

    a.	Go to %XAP_TRAINING_HOME%\gigaspaces-xap\bin
    b.	Start gs-agent
    c.	Start gs-ui
    
3.1.2	Examine the running environment <br>

    a.	Examine the ‘gs-agent.log’ Check the GSM and GSCs have started and registered successfully 

![Screenshot](./Pictures/Picture1.png)

    b.	Go to the gs-ui application
    c.	Press the host tab
    d.	Press on the gsc processes to see the process information and log.

![Screenshot](./Pictures/Picture2.png)

3.2	Self-Healing

In this exercise you will be introduced to the self-healing capabilities of the In Memory Data Grid. <br>
Basically we will ‘kill’ (using task manager or kill -9) a GSC process and see that it restarts automatically by the gs-agent and that new partition are created accordingly <br>

3.2.1	Kill a GSC <br>

Each process ID (all are JVMS) is shown at the Hosts tab (see red circle below). <br>
Choose 1 of the GSCs PID and use the Task Manager or in order to kill the process. <br>
If PID is not shown at the Task Manager simply choose “viewselect columns” and add the PID column. <br>
For Linux use: kill -9 <PID>

![Screenshot](./Pictures/Picture3.png)

3.2.2	Return to the gs-ui in order to check the recovery status.

3.2.3	The following is the Self-Healing processes <br>

    a. GSC was re-launched by gs-agent
    
![Screenshot](./Pictures/Picture4.png) 

3.2.4	Stop the runtime grid <br>

    a.	Press on the GSA
    b.	Right click to open GSA menu
    c.	Select shutdown
    
![Screenshot](./Pictures/Picture5.png) 


