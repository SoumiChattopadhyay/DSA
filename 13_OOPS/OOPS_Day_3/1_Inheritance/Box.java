// Some advantages object oriented programming are:
// code is broken down into chunks so becomes easier to manage
// enhanced security of code
// So there are four properties of object oriented programming which help in achieving these advantages:
// 1.Inheritance,2.Polymorphism ,3.Abstraction,4.Encapsulation


// Inheritance involves a base class(parent class) that passes on its properties and functions to a derived class(child class).
// Derived class has access to all the variables and functions of base class + has some properties of it's own which are not accessible to base class
// Class is a template or a definition of vars and functs
// To incorporate the definition of base class in the derived class the 'extends' keyword is used
// The constructor of the child class must also initialise the parent class variables for obvious reasons so it calls the parent class constructor using super keyword and passes the req. parameters to it
// The child class cannot access the parent class members which are declared private even if both the classes are in the same file cause private means accessible only within the class where it's declared.
public class Box{//parent class
    // instance variables: These are properties of objects and based on whether these variables are static or non-static it is decided whether the same variables are common across all objects or each object has its own copy of these variables.
    private double l;// here the instance variables are non-static which means each object gets its own copy of these variables
    double h;
    double w;//length,height,width
    // If we didn't create any constructor then Java's default constructor would initialise these three variables with 0.0 because that's the default value for double type variables
    // constructor 1
    Box(){//if super() is not used in any subclass constructor then this default superclass constructor will be called
        System.out.println("In Box class constructor 1");
        this.l=-1;
        this.h=-1;
        this.w=-1;
        // System.out.println(this.l);//correct If a parent class variable is private, subclasses do NOT inherit direct access to it. But the variable is still part of the object, so it exists in the subclass.
    }
    // constructor 2 for cubes
    Box(double side){
        super();//no error, cause every class has Object as super class. Every class(Arrays,Box,BoxWt,etc.) references to the Object super class.Ctrl+Clk super to see. Every class inherits object class.
        // super means directly above it that's why Box class is pointing to Object class and BoxWeight class is pointing to Box class not Object class but BoxWeight class is inheriting Object class.
        
        //Uses of super keyword
        // super keyword is used to call the constructor of the class just above the given class
        // super keyword can be used in the child class to access superclass(parent) variables, methods, or constructors.
        System.out.println("In Box class constructor 2");
        
        this.l=side;
        this.h=side;
        this.w=side;
    }
    //constructor 3 
    Box(double l,double h,double w){
        System.out.println("In Box class constructor 3");
        this.l=l;
        this.h=h;
        this.w=w;
    }
    // constructor 4: initialises the new obj with values of another old object
    Box(Box old){
        System.out.println("In Box class constructor 4");
        this.l=old.l;
        this.h=old.h;
        this.w=old.w;
    }
}