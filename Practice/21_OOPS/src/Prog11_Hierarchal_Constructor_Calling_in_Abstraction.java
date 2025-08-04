public class Prog11_Hierarchal_Constructor_Calling_in_Abstraction {
    public static void main(String[] args) {
    Mustang m = new Mustang();//Not just Mustang constructor but first Animal constructor and Horse constructor called
    System.out.println(m.color);
}
}
abstract class Animal{
    String color="brown";
    Animal(){
        System.out.println("Animal constructor called.");
    }
    abstract void walk();
}

class Horse extends Animal{//Horse class inherits Animal class
    void changeColor(){
        color="dark brown";
    }
    Horse(){
        System.out.println("Horse constructor called.");
    }
    void walk(){
        System.out.println("Walks on 4 legs.");
    }
}

class Mustang extends Horse{//Mustang class inherits Horse class
    void changeColor(){
        color="yellow";
    }
    Mustang(){
        System.out.println("Mustang constructor called.");
    }
}