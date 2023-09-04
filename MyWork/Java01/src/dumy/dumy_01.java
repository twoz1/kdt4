package dumy;

public class dumy_01 {
	
	public static void main(String[] args) {
		int [] ballArr = {1,2,3,4,5,6,7,8,9};
		int [] ball3 = new int [3];
		
		//배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
		for (int i = 0; i < ballArr.length; i++) {
			int j = (int)(Math.random() * ballArr.length);

			int tmp = 0;
			
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;
			
		} // i 와 j 의 요소를 서로 교환 -> ballArr의 요소를 무작위로 섞는 것을 의미.
		
		// ballArr 배열의 요소가 무작위로 섞인 후
		// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		// 배열의 요소를 다른 배열 요소에 복사 하기 위해서 arrayCopy()메서드를 사용
		
		System.arraycopy(ballArr, 0, ball3, 0, 3);
		
//		System.arraycopy(srcArray, srcPos, destArray, destPos, length);
//		1. 복사하려는 원본 배열
//		2. 원본 배열에서 복사를 시작할 인덱스
//		3. 복사한 데이터를 저장할 대상 배열
//		4. 대상 배열에서 데이터를 저장할 시작 위치의 인덱스
//		5. 복사할 요소의 개수
		
		for (int i = 0; i < ball3.length; i++) {
			System.out.print(ball3[i]);
		}

		}
	}

