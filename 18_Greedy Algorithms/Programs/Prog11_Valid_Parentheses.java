// Valid Parantheses
// Check if every opening bracket in a string has a corresponding closing bracket.
// Each bracket is pushed to stack
// Whenever a closing bracket appears and it matches opening bracket at top of stack then it is popped
// If stack is empty or types differ then the string is invalid
import java.util.Stack;
public class Prog11_Valid_Parentheses {
    static boolean isValidParentheses(String str){//TC=O(N)
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='[' ){
                stack.push(str.charAt(i));
            }
            else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((str.charAt(i)==')' && top!='(') || (str.charAt(i)=='}' && top!='{') || (str.charAt(i)==']' && top!='[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String str="{[]}";
        System.out.println(isValidParentheses(str));
    }
}
