import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prog05_Fruit_into_Baskets {
    // Brute
    static int funct1(int[] arr, int baskets){
        int n=arr.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(arr[j]);
                if(set.size()<=baskets){
                    int len = j-i+1;
                    maxLen = Math.max(maxLen, len);
                }
                else break;
            }
        }
        return maxLen;
    }
    // Better
    static int funct2(int[] arr, int baskets){
        int n=arr.length;
        int l=0,r=0,maxLen=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r], 0)+1);
            while(map.size()>baskets){
                map.put(arr[l], map.get(arr[l])-1);
                if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                }
                l++;
            }
            if(map.size()<=baskets){
                int len = r-l+1;
                maxLen = Math.max(maxLen,len);
            }
            r++;
        }
        return maxLen;
    }
    // Optimal
    static int funct3(int[] arr, int baskets){
        int n=arr.length;
        int l=0,r=0,maxLen=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r], 0)+1);
            if(map.size()>baskets){
                map.put(arr[l], map.get(arr[l])-1);
                if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                }
                l++;
            }
            if(map.size()<=baskets){
                int len = r-l+1;
                maxLen = Math.max(maxLen,len);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        int baskets=2;
        System.out.println(funct1(arr, baskets));
        System.out.println(funct2(arr, baskets));
        System.out.println(funct3(arr, baskets));
    }
}
