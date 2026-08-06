/*
Example 1:
Input:
 "ab+c*"
Output:
 "(a+b)*c"

Example 2:
Input:
 "ab*cd/+"
Output:
 "(a*b)+(c/d)"

Algorithm
    Traverse the postfix expression from left to right.
    Use a stack to store operands.
    For each operator, pop two operands, combine them in infix order with parentheses, and push the result back.
    The final item in the stack will be the infix expression.

Time Complexity: O(n), a single pass over the postfix expression.
Space Complexity: O(n), stack space for storing operands.
*/


import java.util.Stack;

public class Prog04_Postfix_to_Infix_Conversion {
    static String postfixToInfix(String postfixExp){
        Stack<String> stack = new Stack<>();
        int n=postfixExp.length();
        for(int i=0;i<n;i++){//Traverse from left to right
            char ch = postfixExp.charAt(i);
            if(Character.isLetterOrDigit(ch)){//If scanned character is an operand
                stack.push(String.valueOf(ch));//Push it to stack
            }
            else{//If scanned character is an operator
                // Pop two operands from the stack
                String op2 = stack.pop();
                String op1 = stack.pop();
                // Form the new infix expression and push back to stack
                stack.push("(" + op1 + ch + op2 + ")");
            }
        }
        // The final element in the stack is the result
        return stack.peek();
    }
    public static void main(String[] args) {
        String postfixExp = "AB*CD/+";
        System.out.println(postfixToInfix(postfixExp));
    }
}
