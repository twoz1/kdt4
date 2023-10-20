package iocDI03_jc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//** Java Bean Configuration class를 이용한 DI
//=> Test03 : 스피커 2개중 선택 
//=> 생성자 를 이용한 주입.. & JC에서 @, xml 병행사용

//*** JC 와 @ 병행사용
//*** JC , @, xml 병행사용
//=> JC 내에서 xml 로 생성된 객체를 직접 사용하는것은 허용 되지 않음. 
// 단, User 클래스에서는 사용가능

//** 실습
//=> SsTVsi , Speaker 는 xml 로 생성
//=> LgTVsi, AiTVsi 는 JC 의 @Bean 으로 생성
//=> LgTVsi (Speaker 생성자주입) 
// AiTVsi (Speaker @Autowired)
@ImportResource("iocDI03_jc/app10.xml")
@Configuration
public class JavaConfig03 {
	   //1) 고전적 방법 (직접 new : 소스 재컴파일)
	   //=> xml 병행사용 Test (SsTVsi xml 에서 생성)
	   
	   //2) IOC/DI: 생성자 주입
	   // => SpeakerB 를 xml 에서 생성한 후 전딜되는지 확인 : 불가능
	   // => SpeakerB 를 @ 으로 생성한 후 전딜되는지 확인 : 불가능
	   // => 결론 : JC 내에서 생성자 주입하려면 JC 내에서 생성해야됨.
	  @Bean
	   public TV lgtv() {return new LgTVsi(spb(),"Orange",3333000);}
	  @Bean
	   public Speakeri spb() {return new SpeakerB();}
	   //3) IOC/DI: JC 에서 xml 병행 사용
	   //=> SpeakerA, xml 생성 후  @Autowired 로 주입받음
	   //=> 1) AiTVsi : JC 생성 
	  @Bean
	  public TV aitv() {return new AiTVsi();}
	   //   2) AiTVsi : xml 생성
	  
	  
	
}//class
