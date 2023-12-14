package com.example.financial_manager.mappers;

import com.example.financial_manager.dto.*;
import com.example.financial_manager.entities.*;
import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager.managers.LoanManager;
import com.example.financial_manager.managers.StockManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

//    private final ExpenseManager expenseManager;
//    private final IncomeManager incomeManager;
//    private final LoanManager loanManager;
//    private final StockManager stockManager;
    public UserDto userEntityToDto(UserEntity userEntity){
//        List<ExpenseDto> expenseDtoList = expenseManager.getAllExpenses(userEntity.getId());
//        List<IncomeDto> incomeDtoList = incomeManager.getAllIncomes(userEntity.getId());
//        List<LoanDto> loanDtoList = loanManager.getAllLoans();
//        List<StockDto> stockDtoList = stockManager.getAllStocks(userEntity.getId());
        return new UserDto(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getEmail(),
                userEntity.getPassword()
                );
    }

    public UserEntity userDtoToEntity(UserDto userDto){
//        List<ExpenseEntity> expenseEntities = expenseManager.getAllEntityExpenses(userDto.getId());
//        List<IncomeEntity> incomeEntities = incomeManager.getAllEntityIncomes(userDto.getId());
//        List<LoanEntity> loanEntities = loanManager.getAllEntityLoans();
//        List<StockEntity> stockEntities = stockManager.getAllEntityStocks(userDto.getId());
        return new UserEntity(
                userDto.getId(),
                userDto.getEmail(),
                userDto.getUsername(),
                userDto.getPassword()
         );
    }
}
