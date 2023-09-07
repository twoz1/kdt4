package j07_classExtends;

//** 상속 : extends
//=> 기능을 확장해서 업그레이드 버젼 만듦.
//=> 기존(조상) 클래스의 맴버들(필드와 메소드)을 재사용 & 일부변경도 가능 

//** 생성순서
//=> JVM은 extends 키워드가 있으면 조상생성후 후손생성
//   이때 기본은 조상의 default 생성자를 실행하고,
//   특별히 후손 생성자에서 조상생성자_super(...)를 호출해 놓으면 그생성자를 실행함.
//=> 상속을 허용하는 클래스는 default 생성자를 반드시 작성하는것이 바람직함.

//** 조상 : Super (Parent, Base) class  
//=> super.  : 조상의 인스턴스를 의미 (조상의 맴버에 접근 가능)
//=> super(...)
//   조상의 생성자를 의미 (조상의 생성자에 접근 가능).
//   this() 처럼 생성자 메서드 내에서 첫줄에 위치해야함.

//=> 생성자메서드_super(), this() 호출은 생성자 내에서만 가능 

//** 후손 : Sub ( Chiled, Derived [diráivd] ) class
//=> super class 를 포함



class SportsCar  extends Ex01_Car  {
	int turbo;
	
	SportsCar() {
		super(); 
		// => 넣어주지 않아도 컴파일러가 조상의 default 생성자를 의미하는 super() 를 자동으로 넣어줌
		System.out.println("** SportsCar default 생성자 **");
	}
	SportsCar(int turbo) {
		this.turbo=turbo;
		System.out.println("** SportsCar 초기화 생성자 **");
	}
	
	// => 조상의 맴버들도 모두 초기화 하는 생성자
	SportsCar(int turbo, int speed, int mileage, String color) {
		super(speed, mileage, color);
		// => 조상 생성자 호출, 항상 첫줄에 위치해야함
		this.turbo=turbo;
		System.out.println("** SportsCar, Car 초기화 생성자 **");
	}
	// => Car 클래스에 생성자를 추가하지 않고,
	//    speed , mileage, turbo 를 초기화 하는 생성자를 추가하세요~~
	
	
	public int powerUp(int turbo) {
		return this.turbo+=turbo;
	}
	
	public String toString() {
		// => 조상의 toString 메서드 호출
		return super.toString() +"\n SportsCar [ turbo="+turbo+" ]";
	}
	
} //SportsCar


public class Ex02_CarTest {

	public static void main(String[] args) {
		// 1) 상속 Test
		// => 조상의 맴버에 접근가능함 
		// => SportsCar 맴버 추가이전 / 이후 비교
		//    이름이 같은경우 현재(자식) 클래스에 정의된 맴버 우선 적용됨
		// => 생성자 추가후 출력순서 확인
		//    조상생성자 -> 자식 생성자 실행
		SportsCar sc1 = new SportsCar();
		sc1.color="blue";
		System.out.println(" sc1 => "+sc1); // 추가이전 Car 출력
		System.out.println(" color => "+sc1.color);
		
		// => 생성자 Test
		//    사용자클래스에서 조상의 생성자를 선택할 수 없음 : 조상은 default 생성자 호출됨 
		SportsCar sc2 = new SportsCar(100);
		System.out.println("** 생성자 Test sc2 => "+sc2);
		
		// => 조상포함 모든 맴버변수를 초기화 하는 생성자
		SportsCar sc3 = new SportsCar(300, 100, 1000, "Red");
		System.out.println("** 생성자 Test sc3 => "+sc3);
	} //main

} //class
