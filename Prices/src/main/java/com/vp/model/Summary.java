package com.vp.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Summary {
	private LocalDate toDate;
	private LocalDate fromDate;
	private int noOfRecord;
	private String stockExchange;
}
