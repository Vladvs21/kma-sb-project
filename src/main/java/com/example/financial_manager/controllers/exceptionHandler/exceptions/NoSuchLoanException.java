package com.example.financial_manager.controllers.exceptionHandler.exceptions;

public class NoSuchLoanException extends RuntimeException {
    public NoSuchLoanException(Long id) {
        super("No such Loan with id: "+id);
    }
}
