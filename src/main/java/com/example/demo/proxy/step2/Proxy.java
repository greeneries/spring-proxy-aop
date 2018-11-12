package com.example.demo.proxy.step2;

public class Proxy implements Hello {
	private Hello hello;

	public Proxy(Hello hello) {
		this.hello = hello;
	}

	@Override
	public void say() {
		System.out.println("-------------------");
		hello.say(); // 위임(Delegation): 핵심로직을 호출
		System.out.println("-------------------");
	}
}