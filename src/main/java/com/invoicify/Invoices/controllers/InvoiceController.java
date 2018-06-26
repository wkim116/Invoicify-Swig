package com.invoicify.Invoices.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicify.Invoices.models.BillingRecord;
import com.invoicify.Invoices.models.Invoice;
import com.invoicify.Invoices.models.InvoiceLineItem;
import com.invoicify.Invoices.models.InvoiceView;
import com.invoicify.Invoices.models.User;
import com.invoicify.Invoices.repositories.BillingRecordRepository;
import com.invoicify.Invoices.repositories.CompanyRepository;
import com.invoicify.Invoices.repositories.InvoiceRepository;

//Rest controller for the /api/invoice url
@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private BillingRecordRepository billingRepository;
	
	
	public InvoiceController(InvoiceRepository invoiceRepo) {
		this.invoiceRepository = invoiceRepo;
	}
	
	//Get a list of all the invoices in the invoice repo
	@GetMapping
	public List<Invoice> list() {
		return invoiceRepository.findAll();
}
	//Create a new invoice for the user based on the client Id
	@PostMapping("{clientId}")
	public Invoice createInvoice(@RequestBody InvoiceView invoiceView, @PathVariable int clientId, Authentication auth) {
		//gather any existing invoices
		List<BillingRecord> records = billingRepository.findByIdIn(invoiceView.getRecordIds());
		User user = (User) auth.getPrincipal();
		long currTime = Calendar.getInstance().getTimeInMillis();
		Date now = new Date(currTime);
		Invoice invoice = new Invoice();
		invoice.setInvoiceDescription(invoiceView.getInvoiceDescription());
		Set<InvoiceLineItem> items = new HashSet<InvoiceLineItem>();

		//populate the line items for the invoice, based on the Id found earlier
		for (BillingRecord record : records) {
			InvoiceLineItem lineItem = new InvoiceLineItem();
			lineItem.setBillingRecord(record);
			lineItem.setCreatedOn(now);
			lineItem.setCreatedBy(user);
			lineItem.setInvoice(invoice);
			items.add(lineItem);
		}
		
	    //Return/save the invoice populated with line items in the repository
		invoice.setLineItems(items);
		invoice.setCreatedOn(now);
		invoice.setCreatedBy(user);
		invoice.setCompany(companyRepository.findOne(clientId));
		return invoiceRepository.save(invoice);
	}
}
	


