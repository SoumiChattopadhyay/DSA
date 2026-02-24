public class Prog34_Edit_Distance {
    // Recursion
    static int funct1(int i, int j, String s1, String s2){
        // Base Cases
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(s1.charAt(i)==s2.charAt(j)) return 0+funct1(i-1, j-1, s1, s2);
        
        int insert = 1 + funct1(i, j-1, s1, s2);
        int delete = 1 + funct1(i-1, j, s1, s2);
        int replace = 1 + funct1(i-1, j-1, s1, s2);
        return Math.min(insert,Math.min(delete, replace));
        // Or just write:
        // return 1 + Math.min(funct1(i, j-1, s1, s2),Math.min(funct1(i-1, j, s1, s2),funct1(i-1, j-1, s1, s2)));
    }
    // Memoization
    static int funct2(int i, int j, int[][] dp, String s1, String s2){
        // Base Cases
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=0+funct2(i-1, j-1,dp, s1, s2);
        
        int insert = 1 + funct2(i, j-1,dp, s1, s2);
        int delete = 1 + funct2(i-1, j,dp, s1, s2);
        int replace = 1 + funct2(i-1, j-1,dp, s1, s2);
        return dp[i][j]=Math.min(insert,Math.min(delete, replace));
        // Or just write:
        // return dp[i][j] = 1 + Math.min(funct1(i, j-1, s1, s2),Math.min(funct1(i-1, j, s1, s2),funct1(i-1, j-1, s1, s2)));
    }
    // Memoization 2 : using 1-based indexing : shifting index by +1 (so 0 idx reps. -1, n idx reps. n-1 and so on), code logic remains same
    static int funct22(int i, int j, int[][] dp, String s1, String s2){
        // Base Cases
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i-1)==s2.charAt(j-1)) return dp[i][j]=0+funct22(i-1, j-1,dp, s1, s2);
        
        int insert = 1 + funct22(i, j-1,dp, s1, s2);
        int delete = 1 + funct22(i-1, j,dp, s1, s2);
        int replace = 1 + funct22(i-1, j-1,dp, s1, s2);
        return dp[i][j]=Math.min(insert,Math.min(delete, replace));
        // Or just write:
        // return dp[i][j] = 1 + Math.min(funct1(i, j-1, s1, s2),Math.min(funct1(i-1, j, s1, s2),funct1(i-1, j-1, s1, s2)));
    }
    // Tabulation
    static int funct3(int N, int M, int[][] dp, String s1, String s2){
        // Base Cases
        for(int j=0;j<=M;j++) dp[0][j]=j;
        for(int i=0;i<=N;i++) dp[i][0]=i;

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) 
                    dp[i][j]=0+dp[i-1][j-1];
                else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insert,Math.min(delete,replace));
                    // Or just write:
                    // dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
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
        for(int j=0;j<=M;j++) prevRow[j]=j;
        prevRow[0]=currRow[0]=0;

        for(int i=1;i<=N;i++){
            currRow = new int[M+1];
            currRow[0]=i;
            for(int j=1;j<=M;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) 
                    currRow[j]=0+prevRow[j-1];
                else{
                    int insert = 1 + currRow[j-1];
                    int delete = 1 + prevRow[j];
                    int replace = 1 + prevRow[j-1];
                    currRow[j] = Math.min(insert,Math.min(delete,replace));
                    // Or just write:
                    // currRow[j] = 1 + Math.min(currRow[j-1],Math.min(prevRow[j],prevRow[j-1]));
                }
            }
            prevRow=currRow;
        }
        return prevRow[M];
    }
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
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
        
        dp=new int[N+1][M+1];
        for(int i=0;i<=N;i++){//initialize to -1
            for(int j=0;j<=M;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct22(N, M, dp, s1, s2));

        dp=new int[N+1][M+1];
        System.out.println(funct3(N, M, dp, s1, s2));

        System.out.println(funct4(N, M, s1, s2));
    }
}
