package com.example.financial_manager.mappers;

import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.entities.ExpenseEntity;
import org.springframework.stereotype.Component;


@Component
public class ExpenseMapper {
//    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

//    @Mapping(source = "expense_id", target = "id")
//    @Mapping(source = "expanseAmount", target = "amount")
//    @Mapping(source = "expansePurpose", target = "purpose")
public ExpenseEntity expenseDtoToExpanseEntity(ExpenseDto expenseDto){
        return new ExpenseEntity(
                expenseDto.getId(),
                expenseDto.getAmount(),
                expenseDto.getPurpose()
        );
    };
    public ExpenseDto expanseEntityToExpanseDto(ExpenseEntity expenseEntity){
        return new ExpenseDto(
                expenseEntity.getExpense_id(),
                expenseEntity.getExpensePurpose(),
                expenseEntity.getExpanseAmount()
        );
    }


}
