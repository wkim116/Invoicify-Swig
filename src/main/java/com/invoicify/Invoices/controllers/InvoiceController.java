package com.invoicify.Invoices.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.invoicify.Invoices.models.BillingRecord;
import com.invoicify.Invoices.models.Invoice;
import com.invoicify.Invoices.models.InvoiceLineItem;
import com.invoicify.Invoices.models.InvoiceView;
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
	@PostMapping("{clientId}")
	public Invoice createInvoice(@RequestBody InvoiceView invoiceView, @PathVariable long clientId) {
		List<BillingRecord> records = recordRepository.findByIdIn(invoiceView.getRecordIds());
		long nowish = Calendar.getInstance().getTimeInMillis();
		Date now = new Date(nowish);
		Invoice invoice = new Invoice();
		invoice.setInvoiceDescription(invoiceView.getInvoiceDescription());
		
		List<InvoiceLineItem> items = new ArrayList<InvoiceLineItem>();
		for (BillingRecord record : records) {
			InvoiceLineItem lineItem = new InvoiceLineItem();
			lineItem.setBillingRecord(record);
			lineItem.setCreatedOn(now);
			lineItem.setInvoice(invoice);
			items.add(lineItem);
		}
		
		invoice.setLineItems(items);
		invoice.setCreatedOn(now);
		invoice.setCompany(companyRepository.findOne(clientId));
		
		return invoiceRepo.save(invoice);
	}
	

}
