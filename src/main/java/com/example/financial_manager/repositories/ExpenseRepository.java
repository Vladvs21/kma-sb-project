package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findByExpanseAmount(double amount);
    List<Expense> findByExpensePurpose(String purpose);
}
