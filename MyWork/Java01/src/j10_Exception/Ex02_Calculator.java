package j10_Exception;

import java.util.Scanner;

//** 실습
//=> 두개의 정수를 입력 받아 4칙연산(+,-,*,/) 결과 출력하기
//=> 입력 정수는 1 ~ 99 까지 허용
//=> nextLine() 으로 입력 받기 -> try~catch 적용하기
//1) 범위를 벗어난 값를 입력하면 정상 값 입력 할때까지 반복
//2) 반복분 이용해서 종료하고 싶을때까지 Test 하기.

//** Scanner 사용시 주의 사항
//=> nextInt() , nextLine() 사용시 주의
// nextInt()는 개행문자 (\n) 가 뒤에 붙고, 숫자만 받아 처리한다. 
// 그래서 nextInt() 만 계속되면 문제가 없는데, 
// 뒤이어서 nextLine() 이 오면 앞 nextInt() 의 
// 남겨진 \n 을 한줄로 인식 받아 버린다.
public class Ex02_Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("숫자 2개를 입력해주세요.");
//				int num1 = Integer.parseInt(sc.nextLine());
//				int num2 = Integer.parseInt(sc.nextLine());
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				
				if(0 < num1 && num1 < 100 && 0 < num2 && num2 < 100) {
					System.out.printf("num1과 num2 = 더하기:%d, 빼기:%d, 나누기:%d, 곱하기%d%n",num1+num2,num1-num2,num1/num2,num1*num2);
					break;
				}else {				
					System.out.println("1~99까지 다시 입력하세요.");
				}
			}catch(Exception e) {
				System.out.println("숫자로만 입력해주세요.");
				sc.nextLine();
			}	
		}	
		sc.close();
	}
}

//package j10_Exception;
//import java.util.Scanner;
//
//public class Ex02_Calculator {
//
//   public static void main(String[] args) {
//      // 1. Scanner 인스턴스, 변수 정의
//      Scanner sc = new Scanner(System.in);
//      int i, j ;
//      
//      // 2. 반복문, try~ catch 적용
//      // => 두개의 정수를 입력 받기
//      // => 입력 받은 정수 범위 확인 ( 1 ~ 99 )
//      //    Yes : 4칙연산(+,-,*,/) 결과 출력하고 종료
//      //    No : 다시 입력받기 반복
//      while(true) {
//         try {
//            System.out.println("** 정수1 을 입력하세요 => ");
//            i=Integer.parseInt(sc.nextLine()); 
//            // => 문자입력시: NumberFormatException
//            //i=sc.nextInt(); 
//            // => InputMismatchException 발생
//            //    주의 -> 입력값중 숫자만 가져가고 남아있는 enter_Key 값 때문에 무한반복됨   
//            
//            if (i<1 || i>99) {
//               System.out.println("** 숫자1 이  범위(1~99) 를 벗어납니다. **");
//               continue; //나머지 문장 실행하지않고 다음 반복문 진행 
//            }
//            System.out.println("** 정수2 를 입력하세요 => ");
//            j=Integer.parseInt(sc.nextLine());
//            if (j<1 || j>99) {
//               System.out.println("** 숫자2 가 범위(1~99) 를 벗어납니다. **");
//               continue;
//            }
//            System.out.println("** Add => "+(i+j));
//            System.out.println("** Min => "+(i-j));
//            System.out.println("** Mul => "+(i*j));
//            System.out.println("** Div => "+(i/j));
//            System.out.println("** 종료하시겠습니까? (Y,y : 종료) =>");
//            // => 대,소 문자 모두가능하도록
//            if (sc.nextLine().toUpperCase().equals("Y")   ) {
//               System.out.println("** Program 종료 **");
//               break;
//            }
//         } catch (NumberFormatException e) {
//            System.out.println("** NumberFormatException => "+e.toString());
//            System.out.println("** 정확하게 숫자만 입력하세요 **");
//         } catch (Exception e) {
//            System.out.println("** Exception => "+e.toString()); 
//         }
//      }//while
//   } //main
//
//} //class
