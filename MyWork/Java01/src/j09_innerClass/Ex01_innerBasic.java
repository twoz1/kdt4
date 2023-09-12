package j09_innerClass;

import j07_classExtends.Ex01_Car;
//import j09_innerClass.OuterClass.Inner;

//** 클래스 맴버
//=> 맴버(전역) 변수 : 선언문, 초기화블럭 
//=> 메서드 : 생성자, main, setter/getter, toString, 일반메서드
//=> 초기화블럭 : {   }  / static {   }
//=> 내부(inner) 클래스 : 클래스 내부에 다른 클래스를 정의

//** Inner Class 기본형식과 특성
class OuterClass{
   // 1) 맴버(전역) 변수
   int age =100;
   private String name="홍길동";
   static String grade="A++";
   
   // => 맴버변수로 클래스를 정의
   // => has-a 관계 : 재사용성이 많은경우
   //    inner 클래스와 비교 : 현재클래스에서만 필요한 경우           
   //    (단, inner 클래스가 외부에서 접근 불가능한 맴버는 아님)
   Ex01_Car car;
   
   // 2) 생성자 및 메서드들
   OuterClass() { System.out.println("** OuterClass default 생성자 **"); }
   
   // 3) 내부(inner) 클래스
   // => 일반적인 클래스의 특징을 모두 가짐
   // => 외부클래스의 모든(private 포함) 맴버 접근가능
   
   
   // ** static Inner Test
   // => static 맴버 추가
   //    내부 클래스가 static 변수를 사용하려면, 해당 내부 클래스도 static 이어야함.
   //    -> static 내부 클래스
   // => 단, JavaSE-16 부터는 일반내부 클래스도 static 변수 허용함.
   //class Inner { -> ver01
   static class Inner {
      String country="Korea";
      static String company="Green";
      
      Inner() { 
    	  
       System.out.println("** Inner default 생성자 **"); }
      
      // => static Inner 클래스인경우
      //    static 방법으로 접근 가능하도록 작성
      //    Outer 의 non_static 멤버 접근시 인스턴스 필요함
      // => ver02 static 해결1) Outer 의 인스턴스를 매개변수로 전달
       public void printData(OuterClass out) {
         System.out.printf("** Inner_printData: age = %d, p_name = %s, s_grade = %s, country = %s \n"
                     , out.age, out.name, grade, country);
      }
      // => ver02 static 해결2) static 메서드로 작성
      //    ->Outer, Inner의 모든 non_static 멤버 접근시 인스턴스가 필요함
      //    ->Inner 클래스의 non_static 변수인 country 접근 어려움
      //public static void printData2(OuterClass out) {
      //   System.out.printf("** Inner_printData: age=%d, p_name=%s, s_grade=%s, country=%s \n"
      //               , out.age, out.name, grade, country);
      //}
      
      
      // => ver01: non_static Inner 인 경우
      //public void printData() {
      //   System.out.printf("** Inner_printData: age=%d, p_name=%s, s_grade=%s, country=%s \n"
      //               , age, name, grade, country);
      //}
   } //Inner
   
} //Outer

//======================================
public class Ex01_innerBasic {

   public static void main(String[] args) {
      // ** 생성
      // 1) Outer 만 생성
      // => Outer 의 맴버만 접근가능
      OuterClass out1 = new OuterClass();
      out1.age=123;
      // => Class Type 맴버변수 car 초기화 및 사용
      out1.car = new Ex01_Car(500, 500, "Brown"); 
      System.out.printf("** main: age=%d, s_grade=%s car_Color=%s \n"
            , out1.age, OuterClass.grade, out1.car.color);
      System.out.println("** main out1.car => "+out1.car);
      
      // 2) Inner 사용
      // => 생성
      // => import 확인
      //    import j09_innerClass.OuterClass.Inner; 
      //      -> Type 정의시에 Inner 단독사용가능
      // => ver01: non_static Inner 인 경우
      //    Outer 의 static, non_static, private 등 모든맴버 에 접근 가능
      //OuterClass.Inner in1 =  out1.new Inner();
      //in1.country="대한민국";
      //in1.printData();
      
      // => 직접생성
      //OuterClass.Inner in2 =  new OuterClass().new Inner();
      //in2.printData();
      
      // 3) static Test
      // ** ver02 static Inner
      // => static 맴버중 하나임
      
      // 3.1) static Inner 의 static 맴버접근
      //     -> Inner 클래스 인스턴스는 필요 없지만, Outer 클래스를 통해 접근  
      //       ( 단, import 하면 OuterClass.없이 Inner 단독으로 사용가능 )
      System.out.printf("** main s_grade = %s, company = %s \n"
            , OuterClass.grade, OuterClass.Inner.company);
      
      // 3.2) static Inner 의 non_static 맴버접근
      //     -> Inner 의 non_static printData 메서드 호출
      //     -> static Inner 클래스의 인스턴스가 필요함
      
      OuterClass.Inner in1 = new OuterClass.Inner(); //( 단, import 하면 OuterClass.없이 Inner 단독으로 사용가능 )
      in1.printData(new OuterClass()); // 또는 in1.printData(out1); 
      
   } //main

} //class