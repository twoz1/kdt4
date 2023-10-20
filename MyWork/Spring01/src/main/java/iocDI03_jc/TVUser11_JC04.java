package iocDI03_jc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//** Java Bean Configuration class를 이용한 DI
//=> Test04 : xml 을 이용해서 JC, @ 병행 처리 Test
//			  그러므로 Bean 컨테이너는 GenericXmlApplicationContext 사용
//=> 스피커 2개 중 선택

public class TVUser11_JC04 {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너 구동(생성)
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("iocDI03_jc/app11.xml");
		
		// 2. 필요한 객체를 전달받고 서비스 실행
		System.out.println("\n** Test1. 고전적 방법 (직접 new) **");
		TV tvs = (TV)sc.getBean("sstv");
		tvs.powerOn();
		tvs.volumeUp();
		tvs.volumeDown();
		tvs.powerOff();
		
		System.out.println("\n** Test2. IOC/DI -> 생성자 주입 **");
		TV tvl = (TV)sc.getBean("lgtv");
		tvl.powerOn();
		tvl.volumeUp();
		tvl.volumeDown();
		tvl.powerOff();
		
		System.out.println("\n** Test3. IOC/DI -> @Autowired **");
		TV tva = (TV)sc.getBean("aitv");
		tva.powerOn();
		tva.volumeUp();
		tva.volumeDown();
		tva.powerOff();

		System.out.println("** Program 종료 **");
		sc.close();
	} //main

} //class
