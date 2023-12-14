package com.example.financial_manager.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    private Long loan_id;
    @NotNull
    private String loanSource;
    @NotNull
    @Min(0)
    private double loanAmount;
    @NotNull
    Long userId;
//    private AssetDto assetDto;
}
