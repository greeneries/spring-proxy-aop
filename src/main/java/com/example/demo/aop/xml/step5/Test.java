package com.example.demo.aop.xml.step5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	
	
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("aop-xml-step5.xml");
		
		First f = context.getBean(First.class);
		f.one();
		f.one2();
		f.two();
		f.add(2, 3);
		
		Second s = context.getBean(Second.class);
		s.one();
		s.one2();
		
		try {
			s.two();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// s.add(2, 3);
		double result = s.add(2, 3);
		System.out.println("result = "+ result);
		
	}
	
	
}