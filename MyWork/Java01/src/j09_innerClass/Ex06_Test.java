package j09_innerClass;
//** 실습
//추상 메서드가 2개 있는 interface 를 정의하고 
//이를  main 메서드에서 익명 클래스를 이용해서 구현하고
//실행 시켜 보세요 ~~ 

//** 복습(숙제)
//=> 교재 연습문제 (284~288p)
// 7-3 ~ 7-8


	interface Bird{
		void fly();
		void eat();
	}
	
	
public class Ex06_Test {

	public static void main(String[] args) {
		

		Bird b1 = new Bird() {
			@Override
			public void eat() {System.out.println("냠냠");}
			@Override
			public void fly() {System.out.println("휘잉~");}
		};
		
		b1.eat();
		b1.fly();
	}
}
