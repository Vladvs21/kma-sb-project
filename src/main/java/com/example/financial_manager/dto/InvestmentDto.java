package com.example.financial_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentDto {
    private Long investment_id;
    private String investmentName;
    private double investmentPrice;
    private AssetDto assetDto;
}
