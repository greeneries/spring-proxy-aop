package com.example.demo.aop.xml.step3;

import org.springframework.stereotype.Component;

// target class
@Component
public class First {
	public void one() {
		System.out.println("First # one()");
	}

	public void one2() {
		System.out.println("First # one2()");
	}

	public void two() {
		System.out.println("First # two()");
	}

	public double add(double a, double b) {
		System.out.println("First # add(double a, double b)");
		return a + b;
	}
}
