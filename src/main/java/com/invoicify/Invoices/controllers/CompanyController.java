package com.invoicify.Invoices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicify.Invoices.models.Company;
import com.invoicify.Invoices.repositories.CompanyRepository;


@RestController 
@RequestMapping("/api/company")
public class CompanyController {
  @Autowired
  private CompanyRepository companyRepo;

  public CompanyController(CompanyRepository companyRepo) {
    this.companyRepo = companyRepo;
    
  }

  // Get a list of companies that currently exist
  @GetMapping("")
  public List<Company> getAll() {
    return companyRepo.findAll();
  }

  // Get a Company based on its id
  @GetMapping("{id}")
  public Company getOne(@PathVariable int id) {
    return companyRepo.findOne(id);
  }

  // Create a company
  @PostMapping("")
  public Company create(@RequestBody Company company) {
    return companyRepo.save(company);
  }

  // Update a company given its id and the Company provided
  @PutMapping("{id}")
  public Company update(@RequestBody Company company, @PathVariable int id) {
    company.setId(id);
    return companyRepo.save(company);
  }

  // Delete a company given its id
  @DeleteMapping("{id}")
  public Boolean delete(@PathVariable int id) {
    Company company = companyRepo.findOne(id);
    Boolean deleted = false;
    
    if(company != null) {
    	companyRepo.delete(id);
    	deleted = true;
    }

    return deleted;
  }
  
}