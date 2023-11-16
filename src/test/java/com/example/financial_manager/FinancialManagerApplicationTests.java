package com.example.financial_manager;

import com.example.financial_manager.managers.ExpenseManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FinancialManagerApplicationTests {

	@Autowired
	ApplicationContext applicationContext;
	@Test
	void contextLoads() {
		ExpenseManager expenseManager = applicationContext.getBean(ExpenseManager.class);

		assertNotNull(expenseManager);

	}

}
