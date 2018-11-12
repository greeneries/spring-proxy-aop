package com.example.demo.aop.xml.step3;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

// Aspect: 공통적인 부가로직(횡단 관심사)를 어드바이스라 하고, 
//         새로운 aspect(물리적으로는 클래스)를 열여서 다수의 advice를 갖고 있는 것을 aspect라고 부른다.

@Component
public class MyAspect implements MethodInterceptor, MethodBeforeAdvice{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("----- Around Before Advice -----");
		Object ret = invocation.proceed();
		System.out.println("===== Around After Advice ======");
		return ret;
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("-----------Before Advice------------");
	}

}
