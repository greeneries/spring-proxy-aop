package com.example.demo.aop.xml.step1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

// 횡단 관심사 로직을 가지고 있는 MyAdvice

@Component
public class MyAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("-----Around Before Advice-----");
		Object ret = invocation.proceed();
		System.out.println("=====Around After Advice======");
		return ret;
	}
}
