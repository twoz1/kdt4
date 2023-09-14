package j11_APITest;

import java.util.Date;

//** Person
//=> 주민등록번호, 이름을 전달받으면
//=> 주민등록번호를 이용해서, age, 성별을 set 하고
//=> info 출력하기 

//=> 맴버필드(private) : idNo(String), name(String), age(int), gender(char)
//=> 생성자 2개
//    * default
//    * 주민등록번호,이름을 매개변수로 전달받아 초기화 
//    -> 나이 계산, 성별도 찾아서 set
//=> setter/getter
//     이름만 수정 가능, 
//    모든필드를 사용가능 (그러나 주민번호는 뒷자리는 * 로표시)
//=> infoPrint()
//=> toString 은 오버라이딩

//** info
//이름 : 000
//번호 : 090909-*******
//나이 : 20세
//성별 : "남" 또는 "여"
//Date now = new Date();
class Person{
	private String idNo;
	private String name;
	private int age;
	private char gender;
	
	Person(){}
	Person(String idNo, String name ){
		this.idNo=idNo;
		this.name=name;
		
		int setAge = 0;
		setAge = Integer.parseInt(idNo.substring(7,8));
		if(setAge == 1 || setAge == 3 ) gender='M';
		else gender ='F';
		
	}
	
	public int getAge(int age) {
		
		int setAge = Integer.parseInt(idNo.substring(0,6));
		age = idNo-setAge;
		
		return age;
	}
	
	
}

//** PersonTest
//=> Person 5명 생성후 배열에 넣고,
// 나이순으로 출력하기
//=> 나이순 정렬은 정렬메서드 (static ageSort()) 만들어서 하세요~~  
//=> 출력은 infoPrint() 로 

public class Ex07_PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("햄스터","950221-2254587");
		
	}

}
