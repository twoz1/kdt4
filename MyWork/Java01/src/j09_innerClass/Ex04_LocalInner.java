package j09_innerClass;

//** LocalInner Class
//=> 메서드의 내부에 정의되는 InnerClass.
//=> 메서드내에 정의되는 지역변수와 같다 (즉, 메서드내에서만 사용됨)
//=> static Local_InnerClass는 허용 되지 않음
//   단, 상수는 허용

public class Ex04_LocalInner {
   
   int a=100;
   Ex04_LocalInner() { System.out.println("** Ex04_... default 생성자 **"); }
   
   public void innerTest(int n) {
      int b=200;
      final int C=n;
      System.out.printf("** innerTest1 : a=%d, b=%d, C=%d \n", a, b, C);
      
      // ** Local Inner Class 정의
      class Linner{
         int d=400;
         Linner() { System.out.println("** Linner default 생성자 **"); }
         public void printData() {
            System.out.printf("** Linner printData : a=%d, b=%d, C=%d, d=%d \n", a, b, C,d);
         } //printData
      }//Linner
      
      System.out.printf("** innerTest2 : a=%d, b=%d, C=%d \n", a, b, C); //확인용
      // ** Local Inner Class 사용
      // => 메서드 내에서 인스턴스 생성, 접근가능
      Linner li = new Linner();
      li.printData();
      
   } //innerTest

   public static void main(String[] args) {
      // 1) OuterClass 인스턴스 생성
      // => Inner 클래스 생성시점 : 메서드 호출시 메서드내부의 생성문 실행시점에 생성
      Ex04_LocalInner ex04 = new Ex04_LocalInner(); 
      ex04.innerTest(300); 
      // => 메서드 호출 : innerTest1 -> innerTest2 
      //    -> 생성문: Linner() -> printData()

   } //main

} //class