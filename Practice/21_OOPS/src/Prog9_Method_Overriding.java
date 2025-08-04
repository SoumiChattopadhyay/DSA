public class Prog9_Method_Overriding {
    public static void main(String[] args) {
        Deer d = new Deer();
        d.eat();//Method of derived class gets called
        d.eat();
    }
}
class Animal{
    void eat(){
        System.out.println("Eats anything.");
    }
}

class Deer extends Animal{
    void eat(){
        System.out.println("Eats grass.");
    }
}