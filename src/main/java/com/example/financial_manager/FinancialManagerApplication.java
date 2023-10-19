package com.example.financial_manager;

import com.example.financial_manager.components.ExpenseManagerImpl;
import com.example.financial_manager.components.IncomeManagerImpl;
import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.managers.IncomeManager;
//import com.example.financial_manager_starter.services.UserInfoService;
//import com.example.financial_manager_starter.services.UserInfoServiceImpl;
import com.example.financial_manager.models.Expanse;
import com.example.financial_manager.dto.ExpenseDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinancialManagerApplication {
	public static void main(String[] args) {
		var context = SpringApplication.run(FinancialManagerApplication.class, args);
		ExpenseManagerImpl expenseManager = context.getBean(ExpenseManagerImpl.class);
		ExpenseDto expenseDto = new ExpenseDto();
		expenseDto.setAmount(200);
		expenseDto.setPurpose("Products");
		expenseManager.addExpense(expenseDto);

//		IncomeManager incomeManager = springContext.getBean(IncomeManagerImpl.class);
//		ExpenseManager expenseManager = springContext.getBean(ExpenseManagerImpl.class);
//
//		FinanceManager financeManager = springContext.getBean(FinanceManager.class);
//		incomeManager.addIncome(1000,"Salary");
//		expenseManager.addExpense(300,"Products");
//		System.out.println("Balance 1: "+financeManager.calculateBudget());
//
//		expenseManager.addExpense(200,"Games");
//		System.out.println("Balance 2: "+financeManager.calculateBudget());
//
//		expenseManager.updateExpenseAmount(1L,500);
//		//System.out.println(expenseManager.getAllExpenses().get(0).getExpanseAmount());
//		System.out.println("Balance 3: "+financeManager.calculateBudget());
////		Scanner scanner = new Scanner(System.in);
////		double d = scanner.nextDouble();
//
//		//System.out.println("Income manager currency: "+incomeManager.getCurrency());
	}

}
