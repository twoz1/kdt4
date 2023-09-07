package j04_array;

import java.util.Arrays;
import java.util.Random;

//** Lotto 번호 생성기 만들기 2
//=> 찾기(Search) & 정렬(Sort)

public class Ex05_Lotto2_Sort {

	public static void main(String[] args) {
		//1) 배열정의
		int[] lotto = new int[6];
		//2) Random 으로 숫자추출 & 배열에 담기
		//*** Random 클래스
		//=> java.util 에 있으므로 import 필요하고, new 선언후 사용가능함.
		//=> Random() : 호출시마다 현재시간을 이용한 종자값이 자동 설정됨 
		// Random(long seed) : 인자값으로 주어진 종자값이 설정됨 
		// 종자값 : 난수 만드는 알고리즘에서 사용되는 값
        //		         ( 같으면 같은난수 얻음 )
		//
		//=> Random().nextInt(큰수 - 작은수 + 1) + 작은수 
		// Random().nextInt() , Random().nextLong() , Random().nextBoolean()
		// Random().nextDouble() , Random().nextFloat()

		Random rn = new Random();
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i]=rn.nextInt(45) + 1;
			
			for(int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				} // if
			}//j 
		}//i
		
		//3) 출력
		System.out.println("**Lotto => " + Arrays.toString(lotto));
		
	     // => 순차정렬 (Sequence Sort)
	     // => 정렬 알고리즘에서 가장 간단하고 기본이 되는 알고리즘으로
	     //    배열의 처음과 끝을 탐색하면서 차순대로 정렬하는 가장 기초적인 정렬 알고리즘
	     // ** 정렬 알고리즘 : 삽입(insert)정렬, 합병(Merge)정렬, 퀵(Quick)정렬..
		 for(int i =0; i<lotto.length; i++) {
			 for(int j = i+1; j<lotto.length; j++) {
				 if(lotto[i] > lotto[j]) {
					 int temp = lotto[i];
					 lotto[i] = lotto[j];
					 lotto[j]= temp;	 
				 }
			 }
		 }
		 // 이 식에서 if 문 부호만 바꾸면 내림차순이 됨.
		 System.out.println("**Lotto 오름차순 => "+ Arrays.toString(lotto));
		 
		 // ** 배열 Wrapper Class : Arrays
		 // => Arrays의 주요 메서드 : equals(null, null), sort(null)
		 
		 //5) myNumber 생성 후 비교하기
		 //=> 배열정의 , Random 추출 후 , 중복확인 후 배열에 담기
		 //=> 정렬, equals 비교
		 
//		 Random x = new Random();
		 int[] myNumber = new int[6];
		 
		 for(int i = 0; i <myNumber.length; i++) {
			myNumber[i] = rn.nextInt(45)+1;
			for(int j = 0; j < i; j++ ) {
				if(myNumber[i] == myNumber[j]) {
					--i;
					break;
				}//if
			}//j
		 }//i
		 
		 Arrays.sort(myNumber);
		 System.out.println("귀염둥이의 넘버는?"+Arrays.toString(myNumber));
		 System.out.println("Lotto와 myNumber 비교하깅~! => " + Arrays.equals(lotto, myNumber));
		 
		 int count =0; 
		 for(int i =0; i < myNumber.length; i++) {
			 for(int j = 0; j < myNumber.length; j++) {
				 if(myNumber[j]==lotto[i] ) {
					 count++;
				 }
			 }
		 }
		 
		 switch(count) {
		 case 6 : {
			 System.out.println("1등!!!!!"); break;
		 }
		 case 5 : {
			 System.out.println("2등!!!"); break;
		 }
		 case 4 : {
			 System.out.println("3등!!"); break;
		 }
		 case 3 : {
			 System.out.println("4등!"); break;
		 }
		 case 2 : case 1 :{
			 System.out.println("아쉽지만 다시 사십쇼잉~!"); break;
		 }
		 default : {
			 System.out.println("어떻게 하나도 안 맞냐?ㅋ"); 
		 }
		 }
		 System.out.println("맞은 개수 => "+count);
		 
		 if(lotto == myNumber) {
			 System.out.println("당첨되셨습니다. 인생이 활짝 피겠군요!!!");
		 }else {
			 System.out.println("포기하지 마십쇼...언젠가 1등이 당첨되리라 믿습니다.....");
			 
		 
		 }
	}
}
