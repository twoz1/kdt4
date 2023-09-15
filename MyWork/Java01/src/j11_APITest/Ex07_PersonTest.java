package j11_APITest;

import java.time.LocalDate;
import java.util.Arrays;
//** Person
//=> 주민등록번호, 이름을 전달받으면
//=> 주민등록번호를 이용해서, age, 성별을 set 하고
//=> info 출력하기 

//=> 맴버필드(private) : idNo(String), name(String), age(int), gender(char)
//=> 생성자 2개
//    * default
//    * 주민등록번호,이름을 매개변수로 전달받아 초기화 
//    -> 나이 계산, 성별도 찾아서 set
//=> setter/getter
//     이름만 수정 가능, 
//    모든필드를 사용가능 (그러나 주민번호는 뒷자리는 * 로표시)
//=> infoPrint()
//=> toString 은 오버라이딩

//** info
//이름 : 000
//번호 : 090909-*******
//나이 : 20세
//성별 : "남" 또는 "여"

//** PersonTest
//=> Person 5명 생성후 배열에 넣고,
// 나이순으로 출력하기
//=> 나이순 정렬은 정렬메서드 (static ageSort()) 만들어서 하세요~~  
//=> 출력은 infoPrint() 로 

class Person {
   private String idNo;
   private String name;
   private int age;
   private char gender;
   
   Person(){};
   Person(String idNo, String name) {
      this.idNo = idNo;
      this.name = name;
      ageAndGender(idNo);
   }

   public void ageAndGender(String idNo) {
      String[] idNoParts = idNo.split("-");
      if (idNoParts[1].length() == 7) {
         this.idNo = idNoParts[0] + "-" + "********";
      }

      int birthYear = Integer.parseInt(idNo.substring(0, 2));
      if (birthYear >= 0 && birthYear <= 23) {
         birthYear += 2000;
      } else {
         birthYear += 1900;
      }
      
      int currentYear =LocalDate.now().getYear();
    		      
      this.age = currentYear - birthYear + 1;
      
      char whatGender = idNo.charAt(7);
      this.gender = (whatGender % 2 == 1) ? 'M' : 'F';

   }

//=====================================================   
   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
//======================================================   

   public void infoPrint() {
      System.out.println("이름 : " + name);
      System.out.println("주민번호 : " + idNo);
      System.out.println("나이 : " + age + "세");
      System.out.println("성별 : " + gender);
      System.out.println();
   }

   @Override
   public String toString() {
      return "이름: " + name + "\n주민번호: " + idNo + "\n나이: " + age + "세\n성별: " + gender;
   }

   public static void ageSort(Person[] people) {
      Arrays.sort(people, (person1, person2) -> person1.age - person2.age);
   }
}
//=========================================================   

public class Ex07_PersonTest {

   public static void main(String[] args) {
      Person[] people = new Person[5];
      people[0] = new Person("970904-2234567", "김똥꾸멍");
      people[1] = new Person("930201-2234567", "김방구");
      people[2] = new Person("830909-2234567", "조바보");
      people[3] = new Person("890903-1234567", "김멍총이");
      people[4] = new Person("220101-1234567", "비둘기");

      Person.ageSort(people);

      for (Person person : people) {
         person.infoPrint();
      }

   }

}