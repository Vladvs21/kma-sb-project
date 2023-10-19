package com.example.financial_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {
    private Long stock_id;
    private String nameOfCompany;
    private double price;
    private Set<AssetDto> assetDtos;
}
