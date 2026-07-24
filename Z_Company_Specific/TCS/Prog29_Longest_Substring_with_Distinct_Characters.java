/*
Longest Substring with Distinct Characters
Given a string s, find the length of the longest substring with all distinct characters. 
Examples:
Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.
*/
public class Prog29_Longest_Substring_with_Distinct_Characters {
    static int longestUniqueSubstr(String str){
        int n=str.length();
        int[] last = new int[256];//stores the last occurrence of each character in the string
        for(int i=0;i<256;i++)
            last[i]=-1;
        int l=0,r=0,maxLen=0;
        while(r<n){
            if(last[str.charAt(r)]>=l){
                l=last[str.charAt(r)]+1;
            }
            int len=r-l+1;
            maxLen=Math.max(maxLen,len);
            last[str.charAt(r)]=r;
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }
}
/*
This is a classic Sliding Window + HashMap/Last Seen Index problem.
Idea :
Maintain a window with two pointers:
left → start of the current substring
right → end of the current substring
If a character repeats, move left just after its previous occurrence.
*/