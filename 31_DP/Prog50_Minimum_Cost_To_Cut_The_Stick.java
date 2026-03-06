import java.util.Arrays;

public class Prog50_Minimum_Cost_To_Cut_The_Stick {
    // Recursion
    static int funct1(int i, int j, int[] cuts, int n){
        // Base Case
        if(i>j) return 0;

        int mini=(int)1e9;
        for(int ind=i;ind<=j;ind++){
            int cost = cuts[j+1]-cuts[i-1]
                        + funct1(i, ind-1, cuts, n)
                        + funct1(ind+1, j, cuts, n);
            if(cost<mini) mini=cost;
        }
        return mini;
    }
    static int helper(int[] cuts, int n){
        Arrays.sort(cuts);
        int c=cuts.length;
        int[] newcuts = new int[c+2];
        newcuts[0]=0;
        newcuts[c+1]=n;
        for(int i=0;i<c;i++)
            newcuts[i+1]=cuts[i];

        return funct1(1, c, newcuts, n);
    }
    // Memoization
    static int funct2(int i, int j, int[][] dp, int[] cuts, int n){
        // Base Cases
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int mini=(int)1e9;
        for(int ind=i;ind<=j;ind++){
            int cost = cuts[j+1]-cuts[i-1]
                        + funct2(i, ind-1, dp, cuts, n)
                        + funct2(ind+1, j, dp, cuts, n);
            if(cost<mini) mini=cost;
        }
        return dp[i][j]=mini;
    }
    static int helper2(int[] cuts, int n){
        Arrays.sort(cuts);
        int c = cuts.length;
        int[] newcuts = new int[c+2];
        newcuts[0]=0;
        newcuts[c+1]=n;
        for(int i=0;i<c;i++)
            newcuts[i+1] = cuts[i];
        
        int[][] dp = new int[c+1][c+1];
        for(int i=1;i<=c;i++){
            for(int j=1;j<=c;j++){
                dp[i][j]=-1;
            }
        }
        return funct2(1, c, dp, newcuts, n);
    }

    // Tabulation
    static int funct3(int c, int[][] dp, int[] cuts, int n){
        // Base Case (not needed if u initialize dp array with 0)
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) dp[i][j]=0;
            }
        }

        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                int mini=(int)1e9;
                for(int ind=i;ind<=j;ind++){
                    int cost = cuts[j+1]-cuts[i-1]
                                + dp[i][ind-1]
                                + dp[ind+1][j];
                    if(cost<mini) mini=cost;
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][c];
    }
    static int helper3(int[] cuts, int n){
        Arrays.sort(cuts);
        int c = cuts.length;
        int[] newcuts = new int[c+2];
        newcuts[0]=0;
        newcuts[c+1]=n;
        for(int i=0;i<c;i++)
            newcuts[i+1] = cuts[i];
        
        int[][] dp = new int[c+2][c+2];

        return funct3(c, dp, newcuts, n);
    }
    public static void main(String[] args) {
        int[] cuts = {1,3,4,5};
        int n=7;//stick length
        System.out.println(helper(cuts, n));
        System.out.println(helper2(cuts, n));
        System.out.println(helper3(cuts, n));
    }
}
/*
for(int i=c;i>=1;i--){
    for(int j=i;j<=c;j++){
Start j loop from i
Why? Because we only care about valid segments (i ≤ j).

This avoids unnecessary checks. */