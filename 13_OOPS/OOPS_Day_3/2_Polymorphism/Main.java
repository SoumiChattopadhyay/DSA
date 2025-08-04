public class Main {
    public static void main(String[] args) {
        Shapes shp1 = new Shapes();
        shp1.area();
        System.out.println(shp1.weight);//10.0

        Square sq1 = new Square();
        sq1.area();
        System.out.println(sq1.weight);

        // Parent class Shapes referencing to child class Square. So, the variables the object has access to depends on the type of the reference variable. So the obj has access to the parent class variables
        Shapes shp2 = new Square();
        shp2.area();//area() of child class(Circle class) gets executed
        System.out.println(shp2.weight);//10.0 (weight of Shapes class is printed)

        // Shapes shp3 = new Square();
        Shapes.greetings();
        Square.greetings();
        
        // Square sq2 = new Shapes();//wrong. child class cant reference parent class, coz ref var of type child class expects the object of parent class to have all the variables of child class, but parent classes have no idea about the child class exclusive variables. child class do have idea about parent class variables as they are inheriting the parent class. so this is wrong
    }
}
