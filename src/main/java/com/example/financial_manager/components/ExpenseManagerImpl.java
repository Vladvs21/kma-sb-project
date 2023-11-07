package com.example.financial_manager.components;

import com.example.financial_manager.FinanceManager;
import com.example.financial_manager.controllers.exceptionHandler.exceptions.NoSuchExpanseException;
import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.entities.ExpenseEntity;
import com.example.financial_manager.mappers.ExpenseMapper;
import com.example.financial_manager.repositories.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExpenseManagerImpl implements ExpenseManager {

    private final ExpenseMapper expenseMapper;
    private final ExpenseRepository expenseRepository;

    private static final Logger logger = LoggerFactory.getLogger(FinanceManager.class);
    private static final Marker DB_CONNECT_MARKER = MarkerFactory.getMarker("DB_CONNECT");
    @Override
    public ExpenseDto addExpense(ExpenseDto expenseDto) {
        ExpenseEntity expenseEntity = expenseMapper.expenseDtoToExpanseEntity(expenseDto);
        expenseRepository.save(expenseEntity);
        return expenseMapper.expanseEntityToExpanseDto(expenseEntity);
    }

    @Override
    public void deleteExpense(Long id) {
        if(expenseRepository.findById(id).isPresent()){
            expenseRepository.deleteById(id);
        }else{
            throw new NoSuchExpanseException(id);
        }
    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        if(expenseRepository.findById(id).isPresent()){
            ExpenseEntity expenseEntity = expenseMapper.expenseDtoToExpanseEntity(expenseDto);
            expenseEntity.setExpense_id(id);
            expenseRepository.save(expenseEntity);
            return expenseMapper.expanseEntityToExpanseDto(expenseEntity);
        }else{
            throw new NoSuchExpanseException(id);
        }
    }


    @Override
    public List<ExpenseDto> getAllExpenses() {
        return expenseRepository.findAll().stream().map(expenseMapper::expanseEntityToExpanseDto).toList();
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {
        if(expenseRepository.findById(id).isPresent()){
            return expenseMapper.expanseEntityToExpanseDto(expenseRepository.findById(id).get());
        }else{
            throw new NoSuchExpanseException(id);
        }

    }

    @Override
    public double calculateTotalExpenses() {
       return expenseRepository.findAll().stream().mapToDouble(ExpenseEntity::getExpanseAmount).sum();
    }
}
