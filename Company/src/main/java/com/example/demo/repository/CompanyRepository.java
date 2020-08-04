package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Company;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    public List<Company> findByCompNameContaining(String name);
    public List<Company> findBySectorContaining(String sector);
    public List<Company> findByStockExchangeContaining(String se);
}
