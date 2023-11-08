package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// => Boot 서버 kill
//    netstat -a -n -o -p tcp
//    taskkill /f /pid  14540

//** @SpringBootApplication
//=> 해당 클래스가 Springboot의 설정 클래스임을 명시하며
//   해당 클래스를 메인으로 실행됨
//=> 해당 클래스가 있는 Package를 기본 Package로 간주함
//  그러므로 같은 Package 내의 클래스들은 Scan 됨.
//( 즉, @ComponentScan 을 이미 포함하고 있음 ) 
//=> 소스코드 내부를 보면 다양한 @들을 내포하여 기본동작을 실행하고 자동설정한다  

//=> 기본속성 ( https://mangkyu.tistory.com/211 )
// - exclude: 특정 클래스를 자동 설정에서 제외함
// - excludeName: 클래스의 이름으로 자동 설정에서 제외함
// - scanBasePackages: 컴포넌트 스캔(빈 탐색)을 진행할 베이스 패키지를 설정함
// - scanBasePackageClasses: 컴포넌트 스캔(빈 탐색)을 진행할 베이스 클래스를 설정함
// - nameGenerator: 빈 이름 생성을 담당할 클래스를 설정함
// - proxyBeanMethods: @Bean 메소드를 프록시 방식으로 처리하도록 설정함

//** @SpringBootApplication 의 하위 애너테이션

//=> @SpringBootConfiguration
// - @Configuration과 동일한 역할을 수행
// - 애플리케이션에 1개만 존재해야하며, @SpringBootApplication 안에 포함되어있으므로 따로 작성할 필요는 없음.
// - 그럼에도 존재하는 이유는 해당 애너테이션을 기준으로 설정들을 불러오기 위함
//   (대표적으로 SpringBoot의 통합테스트 애너테이션인 @SpringBootTest 가 이를 사용함)   

//=> @EnableAutoconfiguration
// - SpringBoot 에서 필요할것 같은 빈들을 자동으로 설정해주는 자동설정 기능을 활성화
// - 이 설정으로 SpringBoot 에서는 대부분 자동설정되어있음.

//=> @MapperScan(value={"mapperInterface"})
// - Mapper Interface 위치 설정

//=> @ComponentScan(basePackages={"service"})
// - 기본 Package 외의 Package 를 인식시켜 클래스를 Scan할 수 있도록함.  

//** Mybatis interface 설정
//=> @MapperScan : Mapper 인터페이스들이 들어있는 패키지들을 인식시켜줌
//=> ~Mapper.xml 사용시
// - application.properties 화일에 아래설정 추가
//   mybatis.mapper-locations=classpath:/mappers/*Mapper.xml
// - Spring_MVC 와는 다르게 ~Mapper.xml 을 인식시킨다.  

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan(value= {"mapperInterface"})
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}//main

}//class
