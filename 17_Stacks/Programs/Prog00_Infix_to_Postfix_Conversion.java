import java.util.Stack;

class Solution{
    
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
    
    // Function to convert infix expression to postfix expression

    // Example
    // Input: a + b * (c^d - e) ^ (f + g * h) - i  
    // Output: abcd^e-fgh*+^*+i- 
    // Input:(p + q) * (m - n)  
    // Output: pq+mn-*
    
    // TC = O(N) + O(N) //Outer for loop runs for N times as it scans all N characters in the 
    // expression, first inner while loop can in worst case run N times as in worst case
    // stack might put in all N characters (say all characters are operators) but the first inner
    // while loop would not run more than N times throughout the N iterations of the outer for loop
    // Like TC can't be O(N)xO(N) because for all N iterations of the outer for loop combined,
    // the inner while loop can at max run for N times, so TC is O(N)+O(N)
    // Same for the other two while loops
    
    // SC = O(N) + O(N) //Stack stores N elements and result stringbuilder stores N els
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
            // If the scanned character is an operator - ^,/,*,+,- then if it has higher precedence than character at the top of stack then push it to stack otherwise if it has lower precedence the character at the top of the stack then keep popping characters from stack until a lower precedence character is reached
            else{
                while(!stack.isEmpty() && precedence(stack.peek())>=precedence(ch)){
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
}
public class Prog00_Infix_to_Postfix_Conversion {
    public static void main(String[] args) {
        String infixExp = "(p+q)*(m-n)";  // Infix expression
        System.out.println("Infix expression: " + infixExp);
        String postfixEq = Solution.infixToPostfix(infixExp); // Convert the infix expression to postfix
        System.out.println("Postfix equivalent: " + postfixEq);
    }
}
