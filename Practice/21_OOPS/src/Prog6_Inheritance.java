public class Prog6_Inheritance {
    public static void main(String[] args) {
        Fish shark = new Fish();//Here Java creates a constructor by itself
        shark.eats();
    }
}
//Base Class or Parent Class 
class Animal{
    void eats(){
        System.out.println("Eats.");
    }
    void breathes(){
        System.out.println("Breathes.");
    }
}

//Derived Class or Subclass or Child class
class Fish extends Animal{
    void Swims(){
        System.out.println("Swims.");
    }
    void Fin(){
        System.out.println("Has Fins.");
    }
}
