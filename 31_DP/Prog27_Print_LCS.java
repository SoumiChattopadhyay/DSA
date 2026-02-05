import java.util.Arrays;

public class Prog27_Print_LCS{
    //Returns length of LCS of 2 strings(previous problem) // Tabulation solution
    static int funct3(int N, int M,int[][] dp, String str1,String str2){
        // Base cases
        for(int ind1=0;ind1<=M;ind1++) dp[ind1][0]=0;// idx 0 in dp array represents idx -1 in strings
        for(int ind2=0;ind2<=M;ind2++) dp[0][ind2]=0;// idx 0 in dp array represents idx -1 in strings

        for(int ind1=1;ind1<=N;ind1++){
            for(int ind2=1;ind2<=M;ind2++){
                //match case
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }
                // not match case
                else{
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
        return dp[N][M];        
    }
    // Returns the LCS of two strings
    static String getLCS(int N, int M, int[][] dp, String str1, String str2){
        int len = dp[N][M];//stores the lcs length
        StringBuilder lcs= new StringBuilder(len);
        int i=N,j=M;
        while(i>0 && j>0){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    lcs.append(str1.charAt(i-1));
                    i--;
                    j--;
                }else{
                    if(dp[i-1][j]>dp[i][j-1]) i--;
                    else j--;
                }
        }
        return lcs.reverse().toString();
    }
    public static void main(String[] args) {
        String str1 = "acd";
        int N = str1.length();
        String str2 = "ced";
        int M = str2.length();

        int[][] dp = new int[N+1][M+1];
        System.out.println(funct3(N, M, dp, str1, str2));

        // Printing the dp array 
        int k=0;
        System.out.println("----------------------------------");
        System.out.println("   0  1  2  3");
        for(int[] arr:dp){
            System.out.print(k++ +" ");
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("----------------------------------");


        System.out.println(getLCS(N,M,dp, str1, str2));
    }
}