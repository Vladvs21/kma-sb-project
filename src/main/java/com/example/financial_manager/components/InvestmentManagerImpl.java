package com.example.financial_manager.components;

import com.example.financial_manager.entities.Income;
import com.example.financial_manager.managers.InvestmentManager;
import com.example.financial_manager.entities.Investment;
import com.example.financial_manager.repositories.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InvestmentManagerImpl implements InvestmentManager {

    @Autowired
    private InvestmentRepository investments;
    @Override
    public void addInvestment(double price, String name) {
        investments.save(new Investment(price,name));
    }

    @Override
    public void deleteInvestment(Long id) {
        investments.deleteById(id);
    }

    @Override
    public void updateInvestmentPrice(Long id, double price) {
        try {
            Optional<Investment> investment = investments.findById(id);
            if(investment.isPresent()){
                Investment updatedExpense = investment.get();
                updatedExpense.setInvestmentPrice(price);
                investments.save(updatedExpense);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateInvestmentName(Long id, String name) {
        try {
            Optional<Investment> investment = investments.findById(id);
            if(investment.isPresent()){
                Investment updatedExpense = investment.get();
                updatedExpense.setInvestmentName(name);
                investments.save(updatedExpense);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Investment> getAllInvestments() {
        return investments.findAll();
    }

    @Override
    public double calculateTotalInvestments() {
        return investments.findAll().stream().mapToDouble(Investment::getInvestmentPrice).sum();
    }
}
