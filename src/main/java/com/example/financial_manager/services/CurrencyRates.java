package com.example.financial_manager.services;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class CurrencyRates {
    private Map<String, Double> rates;
    private String base;
    private LocalDate date;
}
