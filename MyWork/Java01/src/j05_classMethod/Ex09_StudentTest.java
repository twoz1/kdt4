package j05_classMethod;

// ** 복습
// => 207p 연습문제 6-1, 6-2, 6-3 구현
// => 6-1
//	-> 맴버변수는 private 으로 정의
//	-> setter/getter, toString 추가
// => 6-2 : info() 는 만들지 않아도 됨.
// => 6-3
//	-> Student 의 인스턴스를 5개 만들어서 배열에 담기
//	-> 배열을 이용해서 위 5개 인스턴스의 정보와 
//     Total, Average 출력하기

// ** 클래스 구성요소 : 맴버
// => 맴버변수(필드 field, 컬럼 column): 전역(Global)변수 
// => 메서드
//	-> main, 생성자메서드, toString, setter/getter
//	-> 사용자정의메서드
// => 실행문을 작성할 수 없다.  

class Student {
	// 1) 맴버변수 선언문
	private String name;
	private int ban;
    private int no;
    private int kor;
    private int eng;
    private int math;
    
    //package Test 용 변수선언
    public static int ddd = 100;
	
	// 2) 메서드
	// => 생성자
    public Student() {}
    public Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
     }
	
	// => setter/getter
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setBan(int ban) { this.ban = ban; }
    public int getBan() { return ban; }

    public void setNo(int no) { this.no = no; }
    public int getNo() { return no; }

    public void setKor(int kor) { this.kor = kor; }
    public int getKor() { return kor; }

    public void setEng(int eng) { this.eng = eng; }
    public int getEng() { return eng; }

    public void setMath(int math) { this.math = math; }
    public int getMath() { return math; }
	
	// => 사용자정의메서드
    public int getTotal() { return kor+eng+math; }
    
    // => 평균은 소수이하 2자리로
    public float getAverage() { 
    	//return (kor+eng+math)/3; 
    	//return (int) ((kor + eng + math) / 3f * 10 + 0.5f) / 10f;
    	return Math.round(((kor+eng+math)/3f) * 100) / 100.0f;
    	// Math.round : 반올림 정수화
    }
    
	// => toString
    public String toString() {
        return "[ 학생이름= " + name + ", 반="
              + ban + ", 번호=" + no + ", 국어점수="
              + kor + ", 영어점수=" + eng + ", 수학점수="
              + math + " ]";
    }
    // ** 성적순 정렬
    // => 인스턴스 없이 다른 클래스들이 호출 가능하도록 작성
    // => 내림차순
    public static void studentSort(Student[] sarr) {
    	for (int i=0; i<sarr.length; i++) {
    		for (int j=i+1; j<sarr.length; j++) {
    			if (sarr[i].getTotal() < sarr[j].getTotal()) {
    				Student temp = sarr[i];
    				sarr[i]=sarr[j];
    				sarr[j]=temp;
    			}
    		} //for_j
    	} //for_i
    }//studentSort
	
} //Student

//=======================================
public class Ex09_StudentTest {

	public static void main(String[] args) {
		// 1) Student 배열 만들기
		Student s1 = new Student();
		s1.setName("홍길동");
		s1.setBan(1);
		s1.setNo(10);
		s1.setKor(90);
		s1.setEng(80);
		s1.setMath(70);
		
		Student s2 = new Student("김길동",2,20,70,80,100);
		// String name="가나다라";  int age=100; 과 동일한 선언문 (비교)
		
		Student[] sss = {s1, s2, 
				new Student("이길동",3,30,90,80,30), 
				new Student("박길동",4,40,80,70,40), 
				new Student("오길동",5,50,90,80,50) };
		
		// 2) 출력
		// => eachFor 적용 : index 사용할 필요 없고 readOnly 의 경우 
		// => 기능추가 : 반 전체 합계, 평균 계산하고 출력하기
		int sum=0;
		double avg=0;
		for ( Student s:sss) {
			System.out.println(s);
			System.out.printf("** Total=%d, Average=%5.2f \n", s.getTotal(), s.getAverage());
			sum+=s.getTotal();  
		}
		avg = sum/sss.length;
		System.out.printf("** 전체합계=%d, 전체평균=%5.2f \n", sum, avg);	
		
		// 3) 석차순 출력
		// => 정렬 메서드 만들기
		// => 인스턴스 없이 다른 클래스들이 호출 가능하도록 작성
		Student.studentSort(sss); 
		// => 정렬 메서드 실행후 sss의 순서는 변경되어있음
		System.out.println("** 성적순 출력 **");
		for ( Student s:sss ) {
			System.out.printf("%s, 합계=%d, 평균=%5.2f \n", s, s.getTotal(), s.getAverage());
		}
		
	} //main
} //class
