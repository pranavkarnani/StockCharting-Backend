package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Company;

import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService companyservice;

	@GetMapping("/")
	public List<Company> getCompanies(){
		return companyservice.getAllCompany();
	}
	
	@PostMapping("/add")
	public void addCompany(@RequestBody Company company) {
		companyservice.saveCompany(company);
	}

	@PutMapping("/update")
	public HttpStatus updateCompany(@RequestBody Company company) {
		return companyservice.updateCompany(company)  ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteCompany(@PathVariable Long id) {
		companyservice.deleteCompany(id);
		return HttpStatus.NO_CONTENT;
	}

	@GetMapping("/{id}")
	public Optional<Company> getCompany(@PathVariable Long id) {
		return companyservice.getById(id);
	}

	@GetMapping("/sector/{sector}")
	public List<Company> getCompanyFromSector(@PathVariable String sector) throws Exception {
		return companyservice.getCompanyFromSector(sector);
	}

	@GetMapping("/exchange/{exchange}")
	public List<Company> getCompanyFromExchange(@PathVariable String exchange) throws Exception {
		return companyservice.getCompanyFromStockExchange(exchange);
	}

	@GetMapping("/matching/{query}")
	public List<Company> getCompanyFromPattern(@PathVariable String query) throws Exception {
		return companyservice.getCompanyFromPattern(query);
	}
}
