package j01_basic;
//** 2진수(Binary number), 8진수 , 16진수 표기
//=> 2진수 : 0b 로시작 -> 0b1111
//=> 8진수 : 0  Octal Number
//=> 16진수: 0x Hexadecimal Number
//=> 03_01~.ppt, 18page  
public class Ex05_BinOctHex {

	public static void main(String[] args) {
		int bin = 0b1111; // 1+2+4+8=15
		int oct = 017; // 8+7=15
		int hex = 0xf;// 9, 10_A, 11_B, 12_C, 13_D, 14_E, 15_F, 16_10
		System.out.printf("bin=%d, oct=%d, hex=%d \n", bin, oct, hex);
		System.out.printf("bin=%s, oct=%#o, hex=%#x \n", Integer.toBinaryString(bin), oct, hex);
		
		//=> Integer를 2, 8, 16 진법으로 출력하기
		System.out.println("Binary =>" + Integer.toBinaryString(123));
		System.out.println("Octal =>" + Integer.toOctalString(123));
		System.out.println("Hexadecimal =>" + Integer.toHexString(123));
		
		// => int to String : 문자열에 연결되면 문자로 취급
		System.out.println("int to String1 => " +bin+oct+hex);
		System.out.println("int to String2 => " +(bin+oct+hex));
		
		// => String to int
		String s = "123";
	    System.out.println("String to int1 =>" +(s+100));
	    System.out.println("String to int2 =>"+(Integer.parseInt(s)+100));
	    s="일이삼";
	    System.out.println("String to int3 =>"+(Integer.parseInt(s)+100));
	}
}
