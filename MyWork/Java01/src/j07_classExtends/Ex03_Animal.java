package j07_classExtends;

class Animal{
   String animal;
   String breath;
   static int leg;
   
   Animal(){}
   Animal(String animal,String breath,int leg){
      this.animal = animal;
      this.breath = breath;
      Animal.leg = leg;
   }
   
   public void breathSound() {
      System.out.printf("%s는 %s 호흡합니다.%n",animal,breath);
   }
   
   public void leg() {
      System.out.printf("%s는 다리가 %d개입니다.%n",animal,leg);
   }
   
   public String toString() {
      return animal+"는 "+breath+"하고 숨쉬고";
      //"다리 "+leg+"개 "+
   }
   
}
class Mammal extends Animal{
   
   String sound;
   Mammal(){}
   Mammal(String animal, String breath, int leg, String sound) {
      super(animal, breath, leg);
      this.sound = sound;
   }
   
   public void growl() {
      System.out.printf("%s는 %s호흡하며, %d하고 웁니다.%n",animal,breath,sound);
   }
   
   public void running() {
      System.out.printf("%s는 다리 %d개로 열심히 뜁니다.%n",animal,leg);
   }
   
   public String toString() {
      return super.toString()+" 그리고 귀엽게 "+sound+"하고 운다.";
   }
   
}
class Wild extends Mammal{
   
   Wild(){}
   Wild(String animal, String breath, int leg,String sound){
      super(animal, breath, leg, sound);
   }
   public String zoo() {
      return "야생동물 "+animal+"는 동물원에 가야합니다.";
   }
}
class Pet extends Mammal{
   
   Pet(){}
   Pet(String animal, String breath, int leg,String sound){
      super(animal, breath, leg, sound);
   }
   public String veterinary() {
      return "애완동물 "+animal+"는 동물병원에서 예방접종을 합니다.";
   }
   
}
public class Ex03_Animal {

   public static void main(String[] args) {
      Wild a1 = new Wild("사자","어흥",4,"으헝");
      System.out.println(a1);
      Wild a2 = new Wild("호랑이","후후",4,"크앙");
      System.out.println(a2);
      System.out.println(a2.zoo());
      
      Pet a3 = new Pet("강아지","훅훅",4,"낑낑");
      System.out.println(a3);
      Pet a4 = new Pet("고양이","크윽",4,"냐옹");
      System.out.println(a4);
      a4.running();
   }

}