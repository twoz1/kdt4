package springMybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.MemberDTO;
import mapperInterface.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Ex02_interfaceMapper {
	
	// ** interface Mapper 설정
	// => Controller -> Service -> (DAO) -> interface Mapper : xml의 sql 구문을 이용해서 DB처리 
	
	@Autowired
	MemberMapper mapper;
	// => 성공: MemberMapper mapper = new MemberMapper구현객체 ;
	//    -> 구현객체 생성 부터는 Spring과 Mybatis가 규칙에 의해 처리해줌 
	//    -> 규칙: 패키지 명과 클래스명을 interface , mapper xml 모두 동일하게 해줌.
	//			  이를 위한 경로 설정 
	//			  <mybatis-spring:scan base-package="mapperInterface"/> 	
	
	@Autowired
	MemberDTO dto;
	

	// ** mapper 의 동작 Test
	public void mapperTest() {
		assertNotNull(mapper);
		System.out.println("** mapper Interface 의 구현객체 => "+mapper.getClass().getName());
		System.out.println("** dto 인스턴스의 클래스 이름 => "+dto.getClass().getName()); //domain.MemberDTO
		// => getClass().getName() : 실제동작하는 클래스(MemberMapper의 구현객체) 의 이름 확인가능
		//    이를 통해 우리는 Mapper interface 만 작성했지만, 
		//    내부적으로는 동일한 타입의 클래스가 만들어졌음을 알 수 있다.  
	}
	
	// ** mapper 의 Method Test
	// 1) selectOne
	public void selectOne() {
		dto.setId("banana"); // 있는 id
		//dto=mapper.selectOne(dto);
		// => Mybatis 적용하는 경우 SQL구문처리에서 매개변수의 주소를 공유하지않기 때문에
		//    selectOne 처리 결과를 전달받아야함 
		// ** 비교
		mapper.selectOne(dto);
		// => 아래 출력문의 dto 의 값이 모두 출력되는지 비교
		//    Mybatis 에서는 매개변수의 주소를 공유하지않음을 알수있다.
		System.out.println("** dto => "+dto); 
		assertNotNull(dto);
	}
	// 2) insert & delete
	//@Before
	public void insertTest() {
		dto.setId("mapper");
		dto.setPassword("12345!");
		dto.setName("유니트");
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

	public void deleteTest() {
		dto.setId("mapper");
		assertEquals(mapper.delete(dto), 1);  
	}
	
	// 3) mapper (xml) 없이 Test 하기
	// => Mapper interface 의 메서드명 위에 @ 을 이용하여 sql 구문 작성
	//    @Select("select * from member where lev='D'")
	// => @select : mapper 없이 일반 쿼리구문을 작성해서 사용할 수 있도록 해줌
	// => 매개변수에 String id 적용
	//	  mapper 메서드의 매개변수는 Type 무관, 그러나 갯수는 반드시 1개
	public void selectOneID() {
		System.out.println("** selectOneID => "+mapper.selectOneID("apple"));
	}
	
	// 4) @Param Test (매개변수 id, jno)
	// => Mybatis 에서 2개이상의 매개변수 처리
	// => 존재하는 Data , 존재하지않는 Data 비교
	@Test
	public void paramTest() {
		dto=mapper.selectOneJno("banana", 7);
		System.out.println("** dto => "+dto);
		assertNotNull(dto);    
	}
	@Test
	// 5) totalCount
	// => admin을 제외한 전체 member count, 출력 확인
	// => interface에 메서드만 추가
	public void totalCountTest() {
		System.out.println("** totalCount => "+mapper.totalCount());
	}	

} //class
