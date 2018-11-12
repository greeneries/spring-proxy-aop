package com.example.demo.proxy.step3;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//마우스 오른쪽 클릭 > Run As > Java Application으로 실행 
@Component
public class Test { 


	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		hello.say(); // 1. 핵심로직만 실행
		System.out.println("");
		
		// class 설계도 없이 동적으로 프록시 객체를 만들었다.
		// 이 기술을 JDK Dynamic Proxy 라고 부른다.
		// Spring은 target객체가 인터페이스를 구현하고 있다면 
		// JDK Dynamic Proxy 기술을 사용하여 Proxy 객체를 만든다.
		Hello h = (Hello)Proxy.newProxyInstance(Hello.class.getClassLoader(), 
						new Class[] {Hello.class}, new MyAdvice(hello)); // java.lang.reflect.Proxy;
		h.say();
	}
	
}
