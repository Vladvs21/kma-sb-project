package com.example.financial_manager.controllers;

import com.example.financial_manager.FinanceManager;
import com.example.financial_manager.components.UserManagerImpl;
import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.dto.UserDto;
import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager.managers.LoanManager;
import com.example.financial_manager.managers.UserManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserManagerImpl userManager;
    private final ExpenseManager expenseManager;
    private final IncomeManager incomeManager;
    private final LoanManager loanManager;

    private final FinanceManager financeManager;
    @GetMapping("/{id}/userInfo/")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userManager.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{id}/view")
    public ModelAndView viewAllExpenses(Model model, ModelMap map, @PathVariable Long id) {
        UserDto userDto = userManager.getUserById(id);
        double expensesSum = expenseManager.calculateTotalExpenses(id);
        double incomesSum = incomeManager.calculateTotalIncome(id);
        double loansSum = loanManager.calculateTotalLoans(id);

        double budget = financeManager.calculateBudget(id);
        model.addAttribute("user",userDto);
        model.addAttribute("expensesSum",expensesSum);
        model.addAttribute("incomesSum",incomesSum);
        model.addAttribute("loansSum",loansSum);
        model.addAttribute("budget",budget);
        return new ModelAndView("mainPage", map);
    }

    @PostMapping("/singUp")
    public ResponseEntity<UserDto> createExpense(UserDto userDto) {
        UserDto addUser = userManager.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addUser);
    }

    @PutMapping("/{id}/userInfo/updatePersonalInfo")
    public ResponseEntity<UserDto> updateExpense(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        UserDto updatedExpense = userManager.updateUser(id, userDto);
        return ResponseEntity.ok(updatedExpense);
    }

}
