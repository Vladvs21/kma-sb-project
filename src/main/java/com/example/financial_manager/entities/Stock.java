package com.example.financial_manager.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stock_id;
    @Column(nullable = false)
    private String nameOfCompany;
    @Column(nullable = false)
    private double price;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Investment> investments;

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(Set<Investment> investments) {
        this.investments = investments;
    }

    public void setStock_id(Long stockId) {
        this.stock_id = stockId;
    }

    public Long getStock_id() {
        return stock_id;
    }
}
