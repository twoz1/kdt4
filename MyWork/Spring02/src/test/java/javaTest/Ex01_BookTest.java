package javaTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static org.junit.Assert.*;

//** Book class
//=> 맴버필드 3개 정의, 맴버필드 3개를 초기화하는 생성자를 만드세요 ~
//=> 접근범위는 default
class Book {
	String author;
	String title;
	int price;
	Book(String author, String title, int price) {
		this.author=author;
		this.title=title;
		this.price=price;
	}
	public boolean isBook(boolean b) { return b; }
} //Book

//** 테스트 레벨 4단계
//=> 단위테스트 -> 통합테스트 -> 시스템테스트 -> 인수테스트

//** 테스트 주도 개발 (Test-Driven Development , TDD)
//=> JUnit 활용
//	Java 개발시 가장 많이 이용되는 단위테스트 프레임
//	오픈 소스 형태로 개발되며 계속 업그레이드 되고 있음.
//	JUnit4 부터 에너테이션 적용 ( Java 가 5 부터 언어적 개선이 이루어짐에 따른 변화임 )

//** @ 종류
//=> @Before - @Test - @After
//	-> 하나의 클래스에서 @ 들을 반복사용하면 오류는 안나지만, 앞쪽 @이 실행됨
//=> @ 적용 테스트 메서드 : non static, void 로 정의 해야 함.

//** org.junit.Assert 가 지원하는 다양한 Test용 Method 
//1) assertEquals(a,b) : a와 b의 값(Value) 이 같은지 확인
//2) assertSame(a,b) : 객체 a와b가 같은 객체임(같은 주소) 을 확인
//3) assertTrue(a) : a가 참인지 확인
//4) assertNotNull(a) : a객체가 Null 이 아님을 확인
//5) assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인

//=> 자동 import 가 안되는경우
//	-> 프로젝트 우클릭 -> Build Path -> Configure Build Path.. 
//			-> Libraries -> Add Library  -> JUnit5
//	-> @Test: import org.junit.Test 확인

//=> pom.xml
//	-> junit version : 4.12 로 수정
//	-> dependency 추가 ( Spring MVC Mybatis Test )

public class Ex01_BookTest {
 
	//1) assertEquals(a,b)
	public void equalsTest() {
		Book b1 = new Book("엄미현","최고로 쉽게 스프링배우기", 9900);
		//assertEquals(b1.author, "남궁성"); 
		assertEquals(b1.author, "엄미현");
		// => 값의 일치성 확인 -> true: green 라인 / false: red 라인
	}
	
	//2) assertSame(a,b)
	public void sameTest() {
		Book b1 = new Book("엄미현","최고로 쉽게 스프링배우기", 9900);
		Book b2 = new Book("톨스토이","죄 와 벌", 19900);
		Book b3 = new Book("톨스토이","죄 와 벌", 19900);
		//assertSame(b1, b2); //false
		//assertSame(b2, b3); //false
		b1=b3;
		assertSame(b1, b3); //true
	}
	
	//3) assertTrue(a)
	public void trueTest() {
		Book b1 = new Book("엄미현","최고로 쉽게 스프링배우기", 9900);
		//assertTrue(b1.isBook(false)); //false
		assertTrue(b1.isBook(true)); //true
	}
	
	//4) assertNotNull(a)
	public void nullTest() {
		Book b1; 
		// => 인스턴스를 정의만 하고 생성은 하지않음
		//    지역변수는 초기화 하지 않으며 오류, 사용시 오류발생
		Book b2 = new Book("톨스토이","죄 와 벌", 19900); //인스턴스 생성
		b2 = null; //인스턴스 삭제 
		assertNotNull(b2);
	}
	@Test
	//5) assertArrayEquals(a,b)
	public void arrayEqualsTest() {
		String[] a1 = {"가","나","다"};
		String[] a2 = {"가","나","다"};
		String[] a3 = {"나","가","다"};
		String[] a4 = {"가","나","라"};
		// 5.1) 두배열의 순서, 값 모두동일, 주소값만 다름 (a1, a2)
		// => true: 순서(index)와 값을 비교 (주소비교 아님)
		//assertArrayEquals(a1, a2); //true
		
		// 5.2) 두배열의 순서는 다르고, 값 모두 동일 (a1, a3)
		//assertArrayEquals(a1, a3); //false
		// 5.3) 모두 다른경우 (a1, a4)
		//assertArrayEquals(a1, a4); //false
		
		// 5.4) Book Type 의 배열 2개 만들고 비교하기
		// => 각 배열의 Data는 3개씩
		Book b1 = new Book("엄미현","최고로 쉽게 스프링배우기", 9900);
		Book b2 = new Book("톨스토이","죄 와 벌", 19900);
		Book b3 = new Book("홍길동","홍길동전", 35000);
		Book[] ba1 = {b1, b2, b3};
		Book[] ba2 = {b1, b2, new Book("홍길동","춘향전", 15000)};
		Book[] ba3 = {b1, b2, b3};
		//assertArrayEquals(ba1, ba2); //false
		assertArrayEquals(ba1, ba3); //true
	}

} //class











