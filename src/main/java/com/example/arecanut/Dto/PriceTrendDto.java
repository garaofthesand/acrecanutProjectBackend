package com.example.arecanut.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PriceTrendDto(LocalDate period, BigDecimal avgPrice) {
	
}