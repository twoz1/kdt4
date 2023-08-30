package j02_ifSwitch;
import java.util.Scanner;

//** switch - case - break 문
//1. => switch(key) 문 인자의 Type은 int, char, String 만 가능
//2. => break : 무조건 탈출 (없으면 아래로 계속 default 까지 진행)
//3. => case 블럭에 구문이 없어도 됨 (아래 구문으로 진행됨)
//4. => case 블럭에는 복합구문에도 {....} 사용하지 않음 
//5. => case 값으로 변수 사용은 불가 그러나 변수를 사용하지 않은 수식은 허용

public class Ex03_switchBasic {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//1. int
		System.out.println("**정수를 입력하세요. =>");
		int i = Integer.parseInt(sc.nextLine());

		switch(i) {
		case 1 : System.out.println("1등"); break;
		case 2 : System.out.println("2등"); break;
		case 3 : System.out.println("3등"); 
		// i값 짝수/홀수인지 출력
		if(i % 2 == 0) System.out.println("짝수");
		else System.out.println("홀수");
		break;

		//if문 안에 여러문장(복합문)이 오면 중괄호로 묶어줘야함
		//		if(i % 2 == 0) {
		//		System.out.println("짝수");
		//		System.out.println("안뇽");
		//		}else System.out.println("홀수");
		//		break;

		case 4 : System.out.println("4등"); break; 
		case 5 : System.out.println("5등"); break;
		default:System.out.println("default"); //생략가능
		}//switch(i)

		// 2. char
		System.out.println("코드를 입력하세요.");
		// char code = sc.nextLine();
		char code = sc.nextLine().toUpperCase().charAt(0);
		// char code = 'A';
		switch(code) {
		case 'A' : System.out.println("예술가"); break;
		case 'P' : System.out.println("개발자"); break;
		case 'C' : System.out.println("요리사"); break;
		default : System.out.println("default");
		}


		// 3. String
		System.out.println("Color를 입력하세요.");
		String color = sc.nextLine().toLowerCase();
		switch(color) {
		case "red" : System.out.println("빨강"); break;
		case "blue" : System.out.println("파랑"); break;
		case "green" : System.out.println("초록"); break;
		default : System.out.println("Error");
		}

		// 4. Switch 구문 중첩
		// => 위 2) 구문을 이용하여, 예술가인 경우에는 
		//    color를 입력받아 출력하도록 구현하세요.

		System.out.println("코드를 입력하세요.");
		code = sc.nextLine().toUpperCase().charAt(0);
		switch(code) {
		case 'A' : System.out.println("예술가");
		System.out.println("color를 입력하세요 =>");
		color = sc.nextLine().toLowerCase();
		switch(color) {
		case "red" : System.out.println("빨강"); break;
		case "blue" : System.out.println("파랑"); break;
		case "green" : System.out.println("초록"); break;
		default : System.out.println("Error"); break;
		}

		break;

		case 'P' : System.out.println("개발자"); break;
		case 'C' : System.out.println("요리사"); break;
		default : System.out.println("default");
		}

		sc.close();
		System.out.println("**Program 정상 종료");

	}//main
}//class
