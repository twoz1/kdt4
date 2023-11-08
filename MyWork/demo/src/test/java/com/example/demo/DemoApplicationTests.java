package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.MemberDTO;

import mapperInterface.MemberMapper;

//** @RunWith
//=> 테스트 실행방법을 확장할때 사용하는 에너테이션. 
//  즉, JUnit 테스트시 내장된 Runner를 실행할 때
//  SpringRunner.class라는 확장된 클래스를 실행하라고 지시함.
//
//** @SpringBootTest
//=> 스프링 부트 어플리케이션 테스트시 필요한 대부분의 의존성을 제공함. 
//=> @SpringBootApplication을 기준으로 스프링 빈을 등록함과 동시에 
//  Maven 같은 빌드 툴에 의해 추가된 스프링부트 의존성도 제공해 줌. 
//=> @SpringBootTest 는 webEnvironment라는 값을 통해 
//  웹 어플리케이션 테스트시 Mock으로 테스트할 것인지,
//  실제 톰캣 같은 서블릿 컨테이너를 구동해서 테스트할 것인지를 정할 수 있음.

@RunWith(SpringRunner.class)
//=> JUnit4 선택 (JUnit5부터  @RunWith는 지원되지않음)
@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	DataSource ds;
	@Autowired
	SqlSessionFactory ssf;
	
	@Autowired
	MemberMapper mapper;
	
	MemberDTO dto = new MemberDTO();
	
	//@Test
	void contextLoads() throws Exception {
		// 1) DataSource, SqlSessionFactory
		System.out.println("** DataSource =>"+ds);
		Connection cn = ds.getConnection();
		System.out.println("** Connection =>"+cn);
		assertNotNull(cn);
		
		// 2) SqlSessionFactory 연결확인
		System.out.println("** SqlSessionFactory =>" +ssf);
		assertNotNull(ssf);
	}
	
	   // 3) Mapper Test
     //@Before
     void insertTest() {
    	  dto.setId("bootin");
    	  dto.setPassword("12345!");
    	  dto.setName("부트");
    	  dto.setAge(20);
          dto.setJno(7);
          dto.setInfo("성공이냐 실패냐 ~~~");
          dto.setPoint(99.88);
          dto.setBirthday("1999-09-09");
          dto.setRid("banana");
          dto.setUploadfile("resource/uploadImages/aaa.gif");
    	      // => 성공:1 , 실패:0
    	  assertEquals(mapper.insert(dto), 1);         
    	   } //insertTest
     
     //@Test
     void deleteTest() {
          dto.setId("bootin");
          assertEquals(mapper.delete(dto), 1);  
     }
     
     //@Test
     void listTest() {
    	 System.out.println("** selecList Test **");
    	 for(MemberDTO m: mapper.selectList()) {
    		 System.out.println(m);
    	 }//for
     }//listTest

}
