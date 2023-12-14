package com.example.financial_manager.mappers;

import com.example.financial_manager.dto.IncomeDto;
import com.example.financial_manager.entities.IncomeEntity;
import com.example.financial_manager.managers.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IncomeMapper {
    private final UserManager userManager;
    public IncomeEntity incomeDtoToIncomeEntity(IncomeDto incomeDto){
        return new IncomeEntity(
                incomeDto.getId(),
                incomeDto.getSource(),
                incomeDto.getAmount(),
                userManager.getUserEntityById(incomeDto.getUserId()));
    };
    public IncomeDto incomeEntityToIncomeDto(IncomeEntity incomeEntity){
        return new IncomeDto(
                incomeEntity.getId(),
                incomeEntity.getIncomeSource(),
                incomeEntity.getIncomeAmount(),
                incomeEntity.getUser().getId()
        );
    }
}
