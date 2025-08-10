public class Daughter extends Parent{
    //Instance variable
    int gpa;
    //constructor
    public Daughter(int age){
        super(age);
    }
    //Overriding abstract methods of superclass to use them
    @Override
    void career(){
        System.out.println("I want to become a Coder.");
    }
    @Override
    void bff(){
        System.out.println("My bff is Payel.");
    }
}