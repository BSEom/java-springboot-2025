package com.ebs0012.spring02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring02Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring02Application.class, args);

		// 예외처리
		int result = 0;
		try {
			result = 17 / 0;	
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		
		System.out.println(result);

		String[] names = { "Hugo" , "Ashley", "Jini" };
		
		try {
			System.out.println(names[3]);	
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

		System.out.println("프로그램 종료!");	// 정상적으로 프로그램 종료

	}

}
