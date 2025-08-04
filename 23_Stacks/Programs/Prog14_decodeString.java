import java.util.Stack;

public class Prog14_decodeString {
     public static void decodeString(String str) {
        Stack<Character> s = new Stack<>();
        int i=0;
        while(i<str.length()){
            char ch=str.charAt(i);
            if(ch=='/'){
                s.push(ch);
            }
            i++;
        }
        
    }

    public static void main(String[] args) {
        String str="/apnacollege/";
        decodeString(str);
       
    }
}
