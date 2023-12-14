package com.example.financial_manager.components;

import com.example.financial_manager.controllers.exceptionHandler.exceptions.NoSuchLoanException;
import com.example.financial_manager.dto.LoanDto;
import com.example.financial_manager.managers.LoanManager;
import com.example.financial_manager.entities.LoanEntity;
import com.example.financial_manager.mappers.LoanMapper;
import com.example.financial_manager.repositories.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoanManagerImpl implements LoanManager {


    private final LoanRepository repository;
    private final LoanMapper mapper;
    @Override
    public LoanDto addLoan(LoanDto loanDto) {
        LoanEntity loanEntity = mapper.loanDtoToLoanEntity(loanDto);
        repository.save(loanEntity);
        return mapper.loanEntityToLoanDto(loanEntity);
    }

    @Override
    public void deleteLoan(Long id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            throw new NoSuchLoanException(id);
        }
    }

    @Override
    public LoanDto updateLoan(Long id, LoanDto loanDto) {
      if(repository.findById(id).isPresent()){
          LoanEntity loanEntity = mapper.loanDtoToLoanEntity(loanDto);
          loanEntity.setLoan_id(id);
          repository.save(loanEntity);
          return mapper.loanEntityToLoanDto(loanEntity);
      }else{
          throw new NoSuchLoanException(id);
      }
    }


    @Override
    public List<LoanDto> getAllLoans(Long userId) {
        return repository.findAllByUserEntityId(userId).stream().map(mapper::loanEntityToLoanDto).toList();
    }

    @Override
    public List<LoanEntity> getAllEntityLoans(Long userId) {
        return repository.findAllByUserEntityId(userId);
    }

    @Override
    public LoanDto getLoan(Long id){
        if(repository.findById(id).isPresent()){
            return mapper.loanEntityToLoanDto(repository.findById(id).get());
        }else{
            throw new NoSuchLoanException(id);
        }

    }


    @Override
    public double calculateTotalLoans() {
        return repository.findAll().stream().mapToDouble(LoanEntity::getLoanAmount).sum();
    }
}
