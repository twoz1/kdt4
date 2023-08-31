package j03_forWhile;

public class Ex03_infinityLoop {

	public static void main(String[] args) {
		// 1) for
		int count =0;
		System.out.println("무한 Loop Test => for");
		for(;;) { // 무조건
			System.out.println("count =>" +count++);
			if(count>50)break; //break는 반복문 탈출
		}
		// 2) 
		count = 0;
		System.out.println("무한 Loop_Test => while");
		while(true) {   //while true 일 때 돌아감 true만 주면 무한 루프
			System.out.println("while_count =>"+count++);
			if(count>50) break;
		}
		
		//3) do_while
		count = 0;
		System.out.println("무한 Loop_Test => do_while");
		do {
			System.out.println("do_while_count =>"+count++);
			if(count>50) break;
		}while(true);
		
		// 조건문 : 무조건 실행
		if(true) System.out.println("TRUE");
        //else System.out.println("FALSE");
		
	}//main

}//class
