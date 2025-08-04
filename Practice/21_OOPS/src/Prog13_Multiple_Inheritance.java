public class Prog13_Multiple_Inheritance {
    public static void main(String[] args) {
        Bear b = new Bear();
        b.eatsGrass();
    }
}

interface Herbivore{
    void eatsGrass();
}

interface Carnivore{
    void eatsFlesh();
}

class Bear implements Herbivore,Carnivore{
    public void eatsGrass(){
        System.out.println("Bear eats Grass..");
    }
    public void eatsFlesh(){
        System.out.println("Bear eats Flesh..");
    }
}