package j09_innerClass;

//** Outer , Inner 인스턴스 관계 Test
class OuterName {
	private String name;
	private int num=0;
	OuterName(String name) { 
		this.name=name; 
		System.out.println("** OuterName 초기화 생성자 **");
	}
	void whoAreU() {
		num++;
		System.out.printf("** whoAreU : name=%s, num=%d \n", name, num);
	}
	class InName {
		String name;
		InName(String name) {
			System.out.println("** InName 초기화 생성자 **");
			this.name=name; 
			// => this 는 Inner 를 가리킴
			// => 변수명이 모두 name 으로 동일 하다면
			// => 매개변수로 전달받은 값을 Outer 의 name 변수에 넣어주려면 this 로는 불가능
			// => 그러나 OuterName.this 로는 접근가능
 			// name=name2;	// inner의 name 을 outer 에 전달 -> inner의 name 출력
			//OuterName.this.name=name;
			whoAreU();
		} //InName 생성자 
	} //InName
} //OuterName

public class Ex03_InstanceTest {

	public static void main(String[] args) {
		// 1) Outer 생성
		OuterName on1 = new OuterName("OUT1");
		OuterName on2 = new OuterName("OUT2");
		on1.whoAreU(); //num=1 
		on2.whoAreU(); //num=1 
		
		// 2) Inner 생성
		// => OutClass 의 인스턴스를 통해 생성됨
		//    OuterName.InName test = new OuterName("Test").new InName("test");
		OuterName.InName in11 = on1.new InName("OUT1_In1"); 
		OuterName.InName in12 = on1.new InName("OUT1_In2"); 
		OuterName.InName in13 = on1.new InName("OUT1_In3");
		on1.whoAreU();
		
		OuterName.InName in21 = on2.new InName("OUT2_In1");
		OuterName.InName in22 = on2.new InName("OUT2_In2");
		on2.whoAreU();

	} //main
} //class
