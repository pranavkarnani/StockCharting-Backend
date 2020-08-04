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
@Table(name = "COMPANY")

public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	private String companyname;
	private String turnover;
	private String ceo;
	private String boardofdirectors;
	private String stockid;
	private String sectorid;
	private String disc;
}
