package com.example.financial_manager.controllers;

import com.example.financial_manager.dto.IncomeDto;
import com.example.financial_manager.managers.IncomeManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomes")
@RequiredArgsConstructor
public class IncomeController {
    private final IncomeManager incomeService;

    @GetMapping
    public ResponseEntity<List<IncomeDto>> getAllIncomes() {
        return ResponseEntity.ok(incomeService.getAllIncomes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeDto> getIncome(@PathVariable Long id) {
        return ResponseEntity.ok(incomeService.getIncome(id));
    }

    @PostMapping(value = "/createIncome", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IncomeDto> createIncome(@Valid @RequestBody IncomeDto incomeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(incomeService.addIncome(incomeDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<IncomeDto> updateIncome(@PathVariable Long id,@Valid @RequestBody IncomeDto incomeDto){
        return ResponseEntity.ok(incomeService.updateIncome(id,incomeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id){
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }
}
