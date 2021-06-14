package com.atakancoban.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

	//Sadece Message service classındaki bir metodu dinle
    @Before("execution(* com.atakancoban.service.MessageService.mesajVer(..))")
    public void mesajVerMetodundanOnce(JoinPoint joinPoint) {
        System.out.println("BEFORE  param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
    
    //service paketi altındaki tüm servislerin tüm metodları
    @After("execution(* com.atakancoban.service.*.*(..))")
    public void mesajVerMetodundanSonra(JoinPoint joinPoint) {
        System.out.println("AFTER  param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
