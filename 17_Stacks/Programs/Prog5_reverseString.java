import java.util.*;
public class Prog5_reverseString {//TC=O(n)
   public static void main(String[] args) {
    Stack<Character> s = new Stack<>();
    String str="abc";
    for(int i=0;i<str.length();i++){
        s.push(str.charAt(i));
    }
    str="";
    while(!s.isEmpty()){
        str+=s.peek();
        s.pop();
    }
    System.out.println(str);
   } 
}
