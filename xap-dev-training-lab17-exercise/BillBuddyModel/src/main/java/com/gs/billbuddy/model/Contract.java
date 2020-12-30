package com.gs.billbuddy.model;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@SuppressWarnings("serial")
@SpaceClass
public class Contract implements Serializable {
	@Id
	private String id;
	private Integer merchantAccountId;
	private Date contractDate;	
	private Double  transactionPrecentFee;
	
	@SpaceId(autoGenerate = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@SpaceRouting
	public Integer getMerchantAccountId() {
		return merchantAccountId;
	}

	public void setMerchantAccountId(Integer merchantAccountId) {
		this.merchantAccountId = merchantAccountId;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Double getTransactionPrecentFee() {
		return transactionPrecentFee;
	}

	public void setTransactionPrecentFee(Double transactionPrecentFee) {
		this.transactionPrecentFee = transactionPrecentFee;
	}


}
