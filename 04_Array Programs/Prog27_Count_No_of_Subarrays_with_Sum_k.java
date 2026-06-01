import java.util.HashMap;
import java.util.Map;

public class Prog27_Count_No_of_Subarrays_with_Sum_k {
    // Brute
    static int funct1(int[] arr, int K){
        int n = arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                if(sum==K){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    // Better Brute
    static int funct2(int[] arr, int k){
        int n = arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    // Optimal
    static int funct3(int[] arr, int k){
        int n=arr.length;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int prefixSum=0;
        int cnt=0;//will store all the subarrays with sum k in the entire array
        for(int i=0;i<n;i++){
            prefixSum+=arr[i];
            int remove = prefixSum-k;
            cnt+=mp.getOrDefault(remove, 0);//how many times prefixSum-k to be removed occurs = no. of times the subarray with sum k ending at idx i occurs. So add that to cnt which stores total no. of subarrays with sum k in the entire array
            mp.put(prefixSum,mp.getOrDefault(prefixSum, 0)+1);//Put prefixSum and no. of times current prefixSum occurs. If it occured before increase the existing count else create a new key with cnt=1
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int k=3;
        System.out.println(funct1(arr, k));
        System.out.println(funct2(arr, k));
        System.out.println(funct3(arr, k));
    }
}
