package com.invoicify.Invoices.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name="rate_based_billing_records")
public class RateBasedBillingRecord extends BillingRecord {

	public RateBasedBillingRecord(Date creationDate, String description, InvoiceLineItem lineItem, Company company, String createdBy){
		super(creationDate, description, lineItem, company, createdBy);
	}
	
	private int rate;
	private int quantity;
	
	public RateBasedBillingRecord() {};
	
	public RateBasedBillingRecord(Date creationDate, String description, InvoiceLineItem lineItem, Company company, String createdBy, int rate, int quantity){
		super(creationDate, description, lineItem, company, createdBy);
		this.rate = rate;
		this.quantity = quantity;
	}
	
	
	@Override
	double getTotal() {
		
		return rate*quantity;
	}


	public int getRate() {
		return rate;
	}


	public void setRate(int rate) {
		this.rate = rate;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
