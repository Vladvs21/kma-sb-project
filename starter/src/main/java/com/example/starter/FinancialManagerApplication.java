package com.example.starter;

import com.example.starter.components.ExpenseManagerImpl;
import com.example.starter.components.IncomeManagerImpl;
import com.example.starter.managers.ExpenseManager;
import com.example.starter.managers.IncomeManager;
import com.example.starter.wrappers.Expense;
import com.example.starter.wrappers.Income;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class FinancialManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialManagerApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

		Expense expense = new Expense(100, "Products");
		Expense expense2 = new Expense(200, "Games");

		Income income = new Income("Salary", 1000);

		IncomeManager incomeManager = context.getBean("incomeManager", IncomeManagerImpl.class);
		ExpenseManager expenseManager = context.getBean("expenseManager", ExpenseManagerImpl.class);

		incomeManager.addIncome(income);
		expenseManager.addExpense(expense);
		expenseManager.addExpense(expense2);

		FinanceManager financeManager = context.getBean("financeManager", FinanceManager.class);

		System.out.println(financeManager.calculateBudget());
	}

}
