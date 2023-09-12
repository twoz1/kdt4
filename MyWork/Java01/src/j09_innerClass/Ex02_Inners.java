package j09_innerClass;

// ** Inner class 의 종류

class Outer2 {
	//=> Instance
	class InstanceInner {
		int iv = 100;
	}
	//=> static
	static class StaticInner {
		int iv = 200;
		static int cv = 300;
	}
	//=> Local
	void myMethod() {
		class LocalInner {
			int iv = 400;
		}
		LocalInner li = new LocalInner(); 
		System.out.println("** myMethod iv = > "+li.iv);
	} //myMethod
} //Outer2

public class Ex02_Inners {

	public static void main(String[] args) {
		// 1) Instance Inner 클래스 생성
		// => 외부 클래스의 인스턴스에 종속된 인스턴스를 생성
		Outer2.InstanceInner ic = new Outer2().new InstanceInner();
		System.out.println("** ic 의 iv => "+ic.iv);
		
		// 2) static 내부 class 
		// 2.1) static 맴버 => 내부 클래스 인스턴스는 필요 없지만, 외부 클래스를 통해 접근 
		System.out.println("** StaticInner 의 cv => "+Outer2.StaticInner.cv);
		// 2.2) static 내부 class의 인스턴스 맴버
		// => static 내부 class의 인스턴스가 필요함
		Outer2.StaticInner sc = new Outer2.StaticInner();
		System.out.println("** sc 의 iv => "+sc.iv);
		
		// 3) Local inner class
		new Outer2().myMethod();
		
	} //main

} //class
