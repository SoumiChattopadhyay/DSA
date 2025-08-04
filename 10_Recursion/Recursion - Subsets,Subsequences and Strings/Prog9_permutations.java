import java.util.ArrayList;
public class Prog9_permutations {
    public static void main(String[] args) {
        permutations("abc", "");
        System.out.println(permutations2("abc", ""));
        System.out.println(permutationsCount("abc", "")); // 3! = 3*2*1 = 6
    }
    static void permutations(String up, String p){//up="abc",p=""
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        // No. of recursion calls = length of processed string+1
        for(int i=0;i<=p.length();i++){//character can be inserted in beginning, anywhere in between and in end. In substring method the 2nd no isnt inclusive its exclusive
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            permutations(up.substring(1), f+ch+s);//processed string would give u the permutation when unprocessed string==""
        }
    }
    static ArrayList<String> permutations2(String up,String p){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch=up.charAt(0);
        // No. of recursion calls = length of processed string+1
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            ans.addAll(permutations2(up.substring(1), f+ch+s));
        }
        return ans;
    }
    static int permutationsCount(String up, String p){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;
        char ch=up.charAt(0);
        // No. of recursion calls = length of processed string+1
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            count = count + permutationsCount(up.substring(1), f+ch+s);
        }
        return count;
    }
} 