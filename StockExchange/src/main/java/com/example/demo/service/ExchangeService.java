package com.example.demo.service;
import java.util.List;

import com.example.demo.model.StockExchange;
import com.example.demo.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExchangeService {

	@Autowired
	ExchangeRepository exchangeRepository;

	public List<StockExchange> getAllExchanges(){
		return (List<StockExchange>) exchangeRepository.findAll();
	}

	public List<StockExchange> getAllExchangesByName(String name){
		return (List<StockExchange>) exchangeRepository.findByStockExchange(name);
	}

	public StockExchange getExchangeById(Long id){
		return (StockExchange) exchangeRepository.findById(id).get();
	}

	public StockExchange deleteExchange(Long id) {
		StockExchange stock = exchangeRepository.findById(id).get();
		exchangeRepository.deleteById(id);
		return stock;
	}
	
	public void saveExchange(StockExchange stock) {
		exchangeRepository.save(stock);
	}
}