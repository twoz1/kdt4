
package j07_classExtends;

//** 클래스와 클래스 간의 관계
// 1) 집합(has-a): Student 와 Car
// 2) 사용(use)  : Ex04_classnclass 와 Car
// 3) 상속(is-a) : Person, Student
// 상속의 특징을 3가지 정리해오기

public class Ex01_classNclass {

	static Ex01_Car car = new Ex01_Car(100, 200, "Yellow"); // 선언과 동시에 초기화
	
	public static void myCar(Ex01_Car car) {
		car.speedDown();
		System.out.println("2) 사용(use) => myCar_speed => " + car.speed);
	}
	
	public static void main(String[] args) {
		
		// 1) 집합(has-a)
		// => Ex01_classNclass 클래스와 Ex01_Car 클래스 관계
		System.out.println("1) 집합(has-a) => " + car);
		
		// => Student 와 Car 클래스의 관계
		Ex01_Student s1 = new Ex01_Student("0001", "홍길동", 99);
		System.out.println("Main Student => " + s1);
		System.out.println("Main Car_color => " + s1.car.color);
		System.out.println("Main myCar_color => " + Ex01_Student.myCar.color.toUpperCase());
		
		// 2) 사용(use)  
		// => Ex01_classNclass 클래스가 메서드 인자의 형식으로 Ex01_Car car 를 사용한 경우 => use의 관계
		myCar(car);

	}

}
