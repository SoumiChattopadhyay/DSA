import java.util.ArrayList;
public class Prog1_skip_character_approach2{
    public static void main(String args[]){
        skipCharacter("baccab",'a',0);
    }

// Skips every occurrence of character del from string str. and does not return anything
// Uses a Character ArrayList to store each allowed character, as the i parameter increases by 1 with each recursive call 
// and in the end when i=len(str) then uses a StringBuilder to combine and store all the characters from the ArrayList and finally prints String version of StringBuilder. 
// We shud only use list.get(idx) to get each ele and not list.remove(idx).Why?
    static ArrayList<Character> list=new ArrayList<>();
    public static void skipCharacter(String str,char del,int i){
        // Base case
        if(i==str.length()){
            StringBuilder sb = new StringBuilder();
            for(int idx=0;idx<list.size();idx++){
                sb.append(list.get(idx));//dont use list.remove(idx) then problem - list tar theke prothom iteration e ele at idx 0 remove hochche niye ele at idx 1 becomes ele at idx 0 tai jonno next iteartion e jokhon we are asking for ele at idx 1 so the ele at idx 0 is getting skipped.
            }
            System.out.println(sb.toString());
            return;
        }
        // Work
        if(str.charAt(i)!=del){
            list.add(str.charAt(i));
        }
        // Recursion call
        skipCharacter(str, del, i+1);
    }
}