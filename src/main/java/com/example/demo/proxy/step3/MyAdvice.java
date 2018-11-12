package com.example.demo.proxy.step3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


// 기존의 Proxy 클래스는 Hello 구현체만 프록싱 할 수 있었으나
// MyAdvice는 어떠한 타겟 객체도 프록싱할 수 있다.
public class MyAdvice implements InvocationHandler{

	// 어떠한 타켓 객체도 취급할 수 있도록 Object 자료형으로 저장한다. 
	private Object target;

	public MyAdvice(Object target) {
		this.target = target;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		// before advice : target 객체 전에 실행되는 before advice
		System.out.println("-------------------");
		// 범용성을 확보하기 위해서는 특정 자료형이 노출되면 안 된다. 
		//((Hello)target).say(); 

		// target 객체의 핵심로직을 수행해야 함.
		// Method method 안에 이미 어떤 객체인지 담겨 있음.
		// 메소드를 호출하면서 파라미터로 args를 전달한다. 
		Object result = method.invoke(target, args);
		
		// after advice : target 객체 전에 실행되는 after advice
		System.out.println("-------------------");
		return result;
	}

}
