import java.util.ArrayList;
public class Prog3_find_subsequences {
// When dealing with strings, we always talk about subsequences, not subsets.Why?
// Because:
// A string is an ordered sequence of characters.
// When you extract parts of it without changing the order, you're generating subsequences.
// If you were to ignore order (like in sets), you'd lose the essence of a string.
    public static void main(String[] args) {
        findSubsequences("abc","");
        ArrayList<String> l = findSubsequences2("abc","");
        System.out.println(l);
    }
    static void findSubsequences(String str,String ans){
        if(str.isEmpty()){
            if(ans.isEmpty()){
                System.out.println("null");
                return;
            }
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0);
        findSubsequences(str.substring(1), ans+ch);//taking the character
        findSubsequences(str.substring(1), ans);//ignoring the character
    }
    // storing subsequences in ArrayList and returning it
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<String> findSubsequences2(String str,String ans){
        if(str.isEmpty()){
            if(ans.isEmpty()){
                list.add("null");
                return list;
            }
            list.add(ans);
            return list;
        }
        char ch=str.charAt(0);
        findSubsequences2(str.substring(1), ans+ch);
        findSubsequences2(str.substring(1), ans);
        return list;
    }

    // using ArrayList as local variable
    static ArrayList<String> findSubsequences3(String str,String ans){
        if(str.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(ans.isEmpty()){
                list.add("null");
                return list;
            }
            list.add(ans);
            return list;
        }
        char ch=str.charAt(0);
        ArrayList<String> left = findSubsequences2(str.substring(1), ans+ch);
        ArrayList<String> right = findSubsequences2(str.substring(1), ans);
        left.addAll(right);
        return left;
    }
}