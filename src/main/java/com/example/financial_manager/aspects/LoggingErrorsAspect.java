package com.example.financial_manager.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingErrorsAspect {
    private static final Logger logger = LogManager.getLogger(LoggingErrorsAspect.class);

    @Pointcut("execution(* com.example.financial_manager.components.ExpenseManagerImpl.*(..))")
    public void expanseMethods(){}

    @Pointcut("execution(* com.example.financial_manager.components.IncomeManagerImpl.*(..)))")
    public void incomeMethods(){}

    @Pointcut("execution(* com.example.financial_manager.components.LoanManagerImpl.*(..)))")
    public void loanMethods(){}

    @AfterThrowing("expanseMethods()")
    public void loggingExpansesExceptions(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        logger.error("Error in ExpanseManager method: "+ method);
    }

    @AfterThrowing("incomeMethods()")
    public void loggingIncomesExceptions(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        logger.error("Error in IncomeManager method: "+ method);
    }

    @AfterThrowing("loanMethods()")
    public void loggingLoansExceptions(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        logger.error("Error in LoanManager method: "+ method);
    }
}
