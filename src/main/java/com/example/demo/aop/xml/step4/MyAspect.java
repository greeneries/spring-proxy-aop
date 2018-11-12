package com.example.demo.aop.xml.step4;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

// Aspect: 공통적인 부가로직(횡단 관심사)를 어드바이스라 하고, 
//         새로운 aspect(물리적으로는 클래스)를 열여서 다수의 advice를 갖고 있는 것을 aspect라고 부른다.

@Component
public class MyAspect {

	public Object aroundTest(ProceedingJoinPoint joinPoint) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("-------- Around Before Advice --------");
		
		// target메소드 파라미터 값이 args가 있다. 
		Object[] args = joinPoint.getArgs();
		if(args != null && args.length > 0) {
			System.out.println("---------------------------------");
			Arrays.asList(args).forEach(System.out::println);
			System.out.println("---------------------------------");
		}
		
		Object ret = joinPoint.proceed(); // ret에는 add 결과 값이 5가 들어가 있다.
			
		ret = (Double)ret + 100; // 결과 값을 가로채서 100을 더해서 돌려준다. 
		
		System.out.println("-------- Around After Advice --------");
		return ret;
	}

	public void beforeTest(JoinPoint jointPoint) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("######### Before Advice ##########");
	}
	
	// afterReturning()하고 afterThrowing()은 동시에 실행 될 수 없다.
	// afterReturning()은 정상적일 때 수행
	// afterThrowing()은 비정상적일 때 수행
	public void myAfterReturning() {
		System.out.println("*********** myAfterReturning ***********");
	}
	
	public void myAfterThrowing() {
		System.out.println("*********** myAfterThrowing ***********");
	}
	
	public void myAfter() {
		System.out.println("*********** myAfter ***********");
	}
	

}
