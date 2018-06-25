package com.invoicify.Invoices.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Invoice")

public class Invoice {
	
	@Id
	@GeneratedValue
	
	private int id; 
	private Date createdOn;
	private String invoiceDescription; 
	
	@OneToMany(mappedBy="invoice", cascade=CascadeType.ALL)
	private List<InvoiceLineItem> lineItems; 
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private String createdBy;
	
	public Invoice () {}
	
	public Invoice (Date createdOn, String invoiceDescription,List <InvoiceLineItem> lineItems, Company company) {
		this.createdOn = createdOn;
		this.invoiceDescription = invoiceDescription;
		this.lineItems = lineItems; 
		this.company = company;
	}

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

	public List<InvoiceLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<InvoiceLineItem> items) {
		this.lineItems = items;
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
