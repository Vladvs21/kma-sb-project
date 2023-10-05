package com.example.financial_manager.components;

import com.example.financial_manager.entities.Expense;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager.entities.Income;
import com.example.financial_manager.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Component
public class IncomeManagerImpl implements IncomeManager {

    private final IncomeRepository incomeRepository;
    private String currency;

    //@Autowired
    public IncomeManagerImpl(IncomeRepository incomeRepository, String currency) {
        this.incomeRepository = incomeRepository;
        this.currency = currency;
    }

    @Override
    public void addIncome(double amount, String source) {
        incomeRepository.save(new Income(amount,source));
    }

    @Override
    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }

    @Override
    public void updateIncomeAmount(Long id, double amount) {
        try {
            Optional<Income> income = incomeRepository.findById(id);
            if(income.isPresent()){
                Income updatedExpense = income.get();
                updatedExpense.setIncomeAmount(amount);
                incomeRepository.save(updatedExpense);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateIncomeSource(Long id, String source) {
        try {
            Optional<Income> income = incomeRepository.findById(id);
            if(income.isPresent()){
                Income updatedExpense = income.get();
                updatedExpense.setIncomeSource(source);
                incomeRepository.save(updatedExpense);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    @Override
    public double calculateTotalIncome() {
        //System.out.println(currency);
        return incomeRepository.findAll().stream().mapToDouble(Income::getIncomeAmount).sum();
    }

}
