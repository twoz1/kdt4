package j05_classMethod;

/* ** static, instance(non_static) 비교
 * static (클래스종속)
 * => static 키워드를 붙이게 되면, 변수 또는 메서드가, 해당 클래스 수준에 속하게 됨.
 * => static 변수는 해당 클래스 수준에서 전역변수와 유사하게 동작하게 됨
 * => 클래스 로드 시 한번 할당되고, 모든 인스턴스가 static 변수를 공유하게 됨.
 * 
 * instance(non_static, 인스턴스종속)
 * => 따로 키워드를 붙이지 않고 사용하면 instance로 사용하게 되고, 객체 또는 인스턴스 수준에 속하게 됨.
 * => instance 변수는 객체 또는 인스턴스 수준에서 지역 변수(인스턴스에 종속적)로 동작함
 * => 각 인스턴스가 고유한 값을 가지므로, 한 인스턴스에서 변경해도 다른 인스턴스에 영향 주지 않음.
 * 
 * ** 호출규칙
 * => static 메서드: static 만, 인스턴스없이 호출가능 
 * => instance 메서드: static, instance(non_static) 모두 인스턴스없이 호출가능 
 */

// ** 4칙연산 계산기 

public class Ex05_static {
   // 1) 맴버변수 정의
   int result;
   int itotal;
   static int total;
   
   // 2) 맴버 메서드 정의
   // => static
   public static int add(int i, int j, Ex05_static ex00) {  
      //result=i+j; -> 인스턴스 없이 접근불가
      total += (i+j); // static 메서드에서 static 은 인스턴스 없이 접근 가능
      
      // static 메서드에서 인스턴스 추가
      // => static 메서드에서 인스턴스는 인스턴스 있어야  접근 가능 
      ex00.itotal += (i+j);   
      
      return i+j;
   }
   public static int min(int i, int j, Ex05_static ex00) {
      total += (i-j);
      ex00.itotal += (i-j);  // 추가해보기 연습
      return i-j;
   }
   
   // => instance
   // => static, instance(non_static) 모두 인스턴스없이 호출가능 
   public int mul(int i, int j) {
      result=i*j;
      total += result;
      itotal += result; // 추가해보기 연습
      return result;
   }
   public int div(int i, int j) {
      result=i/j;
      total += result;
      itotal += result; // 추가해보기 연습
      return result;
   }
   
   // ** static : 모든 메서드 call
   // => 인스턴스 맴버에 접근하기 위해서는 인스턴스가 필요
   public static void staticAll(int i, int j, Ex05_static ex00) {
      System.out.println("** staticAll add => "+add(i,j, ex00));
      System.out.println("** staticAll min => "+min(i,j, ex00));
      System.out.println("** staticAll mul => "+ex00.mul(i,j));
      System.out.println("** staticAll div => "+ex00.div(i,j));
      System.out.println("** staticAll total => "+total);
      System.out.println("** staticAll itotal => "+ex00.itotal);
      System.out.println("** staticAll result => "+ex00.result);
   }
   
   // ** instance : 모든 메서드 call
   public void instanceAll(int i, int j, Ex05_static ex00) {
      System.out.println("** instanceAll add => "+add(i,j, ex00));
      System.out.println("** instanceAll min => "+min(i,j, ex00));
      System.out.println("** instanceAll mul => "+mul(i,j));
      System.out.println("** instanceAll div => "+div(i,j));
      System.out.println("** instanceAll total => "+total);
      System.out.println("** instanceAll itotal => "+itotal);
      System.out.println("** instanceAll result => "+result);
   }
   
   // ** static, instance(non_static) 모두 call
   // => 인스턴스 맴버에 접근하기 위해서는 인스턴스가 필요
   public static void main(String[] args) {
      
      // ** instance 2개 생성 후 비교
      // 1) ex05 생성
      Ex05_static ex05 = new Ex05_static();
      
      // 1.1) static call
      System.out.println("** add => "+add(10,3, ex05));
      System.out.println("** mul => "+min(10,3, ex05));
      // 1.2) instance(non_static) call
      System.out.println("** mul => "+ex05.mul(10, 3));
      System.out.println("** div => "+ex05.div(10, 3));
      
      System.out.println("** main total => "+total);
      System.out.println("** main itotal => "+ex05.itotal);
      // 1.3) staticAll 호출
      System.out.println("** 3) staticAll 호출 **");
      staticAll(30, 3, ex05);
      // 1.4) instanceAll 호출
      System.out.println("** 4) instanceAll 호출 **");
      ex05.instanceAll(40, 4, ex05);
      
      // 2) instance 추가
      System.out.println("** 2) instance 추가 **");
      Ex05_static ex055 = new Ex05_static();
      
      // 2.1) static call
      System.out.println("** add2 => "+add(10,3, ex055));
      System.out.println("** mul2 => "+min(10,3, ex055));
      // 2.2) instance(non_static) call
      System.out.println("** mul2 => "+ex055.mul(10, 3));
      System.out.println("** div2 => "+ex055.div(10, 3));
      
      System.out.println("** main2 total => "+total);
      System.out.println("** main2 itotal => "+ex055.itotal);
      // 2.3) staticAll 호출
      System.out.println("** 2.3) staticAll 호출 **");
      staticAll(30, 3, ex055);
      // 2.4) instanceAll 호출
      System.out.println("** 2.4) instanceAll 호출 **");
      ex05.instanceAll(40, 4, ex055);
      

   } //main

} //class