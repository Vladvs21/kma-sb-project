package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InvestmentRepository extends JpaRepository<Investment,Long> {
    List<Investment> findByInvestmentPrice(double price);
    List<Investment> findByInvestmentName(String name);
}
