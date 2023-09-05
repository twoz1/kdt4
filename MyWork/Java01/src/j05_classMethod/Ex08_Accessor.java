package j05_classMethod;

class Member {
	// 접근제어로 Data 보호
	// => private : 해당 클래스만 접근 가능
	// => 클래스 외부에서는 메서드를 통해 접근하도록 함
	// 설정자(mutator)와 접근자(accessor)
	private String id;
	private String name;
	private int age;
	
	// ** 생성자
	public Member() {}  //default 생성자
	
	public Member(String id,String name,int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	//모든 데이터값을 초기화하는 생성자
	
	// ** 설정자(mutator)와 접근자(accessor)
	public void setId(String id) {this.id = id;}
	//매개변수로 가져온 id를 id에 넣어줌
	public String getId() {return id;}
	//this.id 해도 됨. 그러나 인자가 없기에 그냥 id 해도 됨
	
	public void setName(String name) {this.name = name;}
	public String getName() {return name;}
	
	public void setAge(int age) {this.age = age;}
	public int getAge() {return age;}
	
	// ** toString 
	public String toString() {
		return "[id = "+id+"name = "+name+"age = "+age+"]";
	}
}//Member

public class Ex08_Accessor {

	public static void main(String[] args) {
		//1) 인스턴스 생성 
		// => setter로 초기화
		Member m1 = new Member(); //기본생성자로 인스턴스 만듦.
		m1.setId("귀여운");
		m1.setName("햄스터");
		m1.setAge(99);
		System.out.println("**m1 name = "+m1.getName());
		System.out.println("**m1 = "+m1);
		
		//생성자로 초기화
		Member m2 = new Member("banana","바나나",88);
		m2.setAge(100);
		System.out.println("**m2 name = "+m2.getName());
		System.out.println("**m2 = "+m2);
				
	}

}
