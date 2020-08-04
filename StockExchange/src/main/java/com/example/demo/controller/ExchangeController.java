package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.StockExchange;
import com.example.demo.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/exchange")
public class ExchangeController {

	@Autowired
	ExchangeService exchangeService;

	@GetMapping("/")
	public List<StockExchange> getExchanges(){
		return exchangeService.getAllExchanges();
	}

	@GetMapping("/{name}")
	public List<StockExchange> getExchangeByName(@PathVariable String name){
		return exchangeService.getAllExchangesByName(name);
	}

	@GetMapping("/{id}")
	public StockExchange getExchangeById(@PathVariable Long id){
		return exchangeService.getExchangeById(id);
	}
	
	@PostMapping("/add")
	public void addStockExchange(@RequestBody StockExchange stock) {
		exchangeService.saveExchange(stock);
	}

	@DeleteMapping("/{id}")
	public StockExchange deleteStockExchange(@PathVariable Long id) {
		return exchangeService.deleteExchange(id);
	}
}
