package com.example.demo.pointcut.step1;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

//마우스 오른쪽 클릭 > Run As > Java Application으로 실행 
public class SecondTest {
	public static void main(String[] args) {
		Advice advice = new MyAdvice();

		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* com.example.demo.pointcut.step1.Second.*o*(..))"); // Second클래스에서 메소드 이름이 o가 포함된 것을 필터한다.
		
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
		
		System.out.println("------------------second-----------------------");
		
		ProxyFactory factory2 = new ProxyFactory();
		factory2.setTarget(new Second());
		factory2.addAdvisor(advisor);
		Second f2 = (Second) factory2.getProxy();
		f2.one();
		f2.one2();
		f2.two();
		f2.add(2, 3);
		
		
	}
}