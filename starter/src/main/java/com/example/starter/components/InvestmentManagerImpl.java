package com.example.starter.components;

import com.example.starter.managers.InvestmentManager;
import com.example.starter.wrappers.Investment;
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
