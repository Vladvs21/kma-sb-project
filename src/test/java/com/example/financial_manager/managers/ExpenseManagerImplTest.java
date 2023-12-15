package com.example.financial_manager.managers;

import com.example.financial_manager.components.ExpenseManagerImpl;
import com.example.financial_manager.controllers.exceptionHandler.exceptions.NoSuchExpanseException;
import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.entities.ExpenseEntity;
import com.example.financial_manager.mappers.ExpenseMapper;
import com.example.financial_manager.repositories.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExpenseManagerImplTest {

    @Mock
    private ExpenseMapper expenseMapper;

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseManagerImpl expenseManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddExpense() {
        ExpenseDto expenseDto = new ExpenseDto();
        ExpenseEntity expenseEntity = new ExpenseEntity();

        when(expenseMapper.expenseDtoToExpanseEntity(expenseDto)).thenReturn(expenseEntity);
        when(expenseMapper.expanseEntityToExpanseDto(expenseEntity)).thenReturn(expenseDto);
        when(expenseRepository.save(expenseEntity)).thenReturn(expenseEntity);

        ExpenseDto result = expenseManager.addExpense(expenseDto);
        assertNotNull(result);
        assertEquals(expenseDto, result);
    }

    @Test
    public void testGetAllExpenses() {
        List<ExpenseEntity> expenseEntities = Collections.singletonList(new ExpenseEntity());
        List<ExpenseDto> expenseDtos = Collections.singletonList(new ExpenseDto());

        when(expenseRepository.findAll()).thenReturn(expenseEntities);
        when(expenseMapper.expanseEntityToExpanseDto(any())).thenReturn(expenseDtos.get(0));
        List<ExpenseDto> result = expenseManager.getAllExpenses(1L);
        assertNotNull(result);
    }

    @Test
    public void testGetExpenseById_ThrowsNoSuchExpenseException() {
        long expenseId = 1L;

        when(expenseRepository.findById(expenseId)).thenReturn(Optional.empty());

        assertThrows(NoSuchExpanseException.class, () -> expenseManager.getExpenseById(expenseId));
    }

    @Test
    public void testUpdateExpense_ThrowsNoSuchExpenseException() {
        long expenseId = 1L;
        ExpenseDto expenseDto = new ExpenseDto();

        when(expenseRepository.findById(expenseId)).thenReturn(Optional.empty());

        assertThrows(NoSuchExpanseException.class, () -> expenseManager.updateExpense(expenseId, expenseDto));
    }

    @Test
    public void testCalculateTotalExpenses() {
        List<ExpenseEntity> expenseEntities = Collections.singletonList(new ExpenseEntity());
        expenseEntities.get(0).setExpanseAmount(100.0);

        double sum = expenseRepository.findAllByUserId(1L).stream().mapToDouble(ExpenseEntity::getExpanseAmount).sum();
        double result = expenseManager.calculateTotalExpenses(1L);
        assertEquals(sum, result);
    }

    @Test
    public void testDeleteExpense() {
        Long id = 1L;
        ExpenseEntity expenseEntity = new ExpenseEntity();

        when(expenseRepository.findById(id)).thenReturn(Optional.of(expenseEntity));

        expenseManager.deleteExpense(id);
    }

    @Test
    public void testDeleteExpense_ThrowsNoSuchExpenseException() {
        when(expenseRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchExpanseException.class, () -> {
            expenseManager.deleteExpense(1L);
        });
    }
}
