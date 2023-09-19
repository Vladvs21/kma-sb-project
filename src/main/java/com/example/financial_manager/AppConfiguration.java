package com.example.financial_manager;

import com.example.financial_manager.components.ExpenseManagerImpl;
import com.example.financial_manager.components.IncomeManagerImpl;
import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.managers.IncomeManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public ExpenseManager expenseManager(){
        return new ExpenseManagerImpl();
    }

    @Bean
    public IncomeManager incomeManager(){
        return new IncomeManagerImpl();
    }
    @Bean
    public FinanceManager financeManager() {
        return new FinanceManager(expenseManager(),incomeManager());
    }
}
