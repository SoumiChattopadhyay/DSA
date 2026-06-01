import java.util.HashMap;
import java.util.Map;

public class Prog26_Longest_Subarray_with_Sum_k{
    // Brute Force
    static int funct1(int[] arr, int K){
        int n=arr.length;
        int maxLength=0;
        // Generate all subarrays code
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                if(sum==K){
                    maxLength = Math.max(j-i+1,maxLength);
                }
            }
        }
        return maxLength;
    }
    // Better Brute Force
    static int funct2(int[] arr, int K){
        int n=arr.length;
        int maxLength=0;
        // Generate all subarrays code
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==K){
                    maxLength = Math.max(j-i+1,maxLength);
                }
            }
        }
        return maxLength;
    }
    // Better Solution
    static int funct3(int[] arr, int K){
        int n=arr.length;
        Map<Long,Integer> mp = new HashMap<>();
        long prefixSum=0;
        int maxLen=0;
        for(int i=0;i<n;i++){
            prefixSum+=arr[i];
            if(prefixSum==K){
                maxLen = Math.max(maxLen,i+1);
            }
            if(mp.containsKey(prefixSum-K)){//check if subarray with sum (x-k) exists in map
                int len = i-mp.get(prefixSum-K); // len of subarray with sum k
                maxLen = Math.max(maxLen,len);
            }
            if(!mp.containsKey(prefixSum)){
                mp.put(prefixSum,i);
            }
        }
        return maxLen;
    }
    // Optimal Solution
    static int funct4(int[] arr, int K){
        int n=arr.length;
        int left=0, right=0;
        long sum=arr[0];
        int maxLen=0;
        while(right<n){
            while(left<=right && sum>K){//left must not cross right then theres no point in doing this
                sum-=arr[left];
                left++;//first subtract value then move left pointer
            }
            if(sum==K){
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;//first we have to move right pointer then add value so we cant place sum+=arr[right] line before so we need the edge case
            if(right<n) sum+=arr[right];
        }
        return maxLen;
    }
    public static void main(String[] args) {
        // int[] arr={1,2,3,1,1,1,1,4,2,3};//Array having only positives
        int[] arr={2,0,0,3};
        int K=3;
        System.out.println(funct1(arr, K));
        System.out.println(funct2(arr, K));
        System.out.println(funct3(arr, K));
        System.out.println(funct4(arr, K));
    }
}
