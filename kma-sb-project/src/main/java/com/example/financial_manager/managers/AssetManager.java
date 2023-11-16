package com.example.financial_manager.managers;

import com.example.financial_manager.wrappers.Asset;

import java.util.List;

public interface AssetManager {
    void addAsset(Asset asset);
    List<Asset> getAllAssets();
    double calculateTotalAssets();
}
