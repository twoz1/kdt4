package j01_basic;

//** Type Casting (형변환)
//1. 자동 (프로모션 promotion , 확대 형변환)
// => 큰자료형에 작은자료형을 대입하면 : 자동으로 이루어짐

//2. 강제 (디모션, demotion, 축소 형변환)
// => 작은자료형에 큰자료형을 대입 : 자동으로 이루어지지않음
//=> 자료의 Type이 다른경우
//=> 명시적 형변환

public class Ex04_Casting {

	public static void main(String[] args) {
        // 1. 자동 (프로모션 promotion , 확대 형변환)
		double d = 123.456; // 8byte
		int i = 123456; // 4byte
		
		d=i; //프로모션 promotion
		
		System.out.printf("프로모션 promotion : d = %f, i = %d \n" , d, i);
		
		// i=d; -> Error : Type mismatch
		
		// ----------------------------------------------- 자동 형변환
		
		// 2. 강제 ( 디모션, demotion, 축소 형변환)
		// => 위 21행의 i 값과 비
		
		i = (int)d;
		System.out.printf("디모션 demotion : i = %d \n", i);
		
		// => 같은크기 다Type (int, float)
		
		float f = 456.789f;
		int n = 100;
		// n = f; 오류 , f = n; // 허용 (프로모션 적용)
		n = (int)f;
		System.out.printf("디모션 demotion : n = %d, f = %f \n", n, f);
		
		// => 정수형 연산의경우 
		// 4byte 이하 type 의 정수형 연산의 경우 무조건 그 결과는 int(4byte) 로 처
		
		short s1 = 10, s2 = 20, s3 = 0;
		
		// s3 = s1 + s2; -> Error : Type mismatch ( s1 + s2 의 결과는 int 때문)
		s3 = (short)(s1 + s2);
		
		// => char / int
		char c = 'C'; // 2byte
		System.out.printf("디모션 char1 : c = %s, C의 코드값 = %d \n", c, (int)c);
		n = c+10; // 자동형변환으로 산술연산 적용
		System.out.printf("디모션 char2 : n = %d, n의 char값 = %s \n", n, (char)n);
		
		// ----------------------------------------------- 강제 형변환
	}

}
