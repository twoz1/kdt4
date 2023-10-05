package jdbc02;
// 모델 - 컨드롤러 - 뷰

//** VO (Value Object) , DTO (Data Transfer Object)
//=> 자료의 구조를 표현하는 클래스이며, 자료의 전달에 이용됨
//=> 대부분 Table별로 만들며, Table과 동일한 필드명을 사용한다.
//=> Table과 무관하게 자료전달용으로만 정의한 경우 DTO 라 함.

//=> 맴버변수 : private
//=> 외부에서는 setter/getter 로 접근

public class StudentVO {  //desc를 보고 타입 판단
	
	private int sno;
	private String name;
	private int age;
	private int jno;
	private String info;
	private Double point;
	private String birthday;
	
	//** getter / setter 
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
		this.point = point;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	// toString
	@Override
	public String toString() {
		return "StudentVD [sno=" + sno + ", name=" + name + ", age=" + age + ", jno=" + jno + ", info=" + info
				+ ", point=" + point + ", birthday=" + birthday + "]";
	}
	
}//class // 이지야 안녕!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
