package com.invoicify.Invoices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.invoicify.Invoices.models.Company;
import com.invoicify.Invoices.repositories.CompanyRepository;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	public CompanyController() {
		
	}
	
	// CREATE
	// Create a new company and save it to the repository.
	public void create(String name) {
		Company company = new Company(name);
		companyRepo.save(company);
	}
	
	// READ
	// Get a company given id and return it.
	public Company read(int id) {
		return companyRepo.findOne(id);
	}
	
	// UPDATE
	// Update a company given id with the new parameters. 
	// Return that company afterwards.
	public Company update(int id, String newName) {
		Company company = companyRepo.findOne(id);
		company.setName(newName);
		companyRepo.save(company);
		return company;
	}
	
	// DELETE
	// Delete a company given id and return that company
	public Company delete(int id) {
		Company company = companyRepo.findOne(id);
		companyRepo.delete(id);
		return company;
	}

}
