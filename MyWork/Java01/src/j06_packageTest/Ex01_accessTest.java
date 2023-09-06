package j06_packageTest;

import j05_classMethod.Ex10_CallByRefLotto;

// ** Access Modifier (접근 한정자_제어자)
// => private : 해당 클래스내부 에서만
// => default : 같은 Package 내
// => protected : package + 자손
// => public : 프로젝트내의 모든 Class 접근 가능
//   (단, 다른 package 에서는 import 해야함)

public class Ex01_accessTest {

	public static void main(String[] args) {
		// 1) public
		// => 다른 package 에 public 으로 정의된 Ex10_CallByRefLotto : 됨
		//    단, import 해야함.
		int [] numbers = {3, 6, 9, 10, 1, 2, 5, 11};
		Ex10_CallByRefLotto.lottoSort(numbers, 'D');

		// static
		System.out.println("ex10, static sss => " + Ex10_CallByRefLotto.sss);

		// instance 
		// => instance 변수도 public 만 접근가능
		Ex10_CallByRefLotto ex10 = new Ex10_CallByRefLotto();
		System.out.println("ex10, instance iii => " + ex10.iii);

		// => 결론
		//    클래스 수준에서 허용해도, 멤버수준에서 허용하지 않으면 접근불가함
		
		// 2) Default 클래스
		// => 다른 package 에 Default 로 정의된 Student : xx
		// Student student = new Student();
		// System.out.println("ex10, instance ddd => " + ex10.ddd); // 오류 코드 (Default 로 정의된 변수라서 접근 불가)
		
		
		
		// Stdent.ddd;
		// => 클래스 수준에서 허용되지않으므로 멤버수준의 접근벙뮈(public) 는 무시됨
		
		// => 같은 package 의 Car 호출
		System.out.println("Car ddd => " + Car.ddd);
		Car car = new Car();
		car.color = "DeepGreen";
		car.mileage = 123455;
		car.speed = 9000;
		System.out.println("car=> " + car);
		
	}

}
