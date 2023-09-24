package com.example.starter.components;

import com.example.starter.managers.LoanManager;
import com.example.starter.wrappers.Loan;
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
