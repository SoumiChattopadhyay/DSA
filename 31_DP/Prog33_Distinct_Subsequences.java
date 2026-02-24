public class Prog33_Distinct_Subsequences {
    // Recursion
    static int funct1(int i, int j,String s1, String s2){
        // Base Cases
        if(j<0) return 1;
        if(i<0) return 0;
        
        if(s1.charAt(i)==s2.charAt(j)){
            return funct1(i-1, j-1, s1, s2) + funct1(i-1, j, s1, s2);
        }else{
            return funct1(i-1, j, s1, s2);
        }
    }
    // Memoization
    static int funct2(int i, int j,int[][] dp,String s1, String s2){
        // Base Cases
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j)){
           return dp[i][j] = funct2(i-1, j-1, dp, s1, s2) + funct2(i-1, j, dp, s1, s2);
        }else{
            return dp[i][j] = funct2(i-1, j, dp, s1, s2);
        }
    }
    // Tabulation
    static int funct3(int N, int M,int[][] dp,String s1, String s2){
        // Base Cases
        for(int i=0;i<=N;i++) dp[i][0]=1;
        for(int j=1;j<=M;j++) dp[0][j]=0;//except dp[0][0] it must be 1
// j must start from 1 otherwise it will rewrite the previous for loop's 0 column
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[N][M];
    }
    // Space Optimization
    static int funct4(int N, int M,String s1, String s2){
        int[] prevRow = new int[M+1];
        int[] currRow = new int[M+1];
        // Base Cases
        prevRow[0]=1;
        for(int j=1;j<=M;j++) prevRow[j]=0;//except dp[0][0] it must be 1
// j must start from 1 otherwise it will rewrite the previous for loop's 0 column
        
        for(int i=1;i<=N;i++){
            currRow=new int[M+1];
            currRow[0]=1;
            for(int j=1;j<=M;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    currRow[j] = prevRow[j-1] + prevRow[j];
                }else{
                    currRow[j] = prevRow[j];
                }
            }
            prevRow=currRow;
        }
        
        return prevRow[M];
    }
    // 1-D Array Space Optimization
    static int funct5(int N, int M,String s1, String s2){
        int[] prevRow = new int[M+1];
        // Base Cases
        prevRow[0]=1;
        for(int j=1;j<=M;j++) prevRow[j]=0;//except dp[0][0] it must be 1
// j must start from 1 otherwise it will rewrite the previous for loop's 0 column
        
        for(int i=1;i<=N;i++){
            for(int j=M;j>=1;j--){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    prevRow[j] = prevRow[j-1] + prevRow[j];
                }
                // else{
                //     prevRow[j] = prevRow[j];
                // }
                //we dont need to write else
            }
        }
        
        return prevRow[M];
    }
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        int N = s1.length();
        int M = s2.length();
        System.out.println(funct1(N-1, M-1, s1, s2));

        int[][] dp = new int[N][M];
        for(int i=0;i<N;i++){//initialize to -1
            for(int j=0;j<M;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(N-1, M-1, dp, s1, s2));

        dp = new int[N+1][M+1];//reinitialize to 0
        System.out.println(funct3(N, M, dp, s1, s2));

        System.out.println(funct4(N, M, s1, s2));
        System.out.println(funct5(N, M, s1, s2));
    }
}
