public class Prog1_StaticBlock{
    static int a=30;
    static int b;

    // Static block which gets executed only once when the class is first loaded into the memory by JVM
    // doesnt depend on object creation
    static{
        b=a*2;
    }
    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
        System.out.println("Hello from main block");
    }
    //static blocks get executed before the main method
    static {
        System.out.println("Hello from static block");
    }
}
// Output
// Hello from static block
// 30
// 60
// Hello from main block
