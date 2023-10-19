package com.example.financial_manager.controllers;

import com.example.financial_manager.dto.LoanDto;
import com.example.financial_manager.managers.LoanManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanManager loanService;

    @GetMapping
    public ResponseEntity<List<LoanDto>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanDto> getLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.getLoan(id));
    }

    @PostMapping("/createLoan")
    public ResponseEntity<LoanDto> createLoan(@Valid @RequestBody LoanDto incomeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.addLoan(incomeDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LoanDto> updateLoan(@PathVariable Long id,@Valid @RequestBody LoanDto incomeDto){
        return ResponseEntity.ok(loanService.updateLoan(id,incomeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id){
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
