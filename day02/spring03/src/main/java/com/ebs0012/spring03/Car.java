package com.ebs0012.spring03;

public class Car {
    String name;
	int year;
	private String company; // 클래스 외부에서 사용불가

	public void printCarName() {
		System.out.println("차 이름은 : " + name);
	} 

	// 메서드 오버로딩
	public void printCarName(String point) {
		System.out.println("차 이름은 : " + name + " 포인트는 " + point);
	}

	// 가변인자
	public void printCarName(String...name) {
		for (String n : name) {
			System.out.println(n);
		}
	}

	int calcYear(int currYear) {
		return currYear - year;
	}

    public static void printYear() {
        System.out.println("2020년");
    }
}
