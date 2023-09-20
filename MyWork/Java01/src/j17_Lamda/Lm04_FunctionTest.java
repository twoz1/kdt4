package j17_Lamda;

import java.util.function.Function;

// FunctionalInterface 1
// => Function <T, R>

// 실습
// => String 의 길이를 return
// => Double 입력받아 Double return




public class Lm04_FunctionTest {

	public static void main(String[] args) {
		// 실습 1) String 의 길이를 return

		Function<String, Integer> f1 = s->s.length();

		// 실습 2) Double 입력받아 Double return

		Function<Double, Double> cToi = d -> d * 0.393701; 		
		Function<Double, Double> iToc = d -> d * 2.54;
		
		//** 실행
		System.out.println("** 실습1) function의 길이 =>" +f1.apply("function"));
		System.out.println("** 실습1) 가나다라마 의 길이 =>" +f1.apply("가나다라마"));
		
		System.out.println("** 실습2) cToi, 123cm =>" +cToi.apply(123.0)+"inch");
		System.out.println("** 실습2) iToc, 123inch =>" +iToc.apply(123.0)+"cm");
		
	}

}
