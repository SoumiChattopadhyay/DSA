public class Prog29_Longest_Palindromic_Subsequence {
    //Returns length of LCS of 2 strings(previous problem) // Tabulation solution
    static int funct3(int N, int M,int[][] dp, String str1,String str2){
        // Base cases
        for(int ind1=0;ind1<=N;ind1++) dp[ind1][0]=0;// idx 0 in dp array represents idx -1 in strings
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
    // Returns LCS of 2 strings
    static String getLCS(int N, int M, int[][] dp, String str1, String str2){
        int len = dp[N][M];//stores length of LCS
        StringBuilder lcs = new StringBuilder(len);
        int i=N, j=M;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                lcs.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        return lcs.reverse().toString();
    }
    public static void main(String[] args) {
        String str1 = "bbabcbcab";
        String str2 = new StringBuilder(str1).reverse().toString();
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[N+1][M+1];
        System.out.println("Length of Longest Palindromic Subsequence of the string "+str1+" is : "+funct3(N, M, dp, str1, str2));
        System.out.println("Longest Palindromic Subsequence of the string "+str1+" is : "+getLCS(N, M, dp, str1, str2));
    }
}
