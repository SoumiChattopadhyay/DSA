public class Son extends Parent{
    //Instance variable
    int gpa;
    // Instance method
    void gpaPrint(){
        System.out.println("My gpa is "+gpa);
    }
    //constructor
    public Son(int age){
        super(age);
    }
    //Overriding abstract methods of superclass to use them
    @Override
    void career(){
        System.out.println("I want to become a Doctor.");
    }
    @Override
    void bff(){
        System.out.println("My bff is Rahul.");
    }
    @Override
    void normal(){
        super.normal();
    }
}
