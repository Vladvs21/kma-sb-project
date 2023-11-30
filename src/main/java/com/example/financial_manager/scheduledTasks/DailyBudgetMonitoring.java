package com.example.financial_manager.scheduledTasks;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.financial_manager.FinanceManager;
import com.example.financial_manager.FinancialManagerApplication;

@Component
@AllArgsConstructor
public class DailyBudgetMonitoring {

    private final ApplicationContext applicationContext;
    @Scheduled(cron = "0 0 0 * * *") // every day at 00:00:00
    public void run() {
        FinanceManager financeManager = applicationContext.getBean(FinanceManager.class);

		System.out.println("Budget: " + financeManager.calculateBudget()); // send info notification to client
    }

}
