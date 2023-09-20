package j17_Lamda;

//** Lamda 식 표현 (자바8 부터 추가)
//=> 인터페이스가 하나의 추상메서드만 가지고 있는 경우
//이를 함수형 인터페이스(Functional Interface) 라 하며
//이러한 함수형 인터페이스를 구현하는 경우
//짧은 코드로 완성할수 있도록 지원하는것이 람다식.

//** @FunctionalInterface (예제 Lm01_03~~ 참고 )
//=> 함수형 인터페이스임을 확인하는 애너테이션
//=> 그러므로 위의 애너테이션이 붙은 인터페이스에 둘이상의 추상메서드가 존재하면 컴파일오류
//=> 그러나 구현부가 있는 static, default 선언이 붙은 메서드는 무관함.
//=> 미리 정의된 표준 함수형 인터페이스 (java.util.function 패키지 열혈 674p)
// Predicate<T>, Supplier<T>, Consumer<T>, Function<T,R>
// 이들은 다양하게 활용할수있도록 각각 추상메서드를 정의해놓고 있으므로
// 필요에 따라 이용.

interface Printable{
	void myTest(String s); //추상메서드

}//Printable
//1. 일반적인 방법(Lamda가 없는)
// =>interface Printable의 구현 클래스 Printer를 작성해 놓고 사용

class Printer implements Printable{
	@Override
	public void myTest(String s) {
		System.out.println("** LamdaTest1. 일반적인 방법 => "+s);
	}
}
public class Lm01_Basic {

	public static void main(String[] args) {
		Printable p1 = new Printer();
		p1.myTest("안뇽 람다얌!!!!");

		// 2. 익명클래스
		// => 구현클래스를 일회적으로 필요한 경우 직접구현
		// 조상의 이름을 넣어줌 -> 마치 생성자를 만드는 것 처럼. 인터페이스는 생성자를 사용할 수 없는데 {}을 사용하여 익명클래스를 구현할 때만 사용
		// 의무구현을 해줘야 함 ->  @Override -> 그 후 반드시 ;를 넣어줘야 함.
		Printable p2 = new Printable(){
			@Override
			public void myTest(String s) {
				System.out.println("** LamdaTest2. 익명클래스 적용 =>" +s);
			}
		};
		p2.myTest("안뇽 람다야 나는 익명함수얌~~!!!");

		// 3. Lamda식으로 표현 (인터페이스가 하나의 추상메서드만 가지고 있는 경우 사용할 수 있으니깐)
		// => 인터페이스의 추상메서드가 유일하므로 메서드명 생략가능하고 매개변수의 타입도 인터페이스에 정의되있으므로 
		//    컴파일러가 유추할 수 있기에 생략이 가능하다.
		// => 매개변수의 타입도 이미 정의되어 알수있으므로 생략가능 
		
		//Printable p3 = (String s) -> {
		//	System.out.println("** LamdaTest2. 익명클래스 적용 =>" +s);
		//}; //한 장의 문장이므로 ;사용 Printable p3은  (String s) -> {
		//System.out.println("** LamdaTest2. 익명클래스 적용 =>" +s);야!!!
		// 매개변수 이미 인터페이스에 있기에 생략가능 컴파일러가 유추할 수 있음
		// 아래식으로 고고씽~~~!!!!!!!!!!
		
		//Printable p3 = (s) -> {
		//System.out.println("** LamdaTest2. 익명클래스 적용 =>" +s);
		//}; //근데 또 매개변수가 하나이면 ()을 생략할 수가 있네? 아래식으로 고고씽~~!!!
		//아래식은 최종 Lamda식이라네~~~!!!!!!!
		Printable p3 = s -> {
			System.out.println("** LamdaTest3. Lamda식 적용 =>" +s);
		};
		p3.myTest("안뇽 나는 람다식 적용한 햄스터얌~~너무 편리하지?!!!!!!!!!!");
		
		// 4. 메서드참조 람다식(왓더 더 간단해 질 수가 있었네??)
		//(Lm02_doubleColon.java참고)
		Printable p4 = System.out::println;
		p4.myTest("** LamdaTest4. 메서드참조 람다식");
	}//main
}//class

//어짜피 클래스를 가지고 기능 구현인데 그래서 미리 만들어진 클래스 가져다가 쓰는데  
//local inner class(메서드 안에 클래스 정의)는 가져다 쓴 것이 아니라 클래스가 필요한 곳에서 새롭게 만들어 씀 ->   