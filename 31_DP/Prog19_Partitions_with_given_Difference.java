/*Given an array 'ARR', partition it into two subsets (possibly empty) 
such that their union is the original array. Let the sum of the elements of 
these two subsets be 'S1' and 'S2'.
Given a difference 'D', count the number of partitions in which 'S1' is 
greater than or equal to 'S2' and the difference between 'S1' and 'S2' is 
equal to 'D'.
Since the answer may be too large, return it modulo 10^9 + 7. */
public class Prog19_Partitions_with_given_Difference {
    
    static int mod = (int)(1e9+7);
    
    // Memoization
    static int funct(int ind, int tar,int[][] dp,int[] arr){
        // Base Cases
        if(ind==0){
            if(tar==0 && arr[ind]==0) return 2;
            if(tar==0 || tar==arr[ind]) return 1;
            return 0;
        }
        if(dp[ind][tar]!=-1) return dp[ind][tar];
        int notpick = funct(ind-1,tar,dp,arr);
        int pick=0;
        if(tar>=arr[ind]) pick = funct(ind-1,tar-arr[ind],dp,arr);
        return dp[ind][tar] = (pick+notpick) % mod;
    }

    // Tabulation
    static int funct2(int N, int tar,int[][] dp,int[] arr){
        // Base Cases
        if(arr[0]==0) dp[0][0]=2;//if tar=ar[0]=0 return 2
        else dp[0][0]=1;//if tar=0 but ar[0]!=0 return 1
        if(arr[0]!=0 && arr[0]<=tar) dp[0][arr[0]]=1;//if tar=arr[0]=5 then dp[0][arr[0]]=1 i.e. dp[0][5]=1        

        for(int ind=1;ind<N;ind++){
            for(int sum=0;sum<=tar;sum++){
                int notpick = dp[ind-1][sum];
                int pick=0;
                if(arr[ind]<=sum){
                    pick = dp[ind-1][sum-arr[ind]];
                }
                dp[ind][sum] = (pick + notpick) % mod;
            }
        }
        return dp[N-1][tar];
    }
    // Space Optimization
    static int funct3(int N, int tar,int[] arr){
        int[] prevRow = new int[tar+1];
        int[] currRow = new int[tar+1];
        // Base Cases
        if(arr[0]==0) prevRow[0]=2;//if tar=ar[0]=0 return 2
        else prevRow[0]=1;//if tar=0 but ar[0]!=0 return 1
        if(arr[0]!=0 && arr[0]<=tar) prevRow[arr[0]]=1;//if tar=arr[0]=5 then dp[0][arr[0]]=1 i.e. dp[0][5]=1        

        for(int ind=1;ind<N;ind++){
            currRow = new int[tar+1];
            for(int sum=0;sum<=tar;sum++){
                int notpick = prevRow[sum];
                int pick=0;
                if(arr[ind]<=sum){
                    pick = prevRow[sum-arr[ind]];
                }
                currRow[sum] = (pick + notpick) % mod;
            }
            prevRow=currRow;
        }
        return prevRow[tar];
    }
    static int countPartitions(int[] arr, int D){
        int totalSum=0;
        for(int el:arr) totalSum+=el;
        if((totalSum-D)<0 || (totalSum-D)%2!=0) return 0;

        int n=arr.length;
        int[][] dp = new int[n][(totalSum-D)/2+1];
        // return funct(n-1, (totalSum-D)/2, dp, arr);
        return funct2(n, (totalSum-D)/2, dp, arr);
        // return funct3(n-1, (totalSum-D)/2, arr);
    }
    public static void main(String[] args) {
        int[] arr = {5,2,6,4};
        int D=3;
        System.out.println(countPartitions(arr, D));
    }
}
