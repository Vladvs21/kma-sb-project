package com.example.financial_manager.controllers.exceptionHandler.exceptions;

public class NoSuchExpanseException extends RuntimeException{
    public NoSuchExpanseException(Long id){
        super("No such Expanse with id: "+id);
    }
}
