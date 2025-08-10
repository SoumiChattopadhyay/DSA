package extends_keyword_Demo;

public interface A {
    void fun();
    //Even if we don't override this method in Main class no problem coz we already provided a default implementation
    default void helloA(){
        System.out.println("Hello this is default implementation of method");
        System.out.println("This is present to avoid risk of function not being implemented in class");
    }
    //static interface method should always have a body
    // static void greeting();//error
    static void greeting(){
        System.out.println("Hello I am static interface method.");
    }
}
