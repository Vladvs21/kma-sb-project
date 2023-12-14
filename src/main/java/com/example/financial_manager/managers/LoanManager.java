package com.example.financial_manager.managers;

import com.example.financial_manager.dto.LoanDto;
import com.example.financial_manager.entities.LoanEntity;

import java.util.List;

public interface LoanManager {
    LoanDto addLoan(LoanDto loanDto);
    void deleteLoan(Long id);
    LoanDto updateLoan(Long id, LoanDto loanDto);
    List<LoanDto> getAllLoans(Long userId);
    List<LoanEntity> getAllEntityLoans(Long userId);
    LoanDto getLoan(Long id);
    double calculateTotalLoans();
}
