package j15_enum;

// ** enum 매개변수로 전달
// => 메서드 에 적용
// => 일반상수 의 사용과 안전성 비교

enum Animal { DOG, CAT, BEAR }
enum Person { MAN, WOMAN, CHILD }

public class Ex03_argumentTest {
	// 일반상수 정의
	static final int DOG=0;
	static final int CAT=1;
	static final int BEAR=2;
	
	static final int MAN=0;
	static final int WOMAN=1;
	static final int CHILD=2;
	
	public static void main(String[] args) {
		// 1) 일반변수 사용
		// => 비교 가능한 Type 이 없어서 논리적오류를 예방할 수 없음
		whoAreU(DOG); //논리적 오류....dog인데 man 입니다가 출력되어져 버림..
		whoAreU(MAN);
		// 2) enum 사용
		// => 컴파일타임에 검증 가능
		//whoAreUe(DOG); => Type 안맞아 컴파일오류
		//whoAreUe(MAN); => 클래스 내부의 상수 MAN
		// 2.1) Person 직접 사용
		whoAreUe(Person.WOMAN);
		//whoAreUe(Animal.CAT); 컴파일 오류
		// 2.2) 인스턴스 정의
		Person p = Person.CHILD;
		whoAreUe(p);
		
		Animal dog = Animal.DOG;
		//whoAreUe(dog); => Type 안맞아 컴파일오류
		// ** 인스턴스 확인후 메서드 적용하기
		// if (dog instanceof Person)  
		// => 컴파일오류 로 비교 불가 (비교 대상이 interface 일때만 컴파일오류 없이 비교가능)  
		if (dog instanceof Animal) {
			System.out.println("~~ whoAreUe 입장불가 !!! ~~");
		}

	} //main
	
	// 매개변수: 기본자료형 등 일반 Type
	static void whoAreU(int p) {
		switch (p) {
		case 0 : System.out.println("~~ MAN 입니다 ~~"); break;
		case 1 : System.out.println("~~ WOMAN 입니다 ~~"); break;
		case 2 : System.out.println("~~ CHILD 입니다 ~~"); break;
		} //switch
	} //whoAreU
	
	// 매개변수: enum Person Type 
	static void whoAreUe(Person p) {
		switch (p) {
		case MAN : System.out.println("~~ MAN 입니다 ~~"); break;
		case WOMAN : System.out.println("~~ WOMAN 입니다 ~~"); break;
		case CHILD : System.out.println("~~ CHILD 입니다 ~~"); break;
		} //switch
	} //whoAreU
	
	
	
	
	
	
} //class
