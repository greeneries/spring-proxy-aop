package com.example.demo.xml.homework;

import org.springframework.stereotype.Component;

@Component
public class Engine {

	
	public void run() {
		System.out.println("Engine is running...");
	}
	
	public void stop() {
		System.out.println("Engine is stopping...");
	}
	
}
