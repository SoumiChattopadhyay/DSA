import java.util.*;
public class Prog17_Palindrome_String {

    public static boolean isPalindrome(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-1-i))
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str;
        System.out.println("Enter a string:");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        System.out.println(isPalindrome(str));
        sc.close();
    }
}
