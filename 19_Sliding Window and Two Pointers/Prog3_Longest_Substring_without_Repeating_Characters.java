import java.util.HashMap;
import java.util.Map;

public class Prog3_Longest_Substring_without_Repeating_Characters{
    // Brute
    static int funct1(String str){
        int n=str.length();
        int maxLen=0;
        for(int i=0;i<n;i++){
            int[] hash = new int[256];
            for(int j=i;j<n;j++){
                if(hash[str.charAt(j)]==1) break;
                int len = j-i+1;//length of substring
                maxLen = Math.max(maxLen,len);
                hash[str.charAt(j)]=1;
            }
        }
        return maxLen;
    }
    // Better
    static int funct2(String str){
        int n=str.length();
        Map<Character,Integer> map = new HashMap<>();
        int l=0,r=0,maxLen=0;
        while(r<n){
            if(!map.containsKey(str.charAt(r)) || map.get(str.charAt(r))<l){
                int len = r-l+1;
                maxLen = Math.max(maxLen,len);
                map.put(str.charAt(r), r);
            }else{
                l = map.get(str.charAt(r))+1;
            }
            r++;
        }
        return maxLen;
    }
    // Optimal
    static int funct2_1(String str){
        int n=str.length();
        int[] hash = new int[256];
        for(int i=0;i<256;i++)hash[i]=-1;
        int l=0,r=0,maxLen=0;
        while(r<n){
           if(hash[str.charAt(r)]!=-1){
                if(hash[str.charAt(r)]>=l){
                    l = hash[str.charAt(r)]+1;
                }
           }
           int len = r-l+1;
           maxLen = Math.max(maxLen, len);
           hash[str.charAt(r)] = r;
           r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "cadbzabcd";
        System.out.println(funct1(str));
        System.out.println(funct2(str));
        System.out.println(funct2_1(str));
    }
}