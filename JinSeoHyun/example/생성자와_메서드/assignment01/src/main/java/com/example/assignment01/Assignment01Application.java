package com.example.assignment01;

import com.example.assignment01.Entity.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment01Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment01Application.class, args);
		// 인스턴스 생성
		Car myCar0 = new Car("Hyundai", "G80", 2022);
		// 메서드 호출
		myCar0.displayInfo();
		myCar0.accelerate();
		myCar0.brake();

		Car myCar1 = new Car("Hyundai", "G80", 2022);

		myCar1.setSpeed(100);
		System.out.println(myCar1 .getSpeed());
		myCar1.emergencyBrake();

		Car myCar2  = new Car("Hyundai", "G80", 2022,200);
		myCar2.displayInfo();

	}
}
