package j02_ifSwitch;

//** 실습 : 
//1. 월을 입력 받아서 
//2. 몇일까지 인지,  
// => 1,3,5,7,8,10,12월 => ?월은 31일 까지 입니다.
// => 4,6,9,11 월 => ?월은 30일 까지 입니다.
// => 2 월 => ?월은 29일 까지 입니다.
//3. 무슨 계절인지 출력 하기
//  => 3~5:봄 , 6~8:여름, 9~11:가을, 12~2:겨울3

//** switch case 구문으로 작성 하세요 ~~
import java.util.Scanner;

public class Ex04_switchMonth {

	public static void main(String[] args) {
		//		// TODO Auto-generated method stub
		//		Scanner sc = new Scanner(System.in);
		//		System.out.println("몇 월인지 입력하세용~!");
		//		int month = sc.nextInt();
		//		int days;
		//		switch(month) {
		//		case 3 : days = 31;
		//		case 4 : days = 30;
		//		case 5 : days = 31;
		//			System.out.println("봄이에용 "+month+"월은 "+days+"까지입니덩구리당당" );
		//			break;
		//		case 6 : days = 30;
		//		case 7 : days = 31;
		//		case 8 : days = 31;
		//			System.out.println("여름이에용 "+month+"월은 "+days+"까지입니덩구리당당");
		//			break;
		//		case 9 : days = 30;
		//		case 10 : days = 31;
		//		case 11 : days = 30;
		//		System.out.println("가을이에용 "+month+"월은 "+days+"까지입니덩구리당당");
		//			break;
		//		case 12 : days = 31;
		//		case 1 : days = 31;
		//		case 2 : days = 29;
		//			System.out.println("겨울이에용 "+month+"월은 "+days+"까지입니덩구리당당");
		//			break;
		//		}
		//		

		// 과제
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력해주세요.");
		int month = Integer.parseInt(sc.nextLine());
		int days = 0;
		
	      // 2) 며칠까지인지
	      switch (month) {
	         case 1: case 3: case 5:
	         case 7: case 8: case 10:
	         case 12: days = 31; break;
	         case 4: case 6: case 9:
	         case 11: days = 30; break;
	         case 2:  
	            // => 윤년 확인 추가
	            if (((year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0))
	                  days = 29;
	            else days = 28;
	            break;
	       } //switch
		
		//3) 무슨 계절인지
		String season = "";
		switch(month){
			case 3: case 4: case 5: season = "봄이당"; break;
			case 6: case 7: case 8: season = "여름이당"; break;
			case 9: case 10: case 11: season = "가을이당"; break;
			case 12: case 1: case 2: season = "겨울이당"; break;
			default : System.out.println("숫자를 정확히 입력해라 팍쒸!!!");
		}//switch
		
		// 4) 결과 출력
		System.out.printf("%d월은 %d까지 있고, %s입니다.", month,days,season);
	}
	
    /* => new_version
    Java 버젼 15이상 부터 가능
    switch (month) {
    case 1,3,5,7,8,10,12: days = 31; break;
    case 4,6,9,11: days = 30; break;
    case 2:  days = 29; break;
    } //switch
    */

}


