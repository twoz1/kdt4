package j15_enum;

//** enum 의 내부
//=> enum은 class, interface와 동급의 형식을 가지는 단위임.
//=> 실상은 class 이지만, enum만을 위한 문법적 형식을 가지고 있기 때문에
//   클래스와 구분하기 위해서 enum이라는 키워드를 사용함.
//=> 컴파일된 코드는 ~.class 임
//   class, abstract class, interface, enum 모두 ~.class )

//=> "enum Fruit" 코드의 내부는 다음과 같다.

//class Fruit{
// public static final Fruit APPLE  = new Fruit();
// public static final Fruit PEACH  = new Fruit();
// public static final Fruit BANANA = new Fruit();
// private Fruit(){}
//}

// ** enum의 생성자, 변수, 메서드 
//=> 생성자의 접근 제어자가 private
//   그러므로 클래스 Fruit를 인스턴스로 만들수없도록 하여 다른 용도로 사용하는 것을 금지함. 
//=> 생성자 오버로딩 처럼 생성자의 매개변수 사용은 허용되지만, 
//   생성자는 1개만 허용됨 ( Fruit.APPLE 사용시 1개의 생성자가 자동호출됨 )
//=> 변수, 메서드 정의 가능

enum Fruit {
// 	1) default 생성자
//	APPLE, BANANA, PEACH;	
//	private Fruit(){System.out.println("Call Constructor1 "+this);}
	
//	2) 변수, 생성자 추가하기
//	=> 상수 역할 이므로 사용방법은 생성자의 매개변수와 상관없이 모두 동일 (Fruit.APPLE)
//     Fruit.APPLE 사용시 생성자 자동호출되어 변수값 전달됨
	APPLE("Red"), BANANA("Yellow"), PEACH("Pink");
	String color;
	Fruit(String color){
	  System.out.println("Call Constructor2 "+this);
	  this.color = color;
	} //생성자2
	
//  3) 메서드 추가
	String getColor() { return this.color; }
}

enum Company {
	ORACLE, NAVER, APPLE	
}

public class Ex04_enumConstructor {

	public static void main(String[] args) {
		// 1) default 생성자 
		// => 생성자2 를 사용해도 상수호출(사용) 방법은 차이가 없으므로 동일하게 사용됨
		//    단, 그렇기때문에 생성자는 1개만 허용됨
		System.out.printf("** default 생성자 => %s, %s, %s \n",Fruit.APPLE,Fruit.BANANA,Fruit.PEACH);

		// 2) 생성자2, 변수, 메서드
		Fruit f = Fruit.BANANA;
		switch(f) {
		case APPLE: System.out.println("* APPLE, color => "+Fruit.APPLE.color); // 변수접근
					break;
		case BANANA: System.out.println("* BANANA, getColor=> "+Fruit.BANANA.getColor()); // 메서드접근
					break;
		case PEACH: System.out.println("* APPLE, color => "+Fruit.PEACH.color);  
					break; 			
		} //switch
		
		// 3) 열거형 Type 비교
		// => 값과 타입을 동시에 확인하기때문에 안전한 코딩 가능
		//    즉, enum이 서로 다른 상수 그룹에 대한 비교를 컴파일 시점에서 차단시켜줌.
		// if (Fruit.APPLE == Company.APPLE ) System.out.println(" ** 컴파일 오류 발생 => 그러므로 안전 **");
		// => 컴파일 오류 , 비교구문 불가능 : 그러므로 안전 
		Company c = Company.APPLE ;
		switch(c) {
		case APPLE: System.out.println(c+" => 연봉 5천 "); break;
		case NAVER: System.out.println(c+" => 연봉 6천 "); break;
		case ORACLE: System.out.println(c+" => 연봉 7천 "); break; 	
		}
		
	} //main

} //class
