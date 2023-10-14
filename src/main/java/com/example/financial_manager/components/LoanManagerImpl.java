package com.example.financial_manager.components;

import com.example.financial_manager.entities.Investment;
import com.example.financial_manager.managers.LoanManager;
import com.example.financial_manager.entities.Loan;
import com.example.financial_manager.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LoanManagerImpl implements LoanManager {

    @Autowired
    private LoanRepository loans;
    @Override
    public void addLoan(double amount, String source) {
        loans.save(new Loan(amount,source));
    }

    @Override
    public void deleteLoan(Long id) {
        loans.deleteById(id);
    }

    @Override
    public void updateLoanAmount(Long id, double amount) {
        try {
            Optional<Loan> loan = loans.findById(id);
            if(loan.isPresent()){
                Loan updatedExpense = loan.get();
                updatedExpense.setLoanAmount(amount);
                loans.save(updatedExpense);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateLoanSource(Long id, String source) {
        try {
            Optional<Loan> loan = loans.findById(id);
            if(loan.isPresent()){
                Loan updatedExpense = loan.get();
                updatedExpense.setLoanSource(source);
                loans.save(updatedExpense);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Loan> getAllLoans() {
        return loans.findAll();
    }

    @Override
    public double calculateTotalLoans() {
        return loans.findAll().stream().mapToDouble(Loan::getLoanAmount).sum();
    }
}
