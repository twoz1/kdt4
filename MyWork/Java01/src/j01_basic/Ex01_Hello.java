

package j01_basic;

//** 이클립스 단축키 
//자동 import : Ctrl+Shift+O
//Line삭제 : Ctrl + d

//들여쓰기 : Ctrl+A , Ctrl+I 
//=> 한번에 Ctrl+Shift+F

//클래스 Ctrl+클릭 => 클래스 소스보기 
//클래스 Ctrl+T => 클래스 계층도 

//** 클래스 
//=> 클래스명은 화일명과 동일함.
//=> 맴버   
//변수:value, 
//메서드 (함수 function , 프로시져 procedure) : 동작

//** 문장(Statement)
//=> 사용자가 컴퓨터에게 작업을 지시하는 단위
//=> 문장의 끝은 항상 세미콜론 (;)
//=> 선언문과 실행문(메소드 안에 작성) 

//** Java Coding
//=> 대.소 문자구별함

/* 주석(comment)의 종류
=> 한줄 주석
 => 여러줄 주석
*/
public class Ex01_Hello {
	
	int number = 100;
	String addr;
	String Name; // name, Name 은 다르지만, 변수의 첫 글자 대문자는 바람직 하지 않음.
	String 주소 ="분당"; // 한글도 허용하지만 바락직 하지 않음
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name ="햄스터";
		String job ="강사";
		int age = 20;
		boolean b =false;
		
		System.out.println("Hello");
		System.out.println("이름 : " + name);
		System.out.println("직업 : " + job);
		System.out.println("나이 : " + age);
		System.out.println("참/거짓 :" +b);
		System.out.println("합계 :" +100+200); // 문자포함 + 연산은 문자열연산
		System.out.println("합계 :" +(100+200)); 
	}//main	
}//class
