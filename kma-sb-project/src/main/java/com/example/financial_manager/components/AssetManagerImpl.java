package com.example.financial_manager.components;

import com.example.financial_manager.managers.AssetManager;
import com.example.financial_manager.wrappers.Asset;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AssetManagerImpl implements AssetManager {
    private List<Asset> assets = new ArrayList<>();

    @Override
    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    @Override
    public List<Asset> getAllAssets() {
        return assets;
    }

    @Override
    public double calculateTotalAssets() {
        return assets.stream().mapToDouble(Asset::getAssetPrice).sum();
    }
}
