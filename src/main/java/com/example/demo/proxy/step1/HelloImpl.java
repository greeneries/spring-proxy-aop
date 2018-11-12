package com.example.demo.proxy.step1;

//Target: 핵심로직을 제공하는 객체
public class HelloImpl implements Hello {
	@Override
	public void say() {
		// Primary Concern: 언제나 실행되어야 하는 로직
		// 상황에 따라 실행되는 로직
		System.out.println("-----전 처리 부가로직-----");
		System.out.println("핵심로직: Hello~!!!");
		
		// 상황에 따라 실행되는 로직
		System.out.println("=====후 처리 부가로직=====");
	}
}