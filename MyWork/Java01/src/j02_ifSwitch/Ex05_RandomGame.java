//package j02_ifSwitch;
//
//import java.util.Random;
//import java.util.Scanner;

//public class Ex05_RandomGame {
//	//** 숫자 맞추기 게임
//	//=> 1~10 범위에서 숫자 하나를 입력받아
//	//=> Random 함수의 결과와 일치하면 금메달
//	//=> 차이가 1 이면 은메달, 차이가 2면 동메달, 아니면 꽝
//	//=> Math 클래스를 이용하세요 ~~
//	public static void main(String[] args) {
//		//1) Random Number 구하기
//		Random rn = new Random();
//		int happyNumber = rn.nextInt(10)+1; //1~10 내에서 임의의 정수를 제공
//		
//		//2) myNumber 입력받기
//		String text ="";
//		Scanner sc = new Scanner(System.in);
//		System.out.println("번호를 입력하라 ");
//		int myNumber=sc.nextInt();
//		
//		//3) 결과처림
//		// => 차이 : happyNumber - myNumber의 절대값
////		 => Math.abs(happyNumber - myNumber)
//		String medal = " 꽝꽈웅꽈아아아아앙~~~~멍청이냐?";
////		int result = Math.abs(happyNumber-myNumber);
//		
//		switch(Math.abs(happyNumber-myNumber)) {
//		case 0 : medal = "금메달"; break;
//		case 1 : medal = "은메달"; break;
//		case 2 : medal = "동메달"; break;
//		default : medal = "꽝꽈웅꽈아아아아앙~~~~멍청이냐?";
//		System.out.printf("**오늘의 당첨번호 = %d, myNumner = %d, 결과 =%s \n", happyNumber, myNumber,medal);
//
//	}
//	}
//}

package j02_ifSwitch;

import java.util.Random;
import java.util.Scanner;

//** 숫자 맞추기 게임
//=> 1~10 범위에서 숫자 하나를 입력받아
//=> Random클래스의 추출번호와 일치하면 금메달
//=> 차이가 1 이면 은메달, 차이가 2면 동메달, 아니면 꽝
//=> Math 클래스를 이용하세요 ~~
public class Ex05_RandomGame {

   public static void main(String[] args) {
      // 1) Random Number 구하기
      Random rn = new Random();
      int happyNumber = rn.nextInt(10)+1; // 1~10 내에서 임의의 정수를 제공
      
      // 2) myNumber 입력받기
      Scanner sc = new Scanner(System.in);
      System.out.println("1~10사이의 값을 입력해주세요.");
      int myNumber = sc.nextInt();
      
      // 3) 결과처리 
      // => 차이 : happyNumber - myNumber의 절대값 차이
      // => Math.abs(happyNumber - myNumber) 두 수의 차이
      
      int resultNumber = Math.abs(happyNumber - myNumber);
      String text = "";
      switch(resultNumber) {
         case 0: text = "금메달"; break;
         case 1: text = "은메달"; break;
         case 2: text = "동메달"; break;
      }
      if(resultNumber ==0 || resultNumber<=2) System.out.printf("%d차이로 %s입니다.%n",resultNumber,text);
      else System.out.printf("%d차이로 꽝!!!!!!!!!%n",resultNumber);
   }

}