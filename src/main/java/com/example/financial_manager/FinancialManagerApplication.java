package com.example.financial_manager;

import com.example.financial_manager.components.ExpenseManagerImpl;
import com.example.financial_manager.components.IncomeManagerImpl;
import com.example.financial_manager.components.LoanManagerImpl;
import com.example.financial_manager.dto.*;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager.managers.UserManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FinancialManagerApplication {
	public static void main(String[] args) {
		var context = SpringApplication.run(FinancialManagerApplication.class, args);
//		ExpenseManagerImpl expenseManager = context.getBean(ExpenseManagerImpl.class);
//		UserManager userManager = context.getBean(UserManager.class);
//		UserDto userDto = new UserDto(
//				null,
//				"viktorvavd@gmail.com",
//				"admin",
//				"1111");
////				expenses,
////				incomes,
////				new ArrayList<>(),
////				new ArrayList<>());
//
//		userManager.addUser(userDto);
//
//
//  	    ExpenseDto expenseDto = new ExpenseDto();
//		expenseDto.setAmount(200);
//		expenseDto.setPurpose("Products");
//		expenseDto.setUserId(1L);
//		expenseManager.addExpense(expenseDto);
//
//		ExpenseDto expenseDto2 = new ExpenseDto();
//		expenseDto2.setAmount(300);
//		expenseDto2.setPurpose("Games");
//		expenseDto2.setUserId(1L);
//		expenseManager.addExpense(expenseDto2);
//
//		IncomeManager incomeManager = context.getBean(IncomeManagerImpl.class);
//
//		IncomeDto incomeDto = new IncomeDto();
//		incomeDto.setAmount(1000);
//		incomeDto.setSource("Salary");
//		incomeDto.setUserId(1L);
//		incomeManager.addIncome(incomeDto);
//
//		LoanManagerImpl loanManager = context.getBean(LoanManagerImpl.class);
//
//		LoanDto loanDto = new LoanDto();
//		loanDto.setLoanAmount(100);
//		loanDto.setLoanSource("Monobank");
//		loanDto.setUserId(1L);
//		loanManager.addLoan(loanDto);

//		List<ExpenseDto> expenses = new ArrayList<>();
//		expenses.add(expenseDto);
//		expenses.add(expenseDto2);
//
//		List<IncomeDto> incomes = new ArrayList<>();
//		incomes.add(incomeDto);


	}

}
