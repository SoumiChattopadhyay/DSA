import java.util.ArrayList;

public class Prog2_DifferentConcatenation {
    public static void main(String[] args) {
        System.out.println('a'+'b');//97+98=192
        System.out.println("a"+"b");//ab
        System.out.println('a'+3);//97+3=100
        System.out.println((char)('a'+3));//d
        System.out.println("a"+1);//a1
        //integer 1 is converted to bigger Integer (Wrapper Class) and it calls the toString() method which returns the string representation of Integer 1
        // So here "a"+"1" = a1
        // Addition with characters then the characters are converted into their ascii values and then added
        // But for strings this does not happen. Strings are just joined together.
        System.out.println("Kunal"+new ArrayList<>());
        System.out.println("Kunal"+new int[]{});
        // System.out.println("Kunal"+new Integer(56));
        // System.out.println(new ArrayList<>()+""+new Integer(67));
    }
}