package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "STOCK_EXCHANGE")
public class StockExchange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long exchangeId;
	private String stockExchange;
	private String brief;
	private String address;
	private String remark;
}
