package com.invoicify.Invoices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicify.Invoices.models.Company;
import com.invoicify.Invoices.models.RateBasedBillingRecord;
import com.invoicify.Invoices.models.User;
import com.invoicify.Invoices.repositories.BillingRecordRepository;
import com.invoicify.Invoices.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/billing-record/rate-based")
public class RateBasedBillingController {

	
	@Autowired
	private BillingRecordRepository billingRecordRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	public void RateBasedBillingRecordController(BillingRecordRepository billingRecordRepo, CompanyRepository companyRepo) {
		this.billingRecordRepo = billingRecordRepo;
		this.companyRepo = companyRepo;
}
	
	//Default constructor
	public void RateBasedBillingRecord() {}
	
	
	//method to create a new Rate Based Billing Record and save it in the database
	@PostMapping("{clientId}")
	public RateBasedBillingRecord create(@PathVariable int clientId, @RequestBody RateBasedBillingRecord rateBasedBillingRecord, Authentication auth){
		User user = (User) auth.getPrincipal();
		Company client = companyRepo.findOne(clientId);
		rateBasedBillingRecord.setCompany(client);
		rateBasedBillingRecord.setCreatedBy(user);
		return billingRecordRepo.save(rateBasedBillingRecord);
	}
	
}

