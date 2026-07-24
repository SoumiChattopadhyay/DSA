/*
Given a string s, return true if the string is a palindrome. Otherwise, return false.
A string is considered a palindrome if it reads the same forwards and backwards.
*/
public class Prog26_Palindrome_Strings {
    static boolean checkPalindrome(String str){
        int i=0,j=str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "madam";
        System.out.println(checkPalindrome(s));
    }
}
/*
Best Approach (Two Pointers)
One pointer starts from the beginning.
One pointer starts from the end.
Compare both characters.
If they differ, return false.
If all pairs match, return true.
*/