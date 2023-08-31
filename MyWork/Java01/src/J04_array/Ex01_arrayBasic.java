package J04_array;

import java.util.Arrays;

public class Ex01_arrayBasic {

	public static void main(String[] args) {
		  // ** 과제
	      // => 5명의 성적을 처리한다고 가정
		  int s1 = 11, s2 = 22, s3 = 33, s4 = 44, s5 = 55;
		  int sum = s1 + s2 + s3 + s4+ s5;
		  double avg=(double)sum/5;
		  
		  // ** 배열 : 동일성격의 동일Type 의 자료를 하나의 묶음으로 처리 
	      // 장점 => 일괄처리 (반복문적용)
	      // 특징 => 동일타입, 모든 자료형에 적용가능
	      // 방법
	      // => 선언 후 사용 : 명시적선언, 묵시적선언      
	      // => 크기(length), 인덱스(0 부터 length-1)
	      
	      // 1. 명시적 선언 (new 연산자 이용)
	      // => 크기를 반드시 지정 
		  int [] score = new int[5];
		  
		  // 2. 초기화
		  score[0]=11;
		  score[1]=22;
		  score[2]=33;
		  score[3]=44;
		  score[4]=55;
//		  score[4]="55"; -> 컴파일 오류
//		  score[5]=55;
//		  -> 컴파일 오류는 없지만, 런타임(실행) 오류 발생 
		  //java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
		  
		  
		  //2.1) 합계
		  sum=0;
		  for(int i = 0; i < score.length; i++) {
			 sum+=score[i];
		  }
		  
		  System.out.println("**score =>" +score); //주소값
		  System.out.println("**score 크기 =>" +score.length);
		  System.out.println("**score sum =>" +sum);
		  System.out.println("**Arrays 활용 =>" + Arrays.toString(score));
		  
	}

}
