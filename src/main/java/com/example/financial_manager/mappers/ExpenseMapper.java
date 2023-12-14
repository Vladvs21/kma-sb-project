package com.example.financial_manager.mappers;

import com.example.financial_manager.components.UserManagerImpl;
import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.entities.ExpenseEntity;
import com.example.financial_manager.managers.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ExpenseMapper {
//    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

//    @Mapping(source = "expense_id", target = "id")
//    @Mapping(source = "expanseAmount", target = "amount")
//    @Mapping(source = "expansePurpose", target = "purpose")
    private final UserManagerImpl userManager;
public ExpenseEntity expenseDtoToExpanseEntity(ExpenseDto expenseDto){
        return new ExpenseEntity(
                expenseDto.getId(),
                expenseDto.getAmount(),
                expenseDto.getPurpose(),
                userManager.getUserEntityById(expenseDto.getUserId())
        );
    };
    public ExpenseDto expanseEntityToExpanseDto(ExpenseEntity expenseEntity){
        return new ExpenseDto(
                expenseEntity.getExpense_id(),
                expenseEntity.getExpensePurpose(),
                expenseEntity.getExpanseAmount(),
                expenseEntity.getUser().getId()
        );
    }


}
