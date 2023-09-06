package j07_classExtends;

//** 클래스와 클래스 간의 관계
//1) 상속(is-a) : Person, Student
//2) 집합(has-a): Student 와 Car
//3) 사용(use)  : Ex04_classnclass 와 Car

public class Ex01_classNclass {
	
	static Ex01_Car car = new Ex01_Car(100, 200, "Yellow");
	
	public static void myCar(Ex01_Car car) {
		car.speedDown();
		System.out.println("**2) 사용(use) 관계 : myCar_speed => " +car.speed);
	} //클래스도 인자의 타입이 될 수 있음
	
	public static void main(String[] args) {
		// 1) 집합 (has-a)
		// => Ex01_classNclass 클래스와 Ex01_Car 클래스의 관계
		System.out.println("**1) 집합(has-a) => " +car);
		
		//2) 사용(use)
		// => Ex01_classNclass 클래스가 메서드 인자로 Ex01_Car 를 사용한 경우
		myCar(car);
		
	}//main

}//class
