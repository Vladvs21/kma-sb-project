package com.example.financial_manager.entities;

import jakarta.persistence.*;

@Entity
@Table(name="incomes")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String incomeSource;
    @Column(nullable = false)
    private double incomeAmount;

    public Income() {}

    public Income(double incomeAmount,String incomeSource) {
        this.incomeSource = incomeSource;
        this.incomeAmount = incomeAmount;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
