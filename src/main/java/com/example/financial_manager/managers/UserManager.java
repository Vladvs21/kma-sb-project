package com.example.financial_manager.managers;

import com.example.financial_manager.dto.*;
import com.example.financial_manager.entities.UserEntity;

import java.util.List;

public interface UserManager {
    UserDto addUser(UserDto userDto);
    void deleteUser(Long id);
    UserDto updateUser(Long id, UserDto userDto);
    UserDto getUserById(Long id);
    UserEntity getUserEntityById(Long id);
    List<UserDto> getAllUsers();
    List<ExpenseDto> getAllExpanses();
    List<IncomeDto> getAllIncomes();
    List<LoanDto> getAllLoans();
    List<StockDto> getAllStocks();
}
