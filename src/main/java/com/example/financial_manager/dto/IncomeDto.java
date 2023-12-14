package com.example.financial_manager.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDto {
    Long id;
    @NotBlank
    String source;
    @NotNull
    @Min(1)
    double amount;
    @NotNull
    Long userId;
}
