package com.invoicify.Invoices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.invoicify.Invoices.models.RateBasedBillingRecord;
import com.invoicify.Invoices.repositories.BillingRecordRepository;

@Controller
public class RateBasedBillingController {

	@Autowired
	private BillingRecordRepository rbBillingRecordRepo;
	
	//Default constructor
	public void RateBasedBillingRecord() {}
	
	
	//method to create a new Rate Based Billing Record and save it in the database
	public RateBasedBillingRecord create(){
		RateBasedBillingRecord rbBillingRecord = new RateBasedBillingRecord();
		rbBillingRecordRepo.save(rbBillingRecord);
		return rbBillingRecord;
	}
	
}

