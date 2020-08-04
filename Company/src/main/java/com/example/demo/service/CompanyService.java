package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Company;

import com.example.demo.repository.CompanyRepository;

@Service
@Transactional
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public List<Company> getAllCompany(){
		return (List<Company>) companyRepository.findAll();
	}
	
	public void saveCompany(Company company) {
		companyRepository.save(company);
	}

	@Transactional
	public boolean updateCompany(Company person) {
		return companyRepository.save(person) != null;
	}

	@Transactional
	public void deleteCompany(Long personId) {
		companyRepository.deleteById(personId);
	}

	@Transactional
	public Optional<Company> getById(Long id) {
		return companyRepository.findById(id);
	}

	public List<Company> getCompanyFromPattern(String compName) throws Exception {
		List<Company> listCompanyEntity = companyRepository.findByCompNameContaining(compName);
		return listCompanyEntity;
	}

	public List<Company> getCompanyFromSector(String sector) throws Exception {
		List<Company> listCompanyEntity = companyRepository.findBySectorContaining(sector);
		return listCompanyEntity;
	}

	public List<Company> getCompanyFromStockExchange(String se) throws Exception {
		List<Company> listCompanyEntity = companyRepository.findByStockExchangeContaining(se);
		return listCompanyEntity;
	}
}
