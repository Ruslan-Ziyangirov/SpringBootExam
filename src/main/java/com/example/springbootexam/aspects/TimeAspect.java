package com.example.springbootexam.aspects;

import com.example.springbootexam.dto.WrapperResponseDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {

    @Around(value = "execution(* com.example.springbootexam.controllers.AdController.*(..))")
    public ResponseEntity<WrapperResponseDto> addTimeToResponse(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long before = System.currentTimeMillis();
        Object responseEntity = proceedingJoinPoint.proceed();
        long after = System.currentTimeMillis();
        ResponseEntity response = (ResponseEntity) responseEntity;
        return ResponseEntity.ok( WrapperResponseDto.builder()
                .time(after-before)
                .object(response.getBody())
                .build());

    }
}
