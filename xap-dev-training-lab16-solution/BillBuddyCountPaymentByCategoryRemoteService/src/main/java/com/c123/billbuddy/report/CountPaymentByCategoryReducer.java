package com.c123.billbuddy.report;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.remoting.RemoteResultReducer;
import org.openspaces.remoting.SpaceRemotingInvocation;
import org.openspaces.remoting.SpaceRemotingResult;

/** 
* CountPaymentByCategoryReducer class. 
*  
* Reduce the results from findPaymentCountByCategory method which is executed to the space
* 
* Returns Integer of the count of payments per category 
* 
* @author 123Completed
*/

public class CountPaymentByCategoryReducer implements RemoteResultReducer<Integer, Integer> {

	private final Log log = LogFactory.getLog(CountPaymentByCategoryReducer.class);

    public Integer reduce(SpaceRemotingResult<Integer>[] results,
        SpaceRemotingInvocation remotingInvocation) throws Exception {
    	
    	log.info("Starting CountPaymentByCategoryReducer");
    	int totalCountOfPayments=0;
    	
        // Each result is an array of events. Each result is from a single partition. 
    	
        for (SpaceRemotingResult<Integer> result : results) {
            if (result.getException() != null) {
            	
                // just log the fact that there was an exception
            	
                log.error("Executor Remoting Exception [" + result.getException() + "]");

                continue;
            }
            totalCountOfPayments+=result.getResult();
        }

    	return totalCountOfPayments;       
      
    }
}
