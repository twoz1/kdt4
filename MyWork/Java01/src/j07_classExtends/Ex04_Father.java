package j07_classExtends;

import j06_packageTest.Ex01_carTest;
import static j07_classExtends.Animal.color;

import java.util.Arrays;

//** static, final 과 상속, main 메서드 정리

//** static import
//=> static 맴버 호출시 클래스명 생략가능
//   Animal.color  선언 전/후 비교

//** main 메서드
//=> JVM 이 클래스를 실행시키는 기본 메서드
//   그러므로 public static void 여야만 하고.
//   메서드명 main, 인자값도 변경되면 실행되지 않음. 
//-> Error: Main method not found in class j07_classExtends.Ex04_Father.....

//=> 매개변수는 필요시 사용가능 함. (사용 Test)
//=> main 메서드 오버로딩 Test
//   허용은 되지만 사용이 바람직하지는 않음


public class Ex04_Father {
   
   // ** import Test
   //j06_packageTest.Ex01_CarTest car; // import 하지않는 경우
   Ex01_carTest car; // import 하는 경우 -> 포함(has_a)
   
   // ** static import 비교 Test
   //static String color ="myRed"; 
   // => 추가하기 전/후 비교 ( Animal.color / color )
   
   // ** 모든 자식 인스턴스가 공유하는값은 static 으로 정의
   // => static 적용전/후 Child 인스턴스생성시 비교해본다. 
   static String name;
   //private static int money;
   private int money;
   // => 변수에 final : 상수 
   static final String COUNTRY="Korea";
   
   Ex04_Father() { System.out.println("** Father default 생성자 **"); }
   public Ex04_Father(String name, int money) {
      Ex04_Father.name=name;
      this.money=money;
      System.out.println("** Father 초기화 생성자 **");
   }
   // => 오버라이딩금지 : final
   public void bank(int money) {
      this.money += money;
      System.out.printf("** Father bank total_money=%d, today_money=%d \n"
            , this.money, money);
   }
   
   public void info() {
      System.out.printf("** Father name=%s, money=%d \n", name, money);
   }
   
   // => main 메서드 오버로딩 Test
   public static void main(String name) {
	   System.out.println("**main 오버로딩 Test name => " +name);
   }

   public static void main(String[] args) {
	   
	   // ** main의 매개변수 args 사용
	   // 실행시 전달됨 : 하하하 호호호 짜장면 짬뽕 111 222(스페이스로 구별)
	   System.out.println("** main 인자 Test => " +Arrays.toString(args));
	   // ** main 메서드 오버로딩 Test
	   main("홍길동"); //홍길동 잘 나옴 오버로딩 상관 없어유
	   
	   
      Ex04_Father f1 = new Ex04_Father("홍길동",10000);
      f1.bank(5000);
      f1.info();
      
      Ex04_Father f2 = new Ex04_Father("김길동",1000);
      f2.bank(-10000);
      f2.info();
      
      // ** static import Test
      System.out.println("** static import 사용전 => "+Animal.color);
      System.out.println("** static import 사용후 => "+color); 
      // => 이름이 동일하면 현재클래스에 정의된 변수 우선
      
   } //main

} //class