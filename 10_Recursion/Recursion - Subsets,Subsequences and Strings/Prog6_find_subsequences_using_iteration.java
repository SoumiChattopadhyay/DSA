import java.util.ArrayList;
import java.util.List;
public class Prog6_find_subsequences_using_iteration {
    public static void main(String[] args) {
        subseq("abc");
    }
    static void subseq(String str){
        List<List<Character>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i=0;i<str.length();i++){
            int n=outer.size();
            for(int j=0;j<n;j++){
                List<Character> inner = new ArrayList<>(outer.get(j));
                inner.add(str.charAt(i));
                outer.add(inner);
            }
        }
        System.out.println(outer);
    }
}
