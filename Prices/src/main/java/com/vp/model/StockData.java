package com.vp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="STOCKDATA")
public class StockData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
    private String companyCode;
    private String stockExchange;
    private double pricePerShare;
    private LocalDate date;
    private LocalTime time;
}
