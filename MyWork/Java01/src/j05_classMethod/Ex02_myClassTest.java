package j05_classMethod;

// ** MyClass
// => 맴버변수 3개, 메서드 2개 정의 
// => MyClass 를 정의하고
//    Ex02_MyClassTest 에서 인스턴스 2개 만들어 출력하기

// ** 전역변수 와 지역변수 Test

class Boyfriend {
	// ** 맴버 변수
	// => 전역(Global) 변수
	//    클래스내에 있는 모든 메서드에서 사용가능
	//    다른 클래스에서도 접근 가능
	public double height;
    public int money;
    public String face;

    public void moneyUp(int mymoney) { 
    	
    	// ** void 메서드의 return Test
    	// => void 메서드에서 return 을 만나면 
    	//    더이상 수행하지않고 메서드 종료
    	if (mymoney > 1000) {
    		System.out.println("** mymoney 값 이상으로 종료합니다 **");
    		return;
    	}
    	
    	int money=5000;
    	// => 2. 위치변경후 money1 출력값 비교 
    	
    	money += 10000; // 전역변수 ( 위 2번 적용전까지 )
    	System.out.println("** moneyUp money1 ="+money); //전역 money
    	// ** 지역(local)변수
    	//=> 메서드 내부에 정의된 변수, 인자 
    	//  {  } 내부에서만 적용가능
    	//   클래스 외부에서도 접근 불가능
    	//   전역변수와 동일한 이름의 지역변수를 정의하면 지역변수 우선 적용
    	//  ( 단, 지역변수의 선언위치에 따라 지역변수 선언 이후부터 지역변수 우선함 )
    	mymoney+=money;
    	int price=10000;
    	//int money=5000; //1. 지역변수, 2.위치를 메서드내 첫줄로 이동 
    	System.out.println("** moneyUp money2="+money); //지역 money
    }
    public void moneyDown() { money -= 10000; }

    public String toString() {
       return "[face= "+face+"  money= "+money+"  hieght= "+height+"]";
    }
} //class

public class Ex02_myClassTest {

	public static void main(String[] args) {
		System.out.println("** Boyfriend class Test **");

		Boyfriend myBoyfriend = new Boyfriend();
		myBoyfriend.face = "이도현";
		myBoyfriend.height = 183.6;
		myBoyfriend.money = 500000000;
		System.out.println("** myBoyfriend =>" + myBoyfriend);
		
		// ** 지역변수, void_return Test
		myBoyfriend.moneyUp(1000);
		myBoyfriend.moneyUp(2000);
	      
		Boyfriend exBoyfriend = new Boyfriend();
		exBoyfriend.face = "손석구";
		exBoyfriend.height = 185.5;
		exBoyfriend.money = 700000000;
		System.out.println("** exBoyfriend =>" + exBoyfriend);

	} //main
} //class
