package j05_classMethod;

import java.util.Arrays;
import java.util.Random;

public class Ex10_CallByRefLotto {

		// **package Test 용 변수선언
		int ddd = 100; //default 접근쟈
		public int iii = 200;
		public static int sss = 300;
		
	public static void main(String[] args) {
		// 1) 배열정의
		int[] lotto = new int[6];
		
		// 2) Random 으로 숫자추출 & 배열에 담기
		Random rn = new Random(5);
		for (int i=0; i<lotto.length; i++) {
			
			lotto[i] = rn.nextInt(45)+1;
			// ** 중복확인
			for (int j=0; j<=i-1; j++) {
				if ( lotto[i]==lotto[j] ) {
					--i;
					break;
				} //if
			} //j
		} //i
		
		// 3) 출력 (정렬전)
		System.out.println("** Lotto (정렬전) => "+Arrays.toString(lotto));
		
		// 4) 오름차순 정렬
		// => 순차정렬 (Sequence Sort) 메서드 만들기 
		// => static 
		lottoSort(lotto, 'A');
		System.out.println("** Lotto (정렬후) => "+Arrays.toString(lotto));

	} //main
	
	//** CallByReference (매개변수 참조자료형, 주소전달) 
	//=> 배열
	//=> 매개변수 (배열, char_Asccending/Descending)
	//=> 전달된 배열을 오름차순 또는 내림차순으로 정렬	
	public static void lottoSort(int[] arr, char c) {
		for (int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				// ** 오름차순, 내림차순
				if ( (c=='A' && arr[i]>arr[j]) || (c=='D' && arr[i]<arr[j]) ) {
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			} //j
		} //i
	} //lottoSort
	
} //class
