package com.invoicify.Invoices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.invoicify.Invoices.models.FlatFeeBillingRecord;
import com.invoicify.Invoices.repositories.BillingRecordRepository;

@Controller
public class FlatFeeBillingRecordController {
	
	@Autowired
	private BillingRecordRepository BillingRecordRepo;
	
	//Default Constructor
	public FlatFeeBillingRecordController() {}
	
	//Create method
	public FlatFeeBillingRecord create() {
		FlatFeeBillingRecord flatFeeBillingRecord = new FlatFeeBillingRecord();
		return flatFeeBillingRecord;
	}

}
