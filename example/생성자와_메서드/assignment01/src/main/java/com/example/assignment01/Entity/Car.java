package com.example.assignment01.Entity;

// 클래스 정의
public class Car {
    // 멤버 변수 (속성)
    private String make;
    private String model;
    private int year;
    private int speed;

    // 생성자 (객체 초기화)
    // 매번 이렇게 작성을 해야하나.. 귀찮은데... -> lombok 어노테이션
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = 0;
    }

    // 메서드 (기능)
    public void accelerate() {
        speed += 10;
        System.out.println("속도가 증가했습니다. 현재 속도: " + speed);
    }

    public void brake() {
        speed -= 10;
        System.out.println("속도가 감소했습니다. 현재 속도: " + speed);
    }

    public void displayInfo() {
        System.out.println("제조사: " + make + ", 모델: " + model + ", 연식: " + year);
    }
}