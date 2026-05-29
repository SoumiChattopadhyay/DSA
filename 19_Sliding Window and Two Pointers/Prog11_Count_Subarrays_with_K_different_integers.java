import java.util.HashMap;
import java.util.Map;

public class Prog11_Count_Subarrays_with_K_different_integers {
    // Brute
    static int funct1(int[] arr, int k){
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=i;j<n;j++){
                map.put(arr[j],map.getOrDefault(arr[j], 0)+1);
                if(map.size()==k){
                    cnt++;
                }
                else if(map.size()>k){
                    break;
                }
            }
        }
        return cnt;
    }
    // Optimal
    static int funct2(int[] arr, int k){
        return funct(arr, k) - funct(arr, k-1);
    }
    // Counts no. of subarrays with different integers <= k
    static int funct(int[] arr, int k){
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int l=0,r=0,cnt=0;
        while(r<n){
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);
            while(map.size()>k){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0) map.remove(arr[l]);
                l++;
            }
            if(map.size()<=k){
                cnt+=(r-l+1);
            }
            r++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4};
        int k=3;
        System.out.println(funct1(arr, k));
        System.out.println(funct2(arr, k));
    }
}
