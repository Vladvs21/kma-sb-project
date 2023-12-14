package com.example.financial_manager.controllers;

import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.dto.IncomeDto;
import com.example.financial_manager.managers.IncomeManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("user/{userId}/incomes")
@RequiredArgsConstructor
public class IncomeController {
    private final IncomeManager incomeService;

    @GetMapping("/view")
    public ModelAndView viewAllIncomes(Model model, ModelMap map, @PathVariable Long userId) {
        IncomeDto incomeDto = new IncomeDto();
        incomeDto.setUserId(userId);
        List<IncomeDto> incomes = incomeService.getAllIncomes(userId);
        model.addAttribute("incomes", incomes);
        model.addAttribute("newIncome", incomeDto);
        return new ModelAndView("incomes", map);
    }

    @GetMapping
    public ResponseEntity<List<IncomeDto>> getAllIncomes(@PathVariable Long userId) {
        return ResponseEntity.ok(incomeService.getAllIncomes(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeDto> getIncome(@PathVariable Long id, @PathVariable Long userId) {
        return ResponseEntity.ok(incomeService.getIncome(id));
    }

    @PostMapping(value = "/createIncome")
    public ModelAndView createIncome(@Valid IncomeDto incomeDto, @PathVariable Long userId){
        incomeDto.setUserId(userId);
        incomeService.addIncome(incomeDto);
        return new ModelAndView("redirect:/user/{userId}/incomes/view");
    }
    @PutMapping("/{id}")
    public ResponseEntity<IncomeDto> updateIncome(@PathVariable Long id, @Valid @RequestBody IncomeDto incomeDto, @PathVariable Long userId){
        incomeDto.setUserId(userId);
        return ResponseEntity.ok(incomeService.updateIncome(id,incomeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id, @PathVariable Long userId){
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }
}
