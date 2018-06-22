package com.invoicify.Invoices.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.invoicify.Invoices.models.Invoice;
import com.invoicify.Invoices.repositories.InvoiceRepository;

@Controller
public class InvoiceController {
	
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	// Default Constructor
	public InvoiceController() {}
	
	// Return all the current invoices
	public List<Invoice> list() {
		List<Invoice> invoices = new ArrayList<Invoice>();
		invoices = invoiceRepo.findAll();
		
		return invoices;
	}
	
	

}
