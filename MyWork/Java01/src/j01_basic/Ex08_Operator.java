package j01_basic;

public class Ex08_Operator {

	public static void main(String[] args) {
		  // ** 사칙연산
	      int a = 10, b = 3;
	      System.out.println("**사칙연산**");
	      System.out.println("a + b =" +(a+b));
	      System.out.println("a - b =" +(a-b));
	      System.out.println("a * b =" +(a*b));
	      System.out.println("a / b =" +(a/b));
	      System.out.println("a % b =" +(a%b)); //1
	      
	      // ** 대입연산
	      // a=a+b  -> a+=b
	      System.out.println("**사칙연산**");
	      System.out.println("a += b =>" +(a+=b)); //a=10+3 여기서 '='은 대입연산자를 의미 
	      System.out.println("a -= b =>" +(a-=b)); //a = 10
	      System.out.println("a *= b =>" +(a*=b)); //a = 30
	      System.out.println("a /= b =>" +(a/=b)); //a = 10
	      System.out.println("a %= b =>" +(a%=b)); //a = 1
	      // ** 단항연산
	      // => 1씩 증감 (전/후)
	      a = 10; b = 10;
	      System.out.println("**단항연산**");
	      System.out.println("++a =>"+(++a)); // a = 11, 증강 후 출력
	      System.out.println("++b =>"+(b++)); // b = 10, 출력 후 증가
	      System.out.println("--a =>"+(--a)); // a = 10, 감소 후 출력
	      System.out.println("++b =>"+(b--)); // b = 11, 출력 후 감소
	      
	      // ** 관계연산
	      // => 모든 관계연산의 결과는 boolean Type : true(참) / false(거짓)
	      
	      a = 10; b = 3;
	      System.out.println("**관계연산**");
	      System.out.println("a==b =>"+(a==b));
	      System.out.println("a!=b =>"+(a!=b));
	      System.out.println("a>b =>"+(a>b));
	      System.out.println("a>=b =>"+(a>=b));
	      System.out.println("a<b =>"+(a<b));
	      System.out.println("a<=b =>"+(a<=b));
	      // ** 삼항식
	      // => (조건) ? 참 : 거짓
	      //    String 포함, 모든 기본자료형에 적용가능
	      // => a,b 중 큰값 출력하기
	      int max = (a>b)? a : b ;
	      boolean bool = a>b ? true : false;
	      char cc = a>b ? 'T' : 'F';
	      String ss = a > (a-b) ? "참" : "거짓";
	      System.out.println("**삼항식**");
	      System.out.printf("max=%d, bool=%b, cc=%s, ss=%s \n", max, bool, cc,ss);
	      
	      // ** 논리(집합) 연산
	      // => AND && , OR || , NOT ! 
	      System.out.println("**논리(집합)연산**");
	      // 1) a, b 모두 짝수이면 true
	      bool = (a%2==0) && (b%2==0);
	      System.out.println("**&& =>" +bool);
	     
	      // 2) a, b 중 하나만 짝수이면 true 
	      bool = (a%2==0) || (b%2==0);
	      System.out.println("**|| =>" +bool);		
	      
	      // 3) 부정, NOT
	      System.out.println("**Not => "+!bool);
		
	}

}
