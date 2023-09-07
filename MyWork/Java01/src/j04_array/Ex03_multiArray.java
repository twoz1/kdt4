package j04_array;

//** 다차원 배열
//1차원 배열이 2개 모이면 2차원 배열
//1차원 배열이 3개 모이면 3차원 배열 ...2차원 이상은 거의 안쓰임

public class Ex03_multiArray {

	public static void main(String[] args) {
		
		// 1) 명시적 선언
		int [][] mul = new int[2][3];
		
		// mul = {{10, 20, 30}, {11, 22, 33}}
		//=> 초기화
		mul [0][0] = 10; 
		mul [0][1] = 20; 
		mul [0][2] = 30; 
		mul [1][0] = 11; 
		// mul [1][1] = 22; 
		// => 배열에서 값을 할당하지 않으면 default 값을 가짐 = int 의 default 값은 0 을 가
		mul [1][2] = 33; 
		
		// => 활용
		mul[0][0] = mul[0][1] + mul[1][0];
		
		// => 출력 (for 구문)
		
		for (int i = 0; i < mul.length; i++){
			for(int j =0; j < mul[i].length; j++) {
				System.out.printf("[%d , %d] = %d \n", i, j, mul[i][j]);
			}
		}
		
		//----------------------------------------- 1) 명시적 선언
		
		// 2. 묵시적 선언
		
		int [][] mulz = {{100,200,300},{111,222},{999}};
		// => 명시적으로 내부배열의 크기가 정의되어있지 않기 때문에 각각의 크기를 가짐
		
		for(int i =0; i < mulz.length; i++) {
			for(int j =0; j < mulz[i].length; j++) {
				System.out.printf("[%d , %d] = %d \n", i, j, mulz[i][j]);
			}
		}
		
		
		// => Data 없는 index 확인
		// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
		// System.out.println("확인 =>" + mulz[1][2]);
		
		

	}

}
