//Find the first non-repeating letter in a stream of characters
import java.util.*;
public class Prog9_firstNon_RepeatingLetter {
    public static void findfirstNonRepeatingletter(String str){
        Queue<Character> q = new LinkedList<>();
        int[] freq=new int[26];//for storing the freq. of each character in the string
        //each array el. by default 0
        for(int i=0;i<str.length();i++){//We start a loop and add each character to the queue and increase its count in the freq. array
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){//We run a loop to remove el.s from the queue whose freq. is > 1
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
    }
    public static void main(String[] args) {
        String str="ababbca";
        findfirstNonRepeatingletter(str);
    }
}
// a - a
// ab - a
// aba - b
// abab - -1
// ababb - -1
// ababbc - c
// ababbca - c
// Output : a a b -1 -1 c c