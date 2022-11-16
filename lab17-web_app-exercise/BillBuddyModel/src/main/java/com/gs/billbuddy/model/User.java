package com.gs.billbuddy.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;



/** 
* User class is a POJO which has user account information 
* 
* @author gsUniversity
*/

@Entity
@Table
@SuppressWarnings("serial")
@SpaceClass
public class User implements Serializable{
	@Id
	private Integer userAccountId;
    private String name;
    @Embedded
    @AttributeOverrides( {
    	@AttributeOverride(name="street", column = @Column(name="Address_street") ),
    	@AttributeOverride(name="city", column = @Column(name="Address_city") ),
    	@AttributeOverride(name="state", column = @Column(name="Address_state") ),
    	@AttributeOverride(name="country", column = @Column(name="Address_country") ),
    	@AttributeOverride(name="zipCode", column = @Column(name="Address_zipCode") )
    	} )
    private Address address;
    private Double balance;
    private Double creditLimit;
    private AccountStatus status;
    
    public User(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }

    public User() {
    }

    @SpaceId(autoGenerate = false)
    @SpaceRouting
    public Integer getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }

	public void setName(String name) {
		this.name = name;
	}
	
	@SpaceIndex(type=SpaceIndexType.BASIC)
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

	@SpaceIndex(type=SpaceIndexType.EXTENDED)
	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}
}
