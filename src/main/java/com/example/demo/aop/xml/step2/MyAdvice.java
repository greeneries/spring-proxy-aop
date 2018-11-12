package com.example.demo.aop.xml.step2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

// 횡단 관심사 로직을 가지고 있는 MyAdvice

// Around Advice 로직은 MethodInterceptor 인터페이스를 구현합니다.
// Target Method 로직 처리 후 리턴하는 리턴 값을 조작하고 싶을 때 주로 around advise를 사용합니다.
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
