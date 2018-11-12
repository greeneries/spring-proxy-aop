package com.example.demo.proxy.step7;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


// 타켓 클래스의 핵심로직 앞/디로 수행해야 하는 로직이 무엇인지 보유하고 있는 클래스다.
public class MyAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------");

		// 핵심로직을 호출한다. 
		//super.say();

		// 범용적으로 이 로직을 허용하기 위해서 타켓 클래스와 핵심로직 메소드를
		// 노출하지 않으면서 해당 메소드를 호출해야 한다. (Java reflection 기술)
		Object ret = invocation.proceed();
		System.out.println("---------Around After Advice----------");
		return ret;
	}


}
