package j07_classExtends;

//** Java 의 상속의 특징
//=> 계층적으로는 다중 상속이 가능하고 제한이 없음.
//=> 그러나 다중 상속은 안된다 ( 부모는 무조건 1개의 클래스만 허용 )
// class WildAnimal extends Mammal , Reptile {  -> ERROR

//** 메서드 오버라이딩
//=> 조상의 메서드와 매개변수, 리턴값, 이름 모두 동일한 메서드
//  ( 매개변수가 다르다면 메서드 오버로딩에 해당됨.) 
//   현재 클래스에 구현된 메서드가 호출됨
//   이름은 동일하지만 후손클래스 별로 다양한 기능을 구현할 수 있음. 

//** static , final
//=> 맴버변수, 맴버메서드 , 클래스(final)
//=> final
//		- class : 종단클래스 (상속불가)
//		- method : 재정의(Override) 금지
//		- 필드(변수) : 상수
//=> static 메서드
//		- 상속(오버라이딩) 안됨
//		- 클래스(종속) 메서드로써 필요시 각자 정의해서 사용하는것은 가능함.
//		  ( 단, 동일한 이름의 메서드를 후손이 non_static 으로 정의하는것은 불가능 )	
//		- super , this 는 non_static (인스턴스 메서드) 에서만 사용가능
//		  ( super , this 인 인스턴스를 의미하기 때문 )
//		- static 변수는 클래스명으로 접근 

//** Animal
//=> Mammal ( String cry, crying )  , 
//   Reptile ( swimming ) 
//=> WildAnimal ( allPrint ) , PetAnimal ( infoPrint() )

// =====================================================
// ** 1대: Animal
class Animal {
	String name;
	static int legs ;
	static String color = "Red" ;  // Child 클래스에서 static import Test 용
	
	Animal() { System.out.println("** Animal Default 생성자 **"); }
	Animal(String name, int legs) { 
		this.name=name;
		Animal.legs=legs;
		System.out.println("** Animal 초기화 생성자 **"); 
		}
	void breath() { System.out.printf("** %s는 숨을 쉬고 다리는 %d개 입니다. \n",name, legs); }
} //Animal

// ** 2대: Mammal, Reptile
// => 포유류
class Mammal extends Animal {
	String cry;
	int legs;
	
	Mammal() { System.out.println("** Mammel Default 생성자 **"); }
	Mammal(String name, String cry, int legs ) { 
		super(name, legs);
		this.cry=cry;
		System.out.println("** Mammel 초기화 생성자 **");
	}
	void crying() { System.out.printf("** %s는 %s 소리를 내며 웁니다.\n", name, cry); } 
	
	// => static 메서드 추가
	static void staticTest() {
		System.out.println("** Mammal 의 staticTest() **");
	}
} //Mammal

// => 파충류
class Reptile extends Animal {
}

// ** 3대: WildAnimal, PetAnimal

// => 야생동물
// class WildAnimal extends Mammal , Reptile{
// => Java 는 다중상속 허용안됨
class WildAnimal extends Mammal {
} //WildAnimal

// => 반려동물
class PetAnimal extends Mammal {
	int legs;
	
	PetAnimal() { System.out.println("** PetAnimal Default 생성자 **"); }
	PetAnimal(String name, String cry, int legs) { 
		super(name, cry, legs);  
		System.out.println("** PetAnimal 초기화 생성자 **"); 
	}
	
	// ** static 메서드 오버라이드 Test ------------------------------
	// => static 맴버들은 클래스 종속 이므로 상속 의 개념보다 우선적용됨
	//    그러므로 Override 적용안되고 각 클래스의 맴버 이다.
	//    즉, 조상의 staticTest() 와는 무관한 PetAnimal.staticTest() 임
	//    -> 이러한 특성을 "static 메서드 오버라이딩 불가" 라함.
	
	//@Override -> Error
	static void staticTest() {
		System.out.println("** PetAnimal 의 staticTest() **");
		// => 조상의 static 메서드 호출은 가능
		Mammal.staticTest();
	}
	// => static 메서드 와 동일한 이름의 non_static 메서드 : 허용안됨
	// => 조상에만 있어도 허용안됨 
	//void staticTest() {
	//	System.out.println("** PetAnimal 의 non_static : ERROR **");
	//}
	void statictest(int i) { System.out.println("** 그러나 오버로딩은 허용됨 **");}
	//-----------------------------------------------------------------
	
	@Override
	void crying() {
		super.crying();
		System.out.println("** 노래도 부릅니다 ~~ **");
	}
	
	void checking() { System.out.printf("** %s는 예방접종을 했습니다.\n", name);  } 
	
	void infoPrint() {
		super.legs=this.legs;
		breath();  // legs => 0
		crying();
		checking();
	}
	
	// ** legs Print
	void legsPrint(int legs) {
		System.out.printf("** Loacl=%d, Global_Pet=%d, Parent_Mammal=%d, Animal=%d \n",
									legs, this.legs, super.legs, Animal.legs); 
	}
} //PetAnimal

public class Ex03_AnimalTest {

	public static void main(String[] args) {
		// Test 1) default 생성자
		PetAnimal cat = new PetAnimal();
		cat.name="고냥이";
		cat.cry="야옹야옹";
		cat.legs=4;      // PetAnimal 의 legs 에 할당
		cat.infoPrint(); // 그러므로 ~~ 다리는 0개 입니다.
		
		// Test 2) 초기화 생성자
		PetAnimal dog = new PetAnimal("강아지", "멍멍 멍멍", 4);
		dog.infoPrint();
		// => 생성시에 입력한 legs값 4 는 Animal 에 전달됨을 알수 있다.
		// => 그리고 각 클래스별 legs 값을 출력 비교 해본다.
		dog.legsPrint(111);
		
		// Test 3) static Method 와 변수 Call
		System.out.println("** main Animal legs => "+ Animal.legs);
		System.out.println("** main Animal color => "+ Animal.color);
		PetAnimal.staticTest();
		Mammal.staticTest();
		
	} //main

} //class
