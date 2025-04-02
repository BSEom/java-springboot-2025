package com.ebs0012.spring04;

public class NewCar {
    // 맴버변수/속성
    String model_name;
    String company = "현대자동차";
    String color = "white";
    int release_year;
    String fuel_type = "휘발유";

    // 생성자(클래스명과 일치)
    NewCar() {
        model_name = "아반떼";
        this.company = "현대자동차";
        System.out.println("기본생성자 실행!");
    }

    // 메서드 오버로딩
    NewCar(String modle_name, String company, int release_year) {
        this.model_name = modle_name;
        this.company = company;
        this.release_year = release_year;
        System.out.println("인자 초기화생성자 실행!");
    }

    // 멤버메서드
    public void doAccelerate() {    // 가속
        System.out.println(this.model_name + " 가속!!\n");
    }
    public void doBreak() {    // 정지
        System.out.println(this.model_name + " 정지!!\n");
    }
    public void changeGear() {    // 기어변속
        System.out.println(this.model_name + " 기어변속!!\n");
    }
    public void turnLeft() {    // 좌회전
        System.out.println(this.model_name + " 좌회전!!\n");
    }
    public void turnRight() {    // 우회전
        System.out.println(this.model_name + " 우회전!!\n");
    }

}