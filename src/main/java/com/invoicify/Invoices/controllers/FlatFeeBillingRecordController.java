package com.invoicify.Invoices.controllers;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.invoicify.Invoices.models.FlatFeeBillingRecord;
import com.invoicify.Invoices.repositories.BillingRecordRepository;
import com.invoicify.Invoices.repositories.CompanyRepository;

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
	@PostMapping("{clientId}")
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord record, @PathVariable long clientId, Authentication auth) {
		User user = (User) auth.getPrincipal();
		company client = CompanyRepository.findOne(clientId);
		record.setClient(client);
		record.setCreatedBy(user);
		BillingRecordRepo.save(record);

		return BillingRecordRepo.save(record);
	}
}
