package com.invoicify.Invoices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicify.Invoices.models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

}
