package j01_basic;

//** bit 연산
//=> 쉬프트 연산 , 논리 연산

public class Ex09_Operator02_bit {

	public static void main(String[] args) {
		int x=10, y=3; // 1010, 0011
		// 1) 쉬프트연산 : >> , << 
		System.out.println("** x >> y => "+(x >> y));
		// => 1010 -> 0101 -> 0010 -> 0001 => 1
		System.out.println("** x => "+ x);
		System.out.println("** y => "+ y);
		System.out.println("** x >> 1 => "+(x >> 1));
		
		System.out.println("** x << y => "+(x << y));
		// => x를 왼쪽으로 y만큼 이동
		//    1010 -> 1  0100 -> 10 1000 -> 101 0000 => 80
		System.out.println("** x << 1 => "+(x << 1));
		
	    // 2) 논리연산
	    // => AND & , OR | , XOR ^ (같으면 0)
		System.out.println("** x & y => "+(x&y)); // x = 1010 
		                                            // y = 0011    
													// &   0010 => 2
		System.out.println("** x | y => "+(x|y)); // x = 1010 
        											// y = 0011    
													// |   1011 => 11
		System.out.println("** x ^ y => "+(x^y)); // x = 1010 
													// y = 0011    
													// ^   1001 => 9
		// => 2진수로 출력하기 
		System.out.println("** x ^ y => "+Integer.toBinaryString((x^y)));
		
		// 3) 활용
		int password = 1234567, d=0;
		int s = 0x1A253B65; //16진수
		System.out.println("**암호화 전 password => "+password);
		
		// => 암호화 (Encryption)
		d = password^s;
		System.out.println("**암호화 된 password =>" +d);
		
		// => 복호화 (Decryption)
		d=d^s;
		System.out.println("**복호화 된 password =>" +d);
		
	}//main
}//class
