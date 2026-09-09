/*
940. Distinct Subsequences II
Given a string s, return the number of distinct non-empty subsequences of s. Since the answer may be very large, return it modulo 109 + 7.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not.
 
Example 1:
Input: s = "abc"
Output: 7
Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".

Example 2:
Input: s = "aba"
Output: 6
Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".

Example 3:
Input: s = "aaa"
Output: 3
Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 
Constraints:
1 <= s.length <= 2000
s consists of lowercase English letters.

Topics
    Principal
    String
    Dynamic Programming
*/
public class Day8_Distinct_Subsequences_II {
    static int distinctSubseqII(String s) {
        int MOD = 1000000007;
        int n = s.length();

        long[] dp = new long[n + 1];

        // Empty subsequence
        dp[0] = 1;

        int[] last = new int[26];

        // 0 means the character has never appeared
        // Otherwise, store its 1-based position

        for (int i = 1; i <= n; i++) {

            char ch = s.charAt(i - 1);
            int index = ch - 'a';

            dp[i] = (2 * dp[i - 1]) % MOD;

            if (last[index] != 0) {
                dp[i] = (dp[i] - dp[last[index] - 1] + MOD) % MOD;
            }

            last[index] = i;
        }

        // Remove empty subsequence
        return (int)((dp[n] - 1 + MOD) % MOD);
    }
    public static void main(String[] args) {
        
    }
}
