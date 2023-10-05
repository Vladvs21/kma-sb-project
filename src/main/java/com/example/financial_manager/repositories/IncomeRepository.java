package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.Expense;
import com.example.financial_manager.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {
    List<Income> findByIncomeAmount(double amount);
    List<Income> findByIncomeSource(String source);
}
