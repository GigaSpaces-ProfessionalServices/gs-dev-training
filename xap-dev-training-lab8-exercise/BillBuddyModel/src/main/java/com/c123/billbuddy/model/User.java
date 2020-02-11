package com.c123.billbuddy.model;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;



/** 
* User class is a POJO which has user account information 
* 
* @author 123Completed
*/

//TODO: Add missing space class annotations per the exercise.

@SpaceClass
public class User {

	private Integer userAccountId;
    private String name;
    
    private Double balance;
    private Double creditLimit;
    private AccountStatus status;
    
    // TODO: Add Address class as data member + getter & setter methods.
    
    public User(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }

    public User() {
    }


    public Integer getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }

	public void setName(String name) {
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}


	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public AccountStatus getStatus() {
		return status;
	}

	
}
