package com.invoicify.Invoices.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Invoice")

public class Invoice {
	
	@Id
	@GeneratedValue
	
	private int id; 
	private Date createdOn;
	private String invoiceDescription; 
	
	@OneToMany(mappedBy="invoice", cascade=CascadeType.ALL)
	private Set<InvoiceLineItem> lineItems; 
	
	@JsonIgnore
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private User createdBy;
	
	public Invoice () {}
	

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

	public String getInvoiceDescription() {
		return invoiceDescription;
	}

	public void setInvoiceDescription(String invoiceDescription) {
		this.invoiceDescription = invoiceDescription;
	}

	public Set<InvoiceLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<InvoiceLineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	

}
