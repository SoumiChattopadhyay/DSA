/*
115. Distinct Subsequences

Given two strings s and t, return the number of distinct subsequences of s which equals t.
The test cases are generated so that the answer fits on a 32-bit signed integer.

Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit

Example 2:
Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag
 
Constraints:
1 <= s.length, t.length <= 1000
s and t consist of English letters.

Topics
    String
    Dynamic Programming
*/
public class Day7_Distinct_Subsequences{
    static int numDistinct(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();
        int[] prevRow = new int[M+1];
        // Base Cases
        prevRow[0]=1;
        for(int j=1;j<=M;j++) prevRow[j]=0;//except dp[0][0] it must be 1
// j must start from 1 otherwise it will rewrite the previous for loop's 0 column
        
        for(int i=1;i<=N;i++){
            for(int j=M;j>=1;j--){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    prevRow[j] = prevRow[j-1] + prevRow[j];
                }
                // else{
                //     prevRow[j] = prevRow[j];
                // }
                //we dont need to write else
            }
        }
        
        return prevRow[M];
    }
    public static void main(String[] args) {
        
    }
}