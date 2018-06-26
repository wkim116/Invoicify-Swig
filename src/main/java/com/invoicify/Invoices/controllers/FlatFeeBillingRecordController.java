package com.invoicify.Invoices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicify.Invoices.models.Company;
import com.invoicify.Invoices.models.FlatFeeBillingRecord;
import com.invoicify.Invoices.models.User;
import com.invoicify.Invoices.repositories.BillingRecordRepository;
import com.invoicify.Invoices.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/billing-record/flat-fee")
public class FlatFeeBillingRecordController {
	
	@Autowired
	private BillingRecordRepository BillingRecordRepo;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private BillingRecordRepository billingRepository;
	
	
	
	//Default Constructor
	public FlatFeeBillingRecordController() {}
	
	
	// Post Mapping API to create a FlatFeeBillingRecord given a clientid
	@PostMapping("{clientId}")
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord record, @PathVariable int clientId, Authentication auth) {
		User user = (User) auth.getPrincipal();
		Company client = companyRepository.findOne(clientId);
		record.setCompany(client);
		record.setCreatedBy(user);
		return billingRepository.save(record);
	} 
 

	
	

}
