package com.invoicify.Invoices.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name="flat_fee_billing_records")
public class FlatFeeBillingRecord extends BillingRecord {
	
	public FlatFeeBillingRecord(Date creationDate, String description, InvoiceLineItem lineItem, Company company){
		super(creationDate, description, lineItem, company);
	}
	
	int amount;
	
	public FlatFeeBillingRecord() {};
	
	public FlatFeeBillingRecord(Date creationDate, String description, InvoiceLineItem lineItem, Company company, int amount){
		super(creationDate, description, lineItem, company);
		this.amount = amount;
	}
	
	@Override
	double getTotal() {
		return amount;
	}

}
