package com.invoicify.Invoices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicify.Invoices.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Integer> {
	
	//find by id for controller
	List<BillingRecord> findById(int[] recordId);

}
