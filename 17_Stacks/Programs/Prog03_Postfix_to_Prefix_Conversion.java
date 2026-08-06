/*
Example 1:
Input:
 expression = "ab+"
Output:
 "+ab"
Explanation:
 Postfix → Prefix

Example 2:
Input:
 expression = "abc*+d-"
Output:
 "-+a*bcd"

 Algorithm
    Traverse the postfix expression from left to right.
    Use a stack to store operands.
    For each operator, pop two operands, combine them with the operator in prefix order, and push the result back.
    The final item in the stack will be the prefix expression.
*/

import java.util.Stack;

public class Prog03_Postfix_to_Prefix_Conversion {
    static String postfixToPrefix(String postfixExp){
        Stack<String> stack = new Stack<>();
        int n=postfixExp.length();
        for(int i=0;i<n;i++){//Traverse from left to right
            char ch = postfixExp.charAt(i);
            if(Character.isLetterOrDigit(ch)){//If scanned character is an operand
                stack.push(String.valueOf(ch));//Push it to stack
            }
            else{//If scanned character is an operator
                // Pop two operands from the stack
                String op1 = stack.pop();
                String op2 = stack.pop();
                // Form the new prefix expression and push back to stack
                stack.push(ch + op1 + op2);
            }
        }
        // The final element in the stack is the result
        return stack.peek();
    }
    public static void main(String[] args) {
        String postfixExp = "ABC/-AK/L-*";
        System.out.println(postfixToPrefix(postfixExp));
    }
}
