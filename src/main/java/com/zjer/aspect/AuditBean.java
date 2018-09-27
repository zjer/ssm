package com.zjer.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
*
 * @author shijun
 * @date 2018/8/2 10:34
 * @param 
 * @return 
*/
@Component
@Aspect
public class AuditBean {
    @Around("within(com.zjer.service..*)")
    public Object audit(ProceedingJoinPoint joinPoint) {
        Object object = null;
        try {
            long timeStart = System.currentTimeMillis();
            //执行目标的方法
            object = joinPoint.proceed();
            long timeEnd = System.currentTimeMillis();
            String string = joinPoint.getSignature().toString();
            System.out.println(string + "耗时：" + (timeEnd - timeStart));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }
}
