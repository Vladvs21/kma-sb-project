package com.example.financial_manager.wrappers;

public class Asset {
    private String assetName;
    private double assetPrice;

    public String getAssetName() {
        return assetName;
    }

    public double getAssetPrice() {
        return assetPrice;
    }

    public Asset(String assetName, double assetPrice) {
        this.assetName = assetName;
        this.assetPrice = assetPrice;
    }
}
