package j10_Exception;

//** UnChecked Exception throws Test  
//=> RunTimeException 하의 ~~ : UnChecked Exception 
//=> java 의 컴파일러가 Exception 처리 확인하지 않음
// 즉, 반드시 try ~ catch 구문 을 적용하지 않아도 됨.
// 그러나 필요시엔 throws 로 처리 가능  
//=> 주로 프로그래머의 실수로 발생 가능한 오류들
//=> 상위의 메서드에서도 Exception 처리가 의무조항은 아님
// 즉, 반드시 try ~ catch 구문 구현 하지 않아도 컴파일 오류 없음.

public class Ex06_UNthrows {

	public static void intByZero() throws ArithmeticException {
		int i = 10 / 0;
	}

	public static void arrayIndex() throws ArrayIndexOutOfBoundsException {
		int[] a = new int[3];
		a[3] = 100;
	}

	// => unChecked Exception은 throws했어도 의무가 아님
	// 그러나 역시 계속 throws 가능함
//   public static void callTest() {
	public static void callTest() throws ArithmeticException, ArrayIndexOutOfBoundsException {
		intByZero();
		arrayIndex();
	}

	public static void nullPointer() throws NullPointerException {
		String s = null;
		int l = s.length();
	}

	public static void classCast() throws ClassCastException {
		Object o = new int[5];
		String s = (String) o; // 조상 -> 후손 (DownCasting : 가능한경우에만 명시적으로 허용)
	}

	// ** ClassNotFoundException -> Checked Exception
	public static void classNotFound() throws ClassNotFoundException {
		// ** Class 라는 클래스
		// => JVM에서 동작할 클래스들의 정보를 묘사하는 일종의 메타 클래스(Meta-Class)
		// 클래스의 이름, 멤버 필드와 메소드, 클래스 종류 등의 정보
		// => forName() 메소드에 의해 반환된 Class 클래스의 인스턴스에는 "클래스명"의 정보가 담겨 있음.
		Class<?> c = Class.forName("j10_Exception.Ex05_IOthrows");
		System.out.println(" Find Class => " + c.getName());
	}

	public static void main(String[] args) {
		// 1) unChecked 메서드 call
		// => throws 했어도 try 블럭은 의무사항이 아님
		// 컴파일오류는 없지만 런타임 오류 발생으로 비정상 종료
//	   callTest();
//	   nullPointer();
//	   classCast();

		try {
			// => unChecked call
//			callTest();
//			nullPointer();
//		    classCast();
			// => try 블럭안에 있어도 해당 Exception 을 처리할 catch 구문이 없으면
			// 실행시 Exception 발생후 비정상 종료함.
			classNotFound();
		} catch (NullPointerException e) {
			System.out.println("**main NullPointerException => " + e.toString());
		} catch (Exception e) {
			System.out.println("**main Exception => " + e.toString());
		}

		System.out.println("** Program 정상종료 **");

	}

}