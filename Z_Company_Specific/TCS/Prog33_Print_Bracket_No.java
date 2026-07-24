/*
Print Bracket Number
Given a string s, the task is to find the bracket numbers, i.e., for each bracket in s, return i if the bracket is the ith opening or closing bracket to appear in the string. 

Note : s contains lowercase English alphabets, and '(', ')' characters at any index, the number of opening brackets is greater than or equal to closing brackets

 Examples:

Input:  s = "(aa(bdc))p(dee)"
Output: 1 2 2 1 3 3
Explanation: The highlighted brackets in
the given string (aa(bdc))p(dee) are
assigned the numbers as: 1 2 2 1 3 3.
*/

import java.util.ArrayList;
import java.util.Stack;

public class Prog33_Print_Bracket_No {
    static ArrayList<Integer> bracketNumbers(String str) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int num=1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push(num);
                ans.add(num);
                num++;
            }else if(str.charAt(i)==')'){
                ans.add(stack.pop());
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String  s = "(aa(bdc))p(dee)";
        System.out.println(bracketNumbers(s));
    }
}
/*
This is a Stack problem.
Idea :
Every time you see '(', assign it the next bracket number and push that number onto the stack.
Every time you see ')', print the number on the top of the stack and pop it.

Thus, every matching pair gets the same number.
*/