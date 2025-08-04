public class Prog29_remove_duplicate {
    public static void remove_duplicate(String str,int idx, StringBuilder newstr, boolean map[]){
        //base case
        if(idx==str.length()){
            System.out.println(newstr);
            return;
        }
        //kaam
        char curr = str.charAt(idx);
        if(map[curr-'a']==true){
            remove_duplicate(str, idx+1, newstr, map);
        }else{
            map[curr-'a']=true;
            remove_duplicate(str, idx+1, newstr.append(curr), map);
        }
    }
    public static void main(String[] args) {
    remove_duplicate("hhheleehllowworroorlldd",0,new StringBuilder(""),new boolean[26]);
    }
}
// The error occurs because your code assumes that all characters in the input string 
// are lowercase alphabetic characters ('a' to 'z'). When the string contains spaces or
//  other non-alphabetic characters, the index calculation curr - 'a' results in a negative 
// value or a value greater than 25, leading to an ArrayIndexOutOfBoundsException.



// String str = (String)s.charAt(i); Why wrong??