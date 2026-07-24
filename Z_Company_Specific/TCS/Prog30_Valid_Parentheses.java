// Valid Parantheses
    // Check if every opening bracket in a string has a corresponding closing bracket.
    // Each bracket is pushed to stack
    // Whenever a closing bracket appears and it matches opening bracket at top of stack then it is popped
    // If stack is empty or types differ then the string is invalid

import java.util.Stack;

public class Prog30_Valid_Parentheses {
    static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char currChar = str.charAt(i);
            if(currChar=='(' || currChar=='{' || currChar=='['){
                stack.push(currChar);
            }
            else{
                if(stack.isEmpty())
                    return false;
                char top=stack.pop();
                if((currChar==')' && top!='(') || (currChar=='}' && top!='{')  || (currChar==']' && top!='[') ){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    } 
    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid(s));
    }
}