package springTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.beans.factory.annotation.Autowired;

import domain.MemberDTO;
import model.MemberDAO;

//** DAOTest Spring Version
//=> 설정화일(~.xml) 을  사용
//	-> 테스트코드 실행시에 설정파일을 이용해서 스프링이 로딩 되도록 해줌
//	-> @RunWith(스프링 로딩) , @ContextConfiguration (설정파일 등록)

//=> IOC/DI Test
//=> 공통적으로 사용하는 MemberDAO dao 인스턴스를 전역으로 정의
//=> 자동 주입 받기 ( xml_root-context.xml , @ )

//** SpringJUnit4ClassRunner.class 자동 import 안되면 직접 복.붙 해본다.  

//** import 제대로 안되고 오류발생시 Alt+f5 눌러 Maven Update 한다.
//=> 메뉴 : Project 우클릭 - Maven - Update Project .. 
//	( 하기전 주의사항은 pom.xml 의  <plugin> <configuration> 의 
//				<source>1.8</source> 와 <target> Java 버전 확인 )


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
// => 단, servlet~~~.xml 에 @ scan 하도록 설정되어 있으므로 dao 가 이중으로 생성되어 오류발생
//    <context:component-scan base-package="com.ncs.green, service, model" />
// => "file:~~" 지정시 공백 없어야함
public class Ex01_SpringDAO {
	// ** 자동주입
	// => 생성: root~~~.xml 에 Bean 설정
	@Autowired
	MemberDAO dao;
	@Autowired
	MemberDTO dto;
	
	//1) Detail 정확성
	public void detailTest() {
		// ** 자동주입 확인
		System.out.println("** DAO 주입 확인 => "+dao);
		System.out.println("** DTO 주입 확인 => "+dto);
		assertNotNull(dao);
		assertNotNull(dto);
		
		dto.setId("banana"); //있는 Data: not null, Green_Line
		//dto.setId("black");    //없는 Data: null, Red_Line
		assertNotNull(dao.selectOne(dto));
		System.out.println("** dto => "+dto);
	}
	@Test
	//2) Insert 정확성
	public void insertTest() {
		dto.setId("junitSp");
		dto.setPassword("12345!");
		dto.setName("유니트");
		dto.setAge(22);
		dto.setJno(7);
		dto.setInfo("Junit Test");
		dto.setPoint(3000.3);
		dto.setBirthday("1999-09-09");
		dto.setRid("banana");
		dto.setUploadfile("resources/uploadImages/xxx.gif");
		// => 성공:1, 실패:0
		assertEquals(dao.insert(dto), 1);
	}
	

}
