package extends_keyword_Demo;

public interface B{
    void fun();//but duplicate abstract methods can exist
    //Gives Error coz duplicate default methods can't exist. (Interface C extends both A and B)
    // default void helloA(){
    //     System.out.println("Hello this is default implementation of method");
    //     System.out.println("This is present to avoid risk of function not being implemented in class");
    // }
    default void helloB(){
        System.out.println("Hello this is default implementation of method");
        System.out.println("This is present to avoid risk of function not being implemented in class");
    }
}
