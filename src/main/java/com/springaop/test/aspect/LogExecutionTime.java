package com.springaop.test.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)		        //어노테이션을 어디에 붙일지 정해주는 어노테이션
@Retention(RetentionPolicy.RUNTIME)		//어디까지 유지할건지 정해주는 어노테이션
public @interface LogExecutionTime {
}
