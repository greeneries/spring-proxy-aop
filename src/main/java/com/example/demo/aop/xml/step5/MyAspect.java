package com.example.demo.aop.xml.step5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect // 이 클래스가 AOP 설정정보를 갖고 있는 표시 
public class MyAspect {

	@Pointcut("execution(* add*(..))")
	public void aroundPointcut() {}
	
	
	@Pointcut("execution(* one*(..))")
	public void beforePointcut() {}
	

	@Pointcut("execution(* two*(..))")
	public void myafterPointcut() {}
	
	
//<aop:config proxy-target-class="true">
//	<aop:pointcut expression="execution(* one*(..))" id="before-pointcut"/>
//	<aop:pointcut expression="execution(* add*(..))" id="around-pointcut"/>
//	<aop:pointcut expression="execution(* two*(..))" id="myafter-pointcut"/>
//	
//	<aop:aspect ref="myAspect">
//		<aop:before method="myBefore" pointcut-ref="before-pointcut" />
//		<aop:around method="myAround" pointcut-ref="around-pointcut" />
//		<aop:after-returning method="myAfterReturning" pointcut-ref="myafter-pointcut" />
//		<aop:after-throwing method="myAfterThrowing" pointcut-ref="myafter-pointcut" />
//		<aop:after method="myAfter" pointcut-ref="myafter-pointcut" />
//	</aop:aspect>
//</aop:config>
	

//	@Around("aroundPointcut()")
	@Around("execution(* add*(..))")
	public Object myAround(ProceedingJoinPoint jointPoint) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("-------- Around Before Advice --------");
		Object ret = jointPoint.proceed(); // 처리 메소드 실행 
		System.out.println("-------- Around After Advice --------");
		return ret;
	}

	@Before("beforePointcut()")
	public void myBefore(JoinPoint joinPoint) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("######### Before Advice ##########");
	}
	
	@AfterReturning("myafterPointcut()")
	public void myAfterReturning() {
		System.out.println("*********** myAfterReturning ***********");
	}
	
	@AfterThrowing("myafterPointcut()")
	public void myAfterThrowing() {
		System.out.println("*********** myAfterThrowing ***********");
	}
	
	@After("execution(* add*(..)) || execution(* two*(..))")
	public void myAfter() {
		System.out.println("*********** myAfter ***********");
	}
	

}
