package com.example.financial_manager.controllers;

import com.example.financial_manager.dto.IncomeDto;
import com.example.financial_manager.dto.LoanDto;
import com.example.financial_manager.managers.LoanManager;
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
@RequestMapping("user/{userId}/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanManager loanService;

    @GetMapping("/view")
    public ModelAndView viewAllLoans(Model model, ModelMap map, @PathVariable Long userId) {
        List<LoanDto> loans = loanService.getAllLoans(userId);
        LoanDto loanDto = new LoanDto();
        loanDto.setUserId(userId);
        model.addAttribute("loans", loans);
        model.addAttribute("newLoan", loanDto);
        return new ModelAndView("loans", map);
    }

    @GetMapping
    public ResponseEntity<List<LoanDto>> getAllLoans(@PathVariable Long userId) {
        return ResponseEntity.ok(loanService.getAllLoans(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanDto> getLoan(@PathVariable Long id, @PathVariable Long userId) {
        return ResponseEntity.ok(loanService.getLoan(id));
    }

    @PostMapping("/createLoan")
    public ModelAndView createLoan(@Valid LoanDto incomeDto, @PathVariable Long userId){
        loanService.addLoan(incomeDto);
        return new ModelAndView("redirect:/user/{userId}/loans/view");
    }
    @PutMapping("/{id}")
    public ResponseEntity<LoanDto> updateLoan(@PathVariable Long id,@Valid LoanDto incomeDto, @PathVariable Long userId){
        return ResponseEntity.ok(loanService.updateLoan(id,incomeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id, @PathVariable Long userId){
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
