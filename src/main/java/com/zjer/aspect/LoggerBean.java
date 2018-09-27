package com.zjer.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
*
 * @author shijun
 * @date 2018/8/2 10:50
 * @param 
 * @return 
*/
@Component
@Aspect
public class LoggerBean {
    @Before("within(com.zjer.controller..*)")
    public void logController() {
        System.out.println("AOP切面注入Controller!");
    }

    @Before("within(com.zjer.service..*)")
    public void logService() {
        System.out.println("AOP切面注入Service!");
    }
}
