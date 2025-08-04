import java.util.Arrays;
//Strings are immutable. So original object is not changed.
public class Prog5_StringMethods {
    public static void main(String[] args) {
        String name="Soumi";
        System.out.println(name.length());//5
        System.out.println(name.charAt(2));//u
        System.out.println(name.substring(1,3));//ou //values till endIndex-1 are included
        System.out.println(name.substring(2));//umi
        System.out.println(name.indexOf('a'));// -1
        System.out.println(name.indexOf('u'));// 2
        //The .compareTo() method compares strings lexicographically based on Unicode values.
        // "S" (uppercase) has a Unicode value of 83, while "s" (lowercase) has a Unicode value of 115.
        //'S' - 's' = 83 - 115 = -32
        System.out.println("Soumi".compareTo("soumi"));//-32
        System.out.println("soumi".compareTo("Soumi"));// 32 's'-'S'=32
        System.out.println("SOUMI".compareTo("soumi"));//-32
        System.out.println("sOUMI".compareTo("soumi"));//-32 'O'-'o'=-32
        
        System.out.println("sOuMI".compareToIgnoreCase("Soumi"));// 0
        System.out.println("Aoumi".compareToIgnoreCase("Devi")); //Since case is ignored. this is evaluated as 'a'-'d'= 97-100=-3

        System.out.println(name.concat(" Chattopadhyay"));
        System.out.println(name);

        System.out.println(name.contains("a"));//false. contains() method accept string arguments
        System.out.println(name.contains("umi"));//true

        System.out.println(name.endsWith("ou"));//false
        System.out.println(name.endsWith("mi"));//true
        System.out.println(name.startsWith("ou"));//false
        System.out.println(name.startsWith("So"));//true

        // System.out.println(name.toCharArray());//Soumi
        System.out.println(Arrays.toString(name.toCharArray()));//[S, o, u, m, i]
        System.out.println(name.toLowerCase());//soumi
        System.out.println(name.toUpperCase());//SOUMI

        // strip() method is used to remove leading and trailing whitespace from a string
        System.out.println("   Mistu   ".strip());
        //trim() method in Java removes only leading and trailing ASCII spaces. Does not remove Unicode spaces like strip.Unicode spaces are whitespace characters beyond the standard ASCII space (\u0020). These include tabs, line breaks, and special spaces used in different languages and typography.
        System.out.println("\u2003\u2003Mistu\u2003\u2003".trim());
        System.out.println("\u2003\u2003Mistu\u2003\u2003".strip());
        System.out.println("  Hello\n   My name is\n Soumi".stripIndent());//stripIndent() method is used to remove common leading whitespace from multiline strings 
        System.out.println("    Soumi   ".stripLeading());
        System.out.println("    Soumi   ".stripTrailing());

        System.out.println("   ".isEmpty());//false
        System.out.println("".isEmpty());//true
        System.out.println("  ".isBlank());//true
        System.out.println("".isBlank());//true

        //split() method in Java splits a string into an array of substrings based on a specified String regex or delimiter (separator)
        String s = "apple-banana-orange-mango";
        System.out.println(Arrays.toString(s.split("-")));//[apple, banana, orange, mango]
        String s2 = "-apple-banana-orange-mango";
        //System.out.println(s2.split("-")); The output [Ljava.lang.String;@87aac27 indicates that you are printing an array directly instead of its elements.
        System.out.println(Arrays.toString(s2.split("-")));//[, apple, banana, orange, mango]
        System.out.println(Arrays.toString("Hello my name is Soumi. Nice to meet you all.".split(" ")));
        System.out.println(Arrays.toString("Hello my name is Soumi. Nice to meet you all.".split(" ",5)));//after counting 5 spaces as separator it stops cause 5 is the limit
        
        System.out.println("Soumiu".lastIndexOf("u"));//5
        System.out.println("Souououmiou".lastIndexOf("ou"));//9
        System.out.println("Soumii".lastIndexOf('i'));//5
        System.out.println("Soaaumii".lastIndexOf(97));//3
        System.out.println("Souououmiou".lastIndexOf("ou",'S'));//fromIndex cannot be string it can be char or int
        System.out.println("Soumi".lastIndexOf('i','S'));//5
        System.out.println(name.lastIndexOf('d'));//-1
        System.out.println(name.lastIndexOf(100));//-1
        
        System.out.println("Soumi".replace('i', 'u'));
        // System.out.println("Saoumi".replace(97,100));//not applicable for integer inputs
        System.out.println("Soumi".replace("So", "Mo"));
        System.out.println("Soumiiii".replaceAll("i","u"));//method replaceAll(String, String) in the type String is not applicable for the arguments (char, char)
        System.out.println("Soumiiii".replaceFirst("i", "u"));
        
        // contentEquals() Method in Java
    }
}
// System.out.println(name.substring(1, -1)); This is a runtime error - StringIndexOutOfBoundsException.
// System.out.printf("%d" ); This is a Compilation error because %d expects an integer argument, but none is provided.
// Compilation Error: Happens when there's a syntax issue or an invalid statement that prevents the program from compiling.
// Runtime Error: Occurs when the program compiles successfully but crashes during execution due to an invalid operation.