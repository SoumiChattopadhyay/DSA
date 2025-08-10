public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        car.start();
        car.acc();
        car.brake();
        System.out.println(car.a);
        
        // We can create reference variable of type interface 
        Engine car2 = new Car();
        car2.start();
        car2.acc();
        // car2.brake();//Compile error
        // car2.a=3;//Compile error
        //What can be accessed depends on the type of the reference variable and which version of method runs depends on type of actual object
        //So when we do car2.acc(); acc() of Car class is running not Engine/Media Interface 
        //car2 is of type Engine so it cant access the variables inside Car class.
        
        //Dynamic Method Dispatch:
        // It happens when you call an overridden method using a parent class or interface reference pointing to a child class object.
        // At runtime, Java decides which version of the method to run (child’s or parent’s).(Dynamic Lookup)
        // This is how polymorphism works in Java.

        // Dynamic Lookup:
        // The JVM can’t decide which method to run just by looking at the variable’s type (Engine in the example).
        // Instead, it checks the actual object’s type at runtime (Car) and calls that method.
        // This extra step of figuring it out at runtime is called dynamic method lookup.

        // Performance Overhead:
        // This lookup is slightly slower than a normal method call (where the method is known at compile time).
        // Usually the slowdown is tiny and not a problem.
        // But in performance-critical code (e.g., code running millions of times per second), it might matter.
        // Interfaces in Java always use dynamic method dispatch — so if you overuse them in hot loops, you add unnecessary overhead.

        Media carMedia = new Car();
        carMedia.start();//I start engine like a normal car.
        
        // Suppose u want to change the engine in real life so in ur code u need to create a new object
        //But here u are changing the entire car instead of just changing the engine.
        // Engine car3 = new Car();
        //So we can create separate classes for these interfaces as well(for Engine - PowerEngine,ElectricEngine, for Media - CDPlayer)
        //those classes implement their respective interfaces
        //and so we can create objects of those classes implementing the interfaces
        //And we create a NiceCar class which will have its own engine (say of PowerEngine type)
        //i.e. we create an object of PowerEngine class(implementing Engine interface)
        //and we can change just the engine by creating a new object of this class instead of changing the entire car by creating a Car object

        //Car class implemented interfaces Engine,Brake,Media so it had to implement all their abstract methods
        //Similarly PowerEngine and ElectricEngine classes must implement the abstract methods of Engine interface
        //Similarly CDPlayer classe must implement the abstract methods of Media interface
    }
}
