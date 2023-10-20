package iocDI03_jc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//** Java Bean Configuration class를 이용한 DI
//=> Test02 : 스피커 1개 사용 TV 
// -> 생성자를 이용한 주입,
// -> JC에서 xml 병행사용

//** JC 에서 xml 병행 사용하기 
//=> @ImportResource("iocDI03_jc/app09.xml")
//=> AiTVs 생성은 xml 로 

@ImportResource("iocDI03_jc/app09.xml")
@Configuration
public class JavaConfig02 {
   // 1) 고전적 방법 (직접 new : 소스 재컴파일)
   @Bean 
   // 컨테이너에 의해 메서드 실행되고 인스턴스가 컨테이너로 return 됨
   public TV sstv() { return new SsTVs();}
   
   
   // 2) IOC/DI : 생성자 주입
   // public TV lgtv() { return new LgTVs(new Speaker(), "Pink", 9988000); }
   
   // => speaker 생성 후 사용
   @Bean
   public TV lgtv() { return new LgTVs(sp(), "Pink", 9988000); }
   @Bean
   public Speaker sp() {return new Speaker();}
   // => @Bean 는 해당 인스턴스를 컨테이너로 전달해야할 필요가 있는 경우사용
   //    있을때와 없을때 아래 AiTVs 에 sp 인스턴스가 전달되는지 비교해본다. 
   //   -> 없을때: ...BeanCreationException: Error creating bean with name 'tva' .....
   //            ....NoSuchBeanDefinitionException: No bean named 'sp' available

   // 3) IOC/DI : JC에서 xml 병행사용
   // => AiTVs xml 로 생성 : JC 파일의 sp 인스턴스가 전달되는지 확인
   
   
   
   
}