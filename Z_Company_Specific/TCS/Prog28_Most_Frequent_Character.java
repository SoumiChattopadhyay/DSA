/*
Most Frequent Character
Given a string s of lowercase alphabets. The task is to find the maximum occurring character in the 
string s. If more than one character occurs the maximum number of times then print the 
lexicographically smaller character.

Examples:

Input: s = "testsample"
Output: 'e'
Explanation: 'e' is the character which is having the highest frequency.
*/
public class Prog28_Most_Frequent_Character {
    static char getMaxOccuringChar(String str){
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }
        int max=0;
        char ans='a';
        for(int i=0;i<26;i++){
            if(max<freq[i]){
                max=freq[i];
                ans=(char)(i+'a');
            }
        }
        return ans;
    } 
    public static void main(String[] args) {
        String s = "testsample";
        System.out.println(getMaxOccuringChar(s));
    }
}
