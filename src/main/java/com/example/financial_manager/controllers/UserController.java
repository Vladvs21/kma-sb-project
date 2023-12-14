package com.example.financial_manager.controllers;

import com.example.financial_manager.components.UserManagerImpl;
import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.dto.UserDto;
import com.example.financial_manager.managers.UserManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserManagerImpl userManager;
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userManager.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/singUp")
    public ResponseEntity<UserDto> createExpense(UserDto userDto) {
        UserDto addUser = userManager.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addUser);
    }

    @PutMapping("/{id}/updatePersonalInfo")
    public ResponseEntity<UserDto> updateExpense(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        UserDto updatedExpense = userManager.updateUser(id, userDto);
        return ResponseEntity.ok(updatedExpense);
    }

}
