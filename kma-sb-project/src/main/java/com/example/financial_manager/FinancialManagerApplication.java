package com.example.financial_manager;

import com.example.financial_manager.components.ExpenseManagerImpl;
import com.example.financial_manager.components.IncomeManagerImpl;
import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager.wrappers.Expense;
import com.example.financial_manager.wrappers.Income;
import com.example.financial_manager_starter.services.UserInfoService;
import com.example.financial_manager_starter.services.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class FinancialManagerApplication implements CommandLineRunner {

	@Autowired
	UserInfoService userInfoService;
	public static void main(String[] args) {
		SpringApplication.run(FinancialManagerApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

		Expense expense = new Expense(100, "Products");
		Expense expense2 = new Expense(200, "Games");

		Income income = new Income("Salary", 1000);

		IncomeManager incomeManager = context.getBean(IncomeManagerImpl.class);
		ExpenseManager expenseManager = context.getBean("expenseManager", ExpenseManagerImpl.class);

		incomeManager.addIncome(income);
		expenseManager.addExpense(expense);
		expenseManager.addExpense(expense2);

		FinanceManager financeManager = context.getBean("financeManager", FinanceManager.class);

		System.out.println("Balance: "+financeManager.calculateBudget());
		System.out.println("Income manager currency: "+incomeManager.getCurrency());

//		UserInfoService userInfoService1 = context.getBean(UserInfoService.class);
//		userInfoService1.printUserInfo();
	}

	@Override
	public void run(String... args) throws Exception {
		userInfoService.printUserInfo();
	}
}
