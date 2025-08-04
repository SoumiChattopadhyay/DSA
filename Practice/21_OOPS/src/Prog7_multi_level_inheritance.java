public class Prog7_multi_level_inheritance {
    public static void main(String[] args) {
        Dogs doggu = new Dogs();
        doggu.eats();
        doggu.legs=4;
        System.out.println(doggu.legs);
    }
}

class Animal{
    String color;
    void eats(){
        System.out.println("Eats.");
    }
    void breathes(){
        System.out.println("Breathes.");
    }
}

class Mammals extends Animal{
    int legs;
}

class Dogs extends Mammals{
    String breed;
}