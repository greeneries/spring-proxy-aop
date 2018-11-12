package com.example.demo.proxy.step6;


import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test { 

	public static void main(String[] args) {
//		Hello hello = new Hello();
//			
//		Advice advice = new MyAdvice();
//
//		ProxyFactory factory = new ProxyFactory();
//		factory.setTarget(hello);
//		factory.addAdvice(advice);
//		
//		Hello proxy = (Hello)factory.getProxy();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("proxy-factory-bean-demo.xml");
		Hello proxy = (Hello) context.getBean("proxy");
		proxy.say();
		proxy.bye();
	
	}
	
}
