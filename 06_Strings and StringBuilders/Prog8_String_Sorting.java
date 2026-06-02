// https://www.geeksforgeeks.org/java/sort-a-string-in-java-2-different-ways/
// Method 1 : Using Merge Sort


// Method 2: By using the sort() method
// The main logic is to toCharArray() method of the String class over the input string to create a character array for the input string.
// Now use Arrays.sort(char c[]) method to sort character array.
// Use the String class constructor to create a sorted string from a char array.
import java.util.Arrays;
public class Prog8_String_Sorting {
    // To sort a string alphabetically
    public static String sortString(String inputString)
    {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }

    public static void main(String[] args)
    {
        String inputString = "geeksforgeeks";
        String outputString = sortString(inputString);

        // Input string
        System.out.println("Input String : " + inputString);
        // Output string
        System.out.println("Output String : " + outputString);
    }
}