package com.example.arecanut.projectors;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PriceTrendProjection {

    LocalDate getPeriod();
    BigDecimal getAvgPrice();
}