package j14_Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import j07_classExtends.Ex01_Car;

//ArrayList (ppt 18, 19 ~)

//** ArrayList<E> 의 저장용량  
// => 데이터가 증가하면 메서드 호출하지 않아도 저장용량은 자동증가 함
// => 필요시엔 미리 설정가능
//1) 생성자 
// => 초기값 지정 가능 :  new ArrayList<>(100) ;
//2) 메서드 이용
// => public void ensureCapacity(int minCapacity) : ArrayList 에 정의

//** 계층도
//=> Collection(i) -> List(i) -> LinkedList , ArrayList

public class Ex01_ArrayList {

	public static void main(String[] args) {
		// 1. 정의
		// => Generic Type 을 지정하지않으면 default 는 Object Type
		ArrayList list = new ArrayList();
		//List list = new ArrayList();
		
		list.add("홍길동");
		list.add(123);
		list.add(456);
		list.add('C');
		list.add(123.456f);
		list.add(new Integer(500));
		
		// => size 와 용량 비교
		//    리스트의 현 요소의 수,
		//    용량은 리스트 잠재적으로 그 내부구조를 재 할당 없이 수용 가능한 요소의 수
		System.out.println("list.size() 1 => " + list.size());
		list.ensureCapacity(20);; // ArrayList 에 정
		System.out.println("list.size() 2 => " + list.size());
		
		
		// 2. 사용
		// => get, set(수정), remove
		int sum = (int)list.get(1) + (int)list.get(2);
		list.set(0, sum); // 수정 : 홍길동 -> sum 의 값으로 수정됨
		list.add(1,sum);  // 추가 (끼워넣기)
		list.remove(5);   
		
		// => 출력
		for(Object o : list) {
			System.out.println(o);
		}
		
		//ArrayList<Ex01_Car> list2 = new ArrayList<Ex01_Car>();
		List<Ex01_Car> list2 = new ArrayList<Ex01_Car>();
		list2.add(new Ex01_Car(100, 500, "Red"));
		list2.add(new Ex01_Car(200, 500, "Blue"));
		list2.add(new Ex01_Car(300, 500, "Green"));
		for (Ex01_Car o : list2) {
			System.out.println(o);
		}
		
		// => Car 의 color 만 출력하기
		for (Ex01_Car o : list2) {
			System.out.println(o.color);
		}
		
		// => list2 에서 첫 번째 자료의 color 출력 
		System.out.println("메롱"+list2.get(0).color);
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println("얄루"+list2.get(i));
		}
		
		// LinkedList 비교
		//LinkedList<Ex01_Car> list3 = new LinkedList<Ex01_Car>();
		List<Ex01_Car> list3 = new LinkedList<Ex01_Car>();
		list3.add(new Ex01_Car(100, 500, "Red3"));
		list3.add(new Ex01_Car(200, 500, "Blue3"));
		list3.add(new Ex01_Car(300, 500, "Green3"));
		for (Ex01_Car o : list3) {
			System.out.println(o);
		}
	}

}
