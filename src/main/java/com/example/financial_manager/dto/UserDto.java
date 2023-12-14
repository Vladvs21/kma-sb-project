package com.example.financial_manager.dto;

import com.example.financial_manager.entities.ExpenseEntity;
import com.example.financial_manager.entities.IncomeEntity;
import com.example.financial_manager.entities.LoanEntity;
import com.example.financial_manager.entities.StockEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotNull
    @Email(message = "Please provide a valid email address")
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;

//    private List<ExpenseDto> expenses;
//    private List<IncomeDto> incomes;
//    private List<StockDto> stocks;
//    private List<LoanDto> loans;
}
