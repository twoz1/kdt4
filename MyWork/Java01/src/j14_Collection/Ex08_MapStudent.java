package j14_Collection;

import java.util.HashMap;

//** Student Map Test
//=> Student 객체 5개 HashMap 에 넣고 출력하기

class Student {
	private String no;
	private String name;
	private int java;
	private int html;
	private int sum;

	Student(String no, String name, int java, int html) {
		this.no=no;
		this.name=name;
		this.java=java;
		this.html=html; 
		this.sum=java+html;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
d
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", java=" + java + ", html=" + html + ", sum=" + sum + "] \n";
	}
} //class

public class Ex08_MapStudent {

	public static void main(String[] args) {
		// 1. Map 정의
		HashMap<String, Student> sMap = new HashMap<String, Student>();
		
		// 2. 초기화
		sMap.put("A001", new Student("A001", "홍길동", 90, 80));
		sMap.put("A002", new Student("A002", "김길동", 80, 70));
		sMap.put("A003", new Student("A003", "이길동", 70, 60));
		sMap.put("B001", new Student("B001", "오길동", 50, 90));
		sMap.put("B002", new Student("B002", "차길동", 90, 100));
		
		
		// 3. 수정, 삭제
		sMap.get("A003").setName("김그린");
		sMap.remove("A001");
		
		// 출력
		System.out.println(sMap);
		
		
		
	}

}
