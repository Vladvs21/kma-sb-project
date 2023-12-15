package com.example.financial_manager.managers;

import com.example.financial_manager.dto.IncomeDto;
import com.example.financial_manager.entities.IncomeEntity;

import java.util.List;

public interface IncomeManager {
    IncomeDto addIncome(IncomeDto incomeDto);
    void deleteIncome(Long id);
    IncomeDto updateIncome(Long id, IncomeDto incomeDto);
    List<IncomeDto> getAllIncomes(Long userId);
    List<IncomeEntity> getAllEntityIncomes(Long userId);
    IncomeDto getIncome(Long id);
    double calculateTotalIncome(Long id);
}
