package com.example.assignment01.Entity;

// 클래스 정의
public class Car {
    // 멤버 변수 (속성)
    private String make;
    private String model;
    private int year;
    private int speed;

    //기본 생성자
    public Car() {}

    //매개변수가 3개인 생성자
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = 0;
    }

    //매개변수가 4개인 생성자
    public Car(String make, String model, int year,int speed) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = speed;
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
    public int emergencyBrake() {
        this.speed = 0;
        System.out.println("브레이크! \n현재속도 :" + speed);
        return this.speed;
    }

    public int setSpeed(int speed) {
        this.speed = speed;
        return this.speed;
    }

    public int getSpeed() {
        return this.speed;
    }
    public void displayInfo() {
        System.out.println("제조사: " + make + ", 모델: " + model + ", 연식: " + year);
    }
}