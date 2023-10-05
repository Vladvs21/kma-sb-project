package com.example.financial_manager.entities;

import jakarta.persistence.*;

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
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Stock> stocks;
    public Investment(){}

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

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
