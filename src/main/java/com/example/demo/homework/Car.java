package com.example.demo.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Car has Engine
@Component
public class Car {
	
	@Autowired
	private Engine engine;
	
	public void start() {

		engine.run();

	}
	
	public void stop() {
		engine.stop();
	}
}
