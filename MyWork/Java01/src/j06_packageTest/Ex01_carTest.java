package j06_packageTest;

//** 클래스에 포함 가능한것 (맴버)
//=> 속성(변수, 필드_Field, Column), 기능.동작(메서드)
//=> 맴버변수(전역변수), 맴버메서드 
//=> 맴버메서드 종류 (역할이 정해져있는 메서드들)
//- main, 생성자(Constructor), toString, setter, getter

//** 클래스명                                                                              
//=> 대문자로 시작, 예약어 사용불가 , API 라이브러리의 클래스명 비추
//=> 클래스는 객체의 설계도

//** 객체의 주기 (LifeCycle)
//=> 생성 -> 사용 -> 소멸  (in Memory, RAM)
//=> 클래스(in HDD) -> 생성(in Memory) -> 객체화 (인스턴스 생성)
//-> 사용 -> 소멸(Memory 반납)

//** 클래스, 객체, 인스턴스(instance : 사례, 경우) 
// 클래스와 인스턴스는 설계도와 제품이라고 할수있다.
// 그럼 객체는 클래스일까 인스턴스일까? 
// Java 프로그래밍에서는 설계도인 클래스가
// 메모리상의 구체적인 실체인 인스턴스가 되었을때 객체라고 부른다. 

// 그러므로 클래스와 인스턴스는 구별되고, 클래스와 객체도 구별되지만, 
// 객체와 인스턴스는 구분없이 포괄적으로 객체라는 말을 쓰기도 한다.

class Car {
	 // ** 맴버변수, 필드(field) : 속성 
	 // => 클래스의 전역변수
	 //    클래스내에 있는 모든 메서드에서 사용가능
	 public int speed;
	 public int mileage;
	 public String color;
	 
	 //package Test 용 변수선언
	 public static int ddd = 100;
		
	 // ** 맴버메서드 (Method, function, procedure)
	 // => 동작 또는 기능을 구현
	 public void speedup() { speed += 10;}
	   //void - 리턴값이 없다는 뜻  
	 public void speedDown() {speed -= 10;}
	 
	   // => String (return Type) : 문자열을 반환(return) -> 메서드 처리 결과로 문자열을 제공
	   // => toString (메서드명) : 객체의 속성(맴버필드,맴버변수) 의 값을 문자로 제공하는 역할에 주로 사용됨   
	 public String toString() {
		 // toString() 객체가 가지고 있는 속성의 값을 문자열로 반환하는 메서드 
		 return "[ speed = "+speed+ " mileage = " +mileage+ " color= " +color+ "]"; //타입에 맞는 것을 리턴해야함.
	 } 
	 
}//car - car는 메인이 없기에 스스로 실행 못함. 가져다 써야함.

//=> API 라이브러리의 클래스명 비추
//class System {
// System.out~~~ 이 오류 뜨느것을 확인해본다.
//} 

public class Ex01_carTest {

	public static void main(String[] args) {
       System.out.println("** Car class Test");
       // ** 객체 생성과 사용
       // => 생성-> 사용 -> 소멸
       // => 생성: "인스턴스화 한다" 또는 "인스턴스를 생성한다" 라고 함
       Car myCar = new Car();
       myCar.color = "Black";
       myCar.mileage = 1000;
       myCar.speed = 500;
       myCar.speedup();
       System.out.println("*my Car toString1 => " +myCar.toString());
       System.out.println("*my Car toString2 => " +myCar);
       // 첫 번째 sop 는 toString을 줬지만 두 번째는 주지 않음
       // 그러면 두 번째는 주소값이 나와야하는데 문자열로 나옴..why?
       // 출력문에서 인스턴스를 호출하면 toString이 자동적으로..
       
       // ** 소멸 : 메모리청소
       // => 더이상 사용되지않는 값들은 자동제거해줌
       // => Garbage Collector (쓰레기 수집기)
       // => 정해진 알고리즘에 의해 작동됨 ( 일정시간동안 또는 더이상 참조되지않는등등... )   
       // => 참조형 변수에 null 값을 주면 소멸 (더이상 참조되지않음)
       myCar = null; // null -> 값 없음을 의미
       //myCar.speedDown(); -> 실행 오류 : java.lang.NullPointerException
       
       Car mCar = new Car();
       mCar.color = "White";
       mCar.mileage = 1200;
       mCar.speed = 600;
       mCar.speedup();
       System.out.println("*mCar1 toString1 => " +mCar.toString());
       System.out.println("*mCar2 toString2 => " +mCar);
       
       Car rCar = mCar;
       //mCar라는 인스턴스가 갖고 있는 주소가 그대로 전달
       System.out.println("**rCar => " + rCar);
       
       Car fCar = new Car();
       fCar.color = "Yellow";
       fCar.mileage = 1200;
       fCar.speed = 800;
       fCar.speedup();
       System.out.println("*fCar1 toString1 => " +fCar.toString());
       System.out.println("*fCar2 toString2 => " +fCar);
       
	}//main
	
}//class
