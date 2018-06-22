package com.invoicify.Invoices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicify.Invoices.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
