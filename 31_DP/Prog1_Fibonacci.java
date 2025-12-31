public class Prog1_Fibonacci{
    //Recursion
    // TC = O(2ⁿ) (Exponential), SC=O(N)
    static int fibo1(int n){
        if(n<=1){
            return n;
        }
        return fibo1(n-1)+fibo1(n-2);
    }
    //Memoization
    //TC=O(N), SC=O(N)+O(N)
    static int fibo2(int n,int[] dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n] = fibo2(n-1,dp)+fibo2(n-2,dp);
    }
    // Tabulation
    //TC=O(N), SC=O(N)
    static int fibo3(int n,int[] dp){
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // Space Optimization on Tabulation
    //TC=O(N), SC=O(1)
    static int fibo4(int n){
        int prev2=0;
        int prev=1;
        int curri;
        for(int i=2;i<=n;i++){
            curri = prev+prev2;
            prev2=prev;
            prev=curri;
        }
        return prev;
    }
    public static void main(String[] args){
        int n=5;
        int dp[] = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        System.out.println(fibo1(n));
        System.out.println(fibo2(n,dp));
        System.out.println(fibo3(n,dp));
        System.out.println(fibo4(n));
    }
}

/*
For Recursion
TC = O(2ⁿ) (Exponential)
Why?
Each call makes two more calls
The same values are recomputed again and again
Call tree grows like a binary tree 

SC = O(N)
Why?
Due to recursive call stack
Maximum depth of recursion = n
No extra arrays used*/