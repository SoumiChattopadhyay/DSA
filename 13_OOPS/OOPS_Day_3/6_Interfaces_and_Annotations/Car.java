public class Car implements Brake,Engine,Media{
    int a;
     
    //These methods of Car class are Overriding the methods of interface --> Dynamic Method Dispatch : which method to run is determined at run-time and it depends on the type of the actual object(here car)
    //Although it is not known that method of which interface is being overridden (for methods with same name)
    // like we don't know here that start() and stop() of Engine is getting overridden or those of Media
    @Override
    public void start() {
        System.out.println("I start engine like a normal car.");
    }

    @Override
    public void stop() {
        System.out.println("I stop engine like a normal car.");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal car.");
    }

    @Override
    public void brake() {
        System.out.println("I brake like a normal car.");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        //suppose u want to start music not engine how would u know coz this class is implementing all 3 interfaces
        car.start();

        //suppose i just wanted to change the engine but i had to create an entire car object
        // Engine car2 = new Car();

        // So we create separate classes for separate interfaces
        //And then we have a combined NewCar class which would use only the specific class as per requirement by creating its object

    }
}
