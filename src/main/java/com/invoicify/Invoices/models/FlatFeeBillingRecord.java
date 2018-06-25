package com.invoicify.Invoices.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name="flat_fee_billing_records")
public class FlatFeeBillingRecord extends BillingRecord {
	
	public FlatFeeBillingRecord(Date creationDate, String description, InvoiceLineItem lineItem, Company company, String createdBy){
		super(creationDate, description, lineItem, company, createdBy);
	}
	
	int amount;
	
	public FlatFeeBillingRecord() {};
	
	public FlatFeeBillingRecord(Date creationDate, String description, InvoiceLineItem lineItem, Company company, String createdBy, int amount){
		super(creationDate, description, lineItem, company, createdBy);
		this.amount = amount;
	}
	
	@Override
	double getTotal() {
		return amount;
	}

}
