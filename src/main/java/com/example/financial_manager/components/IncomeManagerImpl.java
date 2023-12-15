package com.example.financial_manager.components;

import com.example.financial_manager.controllers.exceptionHandler.exceptions.NoSuchIncomeException;
import com.example.financial_manager.dto.IncomeDto;
import com.example.financial_manager.entities.ExpenseEntity;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager.entities.IncomeEntity;
import com.example.financial_manager.mappers.IncomeMapper;
import com.example.financial_manager.repositories.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//@Component
@RequiredArgsConstructor
public class IncomeManagerImpl implements IncomeManager {

    private final IncomeMapper incomeMapper;
    private final IncomeRepository incomeRepository;
    private final String currency;


    private static final Logger logger = LoggerFactory.getLogger(IncomeManagerImpl.class);
    private static final Marker DB_CONNECT_MARKER = MarkerFactory.getMarker("DB_CONNECT");


    @Override
    public IncomeDto addIncome(IncomeDto incomeDto) {
        IncomeEntity income = incomeMapper.incomeDtoToIncomeEntity(incomeDto);
        incomeRepository.save(income);

        logger.info(DB_CONNECT_MARKER,"Income added successful");
        return incomeMapper.incomeEntityToIncomeDto(income);
    }

    @Override
    public void deleteIncome(Long id) {
        if(incomeRepository.findById(id).isPresent()){
            incomeRepository.deleteById(id);
        }else{
            throw new NoSuchIncomeException(id);
        }

    }

    @Override
    public IncomeDto updateIncome(Long id, IncomeDto incomeDto) {
        if(incomeRepository.findById(id).isPresent()){
            IncomeEntity incomeEntity = incomeMapper.incomeDtoToIncomeEntity(incomeDto);
            incomeEntity.setId(id);
            incomeRepository.save(incomeEntity);
            return incomeMapper.incomeEntityToIncomeDto(incomeEntity);
        }else{
            throw new NoSuchIncomeException(id);
        }
    }


    @Override
    public List<IncomeDto> getAllIncomes(Long userId) {
        return incomeRepository.findAllByUserId(userId).stream().map(incomeMapper::incomeEntityToIncomeDto).toList();
    }

    @Override
    public List<IncomeEntity> getAllEntityIncomes(Long userId) {
        return incomeRepository.findAllByUserId(userId);
    }

    @Override
    public IncomeDto getIncome(Long id) {
        if(incomeRepository.findById(id).isPresent()){
            return incomeMapper.incomeEntityToIncomeDto(incomeRepository.findById(id).get());
        }else{
            throw new NoSuchIncomeException(id);
        }
    }

    @Override
    public double calculateTotalIncome(Long id) {
        //System.out.println(currency);
        return incomeRepository.findAllByUserId(id).stream().mapToDouble(IncomeEntity::getIncomeAmount).sum();
    }

}
