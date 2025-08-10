package extends_keyword_Demo;

public class Main implements C{//so Main class is also implementing A and B as C extends them
    //here we dont know whether abstract fun() method of A or B is overridden and elaborated
    // If we want specific elaboration we could use separate classes for separate interfaces
    @Override
    public void fun(){
        System.out.println("Coding is fun");
    }

    @Override
    public void greet(){
        System.out.println("Hello!");
    }
    public static void main(String[] args) {
        A obj = new Main();
        obj.fun();
        B obj2 = new Main();
        obj2.fun();
        // obj2.greet();//compile error
        C obj3 = new Main();
        obj3.greet();
        obj3.fun();
        //javac extends_keyword_Demo/Main.java
        //java extends_keyword_Demo.Main
        // Coding is fun
        // Coding is fun
        // Hello!
        // Coding is fun

        // If u do cd extends_keyword_Demo then javac Main.java
        //u will get compile time error so do the previous one

        A obj4 = new Main();
        obj4.helloA();

        // Main.greeting();//static method greeting of interface A not inherited by interface C so also not inherited by class Main
        // Main.greetingC();.//static method greetingC of interface C not inherited by class Main
        //You have to call the static interface methods using interface name
        A.greeting();
        C.greetingC();
    }
}