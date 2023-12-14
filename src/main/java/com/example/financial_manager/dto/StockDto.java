package com.example.financial_manager.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {
    private Long stock_id;
    @NotNull
    private String nameOfCompany;
    @NotNull
    private double price;
    @NotNull
    Long userId;
}
