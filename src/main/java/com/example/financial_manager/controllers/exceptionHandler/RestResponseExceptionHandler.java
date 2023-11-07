package com.example.financial_manager.controllers.exceptionHandler;

import com.example.financial_manager.controllers.exceptionHandler.exceptions.NoSuchExpanseException;
import com.example.financial_manager.controllers.exceptionHandler.exceptions.NoSuchIncomeException;
import com.example.financial_manager.controllers.exceptionHandler.exceptions.NoSuchLoanException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NoSuchExpanseException.class, NoSuchIncomeException.class, NoSuchLoanException.class})
    protected ResponseEntity<Object> handleNoSuchEntity(RuntimeException exception, WebRequest request){
        return handleExceptionInternal(exception,exception.getMessage(),new HttpHeaders(), HttpStatus.NOT_FOUND,request);
    }
}
