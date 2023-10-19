package com.example.financial_manager.controllers.exceptionHandler.exceptions;

public class NoSuchIncomeException extends RuntimeException{
    public NoSuchIncomeException(Long id){
        super("No such Income with id: "+id);
    }
}
