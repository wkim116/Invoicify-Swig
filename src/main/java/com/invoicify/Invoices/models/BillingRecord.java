package com.invoicify.Invoices.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="billing_records")
public abstract class BillingRecord {
	
	@Id
    @GeneratedValue
    private int id;
	
	protected Date createdOn;
	protected String description;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="billingRecord")
	protected InvoiceLineItem lineItem;
	
	@ManyToOne
	protected Company company;
	
	@ManyToOne
	protected String createdBy;
	
	public BillingRecord() {};
	
	public BillingRecord( Date createdOn, String description, InvoiceLineItem lineItem, Company company, String createdBy) {
		this.createdOn = createdOn;
		this.description = description;
		this.lineItem = lineItem;
		this.company = company;
		this.createdBy = createdBy;
	}
	
	abstract double getTotal();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InvoiceLineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(InvoiceLineItem lineItem) {
		this.lineItem = lineItem;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
