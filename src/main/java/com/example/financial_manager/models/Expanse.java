package com.example.financial_manager.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expanse {
    private Long expense_id;
    private double expanseAmount;
    private String expensePurpose;
}
