import java.util.Arrays;
import java.util.Comparator;

public class Prog46_Longest_String_Chain {
    static boolean compare(String s1, String s2){
        if(s1.length()!=s2.length()+1) return false;//length matching, if s1 is not the greater guy return false
        int first=0;
        int second=0;
        while(first<s1.length()){
            if(second<s2.length() && s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        if(first==s1.length() && second==s2.length())
            return true;
        return false;
    }
    static Comparator<String> comp(){
        return new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return s1.length()-s2.length();
            }
        };
    }
    static int funct(String[] arr, int n){
        // Arrays.sort(arr,(s1,s2)->s1.length()-s2.length());
        Arrays.sort(arr,comp());
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }// or use Arrays.fill(dp, 1);
        int maxi=1;
        for(int ind=0;ind<n;ind++){
            for(int prev_ind=0;prev_ind<=ind-1;prev_ind++){
                if(compare(arr[ind],arr[prev_ind]) && 1+dp[prev_ind]>dp[ind]){
                    dp[ind]=1+dp[prev_ind];
                }
            }
            if(dp[ind]>maxi){
                maxi=dp[ind];
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        String[] arr = {"a","b","ba","bca","bda","bdca"};
        int n = arr.length;
        System.out.println(funct(arr, n));

        arr = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
        n = arr.length;
        System.out.println(funct(arr, n));
    }
}
