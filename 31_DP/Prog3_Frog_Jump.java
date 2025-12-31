// Given a number of stairs(N) and a frog, 
// the frog wants to climb from the 0th stair to the (N-1)th stair. 
// At a time the frog can climb either one or two steps. 
// A height[N] array is also given where height[i] is the height of ith stair. 
// Whenever the frog jumps from a stair i to stair j, the energy consumed 
// in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. 
// We need to return the minimum energy that can be used by the frog 
// to jump from stair 0 to stair N-1.

public class Prog3_Frog_Jump {
    // Recursion
    static int funct(int n,int[] heights){
        int right=Integer.MAX_VALUE;
        if(n==0) return 0;
        int left = funct(n-1,heights)+Math.abs(heights[n]-heights[n-1]);
        if(n>1)
            right = funct(n-2,heights)+Math.abs(heights[n]-heights[n-2]);
        return Math.min(left,right);
    }
    // Memoization
    // TC=O(n), SC=O(n)+O(n)
    static int funct2(int n,int[] heights,int[] dp){
        int right=Integer.MAX_VALUE;
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left = funct2(n-1,heights,dp)+Math.abs(heights[n]-heights[n-1]);
        if(n>1)
            right = funct2(n-2,heights,dp)+Math.abs(heights[n]-heights[n-2]);
        return dp[n]=Math.min(left,right);
    }
    // Tabulation
    static int funct3(int n,int[] heights,int[] dp){
        dp[0]=0;
        dp[1]=dp[0]+Math.abs(heights[1]-heights[0]);
        for(int i=2;i<=n;i++){
            int left = dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            int right = dp[i-2]+Math.abs(heights[i]-heights[i-2]);
            dp[i]=Math.min(left,right);
        }
        return dp[n];
    }
    // Space Optimization
    static int funct4(int n,int[] heights){
        int prev2=0;
        int prev=prev2+Math.abs(heights[1]-heights[0]);
        for(int i=2;i<=n;i++){
            int left = prev + Math.abs(heights[i]-heights[i-1]);
            int right = prev2 + Math.abs(heights[i]-heights[i-2]);
            int curr = Math.min(left,right);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    // When only heights is passed as parameter
    // We must include edge cases coz n is not given
    // Space Optimization
    static int minCost(int[] heights) {
        // code here
        int n=heights.length-1;
        if(n==0) return 0;
        if(n==1) return Math.abs(heights[1]-heights[0]);
        int prev2=0;
        int prev=prev2+Math.abs(heights[1]-heights[0]);
        for(int i=2;i<=n;i++){
            int left = prev + Math.abs(heights[i]-heights[i-1]);
            int right = prev2 + Math.abs(heights[i]-heights[i-2]);
            int curr = Math.min(left,right);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] heights = new int[]{30,10,60,10,60,50};
        int n = heights.length-1;//the topmost stair
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=-1;
        System.out.println(funct(n,heights));
        System.out.println(funct2(n,heights,dp));
        System.out.println(funct3(n,heights,dp));
        System.out.println(funct4(n,heights));
    }
}
