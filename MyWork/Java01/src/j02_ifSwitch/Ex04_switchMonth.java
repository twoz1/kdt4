package j02_ifSwitch;

import java.util.Scanner;

//** 실습과제 
//1. 월을 입력 받아서 (Scanner 사용)
//2. 몇일까지 인지,  
//	=> 1,3,5,7,8,10,12월 => ?월은 31일 까지 입니다.
//	=> 4,6,9,11 월 => ?월은 30일 까지 입니다.
//	=> 2 월 => ?월은 28일 (2023년도기준) 까지 입니다.
//3. 무슨 계절인지 출력 하기
//	 => 3~5:봄 , 6~8:여름, 9~11:가을, 12~2:겨울

//** switch case 구문으로 작성 하세요 ~~

public class Ex04_switchMonth {

	public static void main(String[] args) {
		// 1) 선언문 과 month 입력받기
		int month=0;
		int days=0;
		int year=0;
		String season=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("** 연도 입력하세요: ");
	    year = Integer.parseInt(sc.nextLine());
		
		System.out.println("** 월을 입력하세요: ");
		month = Integer.parseInt(sc.nextLine());
		
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
		
		/* => new_version
		      Java 버젼 15이상 부터 가능
		switch (month) {
	      case 1,3,5,7,8,10,12: days = 31; break;
	      case 4,6,9,11: days = 30; break;
	      case 2:  days = 29; break;
	    } //switch
		*/
		
		// 3) 무슨계절인지
		switch (month) {
	      case 3: case 4: 
	      case 5: season =" 봄봄봄 봄이왔어용~"; break;
	      case 6: case 7:
	      case 8: season = " Hot Summer!"; break;
	      case 9: case 10:
	      case 11: season =" 가을타나봐~~"; break;
	      case 12: case 1:
	      case 2: season = " 레리꼬~레리꼬~ "; break;
	      default: season = " Error : 지구에는 없는 월 !!";
	    } //switch
		
		// 4) 결과 출력
		System.out.printf("%d년 %d월은 %d일까지 있고, %s 입니다. \n", 
							year, month, days, season);

	} //main

} //class
