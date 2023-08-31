package j03_forWhile;

public class Ex06_star {
	public static void main(String[] args) {
		//1) 반삼각형
//
//		for(int i = 1; i < 10; i++) {
//			for(int j = 1; j <= i; j++) {
//
//				System.out.print("*");
//			}
//			System.out.println("");
//		}	

		//2) 피라미드(삼각형)
		System.out.println("\n** 2) 피라미드(삼각형) **");
		int line = 10;
		for(int i = 1; i <= line; i++) {
			for(int j = 1; j <= i+(line-1) ; j++) {
				if(j < (line+1)-i )
				System.out.print(" ");
				else {System.out.print("*");}
			}
			System.out.println("");
		}	
	
		//3) 다이아몬드
			  System.out.println("\n** 3) 다이아몬드 **");
			      // => 상부출력
			      line=9;
			      for (int i=1; i<=line; i++) {
			         //=> 반복문1: space
			         for (int j=1; j<=line-i; j++) {
			            System.out.print(" ");
			         }
			         //=> 반복문2: * 
			         for (int j=1; j<=(i*2-1); j++) {
			            System.out.print("*");
			         }
			         System.out.println("");
			      } //for_i
			      
			      // => 하부출력
			      // => 총 그리는 line 갯수(위의 line-1=4) ~ 1 까지 감소 
			      for (int i=line-1; i>=1; i--) {
			         //=> 반복문1: space
			         for (int j=1; j<=line-i; j++) {
			            System.out.print(" ");
			         }
			         //=> 반복문2: *
			         for (int j=1; j<=(i*2-1); j++) {
			            System.out.print("*");
			         }
			         System.out.println("");
			      }

		//4) 모래시계
			      System.out.println("\n** 4) 모래시계 **");
			      line=13;
			      for (int i=line-1; i>=1; i--) {
				         //=> 반복문1: space
				         for (int j=1; j<=line-i; j++) {
				            System.out.print(" ");
				         }
				         //=> 반복문2: *
				         for (int j=1; j<=(i*2-1); j++) {
				            System.out.print("*");
				         }
				         System.out.println("");
				      }
			      
			      for (int i=2; i<=line; i++) {
				         //=> 반복문1: space
				         for (int j=1; j<=line-i; j++) {
				            System.out.print(" ");
				         }
				         //=> 반복문2: * 
				         for (int j=1; j<=(i*2-1); j++) {
				            System.out.print("*");
				         }
				         System.out.println("");
				      } //for_i

	}
}
