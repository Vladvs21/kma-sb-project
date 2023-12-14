package com.example.financial_manager.mappers.othermappers;

import com.example.financial_manager.dto.AssetDto;
import com.example.financial_manager.entities.AssetEntity;
import com.example.financial_manager.mappers.LoanMapper;
import com.example.financial_manager.mappers.StockMapper;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

//@Component
//@RequiredArgsConstructor
public class AssetMapper {
//    private final InvestmentMapper investmentMapper;
//    private final StockMapper stockMapper;
//    private final LoanMapper loanMapper;
//    public AssetEntity assetDtoToAssetEntity(AssetDto assetDto){
//        return new AssetEntity(
//                assetDto.getAsset_id(),
//                assetDto.getAssetName(),
//                assetDto.getAssetPrice(),
//                assetDto.getStockDtos().stream().map(stockMapper::stockDtoToStockEntity).collect(Collectors.toSet()),
//                assetDto.getLoanDtos().stream().map(loanMapper::loanDtoToLoanEntity).toList(),
//                assetDto.getInvestmentDtos().stream().map(investmentMapper::investmentDtoToInvestmentEntity).toList()
//        );
//    }
//
//    public AssetDto assetEntityToAssetDto(AssetEntity assetEntity){
//        return new AssetDto(
//                assetEntity.getAsset_id(),
//                assetEntity.getAssetName(),
//                assetEntity.getAssetPrice(),
//                assetEntity.getStockEntities().stream().map(stockMapper::stockDtoToStockEntity).collect(Collectors.toSet()),
//                assetEntity.getLoanEntities().stream().map(loanMapper::loanEntityToLoanDto).toList(),
//                assetEntity.getInvestmentEntities().stream().map(investmentMapper::investmentEntityToInvestmentDto).toList()
//        );
//    }
}
