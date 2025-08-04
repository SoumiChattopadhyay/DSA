import java.util.*;
public class Prog16_strings {
    public static void main(String[] args) {
        //String Declaration Methods
        //Method 1
        char ar[]={'s','o','u','m','i'};
        System.out.println(ar);

        //Method 2
        String s1 = "Soumi";

        //Method 3
        String s2 = new String("Chatt");
        System.out.println(s1+" "+s2);//String concatenation


        //Strings are IMMUTABLE
        

        // Taking String Inputs
        Scanner sc = new Scanner(System.in);
        // String name = sc.next();
        // System.out.println(name); next statement not executing
        /* If you use the nextLine() method immediately following the nextInt() method, 
        recall that nextInt() reads integer tokens; because of this, the last newline character 
        for that line of integer input is still queued in the input buffer and the next nextLine() 
        will be reading the remainder of the integer line (which is empty). */ 
        String name2 = sc.nextLine();
        System.out.println(name2);
        

        //String length - Here length is a function but in case of arrays length was a property
        System.out.println(name2.length());

        //charAt function
        System.out.println(name2.charAt(4));

        sc.close();
    }
}
// char ar[] = new char[6];
// ar[]={'s','o','u'}; This is wrong because array constants can only be used in initializers