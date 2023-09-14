 package j10_Exception;

// ** Exception
// => Exception 처리하지 않는 경우
//      : Exception 발생 위치에서 비정상 종료

//=> Exception 처리하는 경우
//: Exception 발생 시 대응하여 정상 진행

//** Exception 계층구조 
//=> Object -> Throwable -> Exception, Error, 
//               Exception -> RuntimeException, IOException 

//=> Error: 프로그램 코드에 의해 수습될 수 없는 심각한 오류
//=> Exception
//-> 프로그램 코드에 의해 수습될 수 있는 오류로, 프로그래머가 예외 처리를 할 수 있음
//-> 반드시 예외 처리를 해야하는 Checked Exception과,
//   예외 처리를 하지 않아도 되는 Unchecked Exception으로 나뉜다.
//=> IOException
//-> Checked Exception
//-> 파일 및 입출력 작업에서 발생하는 Exception
//=> RuntimeException
//-> Unchecked Exception
//-> 개발자의 실수로 발생하는 Exception.

//** Exception Test
//=> Exception 처리하지않는 경우
//    -> Exception 발생위치에서 비정상종료 
//=> Exception 처리하는 경우
//   -> Exception 발생시 대응을 하여 정상진행가능 

public class Ex01_Basic {

   public static void main(String[] args) {
      int x = 6, y = 3, result = 0;
      String s = "123000";
      String[] names = { "Apple", "Banana", "Coffee" };

      // Test1) Exception 처리하지 않는 경우
//      y = 0;
      // result = x / y;
      System.out.println("** result1 => " + result);
      // y = 0일 경우 x/y 연산 시, 컴파일 오류는 없음
      // Exception 발생 행에서 해당하는 Exception 객체를 생성해 메세지를 출력하고 비정상 종료
      // Exception in thread "main" java.lang.ArithmeticException: / by zero

      //s = "123AAA";

      // Test1) Exception 처리하는 경우
      try {
         result = x / y;
         System.out.println("** result2 => " + result);
         System.out.println("** result3 => " + (result += Integer.parseInt(s)));
         // s = "123AAA"일 경우 result+=s 연산 시, java.lang.NumberFormatException: For input
         // string: "123AAA"
         System.out.println("** 배열 Test => " + names[-3]);
         // => 배열 크기 음수 지정 :
         names = new String[5];
         System.out.println("** names.length => " + names.length);
         s=null;
         System.out.println("** NullpointerException Test => " + s.length());
      } catch (ArithmeticException e) {
         System.out.println("** ArithmeticException => " + e.toString());
      } catch (NumberFormatException e) {
         System.out.println("** NumberFormatException => " + e.toString());
      } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("** ArrayIndexOutOfBoundsException => " + e.toString());
          // => 인덱스 음수 지정시에도 동일한 Exception 발생
      } catch (NullPointerException e) {
          System.out.println("** NullpointerException => " + e.toString());
      } catch (Exception e) {
         // ** Exception에 다형성 적용
         // => Exception e = new 후손()
         // => 즉, Exception의 모든 후손 Exception들이 현재 catch블럭(catch (Exception e))에 적용됨
         // : ArithmeticException, NumberFormatException...etc
         // => 그러므로 각 Exception별로 처리하는 것도 가능함
         // 이때 조상인 Exception 객체는 제일 마지막에 정의해야함 (순서 중요, 컴파일 오류)
         System.out.println("** Exception => " + e.toString());
      } // catch (ArithmeticException e) {
         // 조상인 Exception 객체보다 전에 정의해야 함
         // }
      finally {
         System.out.println("** finally => 무조건 실행");
      }

      System.out.println("** 정상 종료");

   }

}