public class Prog10_AbstractClasses {
    public static void main(String[] args) {
        //This is wrong-->Animal a = new Animal();
        Horse h = new Horse();
        h.eat();
        h.walk();
        Chicken c = new Chicken();
        c.eat();
        c.walk();
    }
}
abstract class Animal{
    abstract void walk();
    void eat(){
        System.out.println("Animal eats.");
    }
}
class Horse extends Animal{
    void walk(){
        System.out.println("Walks on 4 legs.");
    }
}
class Chicken extends Animal{
    void walk(){
        System.out.println("Walks on 2 legs.");
    }
}