import java.util.Arrays;

public class Prog20_0_1_Knapsack {
    // Recursion
    // TC=O(2^n), SC=O(n)
    static int funct1(int ind, int W, int[] values, int[] weights){
        // Base Cases
        if(ind==0){
            if(weights[0]<=W) return values[0];
            else return 0;
        }
        int nottake = 0 + funct1(ind-1, W, values, weights);
        int take = Integer.MIN_VALUE;//so that take combination is not taken if weight[ind]>bag weight
        if(weights[ind]<=W){
            take = values[ind] + funct1(ind-1, W-weights[ind], values, weights);
        }
        return Math.max(nottake,take);
    }
    // Memoization
    static int funct2(int ind, int W,int[][] dp, int[] values, int[] weights){
        // Base Cases
        if(ind==0){
            if(weights[0]<=W) return values[0];
            else return 0;
        }
        if(dp[ind][W]!=-1) return dp[ind][W];

        int nottake = 0 + funct2(ind-1, W,dp, values, weights);
        int take = Integer.MIN_VALUE;//so that take combination is not taken if weight[ind]>bag weight
        if(weights[ind]<=W){
            take = values[ind] + funct2(ind-1, W-weights[ind],dp, values, weights);
        }
        return dp[ind][W] = Math.max(nottake,take);
    }
    // Tabulation
    static int funct3(int N, int W,int[][] dp, int[] values, int[] weights){
        // Base Cases
        // for(int bagWt=0;bagWt<=W;bagWt++){
        //     if(weights[0]<=bagWt)
        //         dp[0][bagWt]=values[0];
        // }
        for(int bagWt=weights[0];bagWt<=W;bagWt++){
            dp[0][bagWt] = values[0];
        }
        for(int ind=1;ind<N;ind++){
            for(int bagWt=0;bagWt<=W;bagWt++){
                int nottake = 0 + dp[ind-1][bagWt];
                int take = Integer.MIN_VALUE;
                if(weights[ind]<=bagWt){
                    take = values[ind] + dp[ind-1][bagWt-weights[ind]];
                }
                dp[ind][bagWt] = Math.max(nottake,take);
            }
        }
        return dp[N-1][W];
    }
    // 2-Row Space Optimization
    static int funct4(int N, int W,int[] values, int[] weights){
        int[] prevRow = new int[W+1];
        int[] currRow;
        for(int bagWt=weights[0];bagWt<=W;bagWt++){
            prevRow[bagWt] = values[0];
        }
        for(int ind=1;ind<N;ind++){
            currRow = new int[W+1];
            for(int bagWt=0;bagWt<=W;bagWt++){
                int nottake = 0 + prevRow[bagWt];
                int take = Integer.MIN_VALUE;
                if(weights[ind]<=bagWt){
                    take = values[ind] + prevRow[bagWt-weights[ind]];
                }
                currRow[bagWt] = Math.max(nottake,take);
            }
            prevRow=currRow;
        }
        return prevRow[W];
    }
    // 1-Row Space Optimization
    static int funct5(int N, int W,int[] values, int[] weights){
        int[] prevRow = new int[W+1];
        for(int bagWt=weights[0];bagWt<=W;bagWt++){
            prevRow[bagWt] = values[0];
        }
        for(int ind=1;ind<N;ind++){
            for(int bagWt=W;bagWt>=0;bagWt--){
                int nottake = 0 + prevRow[bagWt];
                int take = Integer.MIN_VALUE;
                if(weights[ind]<=bagWt){
                    take = values[ind] + prevRow[bagWt-weights[ind]];
                }
                prevRow[bagWt] = Math.max(nottake,take);
            }
        }
        return prevRow[W];
    }
    public static void main(String[] args) {
        int[] values = {30,40,60};
        int[] weights = {2,3,5};
        int bagWt = 6;
        int n = values.length;//or weights.length-1
        System.out.println(funct1(n-1, bagWt, values, weights));

        int[][] dp = new int[n][bagWt+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=bagWt;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(n-1, bagWt, dp, values, weights));

        dp = new int[n][bagWt+1];//reinitialise each el to 0
        System.out.println(funct3(n, bagWt, dp, values, weights));
       
        System.out.println(funct4(n, bagWt, values, weights));

        System.out.println(funct5(n, bagWt, values, weights));
        
        System.out.println("Printing the dp table:");
        for(int[] arr:dp){
            System.out.println(Arrays.toString(arr));
        }
    }

    
}
