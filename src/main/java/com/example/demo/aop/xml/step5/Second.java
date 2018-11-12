package com.example.demo.aop.xml.step5;

import org.springframework.stereotype.Component;

// target class
@Component
public class Second {
	public void one() {
		System.out.println("Second # one()");
	}

	public void one2() {
		System.out.println("Second # one2()");
	}

	public void two() {
		System.out.println("Second # two()");
		
		
		throw new RuntimeException("앗! 예외가 발생해서 퇴근을 못 해요.");
	}

	public double add(double a, double b) {
		System.out.println("Second # add(double a, double b)");
		return a + b;
	}
}
