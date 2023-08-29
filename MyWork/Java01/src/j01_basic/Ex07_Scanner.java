package j01_basic;

import java.util.Scanner;

// ** Console 입력 Scanner

public class Ex07_Scanner {

   public static void main(String[] args) {
      //1. Scanner 정의(생성)
      Scanner sc = new Scanner(System.in); 
      // 비교: String name="홍길동";
      
      //2. 입력받기
      System.out.println("** 이름을 입력 하세요 =>");
      String name = sc.nextLine();
      // 입력완료(Enter_Key) 까지 대기, 입력완료된 값을 return
      System.out.println("** 나이를 입력 하세요 =>");
      // int age = sc.nextInt(); 
      // => 정상실행 : 입력된 Enter_Key 값은 두고 숫자값만 가져감 
      //    그러므로 nextLine() 을 주로 사용함.
      // => 다른 타입 입력시: java.util.InputMismatchException
      
      int age = Integer.parseInt(sc.nextLine());
      // => 다른 타입 입력시: java.lang.NumberFormatException: For input string: "apple"
      
      System.out.println("** Point 를 입력 하세요 =>");
      //double point = sc.nextDouble();
      // => 정상실행 : 입력된 Enter_Key 값은 두고 숫자값만 가져감 
      double point = Double.parseDouble(sc.nextLine());
      
      System.out.println("** 메뉴를 입력 하세요 =>");
      String menu = sc.nextLine();
      // => 위에서 남겨진 Enter_Key 값을 인식해서 입력된것으로 취급하고
      //    입력값을 기다리지 않고 진행됨
      
      //3. 출력하기
      System.out.println("** 이름: "+name);
      System.out.println("** Age: "+age);
      System.out.println("** Point: "+point);
      System.out.println("** Menu: "+menu);
      
      sc.close();

   } //main
} //class