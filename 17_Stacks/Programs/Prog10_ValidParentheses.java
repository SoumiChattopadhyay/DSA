import java.util.Stack;
public class Prog10_ValidParentheses {
    public static boolean checkValidParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('||c=='{'||c=='['){
                s.push(c);
            }else{
                if(s.isEmpty()){//if str="]]]]" only closing braces then also return false
                    return false;
                }
                if((c==')'&& s.peek()=='(')
                ||(c=='}'&& s.peek()=='{')
                ||(c==']'&& s.peek()=='[')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "(((){}[])";        
       System.out.println(checkValidParentheses(str));
    }
}
