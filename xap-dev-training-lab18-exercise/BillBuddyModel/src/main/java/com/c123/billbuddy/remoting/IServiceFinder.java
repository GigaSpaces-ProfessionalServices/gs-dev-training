package com.c123.billbuddy.remoting;

import com.c123.billbuddy.model.Merchant;
import com.c123.billbuddy.model.Payment;
import com.c123.billbuddy.model.ProcessingFee;


/** 
* IServiceFinder Interface. 
*  
* Define method which will be executed by remoting on top of the space
* 
* @author 123Completed
*/

public interface IServiceFinder {
  
	Payment[] findTop10Payments();
    
    Merchant[] findTop5MerchantFeeAmount();
    
    ProcessingFee[] findTop10ProcessingFees();
}
