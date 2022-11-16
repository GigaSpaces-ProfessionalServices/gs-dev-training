package com.gs.example.model;

import java.io.Serializable;

public class User implements Serializable {
    
	private static final long serialVersionUID = 6972241659127067400L;
	private Integer userAccountId;
    private String name;
    private Double balance;
    private Integer creditLimit;

    
    public User(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }
    
    public User(Integer userAccountId, String name, Double balance, Integer creditLimit) {
        this.userAccountId = userAccountId;
        this.name = name;
        this.balance = balance;
        this.creditLimit = creditLimit; 
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
	
	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}

	
	public Integer getCreditLimit() {
		return creditLimit;
	}
	
	public String toString(){
		return "User account #: " + this.getUserAccountId() +
		" Name: "+ this.getName() +
		" Balance: " + this.getBalance() +
		" Credit Limit: " + this.getCreditLimit();
	}



}
