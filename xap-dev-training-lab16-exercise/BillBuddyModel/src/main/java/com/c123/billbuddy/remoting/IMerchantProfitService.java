package com.c123.billbuddy.remoting;

import org.openspaces.remoting.Routing;


/** 
* IMerchantProfitService Interface. 
*  
* Define method which will be executed by remoting on top of the space
* 
* @author 123Completed
*/

public interface IMerchantProfitService{

	// Other option for Routing on remoting call  
	Double getMerchantProfit(@Routing Integer merchantAccountId);

}
