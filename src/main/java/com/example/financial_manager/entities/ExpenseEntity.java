package com.example.financial_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="expenses")
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long expense_id;
    @Column(nullable = false)
    private double expanseAmount;
    @Column(nullable = false)
    private String expensePurpose;
}
