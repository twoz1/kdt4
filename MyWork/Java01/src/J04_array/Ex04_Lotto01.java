package J04_array;

import java.util.Arrays;
import java.util.Random;

//** Lotto 번호 생성기 만들기 1
// => int 를 6개 담을 수 있는 배열 생성 : lotto
// => Random 으로 1~45 범위의 숫자를 생성해서 배열 초기화 하기
// (추가: 단, 중복은 허용하지 않음)
// => 출력

public class Ex04_Lotto01 {

	public static void main(String[] args) {
		
		// 1) 배열정의
		int[] lotto = new int[6];
		
		
		// 2) Random 이용하여 숫자추출 & 배열에 담기
		Random x = new Random();
		
		for(int i = 0; i < lotto.length; i++) {
			
			lotto[i] = x.nextInt(45) + 1;
			
			// 중복확인 
			
			// => 숫자추출 후, lotto에 담기 전 
			//  -> 임시변수 필요, 중복존재하면 안담고, 존재하지않으면 담는다.
			
			// => 숫자추출 후, lotto에 딤기 후
			//  -> 중복존재하면 i 값을 후진시켜 다시 담도록 <- 이 방법을 사용하여 코
			
			// 중복확인 방법
			// => 이미 lotto 배열에 담겨있는 Data 와 동일성 비
			//    (그러므로 반복문 필요)
			
			for(int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					--i;
					break;
				}//if
			}//j
		}//i
		
		Arrays.sort(lotto);
		
		// 3) 출력
		System.out.println("**Lotto => " + Arrays.toString(lotto));
		
		//4) 최댓값 & 최솟값 출력하기
		int max = lotto[0], min = lotto[0];
		for (int i = 0 ; i < lotto.length; i++) {
			// => 최댓값 찾기
			if(max < lotto[i]) {
				max = lotto[i];
			}
				
			// => 최솟값 찾기
			if(min > lotto[i]) {
				min = lotto[i];
			}
		}
		
		System.out.println("최대값 => "+max);
		System.out.println("최소값 => "+min);
		
		//5) 오름차순 정렬
		// =>Ex05 에서 to be continue.......
		
	}//main

}//class
