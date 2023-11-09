package com.example.financial_manager.controllers;

import com.example.financial_manager.components.ExpenseManagerImpl;
import com.example.financial_manager.dto.ExpenseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseManagerImpl expenseService;

    @GetMapping("/view")
    public ModelAndView viewAllExpenses(Model model, ModelMap map) {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        model.addAttribute("expenses", expenses);
        model.addAttribute("newExpense", new ExpenseDto());
        return new ModelAndView("expenses", map);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable Long id) {
        ExpenseDto expense = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expense);
    }

    @PostMapping("/createExpanse")
    public ResponseEntity<ExpenseDto> createExpense(@Valid @RequestBody ExpenseDto expenseDto) {
        ExpenseDto createdExpense = expenseService.addExpense(expenseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @Valid @RequestBody ExpenseDto expenseDto) {
        ExpenseDto updatedExpense = expenseService.updateExpense(id, expenseDto);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
