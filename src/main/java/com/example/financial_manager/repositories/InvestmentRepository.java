package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.InvestmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InvestmentRepository extends JpaRepository<InvestmentEntity,Long> {
    List<InvestmentEntity> findByInvestmentPrice(double price);
    List<InvestmentEntity> findByInvestmentName(String name);
}
