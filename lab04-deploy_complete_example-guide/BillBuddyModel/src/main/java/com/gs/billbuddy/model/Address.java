package com.gs.billbuddy.model;

import java.io.Serializable;

import javax.persistence.Embeddable;




/** 
* Address class is a POJO which has user address information 
* 
* @author gsUniversity
*/ 
@Embeddable
@SuppressWarnings("serial")
public class Address implements Serializable{
	 
	private String street;
	private String city;
	private String state;
	private CountryNames country;
	private Integer zipCode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public CountryNames getCountry() {
		return country;
	}
	public void setCountry(CountryNames country) {
		this.country = country;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	
}