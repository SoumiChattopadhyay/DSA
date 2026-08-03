/*
Example 1
Input: expression = "+ab
Output: (a+b)

Example 2:
Input: expression = "*+ab-cd
Output: ((a+b)*(c-d))

Algorithm:
    Traverse the prefix expression from right to left.
    Use a stack to store operands.
    For each operator, pop two operands from the stack, wrap them in parentheses, and push the
    resulting expression back.
    The final item in the stack will be the infix expression.
*/

import java.util.Stack;

public class Prog01_Prefix_to_Infix_Conversion {
    static String prefixToInfix(String prefixExp){
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
                // Form the new infix expression and push back to stack
                stack.push("(" + op1 + ch + op2 + ")");
            }
        }
        // The final element in the stack is the result
        return stack.peek();
    }
    public static void main(String[] args) {
        String prefixExp = "*+ab-cd";
        System.out.println(prefixToInfix(prefixExp));
    }
}
