package com.example.financial_manager.components;

import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.entities.Expense;
import com.example.financial_manager.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ExpenseManagerImpl implements ExpenseManager {

    @Autowired
    private ExpenseRepository expenseRepository;
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
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
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
        }else{
            throw new Exception();
        }
        } catch (Exception e) {
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
