package com.invoicify.Invoices.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {
	@Id
	@GeneratedValue(generator = "company_sequence_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name="company_sequence_id", sequenceName="company_sequence_id")
	private int id;
	private String name; 
	
	@OneToMany(mappedBy = "company", cascade=CascadeType.ALL)
	private List<Invoice>invoice;

	public Company() {}
	
	public Company(String name) {
		this.name = name;
	}
	
	public Company(String name, List<Invoice>invoice) {
		this.name = name;
		this.invoice = invoice; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(List<Invoice> invoice) {
		this.invoice = invoice;
	}
	
	
	}
