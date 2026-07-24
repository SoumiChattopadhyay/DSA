/*
Uncommon characters
You are given two strings s1 and s2. Your task is to identify the characters that appear in either
string but not in both (i.e., characters that are unique to one of the strings). Return the result
as a sorted string.

Examples:

Input: s1 = "geeksforgeeks", s2 = "geeksquiz"
Output: "fioqruz"
Explanation: The characters 'f', 'i', 'o', 'q', 'r', 'u', and 'z' are present in either s1 or s2, but not in both.
*/
public class Prog31_Uncommon_Characters {
    static String uncommonChars(String s1, String s2) {
        StringBuilder ans = new StringBuilder();
        boolean[] freq1 = new boolean[26];
        boolean[] freq2 = new boolean[26];
        for(char ch:s1.toCharArray())
            freq1[ch-'a']=true;
        for(char ch:s2.toCharArray())
            freq2[ch-'a']=true;
        for(int i=0;i<26;i++){
            if(freq1[i]^freq2[i]){
                ans.append((char)(i+'a'));
            }
        }
        return ans.length()==0?"":ans.toString();
    }
    public static void main(String[] args) {
        String s1="geeksforgeeks";
        String s2="geeksquiz";
        System.out.println(uncommonChars(s1, s2));
    }
}
/*
Since there are only 26 lowercase letters, the simplest approach is:
Mark characters present in s1.
Mark characters present in s2.
If a character appears in exactly one string (XOR), add it to the answer.
Traverse from 'a' to 'z' so the result is automatically sorted.
*/