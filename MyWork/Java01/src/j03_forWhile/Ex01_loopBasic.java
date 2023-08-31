package j03_forWhile;

public class Ex01_loopBasic {
	//** 반복문 의 3요소 : 반복자의 초기값, 조건식(true or false), 증감식
	//=> for : for(초기값; 조건식; 증감식)
	//=> while, do while : 초기값(before while_Loop), 
    //	                   조건식(true or false => while 조건문), 
    //	                   증감식(in while_Loop)

	//** 반복자(iterator) 
	//=> 반복문에서 횟수를 count 하는 변수
	public static void main(String[] args) {
	     // ** 과제
	      // => 1~100 까지의 합 출력하기
	      // => 1+2+3+.......+100
	      // => int result = 1+2+3+.......+100 ;
//	      int result = 0;
	      // 1) for
//	      for (int i = 1; i<101; i++) {
//	    	  result +=i;
//	      }
//	      System.out.println(result);
	      
	      // 2) while
//		  int result = 0;
//	      int i = 1;
//	      while(i<=100) {
//	    	  result +=i;
//	    	  i++;
//	      }
//	      System.out.println(result);
		
	      // 3) do_while
		  // => 조건에 맞지 않아도 최소한 1번은 무조건 실행함.
		  //    조건식이 뒤에 있으니깐..
	      int i = 1;
	      int result = 0;
	      do {
	    	  result +=i;
	    	  i++;
	      }while(i<=100);
	      System.out.println(result);
	      System.out.println(i);
	}

}
