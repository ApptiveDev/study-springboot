package com.example.assignment02.another;


import com.example.assignment02.main.Person;

public class Stranger {
    public void printInfo(Person person) {
        System.out.println(person.name); // 가능
        // 오류! protected 멤버
        // System.out.println(person.age);
        // 오류! private 멤버
        // System.out.println(person.address);
         System.out.println(person.getAddress());
        // 오류! 패키지 레벨
        // System.out.println(person.phoneNumber);
    }
}