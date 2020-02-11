package com.c123.billbuddy.remoting;

import com.c123.billbuddy.model.CategoryType;
import com.c123.billbuddy.model.Payment;

/** 
* IPaymentService Interface. 
*  
* Define method which will be executed by remoting on top of the space
* 
* @author 123Completed
*/

public interface IPaymentService {
  
	// Payment[] findTop10Payments();
	public Payment[] findTop5PaymentsPerCategory(CategoryType categoryType);
 
}
