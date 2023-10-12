package com.example.financial_manager.components;

import com.example.financial_manager.FinanceManager;
import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.entities.Expense;
import com.example.financial_manager.repositories.ExpenseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ExpenseManagerImpl implements ExpenseManager {

    @Autowired
    private ExpenseRepository expenseRepository;

    private static final Logger logger = LoggerFactory.getLogger(FinanceManager.class);
    private static final Marker SECURITY_MARKER = MarkerFactory.getMarker("SECURITY");
    @Override
    public void addExpense(double amount, String purpose) {
        expenseRepository.save(new Expense(null,amount,purpose));
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public void updateExpenseAmount(Long id, double amount) {
        try {
            Optional<Expense> expense = expenseRepository.findById(id);
            if(expense.isPresent()){
                Expense updatedExpense = expense.get();
                updatedExpense.setExpanseAmount(amount);
                expenseRepository.save(updatedExpense);
                logger.info(SECURITY_MARKER, "Security check passed");
                logger.info("Expanse amount: Successfully updated");
            }else{
                logger.warn("Expanse amount: Not updated. Wrong id");
                throw new Exception();
            }
        } catch (Exception e) {
            logger.error("Expanse amount update error");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateExpensePurpose(Long id, String purpose) {
        try {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()){
            Expense updatedExpense = expense.get();
            updatedExpense.setExpensePurpose(purpose);
            expenseRepository.save(updatedExpense);
            logger.info("Expanse purpose: Successfully updated");
        }else{
            logger.warn("Expanse purpose: Not updated. Wrong id");
            throw new Exception();
        }
        } catch (Exception e) {
            logger.error("Expanse purpose update error");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public double calculateTotalExpenses() {
       return expenseRepository.findAll().stream().mapToDouble(Expense::getExpanseAmount).sum();
    }
}
