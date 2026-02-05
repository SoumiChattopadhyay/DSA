import java.util.Arrays;

public class Prog15_Subset_Sum_equal_to_K {
    // Recursion
    static boolean funct(int ind, int target, int[] arr){
        //Base Cases
        if(target==0) return true;
        if(ind==0) return arr[ind]==target;

        boolean nottake = funct(ind-1, target, arr);
        boolean take=false;
        if(arr[ind]<=target)
            take = funct(ind-1, target-arr[ind], arr);

        return nottake || take;
    }
    // Memoization
    static boolean funct2(int ind, int target, int[][] dp, int[] arr){
        //Base Cases
        if(target==0) return true;
        if(ind==0) return arr[ind]==target;
        if(dp[ind][target]!=-1) return dp[ind][target]==1;

        boolean nottake = funct2(ind-1, target,dp, arr);
        boolean take=false;
        if(arr[ind]<=target)
            take = funct2(ind-1, target-arr[ind], dp, arr);

        dp[ind][target]=(nottake || take)?1:0;
        return nottake || take;
    }
    // Tabulation
     static boolean funct3(int N, int K, boolean[][] dp, int[] arr){
        //Base Cases
        for(int i=0;i<=N-1;i++) 
            dp[i][0]=true;
        if(arr[0]<=K) dp[0][arr[0]]=true;
        
        for(int ind=1;ind<=N-1;ind++){
            for(int target=1;target<=K;target++){
                boolean nottake = dp[ind-1][target];
                boolean take=false;
                if(target>=arr[ind])
                    take = dp[ind-1][target-arr[ind]];

                dp[ind][target]=(nottake || take);
            }
        }
        return dp[N-1][K];
    }
    // Space Optimization
     static boolean funct4(int N, int K, int[] arr){
        boolean[] prevRow= new boolean[K+1];
        boolean[] currRow=new boolean[K+1];
        //Base Cases
        prevRow[0]=currRow[0]=true;//for any row, target 0 (0th idx) has to be true
        if(arr[0]<=K) prevRow[arr[0]]=true;
        
        for(int ind=1;ind<=N-1;ind++){
            currRow = new boolean[K+1];   // reset
            currRow[0] = true;
            for(int target=1;target<=K;target++){
                boolean nottake = prevRow[target];
                boolean take=false;
                if(target>=arr[ind])
                    take = prevRow[target-arr[ind]];

                currRow[target]=(nottake || take);
            }
            prevRow=currRow;
        }
        return prevRow[K];
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,1};
        int K=4;
        int N = arr.length;
        System.out.println(funct(N-1, K, arr));

        int[][] dp = new int[N][K+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<=K;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(N-1, K, dp, arr));
        System.out.println("Printing the dp array:");
        for(int[] ar:dp){
            System.out.println(Arrays.toString(ar));
        }

        boolean dp2[][] = new boolean[N][K+1];
        System.out.println(funct3(N, K, dp2, arr));
        System.out.println(funct4(N, K, arr));
    }
}
