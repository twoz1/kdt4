package iocDI02_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;

//** TV 의 의존성 처리
//=> TV 는 여러개의 Speaker 를 사용할 수 있음 
//=> Speaker interface 적용 
//=> @Autowired 자동주입

//=> 여러개 중 선택 : 명시적 자동주입 
//	@Autowired , @Qualifier("spa")

//** Test1) : spa, spb 생성후 @Autowired 만 한 경우 
// => 선택 가능한 인스턴스가 여러개인 경우 
//...UnsatisfiedDependencyException: Error creating bean with name 'tva': Unsatisfied 
//....matching bean but found 2: spa,spb

//** Test2) : spa 만 생성후 @Autowired 만 한 경우 
//=> Type 일치하는 경우가 1개이기 때문에 정상 실행

//** Test3) @Qualifier("spa") : 명시적으로 요청 했지만 "spa"가 없는 경우
//=> 정확하게 id가 일치하는 객체를 찾으므로 오류 발생  

//=> xml, @ 병행 가능
//	Speaker 의 생성은 xml 에 <bean ..> 등록후 Test

interface Speakeri {
	void volumeUp();
	void volumeDown();
} //Speakeri

//=> xml 과 병행 가능 : xml 에 bean 설정 Test 
@Component("spa")
class SpeakerA implements Speakeri {
	public SpeakerA() { System.out.println("~~ SpeakerAAA Default 생성자 ~~"); }
	@Override
	public void volumeUp() { System.out.println("~~ SpeakerAAA volumeUp ~~"); } 
	@Override
	public void volumeDown() { System.out.println("~~ SpeakerAAA volumeDown ~~"); }
} //SpeakerA

@Component("spb")
class SpeakerB implements Speakeri {
	public SpeakerB() { System.out.println("~~ SpeakerBBB Default 생성자 ~~"); }
	@Override
	public void volumeUp() { System.out.println("~~ SpeakerBBB volumeUp ~~"); } 
	@Override
	public void volumeDown() { System.out.println("~~ SpeakerBBB volumeDown ~~"); }
} //SpeakerA

//1) 고전적 방법 (직접 new : 소스 재컴파일)
//=> SpeakerA, B 교체 : 직접코드에서\
@Component("sstv")
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
//=> SpeakerA, B 교체 : @Autowired, @Qualifier("spa") 
@Component("lgtv")
class LgTVsi implements TV {
	
	@Autowired(required = false)
	// => 해당 Type의 인스턴스를 찾지 못하면 null return
	@Qualifier("spb")
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

//3) IOC/DI
// => xml과 병행 Test

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

public class TVUser07_Anno03 {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너 생성
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("iocDI02_anno/app05.xml");
		
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
