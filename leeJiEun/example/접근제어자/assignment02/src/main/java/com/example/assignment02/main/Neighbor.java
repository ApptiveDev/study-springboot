package com.example.assignment02.main;

// 같은 패키지 내의 다른 클래스
class Neighbor {
    public void printInfo(Person person) {
        System.out.println(person.name); // 가능
        System.out.println(person.age); // 가능
        // 오류! private 멤버
        //System.out.println(person.address);
        System.out.println(person.phoneNumber); // 가능
    }
}