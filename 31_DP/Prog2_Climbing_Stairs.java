// You have been given a number of stairs. Initially you are at the 0th stair,
// and you need to reach the nth stair. Each time you can either climb one step or two steps.
// You are supposed to return the no. of distinct ways in which you can climb from the 0th step To nth step.
public class Prog2_Climbing_Stairs {
    static int countWays(int n){
        if(n<=1) return 1;
        int left = countWays(n-1);
        int right = countWays(n-2);
        return left+right;
    }
    // Memoization
    static int countWays2(int n,int[] dp){
        if(n<=1)return 1;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=countWays2(n-1,dp)+countWays2(n-2,dp);
    }
    // Tabulation
    static int countWays3(int n,int[] dp){
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //Space Optimization
    static int countWays4(int n){
        int prev2=1;
        int prev=1;
        int curr;
        for(int i=2;i<=n;i++){
            curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int n=3;
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        System.out.println(countWays(n));
        System.out.println(countWays2(n,dp));
        System.out.println(countWays3(n,dp));
        System.out.println(countWays4(n));
    }
}
