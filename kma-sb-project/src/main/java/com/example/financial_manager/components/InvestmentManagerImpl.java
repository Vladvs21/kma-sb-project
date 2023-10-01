package com.example.financial_manager.components;

import com.example.financial_manager.managers.InvestmentManager;
import com.example.financial_manager.wrappers.Investment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvestmentManagerImpl implements InvestmentManager {

    private List<Investment> investments = new ArrayList<>();
    @Override
    public void addInvestment(Investment investment) {
        investments.add(investment);
    }

    @Override
    public List<Investment> getAllInvestments() {
        return investments;
    }

    @Override
    public double calculateTotalInvestments() {
        return investments.stream().mapToDouble(Investment::getInvestmentPrice).sum();
    }
}
