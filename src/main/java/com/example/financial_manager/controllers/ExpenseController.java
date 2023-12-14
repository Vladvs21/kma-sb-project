package com.example.financial_manager.controllers;

import com.example.financial_manager.components.ExpenseManagerImpl;
import com.example.financial_manager.dto.ExpenseDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user/{userId}/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseManagerImpl expenseService;

    @GetMapping("/view")
    public ModelAndView viewAllExpenses(Model model, ModelMap map,@PathVariable Long userId) {
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setUserId(userId);
        List<ExpenseDto> expenses = expenseService.getAllExpenses(userId);
        model.addAttribute("expenses", expenses);
        model.addAttribute("newExpense", expenseDto);
        return new ModelAndView("expenses", map);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(@PathVariable Long userId) {
        List<ExpenseDto> expenses = expenseService.getAllExpenses(userId);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable Long id, @PathVariable Long userId) {
        ExpenseDto expense = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expense);
    }


    @PostMapping("/createExpense")
    public ModelAndView createExpense(@Valid ExpenseDto expenseDto, @PathVariable Long userId) {
        expenseDto.setUserId(userId);
        expenseService.addExpense(expenseDto);
        return new ModelAndView("redirect:/user/{userId}/expenses/view");
    }
     /*
    @PostMapping(path = "/createExpanse", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView createExpense(@Valid @ModelAttribute ExpenseDto expenseDto, Model model, ModelMap map) {
        ExpenseDto createdExpense = expenseService.addExpense(expenseDto);

        List<ExpenseDto> updatedExpenses = expenseService.getAllExpenses();
        model.addAttribute("expenses", updatedExpenses);
        model.addAttribute("newExpense", new ExpenseDto());
        return new ModelAndView("expenses", map);
    }
     */

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @Valid @RequestBody ExpenseDto expenseDto, @PathVariable Long userId) {
        expenseDto.setUserId(userId);
        ExpenseDto updatedExpense = expenseService.updateExpense(id, expenseDto);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id, @PathVariable Long userId) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
