package com.example.financial_manager.components;

import com.example.financial_manager.managers.InvestmentManager;
import com.example.financial_manager.entities.InvestmentEntity;
import com.example.financial_manager.repositories.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InvestmentManagerImpl implements InvestmentManager {

    @Autowired
    private InvestmentRepository investments;
    @Override
    public void addInvestment(double price, String name) {
       // investments.save(new InvestmentEntity(price,name));
    }

    @Override
    public void deleteInvestment(Long id) {
        investments.deleteById(id);
    }

    @Override
    public void updateInvestmentPrice(Long id, double price) {
        try {
            Optional<InvestmentEntity> investment = investments.findById(id);
            if(investment.isPresent()){
                InvestmentEntity updatedExpense = investment.get();
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
            Optional<InvestmentEntity> investment = investments.findById(id);
            if(investment.isPresent()){
                InvestmentEntity updatedExpense = investment.get();
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
    public List<InvestmentEntity> getAllInvestments() {
        return investments.findAll();
    }

    @Override
    public double calculateTotalInvestments() {
        return investments.findAll().stream().mapToDouble(InvestmentEntity::getInvestmentPrice).sum();
    }
}
