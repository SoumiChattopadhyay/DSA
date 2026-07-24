/*
Given two non-empty strings s1 and s2, consisting only of lowercase English letters, determine 
whether they are anagrams of each other or not.
Two strings are considered anagrams if they contain the same characters with exactly the same 
frequencies, regardless of their order.
*/
public class Prog25_Anagrams {
    static boolean checkAnagrams(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;

        int[] freq = new int[26];

        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }

        for(int count:freq) {
            if(count!=0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String s1="geeks";
        String s2="skeeg";
        System.out.println(checkAnagrams(s1, s2));
    }
}
