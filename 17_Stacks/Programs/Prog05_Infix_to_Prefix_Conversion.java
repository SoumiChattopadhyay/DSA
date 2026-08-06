/*
Algorithm:
    Reverse the given infix expression.
    Scan the expression from left to right.
    When an operand is encountered, append it to result string.
    If the operator is encountered and the stack is empty, push the operator into the stack.
    If the incoming operator has higher precedence than the top of the stack, push it into the stack.
    If the incoming operator has the same precedence as the top of the stack, push it into the stack.
    If the incoming operator has lower precedence than the top of the stack, pop and append the top of the stack to the result string. Then, test the incoming operator against the top of the stack again and continue popping operators from the stack until it finds an operator with lower or the same precedence.
    If the incoming operator has the same precedence as the top of the stack and the incoming operator is '^', pop the top of the stack until the condition is met. If not, push the '^' operator.
    If the operator is ')', push it into the stack.
    If the operator is '(', pop all operators from the stack until a ')' is encountered.
    If the top of the stack is ')', push the operator onto the stack.
    At the end of the expression, pop and print all remaining operators from the stack.
    Finally, reverse the output and print it as the prefix expression.

    Consider: a^b^c
    This is not (a^b)^c
    It is a^(b^c)
    because ^ is right-associative.
    That means if two ^ operators have the same precedence, you shouldn't always pop.
    So the correct prefix of a^b^c is not ^^abc
    It is ^a^bc

*/

import java.util.Stack;

public class Prog05_Infix_to_Prefix_Conversion {
    // Function to return precedence of operators
    public static int precedence(char c) {
        if (c == '^')// Exponent operator has highest precedence
            return 3;
        else if (c == '/' || c == '*')// Multiplication and division have higher precedence than addition
            return 2;
        else if (c == '+' || c == '-')// Addition and subtraction have lowest precedence
            return 1;
        else
            return -1;
    }
     public static String infixToPostfix(String infixExp){
        
        Stack<Character> stack = new Stack<>();// Stack to hold operators and parentheses
        StringBuilder postfixExp = new StringBuilder();// StringBuilder to hold the resulting postfix expression
        
        int n=infixExp.length();
        
        for(int i=0;i<n;i++){
            char ch = infixExp.charAt(i);

            // If the scanned character is an operand, add it to the result string
            if(Character.isLetterOrDigit(ch)){
                postfixExp.append(ch);
            }
            // If the scanned character is an ‘(’, push it to the stack
            else if(ch=='('){
                stack.push(ch);
            }
            // If the scanned character is a ‘)’, pop from stack until an ‘(’ is encountered
            else if(ch==')'){
                while(stack.peek()!='('){
                    postfixExp.append(stack.pop());
                }
                stack.pop();// Pop the ‘(‘ from the stack, but don't append it to result string
            }
            // If the scanned character is an operator :- ^,/,*,+,- then if it has higher precedence than character at the top of stack:- (,^,/,*,+,-  then push it to stack otherwise if it has lower precedence than the character at the top of the stack then keep popping characters from stack until a lower precedence character is reached and then push it to the stack
            else{
                while(!stack.isEmpty() && (precedence(stack.peek())>precedence(ch)
                || (precedence(stack.peek())==precedence(ch) && ch!='^'))){
                    postfixExp.append(stack.pop());
                }
                stack.push(ch);// Push the current operator to the stack
            }
        }
        // Pop all the remaining elements from the stack
        while(!stack.isEmpty()){
            postfixExp.append(stack.pop());
        }

        return postfixExp.toString();
    }
    public static String infixToPrefix(String infixExp){

        StringBuilder sb = new StringBuilder(infixExp);

        // Reverse the infix expression
        sb.reverse();

        // Replace '(' with ')' and vice versa
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                sb.setCharAt(i, ')');
            else if (sb.charAt(i) == ')')
                sb.setCharAt(i, '(');
        }

        // Get the postfix of the modified string
        String postfixExp = infixToPostfix(sb.toString());

        // Reverse the postfix to get the prefix
        return new StringBuilder(postfixExp).reverse().toString();// Return the prefix expression
    }
    public static void main(String[] args) {
        // String infixExp = "x+y*z/w+u";  // Infix expression
        String infixExp = "a^b^c";  // Infix expression
        System.out.println("Infix expression: " + infixExp);
        String prefixEq = infixToPrefix(infixExp); // Convert the infix expression to prefix
        System.out.println("Prefix equivalent: " + prefixEq);
    }
}