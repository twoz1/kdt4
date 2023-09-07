package j07_classExtends;

public class Ex01_Student {
	// => 변수
	private String no;
	private String name;
	private int score;
	
	// ** 집합(has-a): Student 와 Car 클래스의 관계
	Ex01_Car car = new Ex01_Car(1000, 5000, "Blue");
	static Ex01_Car myCar = new Ex01_Car(1000, 5000, "Gold");
	
	// => 생성자
	Ex01_Student() {}
	Ex01_Student(String no, String name, int score) {
		this.no=no;
		this.name=name;
		this.score=score;
	}
	
	// => 생성시에 초기화 하고 readonly 로 사용
	public String getNo() { return no; }
	public String getName() { return name; }
	public int getScore() { return score; }
	
	// => toString
	public String toString() {
		return "[ no="+no+", name="+name+", score="+score+" ]";
	}

} //class
