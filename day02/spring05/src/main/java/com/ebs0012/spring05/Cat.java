package com.ebs0012.spring05;

public class Cat extends Animal {

    @Override
    void cry() {
        System.out.println(super.getName() + "가 웁니다. 야옹!!");
    }
    
}
