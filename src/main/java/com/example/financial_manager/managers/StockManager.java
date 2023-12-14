package com.example.financial_manager.managers;


import com.example.financial_manager.dto.StockDto;
import com.example.financial_manager.entities.StockEntity;

import java.util.List;

public interface StockManager {
    StockDto addStock(StockDto stockDto);
    StockDto updateStock(Long id, StockDto stockDto);
    void deleteStock(Long id);
    List<StockDto> getAllStocks(Long userId);
    List<StockEntity> getAllEntityStocks(Long userId);
    StockDto getStockById(Long id);
    StockEntity getStockEntityById(Long id);
}
