package aop01;

import java.util.Random;

public class Boy implements Programmer {
	
	@Override
	public void doStudying() {
		System.out.println("~~ 프로젝트 과제를 합니다 => Before");
		try {
			System.out.println("~~ 열심히 회원관리을 만듭니다 => 핵심적 관심사항");
			if ( new Random().nextBoolean() ) {
				// 실패
				throw new Exception("~~ 404*100 ㅠㅠ ~ => 예외발생");
			}else {
				// 성공
				System.out.println("~~ 회원가입이 잘 됩니다 => 핵심적 관심사항 정상종료");
			}
		} catch (Exception e) {
			System.out.println("** Boy Exception => "+e.toString());
			System.out.println("~~ 밤새워 수정 합니다 zz ~~ => 예외발생으로 핵심적 관심사항 비정상종료");
		} finally {
			System.out.println("** finally : 무조건 제출한다 => 무조건종료");
		}
	} //doStudying

} //class
