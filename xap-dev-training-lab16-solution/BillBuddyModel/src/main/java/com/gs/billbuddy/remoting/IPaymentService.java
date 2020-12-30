package com.gs.billbuddy.remoting;

import com.gs.billbuddy.model.CategoryType;
import com.gs.billbuddy.model.Payment;

/** 
* IPaymentService Interface. 
*  
* Define method which will be executed by remoting on top of the space & will be returning Payments
* 
* @author gsUniversity
*/

public interface IPaymentService {
  
	public Payment[] findTop5PaymentsPerCategory(CategoryType categoryType);
 
}
