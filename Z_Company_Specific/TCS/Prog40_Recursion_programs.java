import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prog40_Recursion_programs {
    static void printTillN(int n) {

        if (n == 0)
            return;

        printTillN(n - 1);

        System.out.print(n + " ");
    }
    
    static int fibonacci(int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Target Sum Combinations
    /*
    Given an array arr[] of distinct integers and a target, find all unique combinations in the 
    array where the sum is equal to target. The same number may be chosen from the array any 
    number of times to make target. Note: You can return your answer in any order, but the driver 
    code will print the combinations in sorted order only. 
    Examples: 
    Input: arr[] = [1, 2, 3], target = 5 
    Output: [[1, 1, 1, 1, 1], [1, 1, 1, 2], [1, 1, 3], [1, 2, 2], [2, 3]] 
    Explanation: All the combination have sum of elements equals to target.
    */
   static void solve(int[] arr, int index, int target,
                      ArrayList<Integer> curr,
                      ArrayList<ArrayList<Integer>> ans) {

        // If target becomes 0, we found one combination
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // If all elements are checked, stop
        if (index == arr.length)
            return;

        // -------- Take --------
        if (arr[index] <= target) {
            curr.add(arr[index]);                        // Choose current element
            solve(arr, index, target - arr[index], curr, ans); // Stay on same index
            curr.remove(curr.size() - 1);               // Backtrack
        }

        // -------- Don't Take --------
        solve(arr, index + 1, target, curr, ans);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {

        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();

        solve(arr, 0, target, curr, ans);

        return ans;
    }

    /*
    Generate Parentheses
    Given n pairs of parentheses, write a function to generate all combinations of well-formed 
    parentheses.
    */
   // Stores all valid parentheses strings
    List<String> ans = new ArrayList<>();

    // open  = number of '(' used
    // close = number of ')' used
    // curr  = current string being formed
    void solve(int open, int close, int n, String curr) {

        // If string length becomes 2*n,
        // we have used all brackets
        if (curr.length() == 2 * n) {
            ans.add(curr);   // Save the answer
            return;
        }

        // Choice 1: Add '('
        // We can add '(' only if we haven't used all n opening brackets
        if (open < n) {
            solve(open + 1, close, n, curr + "(");
        }

        // Choice 2: Add ')'
        // We can add ')' only if there is an unmatched '('
        // i.e., opening brackets used > closing brackets used
        if (close < open) {
            solve(open, close + 1, n, curr + ")");
        }
    }
    public List<String> generateParenthesis(int n) {

        // Start with 0 opening brackets,
        // 0 closing brackets,
        // and an empty string
        solve(0, 0, n, "");

        // Return all valid combinations
        return ans;
    }

    // Generate All Binary Strings
    // Given an integer n, the task is to generate all binary strings of size n without consecutive 1's.

     // Recursive function
    // n    -> Required length of binary string
    // curr -> Current binary string being formed
    // ans  -> Stores all valid binary strings
    void solve(int n, String curr, List<String> ans) {

        // ---------------- BASE CASE ----------------

        // If the current string has reached the required length,
        // we have formed one complete binary string.
        if (curr.length() == n) {

            // Store this binary string in the answer list.
            ans.add(curr);

            // Stop this recursive call and go back.
            return;
        }

        // ---------------- CHOICE 1 ----------------

        // We can ALWAYS add '0'.
        // There is no restriction on adding 0.
        solve(n, curr + "0", ans);

        // ---------------- CHOICE 2 ----------------

        // We can add '1' only if:
        //
        // 1. The current string is empty
        //        OR
        // 2. The last character is '0'
        //
        // This prevents consecutive 1's.
        if (curr.length() == 0 || curr.charAt(curr.length() - 1) == '0') {

            // Add '1' and continue building the string.
            solve(n, curr + "1", ans);
        }
    }

    // Driver function
    public List<String> generateBinaryStrings(int n) {

        // List to store all valid binary strings.
        List<String> ans = new ArrayList<>();

        // Start recursion.
        //
        // Current string = ""
        // (Nothing has been formed yet.)
        solve(n, "", ans);

        // Return all valid binary strings.
        return ans;
    }

    /*
    Distinct Permutations of a String
    Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

    Examples:

    Input: s = "ABC"
    Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
    Explanation: Given string ABC has 6 unique permutations.
    */
     // curr = current string
    // vis = tells if a character is already used
    void solve(String s, boolean[] vis, String curr, Set<String> ans) {

        // If permutation is complete
        if (curr.length() == s.length()) {
            ans.add(curr);
            return;
        }

        // Try every character
        for (int i = 0; i < s.length(); i++) {

            // Skip if already used
            if (vis[i])
                continue;

            // Use this character
            vis[i] = true;

            // Add character and go to next step
            solve(s, vis, curr + s.charAt(i), ans);

            // Make it unused again
            vis[i] = false;
        }
    }

    public ArrayList<String> findPermutation(String s) {

        Set<String> ans = new HashSet<>();

        boolean[] vis = new boolean[s.length()];

        // Start with empty string
        solve(s, vis, "", ans);

        ArrayList<String> res = new ArrayList<>(ans);
        Collections.sort(res);

        return res;
    }
    public static void main(String[] args) {
        
    }
}
