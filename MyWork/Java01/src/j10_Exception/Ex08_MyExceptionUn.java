package j10_Exception;

import java.util.Scanner;

// ** AgeException 1 : UnChecked
// => 즉, 컴파일러가 예외처리(try~catch~)를 확인하지 않음
// => RuntimeException 을 상속
// => 주로 프로그래머의 실수로 발생 가능한 오류들
// => 나이의 값이 범위를 벗어나면 Exception 발생
class AgeException extends RuntimeException {
   private static final long serialVersionUID = 1L;
   
   AgeException() { super("나이값이 범위를 벗어남"); }
   AgeException(String message) { super(message); }
} //AgeException

//** AgeException 2 : Checked
//=> 예외처리를 강제함 -> try ~ catch 처리하지 않으면 컴파일 오류 발생 
//=> Exception 을 상속
class AgeExceptionCk extends Exception {
   private static final long serialVersionUID = 1L;
   
   AgeExceptionCk() { super("Age_Error_Checked"); }
   AgeExceptionCk(String message) { super(message); }
} //AgeExceptionCk

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Ex08_MyExceptionUn {
   
   // ** 나이 입력받아 return 하는 메서드 만들기
   static Scanner sc = new Scanner(System.in);
   
   // 1) UnChecked Exception
   // => 예외처리코드를 컴파일시에 확인하지않음
   public static int readAge() {
      System.out.println("** 나이를 입력 하세요 => ");
      //int age=sc.nextInt(); //문자입력시 -> InputMismatchException
      int age=Integer.parseInt(sc.nextLine()); //문자입력시 -> NumberFormatException
      
      if (age<1 || age>200) throw new AgeException();
      else return age;
   }
   
   // 2) Checked Exception
   public static int readAgeCk() throws AgeExceptionCk {
      System.out.println("** 나이를 입력 하세요 => ");
      int age=Integer.parseInt(sc.nextLine());  
      
      if (age<1 || age>200) throw new AgeExceptionCk();
      else return age;
   }

   public static void main(String[] args) {
      // Test1) UnChecked Test
      // => 예외처리코드를 컴파일시에 확인하지않음
      //    그러나 런타임시에 오류가 발생하면 비정상종료함.
      //System.out.println("** main Test1) age1 ="+ readAge());
      
      // Test2) Checked Test
      // => 예외처리코드를 컴파일시에 확인함.
      //    그러므로 반드시 작성해야함 (아니면 main 도 throws 할수있음)
      //System.out.println("** main Test2) ageCk ="+ readAgeCk());
      
      // => 예외처리적용
      try {
         System.out.println("** main Test1) age2 ="+ readAge());
         System.out.println("** main Test2) ageCk ="+ readAgeCk());
      } catch (AgeExceptionCk e) {
         System.out.println("** main AgeExceptionCk => "+e.toString());
      } catch (Exception e) {
         System.out.println("** main Exception => "+e.toString());
      }
      sc.close();
      System.out.println("** Program 정상종료 **");
   } //main

} //class