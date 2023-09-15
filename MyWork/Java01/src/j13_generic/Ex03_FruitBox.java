package j13_generic;

//** Generic Class Test 
//** FruitBox 만들기
//=> Apple, Banana 등 모든 과일을 담을수 있는 Generic FruitBox class 를 만들어 보세요.
// 단 과일들만 담을 수 있어야 함.
// ( 자율적으로 해보시면 됩니다. )
// 힌트: Apple, Banana 등 각종 과일들이 class 이고, 
//      이들은 과일(Fruit) 로 구분 될 수 있어야함.   
//=> 실습
// -> 1) Fruit 만들기
// -> 2) 과일 클래스들 만들기 (3개)
// -> 3) FruitBox 만들기 : 과일들담기_setter, 과일들출력메서드_fruitPrint()
// -> 4) main 완성하기

class Fruit {}

class Banana extends Fruit {public String toString() {return "I AM Banana";}}
class Apple  extends Fruit{public String toString() {return "I AM Apple";}}
class Orange  extends Fruit{public String toString() {return "I AM Orange";}}
class Tomato  {public String toString() {return "I AM Tomato";}}

class FruitBox<T extends Fruit> {
	private T[] arr;
	public void setFruitBox(T[] arr) {this.arr = arr;}
	public T[] getFruitBox() {return this.arr;}
	public void fruitPrint() {
		for(T a : arr) {
			System.out.println(a);
		}
	}
}

public class Ex03_FruitBox {

	public static void main(String[] args) {
		 Fruit[] ff = {new Banana(), new Apple(), new Orange()};
		 FruitBox<Fruit> f1 = new FruitBox<Fruit>();
		 f1.setFruitBox(ff);
		 f1.fruitPrint();
	}

}
