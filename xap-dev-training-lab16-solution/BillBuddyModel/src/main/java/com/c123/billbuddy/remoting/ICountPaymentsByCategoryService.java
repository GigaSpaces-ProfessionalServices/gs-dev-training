package com.c123.billbuddy.remoting;

import com.c123.billbuddy.model.CategoryType;


/** 
* ICountPaymentsByCategoryService Interface. 
*  
* Define method which will be executed by remoting to the space
* 
* @author 123Completed
*/

public interface ICountPaymentsByCategoryService{
  
    int findPaymentCountByCategory(CategoryType categoryType);
}
