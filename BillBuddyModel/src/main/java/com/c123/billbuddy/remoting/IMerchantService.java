package com.c123.billbuddy.remoting;

import org.openspaces.remoting.Routing;

import com.c123.billbuddy.model.Merchant;


/** 
* IServiceFinder Interface. 
*  
* Define method which will be executed by remoting on top of the space
* 
* @author 123Completed
*/

public interface IMerchantService {
  
	Double getMerchantProfit(@Routing("getMerchantAccountId") Merchant merchant);

	// Other option for Routing on remoting call
	//	Double getMerchantProfit(@Routing Integer merchantAccountId);
    
}
