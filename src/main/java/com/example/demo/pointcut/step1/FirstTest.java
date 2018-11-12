package com.example.demo.pointcut.step1;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

//마우스 오른쪽 클릭 > Run As > Java Application으로 실행 
public class FirstTest {
	public static void main(String[] args) {
		Advice advice = new MyAdvice();
		/*
		 * * execution() : 사용하는 표현식 종류 * 
		 * * one*(..) : 리턴자료형 메소드명(파라미터) <- 필수 설정 항목  
		 * * : all * one*
		 * : 메소드명이 one 문자열로 시작 
		 * * (..) : 파라미터 개수가 0~N개 가능, 각 파라미터 자료형은 상관이 없다. 
		 * * 포인트컷 조합 시 and, or , not을 사용할 수 있다.
		 */ 
		
		// advice를 적용 할 대상을 정하는 것을 pointcut이라고 한다. 
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		
		// setExpression: 대상을 어떻게 정할꺼냐? 어떻게 filter를 할 꺼냐? 
		// 리턴자료형 메소드명(파라미터) 이렇게 세개가 필수 항목이다.
		
		
		// *은 리턴자료형이 무엇이든 상관이 없다라는 의미
		// one*는 메소드 명이 one으로 시작하는 문자열 
		// (..) : 파라미터 개수가 0~N개 가능, 각 파라미터 자료형은 상관이 없다. 
		//pointcut.setExpression("execution(* one*(..))");
		
		//pointcut.setExpression("execution(* *(*,*))"); // 리턴자료형은 *이기 때문에 아무거나 상관없고 메소드명도 *이기 때문에 아무거나 상관없고 파라미터는 2개를 받는데 아무거나 상관없다.
		//pointcut.setExpression("execution(* *(int,int))"); // 리턴자료형은 *이기 때문에 아무거나 상관없고 메소드명도 *이기 때문에 아무거나 상관없고 파라미터는 2개를 받는데 int형이다.
		//pointcut.setExpression("execution(* *(int,..))"); // 리턴자료형은 *이기 때문에 아무거나 상관없고 메소드명도 *이기 때문에 아무거나 상관없고 파라미터는 첫번째는 int이고 두번째 파라미터부터 N까지는 아무거나 상관없다.
		pointcut.setExpression("execution(* *(*,*,..))"); // 파라미터를 2개 이상 받는 메소드에 advice를 허용한다. 
		
		// advisor라는 것은 pointcut, advice를 둘 다 가지고 있는 것을 advisor라고 한다.
		// pointcut으로 대상을 추려낸 후 advice를 주겠다는 의미 
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
		ProxyFactory factory = new ProxyFactory();
		
		
		factory.setTarget(new First());
		factory.addAdvisor(advisor);
		First f = (First) factory.getProxy();
		f.one();
		f.one2();
		f.two();
		f.add(2, 3);
					
	}
}