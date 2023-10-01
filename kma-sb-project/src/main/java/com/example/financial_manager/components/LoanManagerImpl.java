package com.example.financial_manager.components;

import com.example.financial_manager.managers.LoanManager;
import com.example.financial_manager.wrappers.Loan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoanManagerImpl implements LoanManager {
    private List<Loan> loans = new ArrayList<>();

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loans;
    }

    @Override
    public double calculateTotalLoans() {
        return loans.stream().mapToDouble(Loan::getLoanAmount).sum();
    }
}
