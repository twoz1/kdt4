package j10_Exception;

public class Ex04_MessageNaN {

	public static void main(String[] args) {
	      // ** by Zero ( 나누기 0 )
	      // => 정수형 연산 : ArithmeticException 
	      // => 실수형 연산 : Exception 이 일어나지않음
	      //                Wrapper 클래스의 메서드 활용
		try {
			double d1 = 1.5/0.0; //Infinity:무한수
			double d2 = 1.5%0.0; //NaN : Not a Number(숫자가 아님)
			
			System.out.printf("** 실수 by zero Test: d1=%f, d2=%f, d1*100=%f%n",d1,d2,d1*100);
			// ** 실수 by zero Test: d1=Infinity, d2=Infinity, d1*100=Infinity
			// => 그러므로 Exception으로 대응할 수 없음
			
			
			if(Double.isFinite(d1) || Double.isNaN(d2)) System.out.println("Zero연산 허용불가");
			else System.out.printf("** 실수 by zero Test: d1=%f, d2=%f, d1*100=%f%n",d1,d2,d1*100);
				
			
			// => 정수형 연산
			System.out.printf("** 정수 by zero Test: 100/0=%d%n",100/0);
		
		}catch(Exception e) {
			System.out.println("Exception => "+e.toString());
			System.out.println("Exception => "+e.getMessage());
			e.printStackTrace(); // 출력 메서드이기 때문에 호출만 하면 됨
	        // => e.toString 을 포함한 순차적인 실행경로 등이 출력되어
	        //    예외발생의 원인과 경로 파악에 도움. 
		}finally {
			System.out.println("finally_무조건 실행");
		}
		
		
	}

} 
