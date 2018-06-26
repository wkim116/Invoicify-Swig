package com.invoicify.Invoices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicify.Invoices.models.RateBasedBillingRecord;
import com.invoicify.Invoices.repositories.BillingRecordRepository;

@RestController
@RequestMapping("/api/billing-record/rate-based/")
public class RateBasedBillingController {

	@Autowired
	private BillingRecordRepository rbBillingRecordRepo;
	
	//Default constructor
	public void RateBasedBillingRecord() {}
	
	
	//method to create a new Rate Based Billing Record and save it in the database
	@PostMapping("{clientId}")
	public RateBasedBillingRecord create(){
		RateBasedBillingRecord rbBillingRecord = new RateBasedBillingRecord();
		rbBillingRecordRepo.save(rbBillingRecord);
		return rbBillingRecord;
	}
	
}

