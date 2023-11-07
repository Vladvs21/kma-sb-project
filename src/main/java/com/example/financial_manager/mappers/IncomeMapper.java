package com.example.financial_manager.mappers;

import com.example.financial_manager.dto.IncomeDto;
import com.example.financial_manager.entities.IncomeEntity;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper {
    public IncomeEntity incomeDtoToIncomeEntity(IncomeDto incomeDto){
        return new IncomeEntity(
                incomeDto.getId(),
                incomeDto.getSource(),
                incomeDto.getAmount());
    };
    public IncomeDto incomeEntityToIncomeDto(IncomeEntity incomeEntity){
        return new IncomeDto(
                incomeEntity.getId(),
                incomeEntity.getIncomeSource(),
                incomeEntity.getIncomeAmount()
        );
    }
}
