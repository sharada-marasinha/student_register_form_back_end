package edu.icet.annotations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
//Aspect-Orientation
public class MethodStatAspect {
    @Around("@annotation(edu.icet.annotations.MethodStat)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startTime;
        log.info("Time taken for calculation is : {} Miles seconds", executionTime);
        return proceed;
    }
}
