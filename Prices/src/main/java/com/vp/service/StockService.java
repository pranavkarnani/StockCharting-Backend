package com.vp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vp.model.StockData;
import com.vp.repository.StockRepository;

@Service
@Transactional
public class StockService {
	@Autowired
	StockRepository stockRepository;
	
	public void saveStock(StockData stockData) {
		stockRepository.save(stockData);
	}
	
	public List<StockData> getAllStockData(){
		return (List<StockData>) stockRepository.findAll();
	}
}
