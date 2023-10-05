package com.example.financial_manager.managers;

import com.example.financial_manager.entities.Asset;

import java.util.List;

public interface AssetManager {
    void addAsset(double price, String name);
    void deleteAsset(Long id);
    void updateAssetPrice(Long id, double price);
    void updateAssetName(Long id, String name);
    List<Asset> getAllAssets();
    double calculateTotalAssets();
}
