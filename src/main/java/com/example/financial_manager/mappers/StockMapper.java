package com.example.financial_manager.mappers;

import com.example.financial_manager.dto.StockDto;
import com.example.financial_manager.entities.StockEntity;
import com.example.financial_manager.managers.UserManager;
import com.example.financial_manager.mappers.othermappers.AssetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StockMapper {
    private final UserManager userManager;
    public StockEntity stockDtoToStockEntity(StockDto stockDto){

        return new StockEntity(
                stockDto.getStock_id(),
                stockDto.getNameOfCompany(),
                stockDto.getPrice(),
                userManager.getUserEntityById(stockDto.getUserId())
                );
    }

    public StockDto stockEntityToStockDto(StockEntity stockEntity1){
        return new StockDto(
                stockEntity1.getStock_id(),
                stockEntity1.getNameOfCompany(),
                stockEntity1.getPrice(),
                stockEntity1.getUserEntity().getId()
        );
    }
}
