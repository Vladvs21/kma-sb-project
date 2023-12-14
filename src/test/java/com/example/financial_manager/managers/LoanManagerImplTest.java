package com.example.financial_manager.managers;

import com.example.financial_manager.components.LoanManagerImpl;
import com.example.financial_manager.controllers.exceptionHandler.exceptions.NoSuchLoanException;
import com.example.financial_manager.dto.LoanDto;
import com.example.financial_manager.entities.LoanEntity;
import com.example.financial_manager.mappers.LoanMapper;
import com.example.financial_manager.repositories.LoanRepository;
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

public class LoanManagerImplTest {

    @Mock
    private LoanMapper loanMapper;

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanManagerImpl loanManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddLoan() {
        LoanDto loanDto = new LoanDto();
        LoanEntity loanEntity = new LoanEntity();

        when(loanMapper.loanDtoToLoanEntity(loanDto)).thenReturn(loanEntity);
        when(loanMapper.loanEntityToLoanDto(loanEntity)).thenReturn(loanDto);
        when(loanRepository.save(loanEntity)).thenReturn(loanEntity);

        LoanDto result = loanManager.addLoan(loanDto);
        assertNotNull(result);
        assertEquals(loanDto, result);
    }

    @Test
    public void testGetAllLoans() {
        List<LoanEntity> loanEntities = Collections.singletonList(new LoanEntity());
        List<LoanDto> loanDtos = Collections.singletonList(new LoanDto());

        when(loanRepository.findAll()).thenReturn(loanEntities);
        when(loanMapper.loanEntityToLoanDto(any())).thenReturn(loanDtos.get(0));
        List<LoanDto> result = loanManager.getAllLoans();
        assertNotNull(result);
        assertEquals(loanDtos, result);
    }

    @Test
    public void testGetLoanById_ThrowsNoSuchLoanException() {
        long loanId = 1L;

        when(loanRepository.findById(loanId)).thenReturn(Optional.empty());

        assertThrows(NoSuchLoanException.class, () -> loanManager.getLoan(loanId));
    }

    @Test
    public void testUpdateLoan_ThrowsNoSuchLoanException() {
        long loanId = 1L;
        LoanDto loanDto = new LoanDto();

        when(loanRepository.findById(loanId)).thenReturn(Optional.empty());

        assertThrows(NoSuchLoanException.class, () -> loanManager.updateLoan(loanId, loanDto));
    }

    @Test
    public void testCalculateTotalLoans() {
        List<LoanEntity> loanEntities = Collections.singletonList(new LoanEntity());
        loanEntities.get(0).setLoanAmount(100.0);

        when(loanRepository.findAll()).thenReturn(loanEntities);
        double result = loanManager.calculateTotalLoans();
        assertEquals(100.0, result);
    }

    @Test
    public void testDeleteLoan() {
        Long id = 1L;
        LoanEntity loanEntity = new LoanEntity();

        when(loanRepository.findById(id)).thenReturn(Optional.of(loanEntity));

        loanManager.deleteLoan(id);
    }

    @Test
    public void testDeleteLoan_ThrowsNoSuchLoanException() {
        when(loanRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchLoanException.class, () -> {
            loanManager.deleteLoan(1L);
        });
    }
}
