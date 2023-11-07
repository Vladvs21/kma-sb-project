package com.example.financial_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDto {
    private Long asset_id;
    private String assetName;
    private double assetPrice;
    private Set<StockDto> stockDtos;

    private List<LoanDto> loanDtos;

    private List<InvestmentDto> investmentDtos;
}
