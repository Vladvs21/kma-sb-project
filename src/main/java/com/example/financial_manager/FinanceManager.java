package com.example.financial_manager;

import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager.services.CurrencyApiService;
import com.example.financial_manager.services.CurrencyRates;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FinanceManager {
    private final ExpenseManager expenseManager;
    private final IncomeManager incomeManager;
    private static final Logger logger = LoggerFactory.getLogger(FinanceManager.class);

    @Value("${currency.default}")
    private String currency;

    public double calculateBudget(Long userId) {
        MDC.put("currency", currency);
        double totalExpenses = expenseManager.calculateTotalExpenses(userId);
        double totalIncome = incomeManager.calculateTotalIncome(userId);
        logger.info("Calculating budget for currency: {}", currency);
        MDC.remove("currency");
        return totalIncome - totalExpenses;
    }
}