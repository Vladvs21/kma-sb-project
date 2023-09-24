package com.example.starter.managers;

import com.example.starter.wrappers.Asset;

import java.util.List;

public interface AssetManager {
    void addAsset(Asset asset);
    List<Asset> getAllAssets();
    double calculateTotalAssets();
}
