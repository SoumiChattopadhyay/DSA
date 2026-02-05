public class Prog24_Unbounded_Knapsack {
    // Recursion
    static int funct1(int ind, int bagWt, int[] wts, int[] vals){
        // Base Case
        if(ind==0){ 
            return (bagWt/wts[ind])*vals[ind];
        }
        int nottake = 0 + funct1(ind-1, bagWt, wts, vals);
        int take = Integer.MIN_VALUE;
        if(wts[ind]<=bagWt){
            take = vals[ind] + funct1(ind, bagWt-wts[ind], wts, vals);//stand at the same index becoz infinite supply problem
        }
        return Math.max(take,nottake);
    }
    // Memoization
    static int funct2(int ind, int bagWt,int[][] dp, int[] wts, int[] vals){
        // Base Case
        if(ind==0){ 
            return (bagWt/wts[ind])*vals[ind];
        }
        if(dp[ind][bagWt]!=-1) return dp[ind][bagWt];

        int nottake = 0 + funct2(ind-1, bagWt,dp, wts, vals);
        int take = Integer.MIN_VALUE;
        if(wts[ind]<=bagWt){
            take = vals[ind] + funct2(ind, bagWt-wts[ind],dp, wts, vals);//stand at the same index becoz infinite supply problem
        }
        return dp[ind][bagWt]=Math.max(take,nottake);
    }
    // Tabulation
    static int funct3(int N, int bagWt,int[][] dp, int[] wts, int[] vals){
        // Base Case
        for(int w=0;w<=bagWt;w++){
            dp[0][w] = (w/wts[0])*vals[0];
        }

        for(int ind=1;ind<N;ind++){
            for(int w=0;w<=bagWt;w++){
                int nottake = 0 + dp[ind-1][w];
                int take = Integer.MIN_VALUE;
                if(wts[ind]<=w){
                    take = vals[ind] + dp[ind][w-wts[ind]];//stand at the same index becoz infinite supply problem
                }
                dp[ind][w] = Math.max(nottake,take);
            }
        }
        
        return dp[N-1][bagWt];
    }
    // Space Optimization
    static int funct4(int N, int bagWt, int[] wts, int[] vals){
        int[] prevRow = new int[bagWt+1];
        // Base Case
        for(int w=0;w<=bagWt;w++){
            prevRow[w] = (w/wts[0])*vals[0];
        }

        for(int ind=1;ind<N;ind++){
            int[] currRow = new int[bagWt+1];
            for(int w=0;w<=bagWt;w++){
                int nottake = 0 + prevRow[w];
                int take = Integer.MIN_VALUE;
                if(wts[ind]<=w){
                    take = vals[ind] + currRow[w-wts[ind]];//stand at the same index becoz infinite supply problem
                }
                currRow[w] = Math.max(nottake,take);
            }
            prevRow=currRow;
        }
        
        return prevRow[bagWt];
    }
    // 1-Row Space Optimization
    static int funct5(int N, int bagWt, int[] wts, int[] vals){
        int[] prevRow = new int[bagWt+1];
        // Base Case
        for(int w=0;w<=bagWt;w++){
            prevRow[w] = (w/wts[0])*vals[0];
        }

        for(int ind=1;ind<N;ind++){
            for(int w=0;w<=bagWt;w++){
                int nottake = 0 + prevRow[w];
                int take = Integer.MIN_VALUE;
                if(wts[ind]<=w){
                    take = vals[ind] + prevRow[w-wts[ind]];//stand at the same index becoz infinite supply problem
                }
                prevRow[w] = Math.max(nottake,take);
            }
        }
        
        return prevRow[bagWt];
    }
    public static void main(String[] args) {
        int bagWt = 10;
        int[] wts = {2,4,6};
        int[] vals = {5,11,13};
        int N = vals.length;
        System.out.println(funct1(N-1, bagWt, wts, vals));

        int[][] dp = new int[N][bagWt+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<=bagWt;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(N-1, bagWt,dp,wts,vals));

        dp = new int[N][bagWt+1];
        System.out.println(funct3(N, bagWt,dp,wts,vals));
        System.out.println(funct4(N, bagWt,wts,vals));
        System.out.println(funct5(N, bagWt,wts,vals));
    }
}
