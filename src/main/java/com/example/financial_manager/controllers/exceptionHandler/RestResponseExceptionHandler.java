package com.example.financial_manager.controllers.exceptionHandler;

import com.example.financial_manager.FinanceManager;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class RestResponseExceptionHandler {
//    @ExceptionHandler(value = {NoSuchExpanseException.class, NoSuchIncomeException.class, NoSuchLoanException.class})
//    protected ResponseEntity<Object> handleNoSuchEntity(RuntimeException exception, WebRequest request){
//        return handleExceptionInternal(exception,exception.getMessage(),new HttpHeaders(), HttpStatus.NOT_FOUND,request);
//    }

    private static final Logger logger = LoggerFactory.getLogger(FinanceManager.class);

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ModelAndView createExpense(MethodArgumentNotValidException exception, HttpServletRequest request) {
        logger.error(exception.getMessage());
        String url = request.getRequestURL().toString();
        url = url.substring(0, url.lastIndexOf('/'));
        return new ModelAndView("redirect:"+url+"/view");
    }

}
