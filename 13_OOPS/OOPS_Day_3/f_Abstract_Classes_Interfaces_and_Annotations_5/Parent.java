public abstract class Parent{//abstract class
    //instance variable
    int age;
    //constructor
    public Parent(int age){
        this.age=age;
    }
    // static method
     static void hello(){
        System.out.println("Hello from parent.");
    }
    // normal method
    void normal(){
        System.out.println("this is a normal method");
    }   
    //abstract methods
    abstract void career();
    abstract void bff();

    // cannot create objects of abstract class
    // Parent p1 = new Parent(48);//compiler error
    //cannot create abstract constructors.
    // can create constructors in abstract class.
    // cannot create abstract static methods.
    // can create static methods in abstract classes.
}