public class BoxWeight extends Box{//Child class or Derived class
    // instance variable
    double weight;
    // constructor 1
    BoxWeight(){
    // Even if you don’t explicitly write super(), the compiler automatically calls the no-arg constructor of the parent class before executing the child constructor.
        System.out.println("In BoxWeight class constructor 1");
        this.weight=-1;
    }
    // constructor 2
    BoxWeight(double side,double weight){
        // In Java, if you're calling a superclass constructor with super(), it must be the very first line in the subclass constructor.
        //Because Java must initialize the parent class before the child class. The super() call tells Java how to set up the parent part of the object.Java objects are built from top (parent) to bottom (child).If you put anything before super(), it means the child is trying to act before the parent even exists → that breaks the rule.
        super(side);//calls the constructor 2 of parent class which initialises these properties of the object
        System.out.println("In BoxWeight class constructor 2");
        this.weight=weight;
    }
    //constructor 3
    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w); //If l is private how is it getting initialized? BoxWeight is not initializing it, Box is doing so. Here l is the parameter passed to the child class constructor and the l property of the child class object is initialized with this value not by the child class constructor but by the parent class constructor.
        System.out.println("In BoxWeight class constructor 3");
        this.weight = weight;

        System.out.println(this.w);//correct
        System.out.println(super.w);//correct
        // System.out.println(super.l);//error can't access l in this file as its private
        // super means directly above it that's why Box class is pointing to Object class and BoxWeight class is pointing to Box class not Object class but BoxWeight class is inheriting Object class.
        
        //Uses of super keyword
        // super keyword is used to call the constructor of the class just above the given class
        // super keyword can be used in the child class to access superclass(parent) variables, methods, or constructors.
    
        // So then why need of super.w if we have this.w?
        // Ans: Suppose we have a var weight in both super class and sub class then to refer to super class weight variable we can use super.weight and to refer to sub class's weight variable we can write this.weight
    }
    //constructor 4
    BoxWeight(BoxWeight old){ 
        super(old);//Box constructor has ref. var of Box type as argument and here BoxWeight type object is passed to it as parameter. So parent class referencing to child object(upcasting).
        System.out.println("In BoxWeight class constructor 4");
        this.weight=old.weight;
    }
}
