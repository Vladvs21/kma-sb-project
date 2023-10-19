package com.example.financial_manager.mappers.othermappers;

import com.example.financial_manager.dto.StockDto;
import com.example.financial_manager.entities.StockEntity;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

//@Component
@RequiredArgsConstructor
public class StockMapper {
    private final AssetMapper assetMapper;
    public StockEntity stockDtoToStockEntity(StockDto stockDto){

        return new StockEntity(
                stockDto.getStock_id(),
                stockDto.getNameOfCompany(),
                stockDto.getPrice(),
                stockDto.getAssetDtos().stream().map(assetMapper::assetDtoToAssetEntity).collect(Collectors.toSet())
                );
    }

    public StockDto stockDtoToStockEntity(StockEntity stockEntity1){
        return new StockDto(
                stockEntity1.getStock_id(),
                stockEntity1.getNameOfCompany(),
                stockEntity1.getPrice(),
                stockEntity1.getAssetEntities().stream().map(assetMapper::assetEntityToAssetDto).collect(Collectors.toSet())
        );
    }
}
