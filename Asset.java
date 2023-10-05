package com.example.financial_manager.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "assets")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long asset_id;
    @Column(nullable = false)
    private String assetName;
    @Column(nullable = false)
    private double assetPrice;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Stock> stocks;

    @OneToMany
    private List<Loan> loan;

    @OneToMany
    private List<Investment> investments;

    public Asset() {}
    public Asset(double assetPrice, String assetName) {
        this.assetName = assetName;
        this.assetPrice = assetPrice;
    }


    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }


    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setAssetPrice(double assetPrice) {
        this.assetPrice = assetPrice;
    }

    public String getAssetName() {
        return assetName;
    }

    public double getAssetPrice() {
        return assetPrice;
    }

    public void setAsset_id(Long assetId) {
        this.asset_id = assetId;
    }

    public Long getAsset_id() {
        return asset_id;
    }
}
