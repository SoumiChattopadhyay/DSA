public class Prog32_Shortest_Common_Supersequence {
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
    static String getSCS(String str1, String str2,int N,int M, int[][] dp){
        int lcs_length = dp[N][M];
        int SCS_length = N + M - lcs_length;
        StringBuilder SCS = new StringBuilder(SCS_length);
        int i=N,j=M;
        while(i>0 && j>0){
            // match case
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                SCS.append(str1.charAt(i-1));
                i--;
                j--;
            }
            // non-match cases
            else if(dp[i-1][j]>dp[i][j-1]){
                SCS.append(str1.charAt(i-1));
                i--;
            }
            else{
                SCS.append(str2.charAt(j-1));
                j--;
            }
        }
        // trace remaining characters of str1
        while(i>0){
            SCS.append(str1.charAt(i-1));
            i--;
        }
        // trace remaining characters of str2
        while(j>0){
            SCS.append(str2.charAt(j-1));
            j--;
        }
        return SCS.reverse().toString();
    }
    public static void main(String[] args) {
        String str1 = "brute";
        String str2 = "groot";
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[N+1][M+1];
        int lcs_length = funct3(N, M, dp, str1, str2);
        int SCS_length = N + M - lcs_length;
        System.out.println("Length of shortest common supersequence = "+SCS_length);
        System.out.println("Shortest common supersequence = "+getSCS(str1, str2, N, M, dp));
    }
}
