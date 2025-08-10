package nested;

public class Main {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.isOdd(7));
    }
    //We cant just compile the Main class.But B is defined in another file (A.java) and has not been compiled yet, so the compiler says "cannot find symbol".
    // We also need to compile the B class.you have to compile A class too, because that’s where B is defined.

    // javac nested/*.java
    // java nested/Main
    //true
}
