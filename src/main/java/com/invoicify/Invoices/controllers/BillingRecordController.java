package com.invoicify.Invoices.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.invoicify.Invoices.models.BillingRecord;
import com.invoicify.Invoices.repositories.BillingRecordRepository;

@Controller
public class BillingRecordController {
		
	@Autowired
	private BillingRecordRepository billingRecordRepo;
	
	//Default Constructor
	public BillingRecordController() {}
	
	//Method to return all Billing Records in the database
	public List<BillingRecord> list() {
		List<BillingRecord> billingRecords = new ArrayList<BillingRecord>();
		billingRecords = billingRecordRepo.findAll();
		return billingRecords;
	}
	
}
