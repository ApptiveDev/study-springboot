package com.example.assignment01;

import com.example.assignment01.Entity.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment01Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment01Application.class, args);
		// 인스턴스 생성
		Car myCar = new Car("Hyundai", "G80", 2022);
		// 메서드 호출
		myCar.displayInfo();
		myCar.accelerate();
		myCar.brake();

		Car car100 = new Car("Hyundai", "G80", 2022);
		car100.setSpeed(100);
		System.out.println(car100.getSpeed());

		car100.emergencyBrake();
	}
}
