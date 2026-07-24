public class Prog55_Partition_Array_for_Maximum_Sum {//Using Front Partition
    // Recursion
    static int funct1(int ind, int[] arr, int k, int n){
        // Base Case
        if(ind==n) return 0;

        int len=0, maxi=Integer.MIN_VALUE, sum, maxAns=Integer.MIN_VALUE;
        for(int j=ind;j<Math.min(n,ind+k);j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            sum = (len*maxi)+funct1(j+1, arr, k, n);
            maxAns = Math.max(maxAns,sum);
        }
        
        return maxAns;
    }
    static int helper1(int[] arr, int k){
        int n = arr.length;
        return funct1(0, arr, k, n);
    }

    // Memoization
    static int funct2(int ind, int[] dp, int[] arr, int k, int n){
        // Base Cases
        if(ind==n) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int len=0, maxi=Integer.MIN_VALUE, maxAns=Integer.MIN_VALUE;
        for(int j=ind;j<Math.min(n,ind+k);j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            int sum = (len*maxi)+funct2(j+1, dp, arr, k, n);
            maxAns = Math.max(maxAns,sum);
        }
        
        return dp[ind]=maxAns;
    }
    static int helper2(int[] arr, int k){
        int n = arr.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++)
            dp[i]=-1;
        return funct2(0, dp, arr, k, n);
    }

    // Tabulation
    static int funct3(int[] dp, int[] arr, int k, int n){
        // Base Case
        dp[n]=0;

        for(int ind=n-1;ind>=0;ind--){
            int len=0, maxi=Integer.MIN_VALUE, maxAns=Integer.MIN_VALUE;
            for(int j=ind;j<Math.min(n,ind+k);j++){
                len++;
                maxi = Math.max(maxi,arr[j]);
                int sum = (len*maxi)+dp[j+1];
                maxAns = Math.max(maxAns,sum);
            }
            dp[ind]=maxAns;
        }

        return dp[0];
    }
    static int helper3(int[] arr, int k){
        int n = arr.length;
        int[] dp = new int[n+1];
        return funct3(dp, arr, k, n);
    }
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k=3;
        System.out.println(helper1(arr,k));
        System.out.println(helper2(arr,k));
        System.out.println(helper3(arr,k));
    }
}