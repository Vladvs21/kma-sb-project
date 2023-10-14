package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    List<Loan> findByLoanSource(String source);
    List<Loan> findByLoanAmount(double amount);
}
