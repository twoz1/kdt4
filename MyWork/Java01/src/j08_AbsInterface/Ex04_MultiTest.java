package j08_AbsInterface;

//** interface 3.
//1) 인터페이스와 인터페이스 관계
//=> 인터페이스 간의 상속(extends) 가능.
//=> 다중상속(부모 여러개 허용), 계층적 상속 모두 가능 

//2) 클래스 와 인터페이스 관계
//=> 다중 구현(implements) 가능
//=> 클래스가 클래스를 상속(extends) 받으면서 동시에
//   인터페이스를 구현(implements, 다중구현도 포함) 하는것 가능 

//** 그러므로 자바는 다중상속이 안되는점을 극복 가능함 

interface Inter1{
	float PI = 3.14159f; // public static final 생략
	int getA(); // public abstract 생략
	
}

interface Inter2 {int getB();}

interface Inter3 extends Inter1, Inter2 {float getC();}

// ** 실습1)
//    => 복수의 interface를 구현하고 (다중구현) 하는 클래스

//class MultiInter implements Inter1 , Inter2 , Inter3{
class MultiInter implements Inter3{
	int a =123, b = 100;
	@Override
	public int getA() {return a;}
	@Override
	public int getB() {	return b;}
	@Override
	public float getC() {return (a+b)*PI;}
}

//** 실습 2)
//=> 클래스 extends 와 interface implements 동시 구현 
class Add{	
	int addNum(int a, int b) { return a+b;}
} //Add

class MultiExIm extends Add implements Inter1 ,Inter2 ,Inter3{
	
	int a = 123, b = 100;
	@Override
	public int getA() {return a;}
	@Override
	public int getB() {	return b;}
	@Override
	public float getC() {return (a+b)*PI;}
	// => Add 클래스의 addNum() 을 호출
	
} 

public class Ex04_MultiTest {

	public static void main(String[] args) {
	 // ** 실습 1)
		 MultiInter m1 = new  MultiInter();
		 System.out.printf("main m1 => getA = %d, getB = %d, getC = %f \n" ,
				 m1.getA(), m1.getB(), m1.getC());
		
	// ** 실습 2)
		 MultiExIm m2 = new MultiExIm();
		 System.out.printf("main m1 => getA = %d, getB = %d, getC = %f \n" ,
				 m2.getA(), m2.getB(), m2.getC());
	// ** 실습 3) 다형성 적용
		 Inter1 in1 = new MultiExIm(); //Inter1에 정의된 만큼만 접근 가능, MultiInter() / MultiExIm() 교체 가능 
		 Inter2 in2 = new MultiInter();// Inter2에 정의된 만큼만 접근 가능, MultiInter() / MultiExIm() 교체 가능 
		 System.out.printf("main in1 => in1.getA = %d  in2.getB=d \n" ,
				 in1.getA(), in2.getB());
		 Inter3 in3 = new MultiExIm(); //모두 접근 가능,  MultiInter() / MultiExIm() 교체 가능
		 System.out.printf("main int3 => getA = %d, getB = %d, getC = %f \n" ,
				 in3.getA(), in3.getB(), in3.getC());
		
	// ** 실습 4) instanceof 해당여부 확인
		if(m1 instanceof Inter1) System.out.println("** m1은 Inter1 입니다.");
		else System.out.println("** m1은 Inter1 아닙니다.");
		
		if(m1 instanceof Inter3) System.out.println("** m1은 Inter3 입니다.");
		else System.out.println("** m1은 Inter3 아닙니다.");
		
		if(in1 instanceof Inter3) System.out.println("** in1은 Inter3 입니다.");
		else System.out.println("** in1은 Inter3 아닙니다.");
		
		if(in2 instanceof Inter3) System.out.println("** in2은 Inter3 입니다.");
		else System.out.println("** in2은 Inter3 아닙니다.");
		
		if(in3 instanceof Inter3) System.out.println("** in3은 Inter3 입니다.");
		else System.out.println("** in3은 Inter3 아닙니다.");
		
		if(in3 instanceof Inter1) System.out.println("** in3은 Inter1 입니다.");
		else System.out.println("** in3은 Inter1 아닙니다.");
		
		// 비교 Test 
		// => interface와 무관한 Add 인스턴스 비교
		Add add = new Add();
		if(add instanceof Inter3) System.out.println("** add 는  Inter3 입니다.");
		else System.out.println("** add는 Inter3 아닙니다.");
		
		// Inter3 in33 = new Add(); - 그러므로 성립안됨
		
	}

}
