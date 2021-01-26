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

//    @Around("@annotation(LogExecutionTime)")    //이 어노테이션이 붙은 메소드를 실행하라는 뜻
//    @Around("execution(* com.springaop..*.get*(..))")   //com.springaop의 하위에 속해있고 메소드명이 'get'으로 시작하는 파라미터가 0개 이상인 메소드
    @Around("execution(* com.springaop..*Controller.*(..))") //com.springaop의 하위에 속해있고 'Controller'로 끝나는 클래스의 파라미터가 0개 이상인 메소드
    /*
    execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
    수식어 : public, private 등 수식어를 명시합니다. (생략 가능)
    리턴타입 : 리턴 타입을 명시합니다.
    클래스이름 및 이름 : 클래스이름과 메서드 이름을 명시합니다. (클래스 이름은 풀 패키지명으로 명시해야합니다. 생략도 가능)
    파라미터 : 메서드의 파라미터를 명시합니다.
    " * " : 모든 값을 표현합니다.
    " .. " : 0개 이상을 의미합니다.
     */
    public Object perTimeLog(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object time = pjp.proceed();    //메소드 실행
        stopWatch.stop();

        logger.info(stopWatch.prettyPrint());   //실행 시간 가져오기

        return time;

    }

}
