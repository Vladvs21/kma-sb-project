package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity,Long> {
    List<IncomeEntity> findByIncomeAmount(double amount);
    List<IncomeEntity> findByIncomeSource(String source);

    List<IncomeEntity> findAllByUserId(Long userId);
}
