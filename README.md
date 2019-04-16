# xap-dev-training - lab4-guide

## 4	Application Level Components

###### Lab Goals 
•	Be introduced and experienced Grid Service Components <br>
•	Deploy, test and Un-deploy Grid Service Components (In-Memory-Data-Grid) <br>
•	Experience the self-healing capability of the space <br>

###### Lab Description
In this lab you will start XAP infrastructure services. Deploy a Space, perform some benchmarks using a benchmark tool that will test your space and undeploy the space. You will perform most actions using command line or the “GigaSpace` Management Console" service 
(a.k.a. gs-ui). You will also try to check the self-healing capabilities of the space by stopping a GSC and see how XAP heals itself.

## 4.1	Start XAP Infrastructure

a.	Go to%XAP_TRAINING_HOME%\gigaspaces-xap\bin <br>
b.	Start gs-agent <br>
c.	Start gs-ui <br>
d.	Press on the gsc processes to see the process information and log. <br>

![Screenshot](./Pictures/Picture1.png)

## 4.2	Deploy an In Memory Data Grid
a.	Use the “Deploy an In Memory Data Grid” option in the menu (see top left red arrow in the diagram below) <br>
*   the 'deploy data grid' is also available from the menu -> launch <br>
 
b.	A Deployment Wizard screen will open

![Screenshot](./Pictures/Picture2.png)

c.	Fill in the fields as follows (see red arrows for locations)

![Screenshot](./Pictures/Picture3.png)

d.	Press the Deploy button. The following should be the status of the deployment wizard after all deployments are done:

![Screenshot](./Pictures/Picture4.png)

e.	Press the close button

f.	Examine the space “Deployed Processing Unit” tab

*   Identify the primary and backup partitions

![Screenshot](./Pictures/Picture5.png)

g.	Examine the “Space Browser” tab

Hint: use the table in the Service View Tab.

![Screenshot](./Pictures/Picture6.png)

h.	Examine which space instance is located on which GSC?

![Screenshot](./Pictures/Picture7.png)


