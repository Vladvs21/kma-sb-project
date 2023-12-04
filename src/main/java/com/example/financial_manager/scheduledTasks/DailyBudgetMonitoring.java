package com.example.financial_manager.scheduledTasks;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.financial_manager.FinanceManager;
import com.example.financial_manager.FinancialManagerApplication;

@Component
public class DailyBudgetMonitoring {

    @Scheduled(cron = "0 0 0 * * *") // every day at 00:00:00
    public void run() {
        var context = SpringApplication.run(FinancialManagerApplication.class);
        FinanceManager financeManager = context.getBean(FinanceManager.class);

		System.out.println("Budget: " + financeManager.calculateBudget()); // send info notification to client
    }

}
