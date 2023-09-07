package j04_array;

import java.util.Arrays;

public class Ex02_arrayType {

	public static void main(String[] args) {
		// 타입별로 배열을 정의 하고 출력해본다.
		// => 묵시적 정의 출력은 eachFor 구문으로
		// => float, char, String
		// => data 개수는 5개
		
		// 1) char
		
		char[] alpha = {'A','B','C','D','F'};
		System.out.println(" char alpha 출력하기");
		for (char a : alpha){
			System.out.print(a + " , ");
		}
		
		// -------------------------------- char
		
		// 2) float
		
		float [] point = {3.14f , 25.3f , 15.3f , 12.4f, 15.6f};
		System.out.println("\n float point 출력하기");
		for (float p : point) {
			System.out.print(p + " , ");
		}
		
		// -------------------------------- float
		
		// 3) String
		
		String [] fruite = {"apple" , "banana", "peach", "berry","watermelon"};
		System.out.println("\n String fruite 출력하기");
		for(String f : fruite) {
			System.out.print(f + " , ");
		}
		
		// -------------------------------- String
		
		// 4) long
		long [] price = {12345, 50000, 65000, 880000000000l, 20221212000000l};
		System.out.println("\n long price  출력하기");
		for(long p : price) {
			System.out.print(p + " , ");
		}
		
		// -------------------------------- long
		
		// 배열지원하는 Wrapper Class : Arrays
		System.out.println("\n Wrapper Class : Arrays");
		System.out.println(Arrays.toString(point));
		System.out.println(Arrays.toString(fruite));
		System.out.println(Arrays.toString(alpha));
		System.out.println(Arrays.toString(price));
	}

}
