public class Prog28_Longest_Common_Substring {
    // Tabulation solution
    //Returns length of LCS of 2 strings
    static int funct3(int N, int M,int[][] dp, String str1,String str2){
        // if we dont initialize dp array with -1 the below code is not needed
        // Base cases 
        // for(int ind1=0;ind1<=M;ind1++) dp[ind1][0]=0;// idx 0 in dp array represents idx -1 in strings
        // for(int ind2=0;ind2<=M;ind2++) dp[0][ind2]=0;// idx 0 in dp array represents idx -1 in strings
        int ans=0;
        for(int ind1=1;ind1<=N;ind1++){
            for(int ind2=1;ind2<=M;ind2++){
                //match case
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                    ans=Math.max(ans,dp[ind1][ind2]);
                }
                // not match case
                else{
                    dp[ind1][ind2] = 0;
                }
            }
        }
        return ans;        
    }
    // Space Optimization solution
    //Returns length of LCS of 2 strings
    static int funct4(int N, int M,String str1,String str2){
        int[] prevRow = new int[N+1];
        int[] currRow = new int[M+1];
        // Base cases //the =0 statements are compulsory only if you initialize dp array with -1
        for(int ind2=0;ind2<=M;ind2++) prevRow[ind2]=0;// idx 0 in dp array represents idx -1 in strings
        
        int ans=0;
        for(int ind1=1;ind1<=N;ind1++){
            currRow = new int[M+1];
            prevRow[0]=currRow[0]=0;
            for(int ind2=1;ind2<=M;ind2++){
                //match case
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
                    currRow[ind2] = 1 + prevRow[ind2-1];
                    ans=Math.max(ans,currRow[ind2]);
                }
                // not match case
                else{
                    currRow[ind2] = 0;
                }
            }
            prevRow=currRow;
        }
        return ans;        
    }
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "abzd";
        int N = str1.length();
        int M = str2.length();

        int[][] dp = new int[N+1][M+1];
        System.out.println(funct3(N-1, M-1,dp, str1, str2));

        dp = new int[N+1][M+1];
        System.out.println(funct4(N-1, M-1, str1, str2));
    }
}
