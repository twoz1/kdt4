package aop03;

import java.util.Random;

//** Aop 구현
//1 단계 : 핵심적 관심사항 과  공통적 관심사항 분리
//=> 핵심적 관심사항만 구현
//=> 공통적 관심사항(Aspect) 분리 : 별도의 클래스로 분리 -> MyAspect.java

public class Girl implements Programmer {
	
	@Override
	public void doStudying() throws Exception {
		System.out.println("~~ 열심히 게시판을 만듭니다 => 핵심적 관심사항");
		
		// ** Test 를 위해 늘 실패로 처리
		// => 늘 true 값이 되도록 조건을 설정 
		//if ( new Random().nextBoolean() ) {
		if (true) {
			// 실패
			throw new Exception("~~ 500*100 ㅠㅠ ~ => 예외발생");
		}
	} //doStudying

} //class
