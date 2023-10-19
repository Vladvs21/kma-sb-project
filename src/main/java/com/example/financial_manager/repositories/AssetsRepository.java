package com.example.financial_manager.repositories;

import com.example.financial_manager.entities.AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetsRepository extends JpaRepository<AssetEntity,Long> {

    List<AssetEntity> findByAssetPrice(double price);
    List<AssetEntity> findByAssetName(String name);
}
