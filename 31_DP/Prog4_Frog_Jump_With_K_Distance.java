import java.util.ArrayList;
import java.util.List;

public class Prog4_Frog_Jump_With_K_Distance {
    // Recursion
    // TC: O(kⁿ) (very slow)
    // SC: O(n) recursion stack
    static int funct(int n,int k,int[] heights){
        if(n==0) return 0;
        int minSteps=Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(n-j>=0)
                minSteps = Math.min(minSteps,funct(n-j,k,heights)+Math.abs(heights[n]-heights[n-j]));
        }
        return minSteps;
    }
    // Memoization
    // TC: O(n × k)
    // SC: O(n) dp + O(n) recursion stack
    static int funct2(int n,int k,int[] heights,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int minSteps=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(n-i>=0)
                minSteps=Math.min(minSteps,funct2(n-i, k, heights, dp)+Math.abs(heights[n]-heights[n-i]));
        }
        return dp[n]=minSteps;
    }
    // Tabulation
    // TC: O(n × k)
    // SC: O(n)
    static int funct3(int n,int k,int[] heights,int[] dp){
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    dp[i]=Math.min(dp[i],dp[i-j]+Math.abs(heights[i]-heights[i-j]));
                }
            }
        }
        return dp[n];
    }
    // Space Optimization(Not needed)
    static int funct4(int n,int k,int[] heights){
        List<Integer> ls = new ArrayList<>();
        ls.add(0);
        for(int i=1;i<=n;i++){
            int minSteps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0 && j<=ls.size()){
                    minSteps=Math.min(minSteps,ls.get(ls.size()-j)+Math.abs(heights[i]-heights[i-j]));
                }
            }
            ls.add(minSteps);
            // sliding window: keep last k dp values
            // remove only when window exceeds k
            if (ls.size() > k) {
                ls.remove(0);
            }
        }
        return ls.get(ls.size()-1);
    }
    public static void main(String[] args) {
        int[] heights = new int[]{30,10,60,10,60,50};
        int n = heights.length-1;//the topmost stair
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=-1;
        System.out.println(funct(n,3,heights));
        System.out.println(funct2(n,3,heights,dp));
        System.out.println(funct3(n,3,heights,dp));
        System.out.println(funct4(n,3,heights));
    }
}
