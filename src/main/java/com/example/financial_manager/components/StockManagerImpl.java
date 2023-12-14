package com.example.financial_manager.components;

import com.example.financial_manager.dto.StockDto;
import com.example.financial_manager.entities.StockEntity;
import com.example.financial_manager.managers.StockManager;
import com.example.financial_manager.mappers.StockMapper;
import com.example.financial_manager.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StockManagerImpl implements StockManager {

    private final StockMapper stockMapper;
    private final StockRepository stockRepository;

    @Override
    public StockDto addStock(StockDto stockDto) {
        StockEntity stockEntity = stockMapper.stockDtoToStockEntity(stockDto);
        stockRepository.save(stockEntity);
        return stockMapper.stockEntityToStockDto(stockEntity);
    }

    @Override
    public StockDto updateStock(Long id, StockDto stockDto) {
        if(stockRepository.findById(id).isPresent()){
            StockEntity stockEntity = stockMapper.stockDtoToStockEntity(stockDto);
            stockEntity.setStock_id(id);
            stockRepository.save(stockEntity);
            return stockMapper.stockEntityToStockDto(stockEntity);
        }else{
            throw new RuntimeException("No such stock");
        }
    }

    @Override
    public void deleteStock(Long id) {
        if(stockRepository.findById(id).isPresent()){
            stockRepository.deleteById(id);
        }else{
            throw new RuntimeException("No such stock");
        }
    }

    @Override
    public List<StockDto> getAllStocks(Long userId) {
        return stockRepository.findAllByUserEntityId(userId).stream().map(stockMapper::stockEntityToStockDto).toList();
    }

    @Override
    public List<StockEntity> getAllEntityStocks(Long userId) {
        return stockRepository.findAllByUserEntityId(userId);
    }

    @Override
    public StockDto getStockById(Long id) {
        if(stockRepository.findById(id).isPresent()){
            return stockMapper.stockEntityToStockDto(stockRepository.findById(id).get());
        }else{
            throw new RuntimeException("No such stock");
        }
    }

    @Override
    public StockEntity getStockEntityById(Long id) {
        if(stockRepository.findById(id).isPresent()){
           return stockRepository.findById(id).get();
        }else{
            throw new RuntimeException("No such stock");
        }
    }
}
