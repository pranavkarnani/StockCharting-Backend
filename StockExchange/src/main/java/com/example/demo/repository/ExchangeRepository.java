package com.example.demo.repository;

import com.example.demo.model.StockExchange;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends CrudRepository<StockExchange, Long> {
    public List<StockExchange> findByStockExchange(String name);
}
