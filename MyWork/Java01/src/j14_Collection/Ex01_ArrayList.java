package j14_Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import j07_classExtends.Ex01_Car;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		// 1. 정의
		// => Generic Type 을 지정하지않으면 default 는 Object Type
		//ArrayList list = new ArrayList();
		List list = new ArrayList();
		
		list.add("홍길동");
		list.add(123);
		list.add(123.456);
		list.add('C');
		list.add(123.456f);
		list.add(new Integer(500));
		
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
