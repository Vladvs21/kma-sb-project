package com.example.financial_manager.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name="investments")
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long investment_id;
    @Column(nullable = false)
    private String investmentName;
    @Column(nullable = false)
    private double investmentPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Asset asset;

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Investment(){}

    public Investment(double investmentPrice, String investmentName) {
        this.investmentName = investmentName;
        this.investmentPrice = investmentPrice;
    }
    public String getInvestmentName() {
        return investmentName;
    }

    public double getInvestmentPrice() {
        return investmentPrice;
    }


    public void setInvestmentName(String investmentName) {
        this.investmentName = investmentName;
    }

    public void setInvestmentPrice(double investmentPrice) {
        this.investmentPrice = investmentPrice;
    }

    public void setInvestment_id(Long investmentId) {
        this.investment_id = investmentId;
    }

    public Long getInvestment_id() {
        return investment_id;
    }
}
