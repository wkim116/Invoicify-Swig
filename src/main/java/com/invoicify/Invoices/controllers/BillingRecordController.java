package com.invoicify.Invoices.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicify.Invoices.models.BillingRecord;
import com.invoicify.Invoices.repositories.BillingRecordRepository;

@RestController
@RequestMapping("/api/billing-record")
public class BillingRecordController {

	@Autowired
	private BillingRecordRepository billingRepository;

	  BillingRecordController(BillingRecordRepository billingRepository) {
	    this.billingRepository = billingRepository;
	  }
	
	//Get a list of all the invoices in the invoice repo
		@GetMapping
		public List<BillingRecord> list() {
			return billingRepository.findAll();
		}
}