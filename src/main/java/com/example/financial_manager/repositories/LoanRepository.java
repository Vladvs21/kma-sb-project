package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoanRepository extends JpaRepository<LoanEntity,Long> {
    List<LoanEntity> findByLoanSource(String source);
    List<LoanEntity> findByLoanAmount(double amount);

    List<LoanEntity> findAllByUserEntityId(Long userId);
}
