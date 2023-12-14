package com.example.financial_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpenseDto {
    private Long id;
    @NotNull
    private String purpose;
    @NotNull
    @Min(0)
    private double amount;
    @NotNull
    private Long userId;
}
