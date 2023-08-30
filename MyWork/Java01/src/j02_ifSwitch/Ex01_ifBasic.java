package j02_ifSwitch;

public class Ex01_ifBasic {

	public static void main(String[] args) {
		// ** 삼항식
		boolean rain = true;
		String doing = (rain==true) ? "Study_Java" : "그래도 공부함";
		
		// **if : 단일구문
		if (rain==true) doing = "Study_Java";
		else doing = "그래도 공부함";
		
		// if : 복합구문(compound statement)
		// => 여러문장의 경우 중괄호를 사용하여 문장들을 그룹핑
		
		if(rain) {
			int i = 100; // 지역변수 : 정의된 {} 내에서만 유효
			System.out.println("**비오면**");
			System.out.println(doing);
			System.out.println("**비오면 우산 필요함");
		}else {
			System.out.println("**비 안오면**");
			System.out.println(doing);
			System.out.println("**비 안오면 양산 필요함");
		}
		
		//**복합조건식
		//=> 날씨가 좋고 공휴일이면 공원에 산책을 간다.
		//   아니면 집에서 요리를 한다.
		//=> rain은 false, day는 "Red"이면
		
		String day="Red";

		if(!rain && day == "Red") {
			System.out.println("공원에 산책을 간다.");
		}else {
			System.out.println("햄스터랑 논다.");
		}
		
	}//main
}//class
