package j03_forWhile;

import java.util.Random;
import java.util.Scanner;

public class Ex04_RandomGame {

	public static void main(String[] args) {
		// 1) Random Number 구하기
	      Random rn = new Random();
	      int happyNumber = rn.nextInt(10)+1; // 1~10 내에서 임의의 정수를제공
	      
	      // 2) myNumber 입력받기
	      // => 당첨될때까지
	      Scanner sc= new Scanner(System.in);
	      int myNumber = 0;
	      int abs = 0;
	      
	      while(true){
	    	  // 2.1 ) myNumber 입력 받기 
	    	  System.out.println("1~10 숫자 입력 : ");
	    	  myNumber = sc.nextInt();
	    	  abs = Math.abs(happyNumber - myNumber);
	    	  // 2.2 ) 확인
	    	  // => 일치, 차이가 1 or 2 : 반복문 탈출 (break);
	    	  //    아니면 계속 진행
	    	  if(abs <= 2 ) break;
	      }
	      
	      String text = "";
	      switch(abs) {
	      case 0: text = "금메달"; break;
	      case 1: text = "은메달"; break;
	      case 2: text = "동메달"; break;
	      }
	      // 3) 결과처리(출력)
	      System.out.printf("당첨번호 %d , 입력번호 %d , 차이 %d 나의 메달은 : %s !!!!!!!!!!!!!!!!! %n",
	    		            happyNumber, myNumber,abs,text);

	}//main
}//class
