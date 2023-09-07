package j06_packageTest;

class Car {
	// ** 맴버변수, 필드(field) : 속성 
	public int speed;
	public int mileage;
	public String color="Yellow";
	
    // ** package Test 용 변수선언
    public static int ddd=100;  
	
	// ** 맴버메서드 (Method, function, procedure)
	public void speedUp() {	speed+=10; }
	public void speedDown() { speed-=10; }
	
	public String toString() {
		return "[ speed="+speed+" mileage="+mileage+" color="+color+" ]";
	}
	
} //car

public class Ex01_carTest {

	public static void main(String[] args) {
		
	} //main

}//class
