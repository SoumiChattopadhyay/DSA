import java.util.Stack;
public class Prog11_DuplicateParentheses {
     public static boolean checkDuplicateParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            //closing
            if(c==')'){
                int count=0;
                while(s.pop()!='('){
                    count++;
                }
                if(count<1){
                    return true;//duplicate exists
                }
            }
            //operator, operand, opening
            else{
                s.push(c);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Valid String
        String str = "((a-b)+(c-d))";//false        
        String str2 = "(((a-b)+(c-d)))";//true        
       System.out.println(checkDuplicateParentheses(str));
       System.out.println(checkDuplicateParentheses(str2));
    }
}
//closing altenative
// if(c==')'){
//     int count=0;
//     while(s.peek()!='('){
//         count++;
//         s.pop();
//     }
//     if(count<1){
//         return true;//duplicate exists
//     }else{
//         s.pop();//pop opening pair
//     }
// }