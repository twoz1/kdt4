package iocDI01_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//** 스프링이 제공하는 BeanFactory
//=> 스프링 컨테이너
//=> AbstractApplicationContext 와 GenericXmlApplicationContext 계층도 
//=> Object -> DefaultResourceLoader (C) -> AbstractApplicationContext (A) 
//         -> GenericApplicationContext (C) -> GenericXmlApplicationContext (C) 

//public abstract class AbstractApplicationContext extends DefaultResourceLoader
//      implements ConfigurableApplicationContext, DisposableBean {....

//public class GenericXmlApplicationContext extends GenericApplicationContext {...

//=> 컨테이너는 xml (설정화일), @, JavaCode (JavaConfig) 등의 
// 전달사항을 통해 요구하는 클래스를 생성, 보관, 제공

//** xml (설정화일)

public class TVUser02 {

   public static void main(String[] args) {
      // 1. 콩공장(BeanFactory, 스프링 컨테이너) 생성
      AbstractApplicationContext sc = new 
            GenericXmlApplicationContext("iocDI01_xml/app02.xml");
      // => 설정화일(xml구문_요구사항 목록) 을 매개변수로 전달
      // => GenericXmlApplicationContext("app02.xml");
      //    xml 문을 "src/main/resources"  에 두면 패키지는 생략가능 
      
      // 2. 필요한 객체를 전달받고 서비스 실행 
      // => 필요한 객체를 설정화일(app02.xml) 을 이용해서 Spring 컨테이너 에게 요청 
      
      // => Spring 컨테이너는 getBean 메서드를 실행해서 해당객체를 제공
      // => 실시간으로 소스코드 수정없이 전달받음 
      TV tv = (TV)sc.getBean("mytv");
      if ( tv!=null ) {
         tv.powerOn();
         tv.volumeDown();
         tv.volumeUp();
         tv.powerOff();
      }else {
         System.out.println("** TV 를 선택하지 않았습니다. **");
      }
      // 3. singleton(싱글톤) Test
      // => 스프링 프레임웤의 모든 작업은 싱글톤을 기본으로함.
      // => 싱글톤 (한개의 인스턴스만 허용 하는것) 적용 Test
      // => 설정화일의 scope 속성 에 "prototype"_ss / "singleton"_lg (default 는 싱글톤)
      // => 생성자 실행횟수와 아래의 주소값 확인해보기
      //    SsTVi 2개, LgTVi 2개 씩 인스턴스 작성 후 확인    
      System.out.println("** singleton(싱글톤) Test **");
      TV tvs1 = (TV)sc.getBean("mytv"); // ss :prototype (다른주소)
      TV tvs2 = (TV)sc.getBean("mytv");
      
      TV tvl1 = (TV)sc.getBean("lg");   // lg : singleton (같은주소)
      TV tvl2 = (TV)sc.getBean("lg");
      
      // => 인스턴스 출력 비교
      System.out.println("** tv_ss => "+tv);   // ss :prototype (다른주소)
      System.out.println("** tvs1_ss => "+tvs1);
      System.out.println("** tvs2_ss => "+tvs2);
      
      System.out.println("** tvl_lg => "+tvl1); // lg : singleton (같은주소)
      System.out.println("** tvl_lg => "+tvl2); 
      sc.close();

   } //main
} //class