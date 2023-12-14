package com.example.financial_manager.mappers;

import com.example.financial_manager.dto.LoanDto;
import com.example.financial_manager.entities.LoanEntity;
import com.example.financial_manager.managers.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanMapper {
    private final UserManager userManager;
    public LoanDto loanEntityToLoanDto(LoanEntity loanEntity){
        return new LoanDto(
                loanEntity.getLoan_id(),
                loanEntity.getLoanSource(),
                loanEntity.getLoanAmount(),
                loanEntity.getUserEntity().getId()
        );
    }

    public LoanEntity loanDtoToLoanEntity(LoanDto loanDto){
        return new LoanEntity(
                loanDto.getLoan_id(),
                loanDto.getLoanSource(),
                loanDto.getLoanAmount(),
                userManager.getUserEntityById(loanDto.getUserId())
        );
    }

}
