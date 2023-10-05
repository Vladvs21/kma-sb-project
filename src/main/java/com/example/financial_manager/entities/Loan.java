package com.example.financial_manager.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loan_id;
    @Column(nullable = false)
    private String loanSource;
    @Column(nullable = false)
    private double loanAmount;
    public Loan(){}
    public Loan(double loanSum, String loanSource) {
        this.loanSource = loanSource;
        this.loanAmount = loanSum;
    }
    public String getLoanSource() {
        return loanSource;
    }

    public void setLoanSource(String loanSource) {
        this.loanSource = loanSource;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(Long loan_id) {
        this.loan_id = loan_id;
    }
}
