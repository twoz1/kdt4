package j08_AbsInterface;

//** interface 4.
//=> 상수, 추상메서드
//=> static, default 메서드 (구현부가 있는 메서드, Java8 부터 추가됨)

//** static, default
//=> 반드시 바디를 구현 해야함
//=> 구현클래스의 오버라이딩 의무 없음

interface NewInter{
    // ** 추상메서드
	// => 반스시 헤더만 정의, 바디(실행)부는 없어야 함.
	void test();
	
	// ** static 메서드
	//static void staticTest(); -> ERROR
	static void staticTest() {
		System.out.println("** interface staticTest()**");
	}
	
	// ** default
	// interface에만 있음, 오버라이딩 의무 없지만 ,필요시에는 가능
	// default void defaultTest(); -> ERROR
	default void defaultTest() {
		System.out.println("** interface defaultTest()**");
	}
	
}// NewInter

class NewTest implements NewInter{
	
	@Override
	public void test() {System.out.println("** NewTest test() Override**");}
	
	// Test1) static
	static void staticTest() {
		System.out.println("** NewTest staticTest()**");
	}
	
	// Test2) default
	// => 의무는 아님, 오버라이딩은 허용
	// => 오버라이딩 주의 사항
	//    - default 사용 금지(인터페이스에만 사용 가능)
	//    - 접근범위 : 조상과 같거나 더 넓어야 함 
	// @ 를 붙여봐서 오버라이딩인지 확인 에러가 없으면 오버라이딩인 것임
	public void defaultTest() {
		// ** 조상의 default 메서드 호출
		// => 조상의 interface 인 경우 접근방법
		NewInter.super.defaultTest();
		// super는 조상클래스의 인스턴스를 의미
		// 인터페이스는 인스턴스가 아니기에 단순히 super로 접근하기 어려움
		// 따라서 인터페이스 이름을 붙여서 인터페이스의 조상을 의미
		// default static은 나중에 추가된 것이기에 인스턴스를 접근하는 명령어는 super로 했지만
		// 인터페이스는 동일하게 할 수 없으므로 방식을 달리함
		System.out.println("** NewTest defaultTest Override() **");
	   }
	   // => 메서드 오버로딩
	   public void defaultTest(int i) {
	      System.out.println("** NewTest defaultTest() i*i => "+(i*i));
	   }
	   
	}

public class Ex05_staticDefault {

	public static void main(String[] args) {
		//1) 클래스 타임으로 생성
		NewTest n1 = new NewTest();
		n1.test();
		n1.defaultTest();
		n1.defaultTest(123);
		NewTest.staticTest();
		NewInter.staticTest(); //인터페이스의 이름으로도 static 메서드 접근 가능함
		
		//2) 인터페이스 타입으로 생성
		NewInter n2 = new NewTest();
		n2.test();
		n2.defaultTest();
	  //n2.defaultTest(123); 인터페이스에 정의된 멤버만 접근 가능
		NewTest.staticTest();
	}//main

}//class
