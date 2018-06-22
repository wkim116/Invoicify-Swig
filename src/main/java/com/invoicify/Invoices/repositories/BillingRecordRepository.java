package com.invoicify.Invoices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicify.Invoices.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Integer> {

}
