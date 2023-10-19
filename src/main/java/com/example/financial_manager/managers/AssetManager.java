package com.example.financial_manager.managers;

import com.example.financial_manager.entities.AssetEntity;

import java.util.List;

public interface AssetManager {
    void addAsset(double price, String name);
    void deleteAsset(Long id);
    void updateAssetPrice(Long id, double price);
    void updateAssetName(Long id, String name);
    List<AssetEntity> getAllAssets();
    double calculateTotalAssets();
}
