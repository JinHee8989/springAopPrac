package com.springaop.test.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class TimeLogAspect {

    Logger logger = LoggerFactory.getLogger(TimeLogAspect.class);

    @Around("@annotation(LogExecutionTime)")    //이 어노테이션이 붙은 메소드를 실행하라는 뜻
    public Object perTimeLog(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object time = pjp.proceed();    //메소드 실행
        stopWatch.stop();

        logger.info(stopWatch.prettyPrint());   //실행 시간 가져오기

        return time;

    }

}
