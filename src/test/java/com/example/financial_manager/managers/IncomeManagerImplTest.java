package com.example.financial_manager.managers;

import com.example.financial_manager.components.IncomeManagerImpl;
import com.example.financial_manager.controllers.exceptionHandler.exceptions.NoSuchIncomeException;
import com.example.financial_manager.dto.IncomeDto;
import com.example.financial_manager.entities.IncomeEntity;
import com.example.financial_manager.mappers.IncomeMapper;
import com.example.financial_manager.repositories.IncomeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IncomeManagerImplTest {

    @Mock
    private IncomeMapper incomeMapper;

    @Mock
    private IncomeRepository incomeRepository;

    @InjectMocks
    private IncomeManagerImpl incomeManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddIncome() {
        IncomeDto incomeDto = new IncomeDto();
        IncomeEntity incomeEntity = new IncomeEntity();

        when(incomeMapper.incomeDtoToIncomeEntity(incomeDto)).thenReturn(incomeEntity);
        when(incomeMapper.incomeEntityToIncomeDto(incomeEntity)).thenReturn(incomeDto);
        when(incomeRepository.save(incomeEntity)).thenReturn(incomeEntity);

        IncomeDto result = incomeManager.addIncome(incomeDto);
        assertNotNull(result);
        assertEquals(incomeDto, result);
    }

    @Test
    public void testGetAllIncomes() {
        List<IncomeEntity> incomeEntities = Collections.singletonList(new IncomeEntity());
        List<IncomeDto> incomeDtos = Collections.singletonList(new IncomeDto());

        when(incomeRepository.findAll()).thenReturn(incomeEntities);
        when(incomeMapper.incomeEntityToIncomeDto(any())).thenReturn(incomeDtos.get(0));
        List<IncomeDto> result = incomeManager.getAllIncomes();
        assertNotNull(result);
        assertEquals(incomeDtos, result);
    }

    @Test
    public void testGetIncomeById_ThrowsNoSuchIncomeException() {
        long incomeId = 1L;

        when(incomeRepository.findById(incomeId)).thenReturn(Optional.empty());

        assertThrows(NoSuchIncomeException.class, () -> incomeManager.getIncome(incomeId));
    }

    @Test
    public void testUpdateIncome_ThrowsNoSuchIncomeException() {
        long incomeId = 1L;
        IncomeDto incomeDto = new IncomeDto();

        when(incomeRepository.findById(incomeId)).thenReturn(Optional.empty());

        assertThrows(NoSuchIncomeException.class, () -> incomeManager.updateIncome(incomeId, incomeDto));
    }

    @Test
    public void testCalculateTotalIncomes() {
        List<IncomeEntity> incomeEntities = Collections.singletonList(new IncomeEntity());
        incomeEntities.get(0).setIncomeAmount(100.0);

        when(incomeRepository.findAll()).thenReturn(incomeEntities);
        double result = incomeManager.calculateTotalIncome();
        assertEquals(100.0, result);
    }

    @Test
    public void testDeleteIncome() {
        Long id = 1L;
        IncomeEntity incomeEntity = new IncomeEntity();

        when(incomeRepository.findById(id)).thenReturn(Optional.of(incomeEntity));

        incomeManager.deleteIncome(id);
    }

    @Test
    public void testDeleteIncome_ThrowsNoSuchIncomeException() {
        when(incomeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchIncomeException.class, () -> {
            incomeManager.deleteIncome(1L);
        });
    }
}

