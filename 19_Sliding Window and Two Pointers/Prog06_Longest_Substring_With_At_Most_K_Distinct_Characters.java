import java.util.HashMap;
import java.util.Map;

public class Prog06_Longest_Substring_With_At_Most_K_Distinct_Characters {
    // Brute
    static int funct1(String str, int k){
        int n=str.length();
        int maxLen=0;
        for(int i=0;i<n;i++){
            Map<Character,Integer> map = new HashMap<>();
            for(int j=i;j<n;j++){
                map.put(str.charAt(j),map.getOrDefault(str.charAt(j), 0)+1);
                if(map.size()<=k){
                    int len = j-i+1;
                    maxLen = Math.max(maxLen, len);
                }
                else break; 
            }
        }
        return maxLen;
    }
    //Better
    static int funct2(String str, int k){
        int n=str.length();
        int l=0,r=0,maxLen=0;
        Map<Character,Integer> map = new HashMap<>();
        while(r<n){
            map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0)+1);
            while(map.size()>k) {
                map.put(str.charAt(l), map.get(str.charAt(l))-1);
                if(map.get(str.charAt(l))==0){
                    map.remove(str.charAt(l));
                }
                l++;
            }
            if(map.size()<=k){
                int len = r-l+1;
                maxLen = Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }
    //Optimal
    static int funct3(String str, int k){
        int n=str.length();
        int l=0,r=0,maxLen=0;
        Map<Character,Integer> map = new HashMap<>();
        while(r<n){
            map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0)+1);
            if(map.size()>k) {
                map.put(str.charAt(l), map.get(str.charAt(l))-1);
                if(map.get(str.charAt(l))==0){
                    map.remove(str.charAt(l));
                }
                l++;
            }
            if(map.size()<=k){
                int len = r-l+1;
                maxLen = Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "aaabbccd";
        int k=2;
        System.out.println(funct1(s, k));
        System.out.println(funct2(s, k));
        System.out.println(funct3(s, k));
    }
}
