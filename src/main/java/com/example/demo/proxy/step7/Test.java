package com.example.demo.proxy.step7;


import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test { // 클라이언트 입장에서는 자기가 어떤 객체를 사용하는지 몰라야 한다.

	@Autowired
	private Hello h;

	// Proxy : target에 직접 물어보지 않고, 누군가를 거쳐 물어본다.
	// 하나하나 적용하면 Proxy이고, 수백개를 하면은 AOP가 된다. 
	// 핵심로직은 Hello 클래스에 구현하고, 핵심로직 전에 수행되어야 할 로직은 before Advice, after Advice를 통해 구현한다. 
	public static void main(String[] args) {
		Hello hello = new HelloImpl();
			
		Advice advice = new MyAdvice();
		
//      CGLIB Dynamic Proxy 
//		CGLIB는 코드 생성 라이브러리로서(Code Generator Library) 런타임에 동적으로 자바 클래스의 프록시를 생성해주는 기능을 제공한다. 
//		CGLIB를 사용하면 매우 쉽게 프록시 객체를 생성할 수 있으며, 성능 또한 우수하다. 
//		더불어, 인터페이스가 아닌 클래스에 대해서 동적 프록시를 생성할 수 있기 때문에 다양한 프로젝트에서 널리 사용되고 있다. 
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(hello);
		
		// advice를 사용하는 이유는 
		// 범용적으로 이 로직을 허용하기 위해서 타켓 클래스와 핵심로직 메소드를
		// 노출하지 않으면서 해당 메소드를 호출해야 한다. (Java reflection 기술)
		factory.addAdvice(advice);
		
		Hello proxy = (Hello) factory.getProxy();
		proxy.say();
	}
	
}
