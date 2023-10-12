package com.example.financial_manager;

import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.managers.IncomeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FinanceManager {
    private final ExpenseManager expenseManager;
    private final IncomeManager incomeManager;
    private static final Logger logger = LoggerFactory.getLogger(FinanceManager.class);

    @Value("${currency.default}")
    private String currency;

    @Autowired
    public FinanceManager(ExpenseManager expenseManager, IncomeManager incomeManager) {
        this.expenseManager = expenseManager;
        this.incomeManager = incomeManager;
    }

    public double calculateBudget() {
        double totalExpenses = expenseManager.calculateTotalExpenses();
        double totalIncome = incomeManager.calculateTotalIncome();
        logger.info(currency);
        //System.out.println("FinanceManager currency: " + currency);
        return totalIncome - totalExpenses;
    }
}