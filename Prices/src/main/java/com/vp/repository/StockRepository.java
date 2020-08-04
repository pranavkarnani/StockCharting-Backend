package com.vp.repository;

import org.springframework.data.repository.CrudRepository;

import com.vp.model.StockData;

public interface StockRepository extends CrudRepository<StockData, Long>{

}
