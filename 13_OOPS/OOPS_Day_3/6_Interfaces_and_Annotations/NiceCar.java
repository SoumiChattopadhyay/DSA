public class NiceCar{
    //Instance variable
    private Engine engine;//ref var of type Engine(Interface) (Data hiding-->private)
    private Media media = new CDPlayer();
    //constructor Of NiceCar class is calling the constructor of PowerEngine class so that it initializes the object 
    // since both the classes are in the same folder so accessible
    public NiceCar(){
        engine = new PowerEngine();
    }
    //construtor to add engine of your own
    public NiceCar(Engine engine){
        this.engine=engine;
    }
    public void startEngine(){//NiceCar constructor is calling and creating object of PowerEngine class implementing Engine interface and elaborating all its abstract methods
        engine.start();// Dynamic method dispatch - abstract method start() of Engine interface is overridden by the method of PowerEngine class implementing the Engine interface
    }
    public void stopEngine(){
        engine.stop();
    }
    public void startMusic(){
        media.start();
    }
    public void stopMusic(){
        media.stop();
    }
    public void upgradeEngine(Engine engine){
        this.engine=engine;
    }
    public static void main(String[] args) {
        //Whenever creating a new car object(or purchasing new car in real life)
        //we getting a new engine object, a new media object
        //engine ref var type is Engine interface and actual object is type PowerEngine
        //media ref var type is Media interface and actual object is type CDPlayer
        NiceCar car = new NiceCar();
        car.startEngine();
        car.startMusic();
        car.stopMusic();
        car.stopEngine();
        car.upgradeEngine(new ElectricEngine());
        car.startEngine();
    }
}
