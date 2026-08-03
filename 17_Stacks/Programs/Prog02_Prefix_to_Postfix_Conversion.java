/*
Example 1:
Input: expression = "+ab"
Output: ab+

Example 2:
Input: expression = "*+ab-cd"
Output: ab+cd-*

Algorithm
    Traverse the prefix expression from right to left.
    Use a stack to store operands.
    For each operator, pop two operands from the stack, combine them with the operator, and 
    push the result back.
    The final item in the stack will be the postfix expression.

Time Complexity: O(n), single pass through the expression.
Space Complexity: O(n), stack space for storing intermediate results.
*/

import java.util.Stack;

public class Prog02_Prefix_to_Postfix_Conversion {
    static String prefixToPostfix(String prefixExp){
        Stack<String> stack = new Stack<>();
        int n=prefixExp.length();
        for(int i=n-1;i>=0;i--){//Traverse from right to left
            char ch = prefixExp.charAt(i);
            if(Character.isLetterOrDigit(ch)){//If scanned character is an operand
                stack.push(String.valueOf(ch));//Push it to stack
            }
            else{//If scanned character is an operator
                // Pop two operands from the stack
                String op1 = stack.pop();
                String op2 = stack.pop();
                // Form the new postfix expression and push back to stack
                stack.push(op1 + op2 + ch);
            }
        }
        // The final element in the stack is the result
        return stack.peek();
    }
    public static void main(String[] args) {
        String prefixExp = "*-A/BC-/AKL";
        System.out.println(prefixToPostfix(prefixExp));
    }
}
