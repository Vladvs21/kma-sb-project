package com.example.financial_manager.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LimitMethodAspect {
    private static final int LIMIT = 5;

    private int counter = 0;
    private static final long WINDOW_IN_MILLISECONDS = 60000;
    @Pointcut("execution(* com.example.financial_manager.components.ExpenseManagerImpl.addExpense(..))")
    public void addExpanseMethod(){}

    @Around("addExpanseMethod()")
    public Object limitAddingExpanses(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();

        if (counter <= LIMIT) {
            counter++;
            return joinPoint.proceed();
        } else {
            // Перевищено ліміт
            System.out.println("Call limit exceeded for method: " + methodName);
            return null; // Можна викинути виняток або повернути інше значення за необхідності
        }
    }

    @Scheduled(fixedRate = WINDOW_IN_MILLISECONDS)
    public void resetCallCounters() {
        counter = 0;
    }
}
