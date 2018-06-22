package com.invoicify.Invoices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicify.Invoices.models.InvoiceLineItem;

public interface InvoiceLineItemRepository extends JpaRepository<InvoiceLineItem, Integer>{

}
