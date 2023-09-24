package com.example.starter;

import com.example.starter.components.ExpenseManagerImpl;
import com.example.starter.components.IncomeManagerImpl;
import com.example.starter.managers.ExpenseManager;
import com.example.starter.managers.IncomeManager;
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
