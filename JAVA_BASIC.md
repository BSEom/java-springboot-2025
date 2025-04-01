## Java 기초문법

### 기본
- 소스코드 템플릿

    ```java
    // 한줄 주석.
    /* 여러줄 
        주석. */
    package com.ebs0012.spring01; // 자기 프로젝트의 패키지명(폳더)

    import org.springframework.boot.SpringApplication;  // 라이브러리, 클래스 가져오기
    import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication  // 자바프로젝트 실행을 도와주는 어노테이션
    public class Spring01Application {  // 자신의 클래스명

        // 엔트리포인트(프로젝트당 하나만 존재)
        public static void main(String[] args) {  // 함수, 클래스, 조건문, 반복문시작이 중괄호({)
            SpringApplication.run(Spring01Application.class, args);  // 한줄이 끝나면 반드시 ;

            System.out.println("Hello, Spring Boot!");  // 콘솔출력, 문자열을 항상 "
        }

    }
    ```
    