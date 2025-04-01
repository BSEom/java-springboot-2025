package com.ebs0012.spring02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;	// 콘솔 입력받을 클래스 선언

@SpringBootApplication
public class Spring02Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring02Application.class, args);

		Scanner scan = new Scanner(System.in);

		System.out.print(">> 아이디 입력 : ");
		String userid = scan.next();
		System.out.print(">> 비밀번호 입력 : ");
		String passwd = scan.next();

		System.out.println("입력 아이디 --> " + userid);
		System.out.println("입력 비밀번호 --> " + passwd);

		
		// 문자열은 == 으로 비교하면 메모리 주소를 비교함, 값을 비교하기에는 옳지않음 equal 쓰자 
		
		// if문 연습
		if (userid.equals("ebs0012") && passwd.equals("root1234")) {
			System.out.println("로그인 성공!");
		} else {
			System.out.println("로그인 실패!! 아이디 또는 비밀번호 오류!");
		}

		// switch문 연습
		switch (passwd) {
			case "root1234":
				System.out.println("패스워드 변경요망");
				break;
			case "12":
				System.out.println("패스워드 오류1!");
				break;
			case "34":
				System.out.println("패스워드 오류2!");
				break;
			default:
				System.out.println("전제 오류!");
				break;
		}

		// 3항연산 연습
		String result = (passwd.equals("root1234")) ? "메인화면 진입" : "로그인 화면으로";
		System.out.println("다음화면 >> " + result);
		

	}

}
