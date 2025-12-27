// package com.examly.springapp.aop;

// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.After;
// import org.springframework.stereotype.Component;

// @Aspect
// @Component
// public class MyAspect {

//     @Before("execution(* com.examly.springapp.service.*.*(..))")
//     public void logBeforeServiceMethods(JoinPoint joinPoint) {
//         System.out.println("[AOP] Starting method: " + joinPoint.getSignature().getName());
//     }

//     @After("execution(* com.examly.springapp.service.*.*(..))")
//     public void logAfterServiceMethods(JoinPoint joinPoint) {
//         System.out.println("[AOP] Finished method: " + joinPoint.getSignature().getName());
//     }
// }
