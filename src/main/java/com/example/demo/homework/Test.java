package com.example.demo.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 일반 차는 안전벨트를 제공하지 않습니다. 
		ApplicationContext context = new ClassPathXmlApplicationContext("car-advice.xml");   
	
		Car car = context.getBean("car", Car.class);

		car.start();
		car.stop();

		
		// 안전벨트를 착용했으면 engine is running 만약 안전벨트를 착용하지 않았으면 띵동 안전벨트를 착용하세요.
		Car luxuryCar = context.getBean("luxuryCar", LuxuryCar.class);

		luxuryCar.start();
		luxuryCar.stop();

		
	
	}

}
