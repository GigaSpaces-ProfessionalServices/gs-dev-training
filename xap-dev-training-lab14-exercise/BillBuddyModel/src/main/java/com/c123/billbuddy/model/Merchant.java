package com.c123.billbuddy.model;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;


/** 
* Merchant class is a POJO which has merchant account information 
* 
* @author 123Completed
*/

@SpaceClass
public class Merchant {

	private Integer merchantAccountId;
    private String name;
    private Double receipts;
    private Double feeAmount;
    private CategoryType category;
    private AccountStatus status;
    
    
    public Merchant(Integer merchantAccountId) {
        this.merchantAccountId = merchantAccountId;
    }

    public Merchant() {
    }

    @SpaceId(autoGenerate = false)
    @SpaceRouting
    public Integer getMerchantAccountId() {
        return merchantAccountId;
    }

    public void setMerchantAccountId(Integer merchantAccountId) {
        this.merchantAccountId = merchantAccountId;
    }

	public void setName(String name) {
		this.name = name;
	}
	
	@SpaceIndex(type=SpaceIndexType.BASIC)
	public String getName() {
		return name;
	}

	public CategoryType getCategory() {
		
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}


	public void setReceipts(Double receipts) {
		this.receipts = receipts;
	}

	public Double getReceipts() {
		return receipts;
	}

	public void setFeeAmount(Double feeAmount) {
		this.feeAmount = feeAmount;
	}

	public Double getFeeAmount() {
		return feeAmount;
	}

}
