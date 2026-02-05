public class Prog26_Longest_Common_Subsequence {
    // Recursion
    static int funct1(int ind1, int ind2, String str1, String str2){
        // Base cases
        if(ind1<0 || ind2<0){
            return 0;
        }

        // Match case
        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return 1 + funct1(ind1-1, ind2-1, str1, str2);
        }
        // Non-Match case
        else return 0 + Math.max(funct1(ind1-1,ind2,str1,str2),funct1(ind1,ind2-1,str1,str2));
    }
    // Memoization
     static int funct2(int ind1, int ind2,int[][] dp, String str1, String str2){
        // Base cases
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        // Match case
        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return 1 + funct2(ind1-1, ind2-1,dp, str1, str2);
        }
        // Non-Match case
        else return dp[ind1][ind2] = 0 + Math.max(funct2(ind1-1,ind2,dp,str1,str2),funct2(ind1,ind2-1,dp,str1,str2));
    }
    // Tabulation
    static int funct3(int N, int M,int[][] dp, String str1, String str2){
        // if we dont initialize dp array with -1 the below base case code is not needed
        // Base cases
        for(int ind1=0;ind1<=N;ind1++) dp[ind1][0]=0;
        for(int ind2=0;ind2<=M;ind2++) dp[0][ind2]=0;
        
        for(int ind1=1;ind1<=N;ind1++){
            for(int ind2=1;ind2<=M;ind2++){
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){//Your DP table is 1-indexed, but Java strings are 0-indexed.
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }else{
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
       return dp[N][M];
    }
    // Space Optimization
    static int funct4(int N, int M, String str1, String str2){
        int[] prevRow = new int[M+1];
        int[] currRow = new int[M+1];
        // Base cases
        // idx 0 in dp array represents idx -1 in strings
        for(int ind2=0;ind2<=M;ind2++) prevRow[ind2]=0;//only needed if you initialize dp array with -1. if you initialize it with 0 then not needed
        
        for(int ind1=1;ind1<=N;ind1++){
            currRow = new int[M+1];
            prevRow[0]=currRow[0]=0;//only needed if you initialize dp array with -1. if you initialize it with 0 then not needed
            for(int ind2=1;ind2<=M;ind2++){
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){//Your DP table is 1-indexed, but Java strings are 0-indexed.
                    currRow[ind2] = 1 + prevRow[ind2-1];
                }else{
                    currRow[ind2] = 0 + Math.max(prevRow[ind2],currRow[ind2-1]);
                }
            }
            prevRow=currRow;
        }
       return prevRow[M];
    }

    public static void main(String[] args) {
        String str1 = "acd";
        String str2 = "ced";
        int N = str1.length();
        int M = str2.length();
        System.out.println(funct1(N-1, M-1, str1, str2));


        int[][] dp = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(N-1, M-1, dp, str1, str2));

        dp = new int[N+1][M+1];
        System.out.println(funct3(N, M, dp, str1, str2));
        System.out.println(funct4(N, M, str1, str2));
    }
}
