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
@Table(name = "IPO_DETAILS")
public class Ipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ipoId;
	private String companyName;
	private String stockExchange;
	private Long pricePerShare;
	private Long noOfShares ;
	private String openDateTime;
	private String remarks;
}
