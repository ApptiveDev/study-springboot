package com.example.assignment01;

import com.example.assignment01.Entity.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment01Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment01Application.class, args);
		// 인스턴스 생성
		Car jieunCar = new Car("Hyundai", "CASPER", 2021);
		jieunCar.setSpeed(100);

		Car jieunCar2 = new Car("Hyundai", "CASPER", 2021, 100);
		jieunCar2.displayInfo();
		jieunCar2.emergencyBrake();
	}
}
