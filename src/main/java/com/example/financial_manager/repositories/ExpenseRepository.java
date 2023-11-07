package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
    List<ExpenseEntity> findByExpanseAmount(double amount);
    List<ExpenseEntity> findByExpensePurpose(String purpose);
}
