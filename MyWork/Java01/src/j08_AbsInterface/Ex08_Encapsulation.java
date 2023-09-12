package j08_AbsInterface;

//** 캡슐화(Encapsulation)
//1. 은닉 (보호) : 접근 제어자를 이용
//=> 외부로부터 데이터를 보호하고,
// 내부적으로만 사용되는 부분은 감추어 준다 
//=> 접근 제어자 : private(해당클래스) < default(같은 패키지) <  protected(같은패키지 + 상속받은 클래스) < public (프로젝트)

//2. 단위 기능 모듈화
//=> 세분화 되어있는 모듈을 하나의 기능으로 처리할 수 있도록 묶어준다.
//=> 종합 감기약 처럼 
//=> 세분화 되어있는 모듈을 사용하면서 호출 순서에 따른 오류 등
// 발생가능한 논리적 오류를 예방하고, 생산성 및 유지보수 에 유리

//** 실습
//=> 감기 증상 : 두통, 콧물, 몸살
class HeadacheCap {
   void take() { System.out.println(" 두통 해결 ~~"); }
} // HeadacheCap
class SinivelCap {
   void take() { System.out.println(" 콧물 해결 ~~"); }
} // SinivelCap
class BodyPainCap {
   void take() { System.out.println(" 몸살 해결 ~~"); }
} // BodyPainCap

//** 환자발생1. BadCase Encapsulation
//=> 증상별 복용순서에 따라 복용
//=> 세분화 되어있는 모듈을 직접 사용하는 경우
class ColdPatient {
   void takeHead(HeadacheCap hcap) { hcap.take(); }
   void takeSinivel(SinivelCap scap) { scap.take(); }
   void takeBody(BodyPainCap bcap) { bcap.take(); }
}

//환자2. GoodCase Encapsulation
class TotalCap{
   // => 인스턴스를 멤버변수로 정의
   HeadacheCap hcap = new HeadacheCap();
   SinivelCap scap = new SinivelCap();
   BodyPainCap bcap = new BodyPainCap();
   
   // => 복용순서대로 작성해놓음
   void take() {
      hcap.take();
      scap.take();
      bcap.take();
   } //take
} //TotapCap

class NewPatient{
   void takeTotal(TotalCap tcap) { tcap.take(); }
}

public class Ex08_Encapsulation {

   public static void main(String[] args) {
      //** 환자발생1. BadCase Encapsulation
      //캡슐화 전
      //=> 인스턴스 생성, 메서드 호출
      //=> 단점: 메서드 호출 순서의 오류가 일어날 수 있음
      //        ex) 논리적 호출 순서가 Head -> Sinivel -> BodyPain로
      //        정해져 있었는 기능이라면 실행 시 논리적 오류 발생 가능성 높음
      //=> 컴파일 오류(눈으로 확인가능) -> 런타임 오류(실행시 확인가능) -> 논리적 오류(Local Error, 확인어려움-결과가 이상하게 나옴)
      ColdPatient cp = new ColdPatient();
      cp.takeBody(new BodyPainCap());
      cp.takeHead(new HeadacheCap());
      cp.takeSinivel(new SinivelCap());
      
      //** 환자발생2. GoodCase Encapsulation
      NewPatient np = new NewPatient();
      np.takeTotal(new TotalCap());
      
   }

}