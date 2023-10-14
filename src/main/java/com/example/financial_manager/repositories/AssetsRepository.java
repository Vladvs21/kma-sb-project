package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetsRepository extends JpaRepository<Asset,Long> {

    List<Asset> findByAssetPrice(double price);
    List<Asset> findByAssetName(String name);
}
