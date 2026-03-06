import java.util.Arrays;

public class Prog45_Longest_Divisible_Subset {
    // Return the LDS
    static int[] funct6(int[] arr, int n){
        Arrays.sort(arr);
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            hash[i]=i;
        }
        int maxi=1;
        int lastIdx=0;
        for(int ind=0;ind<n;ind++){
            for(int prev_ind=0;prev_ind<=ind-1;prev_ind++){
                if(arr[ind]%arr[prev_ind]==0 && 1+dp[prev_ind]>dp[ind]){
                    dp[ind]=1+dp[prev_ind];
                    hash[ind]=prev_ind;
                }
            }
            if(dp[ind]>maxi){
                maxi=dp[ind];
                lastIdx=ind;
            }
        }
        int[] lds = new int[maxi];
        lds[maxi-1]=arr[lastIdx];
        int ind=maxi-2;
        while(hash[lastIdx]!=lastIdx){
            lastIdx=hash[lastIdx];
            lds[ind--]=arr[lastIdx];
        }
        
        return lds;
    }
    public static void main(String[] args) {
        int[] arr = {1,16,7,8,4};
        int n = arr.length;
        System.out.println(Arrays.toString(funct6(arr, n)));
    }
}
