package iocDI03_jc;
//** Java Bean Configuration class를 이용한 DI
//=> Test04 : 스피커 2개중 선택 
//=> xml 에서 JC 화일 import , @ 병행 사용
//=> JC 에서는 LgTVsi, AiTVsi, SpeakerB 생성

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig04 {
	@Bean
	public TV lgtv() {return new LgTVsi(new SpeakerB(),"Black",4565444);}
	@Bean
	public TV aitv() {return new AiTVsi();}
}
