package j05_classMethod;

// static, instance 접근하기
// => 다른 클래스의 멤버 접근 ( Ex05_Static )

public class Ex05_staticTest {

	public static void main(String[] args) {
		// 1) static 변수 출력하기
		System.out.println("total => " + Ex05_static.total);
		
		// 2) instance(non_static) 멤버 접근
		Ex05_static ex05 = new Ex05_static();
		ex05.instanceAll(10, 3, ex05);
		Ex05_static.staticAll(10, 3, ex05);
		
		// 3) 인스턴스 추가 후 Test
		System.out.println("인스턴스 추가 후 Test");
		Ex05_static ex055 = new Ex05_static();
		ex055.instanceAll(10, 3, ex055);
		Ex05_static.staticAll(10, 3, ex055);
		
		
		
	}

}
