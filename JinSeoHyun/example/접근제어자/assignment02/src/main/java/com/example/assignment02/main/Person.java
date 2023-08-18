package com.example.assignment02.main;

public class Person {
    public String name; // 어디서든 접근 가능
    protected int age; // 같은 패키지 또는 하위 클래스에서 접근 가능
    private String address; // 같은 클래스 내에서만 접근 가능
    String phoneNumber; // 같은 패키지 내에서만 접근 가능 (패키지 레벨)

    public Person(String name, int age, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // private 멤버에 대한 public 접근자 메서드
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

