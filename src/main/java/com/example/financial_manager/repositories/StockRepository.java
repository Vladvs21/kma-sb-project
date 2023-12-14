package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<StockEntity,Long> {
    List<StockEntity> findAllByUserEntityId(Long userId);
}
