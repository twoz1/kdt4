package iocDI03_jc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

//** Java Bean Configuration class를 이용한 DI
//=> Bean 컨테이너 : AnnotationConfigApplicationContext 사용
//=> Test03 : 스피커 2개 중 선택

//** JC 와 @ , xml 병행 처리 Test
//=> 생성자 를 이용한 주입.. & JC에서 @, xml 병행사용

//** xml 에서 JC 사용  Test ( TVUser11 에서 )
//=> 1) SpeakerA xml 에서 생성후 AiTVsi 에서 @Autowired
//=> 2) @ 으로 생성후  AiTVsi 에서 @Autowired

interface Speakeri {
	void volumeUp();
	void volumeDown();
} //Speakeri

//=> JC 생성 : aiTVsi 에서 @Autowired Test
class SpeakerA implements Speakeri {
	public SpeakerA() { System.out.println("~~ SpeakerAAA Default 생성자 ~~"); }
	@Override
	public void volumeUp() { System.out.println("~~ SpeakerAAA volumeUp ~~"); } 
	@Override
	public void volumeDown() { System.out.println("~~ SpeakerAAA volumeDown ~~"); }
} //SpeakerA

//=> @, xml 생성 모두 Test : JC 로는 전달안됨
//@Component("spb")
class SpeakerB implements Speakeri {
	public SpeakerB() { System.out.println("~~ SpeakerBBB Default 생성자 ~~"); }
	@Override
	public void volumeUp() { System.out.println("~~ SpeakerBBB volumeUp ~~"); } 
	@Override
	public void volumeDown() { System.out.println("~~ SpeakerBBB volumeDown ~~"); }
} //SpeakerA

//1) 고전적 방법 (직접 new : 소스 재컴파일)
//=> SpeakerA, B 교체 : 직접코드에서
class SsTVsi implements TV {
	
	private Speakeri speaker = new SpeakerA();
	
	public SsTVsi() { System.out.println("~~ SsTVsi Default 생성자 ~~"); }
	
	@Override
	public void powerOn() { System.out.println("~~ SsTVsi powerOn ~~"); }
	@Override
	public void powerOff() { System.out.println("~~ SsTVsi powerOff ~~"); }
	@Override
	public void volumeDown() { speaker.volumeDown(); }
	@Override
	public void volumeUp() { speaker.volumeUp(); }
} //SsTVs

//2) IOC/DI 
//=> SpeakerA, B 교체 : 생성자주입
class LgTVsi implements TV {
	
	private Speakeri speaker;
	
	private String color;
	private int price;
	
	public LgTVsi() { System.out.println("~~ LgTVsi Default 생성자 ~~"); }
	
	public LgTVsi(Speakeri speaker, String color, int price) { 
		this.speaker=speaker;
		this.color=color;
		this.price=price;
		System.out.printf("~~ LgTVsi 초기화 생성자 : color=%s, price=%d \n",color,price); 
	}
	
	@Override
	public void powerOn() { System.out.println("~~ LgTVsi powerOn ~~"); }
	@Override
	public void powerOff() { System.out.println("~~ LgTVsi powerOff ~~"); }
	@Override
	public void volumeDown() { speaker.volumeDown(); }
	@Override
	public void volumeUp() { speaker.volumeUp(); }
} //LgTVs

//3) IOC/DI: JC 와 @ Test
//=> TV, SpeakerA 는 JC 에서 생성하고
//	 @Autowired 로 주입 받음
//@Component("aitv")
class AiTVsi implements TV {
	
	@Autowired(required = false)
	@Qualifier("spa")
	private Speakeri speaker;
	
	private String color;
	private int price;
	
	public AiTVsi() { System.out.println("~~ AiTVsi Default 생성자 ~~"); }
	
	public void setSpeaker(Speakeri speaker) { this.speaker=speaker; }
	public void setColor(String color) { this.color=color; }
	public void setPrice(int price) { this.price=price; }
	
	@Override
	public void powerOn() { System.out.printf("~~ AiTVsi powerOn : color=%s, price=%d \n",color,price); }
	@Override
	public void powerOff() { System.out.println("~~ AiTVsi powerOff ~~"); }
	@Override
	public void volumeDown() { speaker.volumeDown(); }
	@Override
	public void volumeUp() { speaker.volumeUp(); }
} //AiTVs

public class TVUser10_JC03 {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너 생성
		AbstractApplicationContext sc = new 
				AnnotationConfigApplicationContext(JavaConfig03.class);
		
		// 2. 필요한 객체를 전달받고 서비스 실행 
		System.out.println("\n** 1) 고전적 방법 (직접 new : 소스 재컴파일) **");
		TV sstv = (TV)sc.getBean("sstv");
		sstv.powerOn();
		sstv.volumeDown();
		sstv.volumeUp();
		sstv.powerOff();
		 
		System.out.println("\n** 2) IOC/DI -> 생성자 주입 **");
		TV lgtv = (TV)sc.getBean("lgtv");
		lgtv.powerOn();
		lgtv.volumeDown();
		lgtv.volumeUp();
		lgtv.powerOff();
		
		System.out.println("\n** 3) IOC/DI -> setter 주입 **");
		TV aitv = (TV)sc.getBean("aitv");
		aitv.powerOn();
		aitv.volumeDown();
		aitv.volumeUp();
		aitv.powerOff();	 
		
		System.out.println("** Program 정상종료 **");
		sc.close();

	} //main
} //class
