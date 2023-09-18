package j14_Collection;
//** Set : ppt 30 p
//=> 원소의 중복을 허용하지 않고, 순서가 없음
//=> HashSet, TreeSet, LinkedHashSet

import java.util.HashSet;
import java.util.Iterator;

//** HashSet
//=> HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수,
// 하지만 원소들의 순서가 일정하지 않은 단점이 있다.

// HashSet은 순차처리가 안되기에 Iterator로 순차처리..하기.....
//** Iterator 클래스 를 이용한 처리 (출력등..)
//=> 배열 -> Set
//=> Set -> Iterator : 순차 처리 적용
public class Ex04_HashSet {

	public static void main(String[] args) {
		//1) 정의 
		// => 중복 허용 하지 않음
		//1.1) Object
		// 제네릭을 적용하지 않거나, Object Type 인 경우
		// 값은 같지만 Type이 다른 경우 Test(다른 데이터로 취급)
		
		Object[] ob = {"가나다", "Green", "123", 123, new Integer(123), "Green", "123.456"}; 
		HashSet<Object> oSet = new HashSet<>();
		for(Object o:ob) {
			if(!oSet.add(o)) {System.out.println("**중복자료 => "+ o);}
		}
		// => 확인
		System.out.println("** oSet =>" +oSet); //toString() 오버라이딩 되어있음
		
		//1.2)String
		HashSet<String> sSet = new HashSet<>();
		
		//2) 초기화
		sSet.add("Java");
		sSet.add("MySql");
		sSet.add("Web");
		sSet.add("Spring");
		sSet.add("Mybatis");
		sSet.add("JPA");
		sSet.add("Java"); // 오류는 없고 허용하지 않음
		sSet.add("Spring");// 오류는 없고 허용하지 않음
		//sSet.add(123.456); String 만 허용
		
		// => 삭제
	      System.out.println("** sSet Spring 삭제결과 => "+sSet.remove("Spring"));
	      System.out.println("** sSet Test 삭제결과 => "+sSet.remove("Test"));
		
		//3) 출력
		System.out.println("** sSet => " +sSet);
		System.out.println("** sSet.size => " +sSet.size());
		
		//4) 반복처리
		// => 삭제시 필요, 반복처리가 가능하도록 해줘야 함(즉, Iterator를 사용해야 함)
		// => Iterator 활용
		//  - 순차적으로 비교하면서 원하는 값 찾기, 삭제하기
		//  - 변경된 사항들은 set에 반영됨
		Iterator<String> iSet = sSet.iterator();
		while(iSet.hasNext()) {
			// if (iSet.next().equals("Web")) iSet.remove(); -> 반복문 없어도 가능
			// => "a" 포함된 자료는 삭제(반복문 필요)
			if(iSet.next().contains("a")) iSet.remove();
			// => remove 결과는 원본인 sSet에 반영됨
			// => 비교
			//    반복문 내부에서 sSet 접근 : 허용하지 않음
			//    (iSet과 sSet의 remove 메서드 인자값 차이 주의)
			// if (iSet.next().equals("Web")) sSet.remove();
			//sSet.add("Oracle"); 
			// 런타임 오류 발생
			// : java.util.ConcurrentModificationException
		}
		
		// =>삭제결과
		// System.out.println("** 삭제결과 sSet toString => " +sSet);
		// => 삭제결과 : 반복문으로 출력하기
		// iSet 재사용
		// Iterator 는 한 번 사용을 마치면 자료를 포인트하는 커서가 끝에 가 있어 hasNext()가
		// false를 return 하기 때문에 재할당해야한다.
		
		System.out.println("**iSet.hasNext() 확인=> **" +iSet.hasNext());
		while(iSet.hasNext()) {
			System.out.println("최종 결과 => "+iSet.next());
		}
		System.out.println("**Program 정상 종료**");
		
	}

}
