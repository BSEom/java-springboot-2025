package com.ebs0012.spring05;

// 부모클래스 동물
public class Animal {
    String name;
    
    void setName(String name) {
        this.name = name;
    }
    
    String getName() {
        return this.name;
    }

    void cry() {
        System.out.println(this.name + "가 웁니다.");
    }
}

