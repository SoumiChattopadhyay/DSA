package extends_keyword_Demo;
// interface to interface inheritance requires the use of extends keyword
// class to interface inheritance requires the use of implements keyword
// In both cases multiple inheritance allowed
public interface C extends A,B{
    void greet();
    static void greetingC(){
        System.out.println("Hello I am static interface method.");
    }
}
