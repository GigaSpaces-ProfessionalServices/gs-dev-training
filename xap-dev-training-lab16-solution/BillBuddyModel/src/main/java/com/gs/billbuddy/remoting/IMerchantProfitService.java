package com.gs.billbuddy.remoting;

import org.openspaces.remoting.Routing;


/** 
* IMerchantProfitService Interface. 
*  
* Define method which will be executed by remoting on top of the space
* 
* @author gsUniversity
*/

public interface IMerchantProfitService{

	// Other option for Routing on remoting call  
	Double getMerchantProfit(@Routing Integer merchantAccountId);

	
}
